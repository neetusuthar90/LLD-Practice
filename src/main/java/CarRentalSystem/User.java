package CarRentalSystem;

public class User {
    int userId;
    String username;
    int DLNum;

    public User(int userId, String username, int DLNum){
        this.userId = userId;
        this.username = username;
        this.DLNum = DLNum;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDLNum(int DLNum) {
        this.DLNum = DLNum;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public int getDLNum() {
        return DLNum;
    }

}
