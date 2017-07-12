package com.db.domain;

import java.util.*;

/**
 * Created by dbenoff on 7/10/17.
 */
public class Game {

    private Map<String, Player> players = new HashMap<>();
    private Collection<Move> history = new LinkedList<>();
    private Board board =  new Board();
    private String lastPlayerMoved = null;

    private Game(){};

    public Game(String player1Name, String player2Name){
        players.put(player1Name, new Player(player1Name, Color.RED));
        players.put(player2Name, new Player(player2Name, Color.BLACK));
    }

    public boolean move(String playerName, int column){
        if(lastPlayerMoved != null && lastPlayerMoved.equals(playerName))
            throw new IllegalArgumentException("Player turns must alternate");
        if(players.get(playerName).getPieceCount() == 0)
            throw new IllegalArgumentException("Player is out of pieces");
        lastPlayerMoved = playerName;
        Move move = new Move();
        move.setPlayer(players.get(playerName));
        move.setColumn(column);
        history.add(move);
        boolean result = board.processMove(move);
        System.out.println("Board after move number " + history.size());
        board.dumpGrid();
        return result;
    }
}
