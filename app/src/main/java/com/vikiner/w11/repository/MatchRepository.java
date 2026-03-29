package com.vikiner.w11.repository;

import com.vikiner.w11.model.Match;

import java.util.List;

public class MatchRepository extends Repository<Match> {

    public List<Match> filterByTeam(String team) {
        return filter(match ->
                match.getHomeTeam().equalsIgnoreCase(team) ||
                        match.getAwayTeam().equalsIgnoreCase(team)
        );
    }
}