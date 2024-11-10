package com.nesGS.vernaculo_v2.repository;


import com.nesGS.vernaculo_v2.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
