package VotingPoll;

import java.time.LocalDateTime;

public class Vote {
    private String pollId;
    private String userId;
    private String option;
    private LocalDateTime timestamp;

    public Vote(String pollId, String userId, String option) {
        this.pollId = pollId;
        this.userId = userId;
        this.option = option;
        this.timestamp = LocalDateTime.now();
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
