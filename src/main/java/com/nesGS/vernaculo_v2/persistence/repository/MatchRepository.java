package com.nesGS.vernaculo_v2.persistence.repository;

import com.nesGS.vernaculo_v2.persistence.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}