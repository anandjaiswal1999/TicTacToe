package org.example;

public class Players {
    String userName ;

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }

    PlayingPiece playingPiece;
    public Players(String userName , PlayingPiece playingPiece){
        this.userName=userName;
        this.playingPiece=playingPiece;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
