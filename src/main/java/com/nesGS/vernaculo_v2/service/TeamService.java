package com.nesGS.vernaculo_v2.service;




import com.nesGS.vernaculo_v2.persistence.model.Team;

import java.util.Optional;

public interface TeamService {

    public Iterable<Team> getAllTeam();

    public Optional<Team> getTeamById(Long id);

    public Optional<Team> createTeam(Team team);

    public Optional<Team> updateTeam(Long id, Team team);

    public void deleteTeam(Long id);

}
