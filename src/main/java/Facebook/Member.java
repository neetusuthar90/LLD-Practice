package Facebook;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int userId;
    private String username;
    private List<Member> following;
    private List<Member> follower;

    public Member(int userId, String username) {
        this.userId = userId;
        this.username = username;
        following = new ArrayList<>();
        follower = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Member> getFollower() {
        return follower;
    }

    public void setFollower(List<Member> follower) {
        this.follower = follower;
    }

    public List<Member> getFollowing() {
        return following;
    }

    public void setFollowing(List<Member> following) {
        this.following = following;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addFollower(Member member){
        follower.add(member);
    }

    public void addFollowing(Member member){
        following.add(member);
    }
}
