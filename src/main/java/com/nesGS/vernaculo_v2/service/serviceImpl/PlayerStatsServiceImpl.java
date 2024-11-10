package com.nesGS.vernaculo_v2.service.serviceImpl;


import com.nesGS.vernaculo_v2.model.PlayerStats;
import com.nesGS.vernaculo_v2.service.PlayerStatsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.nesGS.vernaculo_v2.repository.PlayerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerStatsServiceImpl implements PlayerStatsService {


    @Autowired
    public PlayerStatsRepository playerStatsRepository;

    @Transactional
    @Override
    public Iterable<PlayerStats> getAllPlayerStats() {
        return playerStatsRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<PlayerStats> getPlayerStatsById(Long id) {
        return playerStatsRepository.findById(id);
    }

    @Override
    public Optional<PlayerStats> createPlayerStats(PlayerStats playerStats) {
        PlayerStats newPlayerStats = playerStatsRepository.save(playerStats);
        return Optional.of(newPlayerStats);
    }

    @Override
    public Optional<PlayerStats> updatePlayerStats(Long id, PlayerStats updatedPlayerStats) {
        updatedPlayerStats.setId(id);
        PlayerStats savedPlayerStats = playerStatsRepository.save(updatedPlayerStats);
        return Optional.of(savedPlayerStats);
    }

    @Override
    public void deletePlayerStats(Long id) {
        playerStatsRepository.deleteById(id);

    }
}
