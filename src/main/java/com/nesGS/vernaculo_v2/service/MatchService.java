package com.nesGS.vernaculo_v2.service;

import com.nesGS.vernaculo_v2.model.Match;

import java.util.Optional;

public interface MatchService {

    public Iterable<Match> getAllMatch();

    public Optional<Match> getMatchById(Long id);

    public Optional<Match> createMatch(Match match);

    public Optional<Match> updateMatch(Long id, Match match);

    public void deleteMatch(Long id);

}
