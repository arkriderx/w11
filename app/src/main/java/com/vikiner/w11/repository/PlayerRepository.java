package com.vikiner.w11.repository;

import com.vikiner.w11.model.Player;

import java.util.List;

public class PlayerRepository extends Repository<Player> {

    public List<Player> filterByTeam(String team) {
        return filter(player -> player.getTeam().equalsIgnoreCase(team));
    }
}
