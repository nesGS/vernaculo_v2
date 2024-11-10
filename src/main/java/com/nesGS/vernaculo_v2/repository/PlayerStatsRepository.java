package com.nesGS.vernaculo_v2.repository;

import com.nesGS.vernaculo_v2.model.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {
}