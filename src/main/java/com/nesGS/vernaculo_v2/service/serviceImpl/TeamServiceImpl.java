package com.nesGS.vernaculo_v2.service.serviceImpl;

import com.nesGS.vernaculo.model.Team;
import com.nesGS.vernaculo.repository.TeamRepository;
import com.nesGS.vernaculo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {


    @Autowired
    public TeamRepository teamRepository;

    @Transactional
    @Override
    public Iterable<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public Optional<Team> createTeam(Team team) {
        Team newTeam = teamRepository.save(team);
        return Optional.of(newTeam);
    }

    @Override
    public Optional<Team> updateTeam(Long id, Team updatedTeam) {
        updatedTeam.setId(id);
        Team savedTeam = teamRepository.save(updatedTeam);
        return Optional.of(savedTeam);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);

    }
}
