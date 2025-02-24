package SnakeAndLadder;

import java.util.*;

import java.util.concurrent.ThreadLocalRandom;
public class Board {
    private int boardSize; //n*n
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board(int n, int numberOfSnakes, int numberOfLadders) {
        this.boardSize = n * n;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        initializeBoard(numberOfSnakes, numberOfLadders);
    }

    public void initializeBoard(int numberOfSnakes, int numberOfLadders){
        //add snakes
//        snakes.put(20,5);
//        snakes.put(34,22);
//        snakes.put(25,12);
//        snakes.put(30,20);

        while(numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,boardSize);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,boardSize);
            if(snakeTail >= snakeHead) {
                continue;
            }
            snakes.put(snakeHead, snakeTail);
            numberOfSnakes--;
        }


        //add ladder
//        ladders.put(2,14);
//        ladders.put(6,19);
//        ladders.put(23,35);
//        ladders.put(21,28);

        while(numberOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1,boardSize);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,boardSize);
            if(ladderStart >= ladderEnd) {
                continue;
            }
            ladders.put(ladderStart, ladderEnd);
            numberOfLadders--;
        }

    }

    public void printSnakesAndLadders() {
        System.out.println("=== Snakes ===");
        for (Map.Entry<Integer, Integer> snake : snakes.entrySet()) {
            System.out.println("Snake from " + snake.getKey() + " to " + snake.getValue());
        }

        System.out.println("\n=== Ladders ===");
        for (Map.Entry<Integer, Integer> ladder : ladders.entrySet()) {
            System.out.println("Ladder from " + ladder.getKey() + " to " + ladder.getValue());
        }
        System.out.println("\n");
    }

    public Map<Integer, Integer> getSnakes(){
        return snakes;
    }

    public Map<Integer, Integer> getLadders(){
        return ladders;
    }

    public int getBoardSize(){
        return boardSize;
    }

}
