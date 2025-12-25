package com.pl.premier_zone.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();

    }

    public List<Player> getPlayersFromTeam(String getTeamName) {
        return playerRepository.findAll().stream()
                .filter(player -> getTeamName.equals(player.getTeamName()))
                .collect(Collectors.toList());
    }
}
