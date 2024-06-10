package org.example;

public class PlayingPiece {
    PieceType pieceType;

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
