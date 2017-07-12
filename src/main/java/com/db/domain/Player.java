package com.db.domain;

/**
 * Created by dbenoff on 7/10/17.
 */
public class Player {

    private String name;
    private Color color;
    private int pieceCount = 21;

    private Player (){};

    public Player(String name, Color color){
        this.name = name;
        this.color = color;
    };

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getPieceCount() {
        return pieceCount;
    }

    public void subtractPiece() {
        pieceCount--;
    }
}
