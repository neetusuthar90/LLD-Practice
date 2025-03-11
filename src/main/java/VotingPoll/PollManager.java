package VotingPoll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollManager {
    private Map<String, Poll> pollMap;

    public PollManager() {
        this.pollMap = new HashMap<>();
    }

    //create poll
    public Map<String, String> createPoll(String pollId, String question, List<String> options){
        Poll newPoll = new Poll(pollId, question, options);
        pollMap.put(pollId, newPoll);
        Map<String, String> responseString = new HashMap<>();
        responseString.put("pollId", pollId);
        responseString.put("message", "Poll created successfully");
        return responseString;
    }
    //update poll
    public Map<String, String> updatePoll(String pollId, String question, List<String> options){
        Poll poll = getPollById(pollId);
        poll.setQuestion(question);
        poll.setOptions(options);
        Map<String, String> responseString = new HashMap<>();
        responseString.put("message", "Poll updated successfully!");
        return responseString;
    }

    public Poll getPollById(String pollId){
        if(!pollMap.containsKey(pollId)){
            throw new NullPointerException("No such poll Id exist");
        }
        return pollMap.get(pollId);
    }

    //delete poll
    public Map<String, String> deletePoll(String pollId){
        if(!pollMap.containsKey(pollId)){
            throw new NullPointerException("No such poll Id exist");
        }
        pollMap.remove(pollId);
        Map<String, String> responseString = new HashMap<>();
        responseString.put("message", "Poll deleted successfully!");
        return  responseString;
    }

    public String getQuestionById(String pollId) {
        Poll curPoll = pollMap.get(pollId);
        return curPoll.getQuestion();
    }
}
