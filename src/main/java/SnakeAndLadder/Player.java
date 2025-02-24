package SnakeAndLadder;

public class Player {
    public int playerId;
    public String playerName;
    public int playerPosition;

    public Player(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerPosition = 1;
    }
}
