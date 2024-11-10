package com.nesGS.vernaculo_v2.service;

import com.nesGS.vernaculo_v2.model.Club;

import java.util.Optional;

public interface ClubService {

    public Iterable<Club> getAllClub();

    public Optional<Club> getClubById(Long id);

    public Optional<Club> createClub(Club club);

    public Optional<Club> updateClub(Long id, Club club);

    public void deleteClub(Long id);

}
