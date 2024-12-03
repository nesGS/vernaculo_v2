package com.nesGS.vernaculo_v2.controller;




import com.nesGS.vernaculo_v2.persistence.model.Team;
import com.nesGS.vernaculo_v2.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vernaculo/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public Iterable<Team> getAllTeam() {
        return teamService.getAllTeam();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Team team = teamService.getTeamById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
        return ResponseEntity.ok(team);
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team savedTeam = teamService.createTeam(team)
                .orElseThrow(() -> new RuntimeException("Unexpected error occurred while creating the team"));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team updatedTeam) {
        Team team = teamService.getTeamById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
        Optional<Team> savedTeam = teamService.updateTeam(id, updatedTeam);

        return ResponseEntity.status(HttpStatus.OK).body(savedTeam.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        Team team = teamService.getTeamById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }

}
