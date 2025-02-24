package SnakeAndLadder;

public class Main {
    public static void main(String[] args){
        SnakeAndLadderGame game = new SnakeAndLadderGame();
        game.initializeGame();
        //check the snakes and ladders
        System.out.println("The winner is: " + game.startGame());
    }
}
