package com.db.api;

import com.db.domain.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by dbenoff on 7/10/17.
 */
@SpringBootApplication
public class GameManager {

    private Map<String, Game> gameMap = new HashMap<>();

    public static void main(String[] args){
        SpringApplication.run(GameManager.class, args);
    }

    public String startGame(String player1Name, String player2Name){
        if(player1Name.equals(player2Name))
            throw new IllegalArgumentException("Player names must be unique");
        Game game = new Game(player1Name, player2Name);
        String gameId = UUID.randomUUID().toString();
        gameMap.put(gameId, game);
        return gameId;
    };

    public boolean move(String gameId, String playerName, int column){
        Game game = gameMap.get(gameId);
        return game.move(playerName, column);
    };
}
