package com.vikiner.w11.iterator;

import com.vikiner.w11.model.Team;

import java.util.List;

public class TeamIterator implements CustomIterator<Team> {
    private List<Team> teams;
    private int index = 0;

    public TeamIterator(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public boolean hasNext() {
        return index < teams.size();
    }

    @Override
    public Team next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more teams available");
        }
        return teams.get(index++);
    }
}
