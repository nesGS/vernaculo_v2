package com.nesGS.vernaculo_v2.controller;

import com.nesGS.vernaculo_v2.persistence.model.Club;
import com.nesGS.vernaculo_v2.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vernaculo/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping
    public Iterable<Club> getAllClub() {
        return clubService.getAllClub();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable Long id) {
        Club club = clubService.getClubById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club not found"));
        return ResponseEntity.ok(club);
    }

    @PostMapping
    public ResponseEntity<Club> createClub(@RequestBody Club club) {
        Club savedClub = clubService.createClub(club)
                .orElseThrow(() -> new RuntimeException("Unexpected error occurred while creating the club"));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClub);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(@PathVariable Long id, @RequestBody Club updatedClub) {
        Club club = clubService.getClubById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club not found"));
        Optional<Club> savedClub = clubService.updateClub(id, updatedClub);

        return ResponseEntity.status(HttpStatus.OK).body(savedClub.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
        Club club = clubService.getClubById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club not found"));
        clubService.deleteClub(id);
        return ResponseEntity.noContent().build();
    }

}
