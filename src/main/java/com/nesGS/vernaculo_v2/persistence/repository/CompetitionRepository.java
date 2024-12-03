package com.nesGS.vernaculo_v2.persistence.repository;

import com.nesGS.vernaculo_v2.persistence.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}