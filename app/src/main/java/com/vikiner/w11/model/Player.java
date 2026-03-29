package com.vikiner.w11.model;

public class Player implements SoccerEntity {
    private String id;
    private String name;
    private String position;
    private String team;

    public Player(String id, String name, String position, String team) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.team = team;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
