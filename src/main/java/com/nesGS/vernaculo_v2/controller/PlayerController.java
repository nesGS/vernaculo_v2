package com.nesGS.vernaculo_v2.controller;




import com.nesGS.vernaculo_v2.model.Player;
import com.nesGS.vernaculo_v2.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vernaculo/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public Iterable<Player> getAllPlayer() {
        return playerService.getAllPlayer();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found"));
        return ResponseEntity.ok(player);
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.createPlayer(player)
                .orElseThrow(() -> new RuntimeException("Unexpected error occurred while creating the player"));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        Player player = playerService.getPlayerById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found"));
        Optional<Player> savedPlayer = playerService.updatePlayer(id, updatedPlayer);

        return ResponseEntity.status(HttpStatus.OK).body(savedPlayer.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found"));
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

}
