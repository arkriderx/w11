package com.vikiner.w11.repository;

import com.vikiner.w11.model.Team;

import java.util.List;

public class TeamRepository extends Repository<Team> {

    public List<Team> filterByLeague(String league) {
        return filter(team -> team.getLeague().equalsIgnoreCase(league));
    }
}
