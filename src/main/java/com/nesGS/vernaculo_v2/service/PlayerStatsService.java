package com.nesGS.vernaculo_v2.service;

import com.nesGS.vernaculo_v2.model.PlayerStats;

import java.util.Optional;

public interface PlayerStatsService {

    public Iterable<PlayerStats> getAllPlayerStats();

    public Optional<PlayerStats> getPlayerStatsById(Long id);

    public Optional<PlayerStats> createPlayerStats(PlayerStats playerStats);

    public Optional<PlayerStats> updatePlayerStats(Long id, PlayerStats playerStats);

    public void deletePlayerStats(Long id);

}
