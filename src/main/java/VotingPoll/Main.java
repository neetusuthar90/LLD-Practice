package VotingPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args){
        //create user
        User user1 = new User("1", "neetu");
        User user2 = new User("2", "neha");

        PollManager pollManager = new PollManager();
        List<String> options = new ArrayList<>();
        options.add("red");
        options.add("yellow");
        options.add("Pink");

        Map<String, String> map = pollManager.createPoll("123","Choose your favourite color?", options);
        System.out.println(map);

        PollService pollService = new PollService(pollManager);
        map = pollService.voteInPoll("123", "1", "red");
        System.out.println(map);
        map = pollService.voteInPoll("123", "2", "red");
        System.out.println(map);

        Map<String, Object> objectMap = pollService.viewPollResults("123");
        System.out.println(objectMap);
    }

}
