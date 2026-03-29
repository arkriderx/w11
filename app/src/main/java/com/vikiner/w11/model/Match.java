package com.vikiner.w11.model;

public class Match implements SoccerEntity {
    private String id;
    private String homeTeam;
    private String awayTeam;
    private String score;

    public Match(String id, String homeTeam, String awayTeam, String score) {
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return homeTeam + " vs " + awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getScore() {
        return score;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
