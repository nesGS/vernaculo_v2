package com.nesGS.vernaculo_v2.controller;

import com.nesGS.vernaculo_v2.model.Competition;
import com.nesGS.vernaculo_v2.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vernaculo/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping
    public Iterable<Competition> getAllCompetition() {
        return competitionService.getAllCompetition();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable Long id) {
        Competition competition = competitionService.getCompetitionById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competition not found"));
        return ResponseEntity.ok(competition);
    }

    @PostMapping
    public ResponseEntity<Competition> createCompetition(@RequestBody Competition competition) {
        Competition savedCompetition = competitionService.createCompetition(competition)
                .orElseThrow(() -> new RuntimeException("Unexpected error occurred while creating the competition"));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompetition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> updateCompetition(@PathVariable Long id, @RequestBody Competition updatedCompetition) {
        Competition competition = competitionService.getCompetitionById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competition not found"));
        Optional<Competition> savedCompetition = competitionService.updateCompetition(id, updatedCompetition);

        return ResponseEntity.status(HttpStatus.OK).body(savedCompetition.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable Long id) {
        Competition competition = competitionService.getCompetitionById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competition not found"));
        competitionService.deleteCompetition(id);
        return ResponseEntity.noContent().build();
    }

}
