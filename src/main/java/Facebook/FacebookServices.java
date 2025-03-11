package Facebook;

import java.util.*;

public class FacebookServices {
    private static final int MAX_SIZE = 3;
    private List<Member> memberList = new ArrayList<>();
    private Map<Integer, FriendRequest> friendRequestMap = new HashMap<>();
    private Map<Integer, Post> postMap = new HashMap<>();

    public void createMember(Member member){
        memberList.add(member);
    }

    public void sendFriendRequest(Member from, Member to){
        if (from == null || to == null) {
            System.out.println("Invalid members provided for friend request.");
            return;
        }
        if (from.equals(to)) {
            System.out.println("Cannot send a friend request to oneself.");
            return;
        }
        int requestId = friendRequestMap.size() + 1;
        FriendRequest currentRequest = new FriendRequest(requestId, from, to);
        friendRequestMap.put(friendRequestMap.size()+1, currentRequest);
    }

    public void createPost(Member member, String postText){
        int totalPost = postMap.size();
        Post newPost = new Post(totalPost+1, member, postText);
        postMap.put(newPost.getPostId(), newPost);
    }

    public void deletePost(int postId){
        boolean isThere = postMap.containsKey(postId);
        if(!isThere){
            System.out.println("No post is there with this id");
        }else{
            postMap.remove(postId);
        }
    }

    public void ShowAllRequest(){
        System.out.println("-------------------------");
        for(Map.Entry<Integer, FriendRequest> ptr: friendRequestMap.entrySet()){
            int requestId = ptr.getKey();
            Member from = ptr.getValue().getRequestFrom();
            Member to = ptr.getValue().getRequestTo();
            System.out.println("RequestId " + requestId + "-->" + from.getUsername() + " send follow request to " + to.getUsername());
        }
        System.out.println("-------------------------");
    }

    public void acceptRequest(int requestId, Member currentActiveUser){
        FriendRequest request = friendRequestMap.get(requestId);
        if (request == null) {
            System.out.println("Invalid friend request ID.");
            return;
        }
        Member from = request.getRequestFrom();
        Member to = request.getRequestTo();
        if (!currentActiveUser.equals(to)) {
            System.out.println("Friend request data is invalid.");
            return;
        }

        if (!from.getFollower().contains(to)) {
            from.addFollower(to);
        }
        if (!to.getFollowing().contains(from)) {
            to.addFollowing(from);
        }

        request.setRequestStatus(RequestStatus.ACTIVE);
        friendRequestMap.remove(requestId);
    }

    public void rejectRequest(int requestId){
        if (!friendRequestMap.containsKey(requestId)) {
            System.out.println("Invalid request ID to reject.");
            return;
        }
        friendRequestMap.get(requestId).setRequestStatus(RequestStatus.REJECT);
    }

    public void showTopPosts(Member member){
        //first get the follower and following list
        List<Member> relevantMembers = new ArrayList<>();
        relevantMembers.add(member);
        relevantMembers.addAll(member.getFollower());
        relevantMembers.addAll(member.getFollowing());

        //check if any post made by follower or following if yes then add into top
        PriorityQueue<Post> topPosts = new PriorityQueue<>(MAX_SIZE, Comparator.comparing(Post::getTimestamp));
        for(Post post: postMap.values()){
            if(relevantMembers.contains(post.getPostOwner())){
                topPosts.offer(post);
                if (topPosts.size() > MAX_SIZE) {
                    topPosts.poll();
                }
            }
        }

        //print top 3
        for(Post post: topPosts){
            System.out.println(post.getText() + " by " + post.getPostOwner().getUsername() + " at " + post.getTimestamp());
        }
    }

    public Member getMemberById(int memberId) {
        for(Member member:memberList){
            if(member.getUserId() == memberId){
                return member;
            }
        }
        return null;
    }

    public void DisplayAllMembers() {
        for(Member member:memberList){
            System.out.println(member.getUserId() + " , " + member.getUsername());
        }
    }

    public void displayMyFriends(Member currentUser) {
        List<Member> friendList = new ArrayList<>();
        friendList.addAll(currentUser.getFollower());
        friendList.addAll(currentUser.getFollowing());
        System.out.println("---------------");
        for(Member friend:friendList){
            System.out.println(friend.getUsername());
        }
        System.out.println("---------------");
    }
}
