package VotingPoll;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Poll {
    private String pollId;
    private String question;
    private List<String> options;
    private LocalDateTime createdAt;

    public Poll(String pollId, String question, List<String> options) {
        this.pollId = pollId;
        this.question = question;
        this.options = options;
        this.createdAt = LocalDateTime.now();
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
