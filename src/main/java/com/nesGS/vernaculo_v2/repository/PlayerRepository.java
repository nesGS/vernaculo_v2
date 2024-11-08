package com.nesGS.vernaculo_v2.repository;


import com.nesGS.vernaculo_v2.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
