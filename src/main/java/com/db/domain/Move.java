package com.db.domain;

/**
 * Created by dbenoff on 7/10/17.
 */
public class Move {

    private Player player;
    private int column;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
