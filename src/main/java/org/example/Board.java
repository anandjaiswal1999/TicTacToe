package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][]board;

    public Board(int n) {
        this.size=n;
        board = new PlayingPiece[size][size];
    }

    public void printBoard() {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null)
                    System.out.print(board[i][j].pieceType.name() + " ");
                else
                    System.out.print(board[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

    public List<List<Integer>> getFreeCells() {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
               if(board[i][j]==null){
                   lists.add(Arrays.asList(i,j));
               }
            }

        }
        return lists;
    }

    public void addCells(int r, int c, Players getCurrentPlayer) {
        board[r][c]=getCurrentPlayer.getPlayingPiece();
    }
}
