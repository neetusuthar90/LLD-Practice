package VotingPoll;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PollService {
    private Map<String, Vote> voteMap;
    private PollManager pollManager;
    private Map<String, Map<String, Integer>> pollVoteCountMap;

    public PollService(PollManager pollManager) {
        this.pollManager = pollManager;
        this.voteMap = new ConcurrentHashMap<>(); // Thread-safe
        this.pollVoteCountMap = new ConcurrentHashMap<>(); // Thread-safe
    }

    public synchronized Map<String, String> voteInPoll(String pollId, String userId, String option) {
        Poll currentPoll = pollManager.getPollById(pollId);
        List<String> options = currentPoll.getOptions();

        if (options == null || !options.contains(option)) {
            throw new NullPointerException("Invalid poll or option");
        }

        String voteId = pollId + userId;
        if (voteMap.containsKey(voteId)) {
            throw new IllegalStateException("User has already voted in this poll");
        }

        increaseVoteCount(pollId, option, options);

        Vote newVote = new Vote(pollId, userId, option);
        voteMap.put(voteId, newVote);

        return Map.of("message", "Vote cast successfully");
    }

    public Map<String, Object> viewPollResults(String pollId) {
        if (!pollVoteCountMap.containsKey(pollId)) {
            throw new NullPointerException("Poll does not exist");
        }

        Map<String, Integer> voteCount = pollVoteCountMap.get(pollId);
        String question = pollManager.getQuestionById(pollId);

        return Map.of(
                "pollId", pollId,
                "question", question,
                "results", voteCount
        );
    }

    private synchronized void increaseVoteCount(String pollId, String option, List<String> options) {
        pollVoteCountMap.putIfAbsent(pollId, new ConcurrentHashMap<>());
        Map<String, Integer> voteCount = pollVoteCountMap.get(pollId);

        for (String opt : options) {
            voteCount.putIfAbsent(opt, 0);
        }
        voteCount.put(option, voteCount.get(option) + 1);
    }
}
