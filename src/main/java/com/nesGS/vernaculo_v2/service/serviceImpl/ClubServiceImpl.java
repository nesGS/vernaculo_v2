package com.nesGS.vernaculo_v2.service.serviceImpl;

import com.nesGS.vernaculo_v2.model.Club;
import com.nesGS.vernaculo_v2.service.ClubService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.nesGS.vernaculo_v2.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClubServiceImpl implements ClubService {


    @Autowired
    public ClubRepository clubRepository;

    @Transactional
    @Override
    public Iterable<Club> getAllClub() {
        return clubRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Club> getClubById(Long id) {
        return clubRepository.findById(id);
    }

    @Override
    public Optional<Club> createClub(Club club) {
        Club newClub = clubRepository.save(club);
        return Optional.of(newClub);
    }

    @Override
    public Optional<Club> updateClub(Long id, Club updatedClub) {
        updatedClub.setId(id);
        Club savedClub = clubRepository.save(updatedClub);
        return Optional.of(savedClub);
    }

    @Override
    public void deleteClub(Long id) {
        clubRepository.deleteById(id);

    }
}
