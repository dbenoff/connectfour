package com.db.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created by dbenoff on 7/11/17.
 */
@Controller
@Path("/")
public class RestController {

    @Autowired
    private GameManager gameManager;

    @GET
    @Path("/start")
    public String startGame(@QueryParam("player1") String player1, @QueryParam("player2") String player2) {
        return gameManager.startGame(player1, player2);
    }

    @GET
    @Path("/move")
    public Boolean move(@QueryParam("gameId") String gameId, @QueryParam("playerName") String playerName, @QueryParam("column") int column) {
        return gameManager.move(gameId, playerName, column);
    }
}
