package com.vikiner.w11.model;

public class Team implements SoccerEntity {
    private String id;
    private String name;
    private String country;
    private String league;

    public Team(String id, String name, String country, String league) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.league = league;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", league='" + league + '\'' +
                '}';
    }
}
