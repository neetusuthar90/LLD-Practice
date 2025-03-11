package Splitwise;

public class User {
    private int userId;
    private String username;

    public User(int userId, String username) {
        this.username = username;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
