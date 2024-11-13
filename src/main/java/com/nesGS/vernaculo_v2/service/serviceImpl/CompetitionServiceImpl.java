package com.nesGS.vernaculo_v2.service.serviceImpl;

import com.nesGS.vernaculo_v2.model.Competition;
import com.nesGS.vernaculo_v2.repository.CompetitionRepository;
import com.nesGS.vernaculo_v2.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompetitionServiceImpl implements CompetitionService {


    @Autowired
    public CompetitionRepository competitionRepository;

    @Transactional
    @Override
    public Iterable<Competition> getAllCompetition() {
        return competitionRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Competition> getCompetitionById(Long id) {
        return competitionRepository.findById(id);
    }

    @Override
    public Optional<Competition> createCompetition(Competition competition) {
        Competition newCompetition = competitionRepository.save(competition);
        return Optional.of(newCompetition);
    }

    @Override
    public Optional<Competition> updateCompetition(Long id, Competition updatedCompetition) {
        updatedCompetition.setId(id);
        Competition savedCompetition = competitionRepository.save(updatedCompetition);
        return Optional.of(savedCompetition);
    }

    @Override
    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);

    }
}
