package com.nesGS.vernaculo_v2.repository;

import com.nesGS.vernaculo_v2.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}