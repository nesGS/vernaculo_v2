package com.nesGS.vernaculo_v2.repository;

import com.nesGS.vernaculo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
