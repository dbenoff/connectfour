package com.db.domain;

/**
 * Created by dbenoff on 7/10/17.
 */
public enum Color {

    BLACK("X"),

    RED("O");

    private String symbol;

    private Color(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
