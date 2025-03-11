package Facebook;


import java.time.LocalDateTime;

public class Post {
    private int postId;
    private Member postOwner;
    private String text;
    private LocalDateTime timestamp;
    //private int totalLikes;
    //add likes

    public Post(int postId, Member postOwner, String text) {
        this.postId = postId;
        this.postOwner = postOwner;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Member getPostOwner() {
        return postOwner;
    }

    public void setPostOwner(Member postOwner) {
        this.postOwner = postOwner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
