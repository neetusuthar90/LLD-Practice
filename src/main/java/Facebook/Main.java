package Facebook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        FacebookServices facebookServices = new FacebookServices();

        Member member1 = new Member(1, "neetu");
        Member member2 = new Member(2, "liptan");
        Member member3 = new Member(3, "Nena");
        Member member4 = new Member(4, "Sahil");
        Member member5 = new Member(5, "rohit");

        facebookServices.createMember(member1);
        facebookServices.createMember(member2);
        facebookServices.createMember(member3);
        facebookServices.createMember(member4);
        facebookServices.createMember(member5);

        facebookServices.DisplayAllMembers();
        int input;
        Member currentUser = member1;

        do {
            System.out.println("\nCurrent User: " + currentUser.getUsername());
            System.out.println("Choose from the following: \n" +
                    "0. Switch User \n" +
                    "1. Send Friend Request \n" +
                    "2. Show All Friend Request \n" +
                    "3. Accept Request \n" +
                    "4. Reject Request \n" +
                    "5. Create New Post \n" +
                    "6. Show Top Post \n" +
                    "7. Display my friends \n" +
                    "8. Exit");

            input = scanner.nextInt();
            switch (input) {
                case 0:
                    System.out.print("Enter member ID to switch: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    Member user = facebookServices.getMemberById(userId);
                    if (user != null) {
                        currentUser = user;
                        System.out.println("Switched to " + currentUser.getUsername());
                    } else {
                        System.out.println("Invalid member ID! User not found.");
                    }
                    break;
                case 1:
                    System.out.print("Enter member ID to send friend request to: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Member requestUser = facebookServices.getMemberById(id);
                    if (requestUser != null) {
                        facebookServices.sendFriendRequest(currentUser, requestUser);
                    } else {
                        System.out.println("Invalid member ID!");
                    }
                    break;
                case 2:
                    facebookServices.ShowAllRequest();
                    break;
                case 3:
                    System.out.println("Enter the request id you want to accept: ");
                    int requestId = scanner.nextInt();
                    facebookServices.acceptRequest(requestId, currentUser);
                    break;
                case 4:
                    System.out.println("Enter the request id you want to reject: ");
                    int whichToRejectId = scanner.nextInt();
                    facebookServices.rejectRequest(whichToRejectId);
                    break;
                case 5:
                    System.out.println("Enter your post message: ");
                    scanner.nextLine();
                    String postText = scanner.nextLine();
                    if (!postText.isEmpty()) {
                        facebookServices.createPost(currentUser, postText);
                    } else {
                        System.out.println("Post message cannot be empty!");
                    }
                    break;
                case 6:
                    facebookServices.showTopPosts(currentUser);
                    break;
                case 7:
                    facebookServices.displayMyFriends(currentUser);
                    break;
                case 8:
                    System.out.println("Application Exit!!");
                    break;
            }
        }while (input != 8);

        scanner.close();
    }
}
