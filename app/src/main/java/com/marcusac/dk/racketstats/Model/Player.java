package com.marcusac.dk.racketstats.Model;

public class Player {

    private String playerID;
    private String name;
    private String age;
    private String club;
    private String playingHand;

    public Player() {}

    public Player(String playerID, String name, String age, String club, String playingHand) {
        this.playerID = playerID;
        this.name = name;
        this.age = age;
        this.club = club;
        this.playingHand = playingHand;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPlayingHand() {
        return playingHand;
    }

    public void setPlayingHand(String playingHand) {
        this.playingHand = playingHand;
    }
}
