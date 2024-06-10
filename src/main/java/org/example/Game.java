package org.example;

import java.util.*;

public class Game {
    Board board;
    Deque<Players> deque;
    Map<Players, String> mp = new HashMap<>();
    public Game(){
        letsPlay();
    }

    private void letsPlay() {
        deque = new LinkedList<>();
        PlayingPieceO playingPieceO = new PlayingPieceO();
        PlayingPieceX playingPiecex = new PlayingPieceX();
        Players p1 = new Players("p1" , playingPiecex);
        Players p2 = new Players("p2" ,playingPieceO );
        mp.put(p1,"p1");
        mp.put(p2,"p2");
        deque.add(p1);
        deque.add(p2);
        board= new Board(3);
    }
    public String startTheGame(){
        boolean noWinner = true;
        while(noWinner){
            Players getCurrentPlayer = deque.removeFirst();
            board.printBoard();
            List<List<Integer>> freeCells = board.getFreeCells();
            if(freeCells.isEmpty()){
                noWinner=false;
            }
            Scanner scanner = new Scanner(System.in);
            String s= scanner.nextLine();
            String[] values = s.split(",");
            int r = Integer.parseInt(values[0]);
            int c = Integer.parseInt(values[1]);
            if(freeCells.contains(Arrays.asList(r,c))){
                board.addCells(r,c,getCurrentPlayer);
                freeCells.remove(Arrays.asList(r,c));
                deque.addLast(getCurrentPlayer);
                System.out.println("Success Adding");

            }else{
                System.out.println("Not Eligible");
                deque.addFirst(getCurrentPlayer);
            }
            boolean winner = isThereWinner(r,c ,getCurrentPlayer.playingPiece.pieceType);
            if(winner){
                return mp.get(getCurrentPlayer);
            }

        }
        return ":) its A Tie";
    }

    private boolean isThereWinner(int row, int column, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.size;i++) {

            if(board.board[row][i] == null || board.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<board.size;i++) {

            if(board.board[i][column] == null || board.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.size;i++,j++) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.size-1; i<board.size;i++,j--) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }
}
