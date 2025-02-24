package SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class SnakeAndLadderGame {
    Deque<Player> players;
    Board board;
    Map<Integer, Integer> snakes;
    Map<Integer, Integer> ladders;
    Dice dice;

    public void initializeGame(){
        players = new LinkedList<>();

        Player player1 = new Player(1,"Neetu");
        Player player2 = new Player(2, "Liptan");

        players.add(player1);
        players.add(player2);

        dice = new Dice(1);
        board = new Board(6,4,4);
        board.printSnakesAndLadders();
        snakes = board.getSnakes();
        ladders = board.getLadders();
    }

    public String startGame() {
        boolean noWinner = true;
        while (noWinner) {
            Player playerTurn = players.removeFirst();
            int originalPosition = playerTurn.playerPosition;
            int newPosition = originalPosition;

            int consecutiveSixCount = 0;
            while (true) {
                int diceRoll = dice.roll();
                System.out.println(playerTurn.playerName + " rolled " + diceRoll);
                if (diceRoll == 6) {
                    consecutiveSixCount++;
                    if (consecutiveSixCount == 3) {
                        System.out.println(playerTurn.playerName + " rolled 6 three times! Turn skipped.");
                        newPosition = originalPosition;  // Reset to original position
                        break;
                    }
                } else {
                    consecutiveSixCount = 0;  // Reset count if not a 6
                }

                newPosition = movePlayer(newPosition, diceRoll);

                if (diceRoll != 6) break;  // Stop if not a 6
            }

            // Update position only if turn wasn't skipped
            playerTurn.playerPosition = newPosition;
            System.out.println(playerTurn.playerName + " moved to " + newPosition);

            if (newPosition >= board.getBoardSize()) {
                noWinner = false;
                return playerTurn.playerName + " wins!";
            }

            players.add(playerTurn);
        }
        return "No Winner";
    }


    private int movePlayer(int playerPosition, int diceRoll){
        int newPosition = playerPosition + diceRoll;
        if (newPosition > board.getBoardSize()) {
            return playerPosition;  // Stay in place if move exceeds board size
        }
        if(snakes.containsKey(newPosition)){
            newPosition = snakes.get(newPosition);
        }else if(ladders.containsKey(newPosition)){
            newPosition = ladders.get(newPosition);
        }
        return newPosition;
    }

}
