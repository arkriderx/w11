package com.vikiner.w11.provider;

import com.vikiner.w11.model.Match;
import com.vikiner.w11.model.Player;
import com.vikiner.w11.model.Team;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public List<Team> createSampleTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("T1", "FC Barcelona", "Spain", "La Liga"));
        teams.add(new Team("T2", "Manchester United", "England", "Premier League"));
        teams.add(new Team("T3", "Bayern Munich", "Germany", "Bundesliga"));
        teams.add(new Team("T4", "Juventus", "Italy", "Serie A"));
        teams.add(new Team("T5", "Paris Saint-Germain", "France", "Ligue 1"));
        return teams;
    }

    public List<Player> createSamplePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("P1", "Lionel Messi", "Forward", "FC Barcelona"));
        players.add(new Player("P2", "Cristiano Ronaldo", "Forward", "Juventus"));
        players.add(new Player("P3", "Robert Lewandowski", "Forward", "Bayern Munich"));
        players.add(new Player("P4", "Bruno Fernandes", "Midfielder", "Manchester United"));
        players.add(new Player("P5", "Neymar Jr.", "Forward", "Paris Saint-Germain"));
        return players;
    }

    public List<Match> createSampleMatches() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("M1", "FC Barcelona", "Real Madrid", "2-1"));
        matches.add(new Match("M2", "Manchester United", "Liverpool", "0-3"));
        matches.add(new Match("M3", "Bayern Munich", "Borussia Dortmund", "4-2"));
        matches.add(new Match("M4", "Juventus", "AC Milan", "1-1"));
        matches.add(new Match("M5", "Paris Saint-Germain", "Lyon", "3-0"));
        return matches;
    }
}