package com.db.domain;

/**
 * Created by dbenoff on 7/10/17.
 */
public class Board {

    //6 rows, 7 columns
    private String[][] grid = new String[7][6];

    public Boolean processMove(Move move){
        int column = move.getColumn();
        String symbol = move.getPlayer().getColor().getSymbol();
        String[] verticalColumn = grid[column];
        int row = -1;
        for(int i = 0; i < verticalColumn.length; i++){
            String cellValue = verticalColumn[i];
            if(cellValue != null){
                if(i == 0)
                    throw new IllegalArgumentException("Cannot execute move, column is full.");
                verticalColumn[i - 1] = symbol;
                row = i - 1;
                break;
            }else if(i == verticalColumn.length - 1){
                verticalColumn[i] = symbol;
                row = i;
            }
        }
        move.getPlayer().subtractPiece();
        dumpGrid();
        return checkForWin(row, column, move.getPlayer().getColor().getSymbol());
    }

    private Boolean checkForWin(int row, int column, String symbol){

        //Explore the 4 axes (n/s, e/w, nw/se, ne/sw) around the newly placed piece, looking for connect 4

        //traverse to NW corner
        int tempCol = column;
        int tempRow = row;
        for(int i = 0; i < 3; i++){
            if(tempCol > 0 && tempRow > 0 ){
                tempCol--;
                tempRow--;
            }
        }

        //now traverse SE looking for a string of 4
        int pieceCount = 0;
        for(int i = 0; i < 7; i++){
            if(grid[tempCol][tempRow] != null && grid[tempCol][tempRow].equals(symbol)){
                pieceCount++;
            }else{
                pieceCount = 0;
            }
            if(pieceCount == 4)
                return true;
            tempCol++;
            tempRow++;
            if(tempRow < 0 || tempRow > 5 || tempCol < 0 || tempCol > 6)
                break;
        }

        //traverse to SW corner
        tempCol = column;
        tempRow = row;
        for(int i = 0; i < 3; i++){
            if(tempRow < 5 && tempRow >= 0 && tempCol > 0){
                tempCol--;
                tempRow++;
            }
        }

        //now traverse NE looking for a string of 4
        pieceCount = 0;
        for(int i = 0; i < 7; i++){
            if(grid[tempCol][tempRow] != null && grid[tempCol][tempRow].equals(symbol)){
                pieceCount++;
            }else{
                pieceCount = 0;
            }
            if(pieceCount == 4)
                return true;
            tempCol++;
            tempRow--;
            if(tempRow < 0 || tempRow > 5 || tempCol < 0 || tempCol > 6)
                break;
        }

        int north = Math.max(0, row - 3);
        int south = Math.min(5, row + 3);
        int west = Math.max(0, column - 3);
        int east = Math.min(6, column + 3);

        //n/s
        pieceCount = 0;
        for(int i = north; i < south + 1; i++){
            String value = grid[column][i];
            if(value == null || !value.equals(symbol)){
                pieceCount = 0;
            }else{
                pieceCount++;
            }
        }
        if(pieceCount == 4)
            return true;

        //e/w
        pieceCount = 0;
        for(int i = west; i < east + 1; i++){
            String value = grid[i][row];
            if(value == null || !value.equals(symbol)){
                pieceCount = 0;
            }else{
                pieceCount++;
            }
        }
        if(pieceCount == 4)
            return true;

        return false;
    }

    public void dumpGrid(){
        String[][] transposed = grid; /*new String[grid[0].length][grid.length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                transposed[j][i] = grid[i][j];*/

        for(int i = 0; i < transposed.length; i++){
            String[] row = transposed[i];
            for(int j = 0; j < row.length; j++){
                String symbol = row[j] == null ? "*": row[j];
                System.out.print(symbol);
            }
            System.out.println();
        }
        System.out.println();
    }
}
