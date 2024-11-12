package com.nesGS.vernaculo_v2.controller;

import com.nesGS.vernaculo_v2.model.PlayerStats;
import com.nesGS.vernaculo_v2.service.PlayerStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vernaculo/playerstats")
public class PlayerStatsController {

    @Autowired
    private PlayerStatsService playerStatsService;

    // GET /api/statistics/1?expand=player,team,club
    @GetMapping
    public Iterable<PlayerStats> getAllPlayerStats() {
        return playerStatsService.getAllPlayerStats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerStats> getPlayerStatsById(@PathVariable Long id) {
        PlayerStats playerStats = playerStatsService.getPlayerStatsById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PlayerStats not found"));
        return ResponseEntity.ok(playerStats);
    }

    @PostMapping
    public ResponseEntity<PlayerStats> createPlayerStats(@RequestBody PlayerStats playerStats) {
        PlayerStats savedPlayerStats = playerStatsService.createPlayerStats(playerStats)
                .orElseThrow(() -> new RuntimeException("Unexpected error occurred while creating the playerStats"));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayerStats);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerStats> updatePlayerStats(@PathVariable Long id, @RequestBody PlayerStats updatedPlayerStats) {
        PlayerStats playerStats = playerStatsService.getPlayerStatsById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PlayerStats not found"));
        Optional<PlayerStats> savedPlayerStats = playerStatsService.updatePlayerStats(id, updatedPlayerStats);

        return ResponseEntity.status(HttpStatus.OK).body(savedPlayerStats.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerStats(@PathVariable Long id) {
        PlayerStats playerStats = playerStatsService.getPlayerStatsById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PlayerStats not found"));
        playerStatsService.deletePlayerStats(id);
        return ResponseEntity.noContent().build();
    }

}
