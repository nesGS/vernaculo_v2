package com.nesGS.vernaculo_v2.controller;

import com.nesGS.vernaculo_v2.model.Match;
import com.nesGS.vernaculo_v2.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vernaculo/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping
    public Iterable<Match> getAllMatch() {
        return matchService.getAllMatch();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Match match = matchService.getMatchById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found"));
        return ResponseEntity.ok(match);
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match savedMatch = matchService.createMatch(match)
                .orElseThrow(() -> new RuntimeException("Unexpected error occurred while creating the match"));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMatch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
        Match match = matchService.getMatchById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found"));
        Optional<Match> savedMatch = matchService.updateMatch(id, updatedMatch);

        return ResponseEntity.status(HttpStatus.OK).body(savedMatch.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        Match match = matchService.getMatchById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found"));
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }

}
