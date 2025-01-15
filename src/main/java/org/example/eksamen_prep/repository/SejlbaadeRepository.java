package org.example.eksamen_prep.repository;

import org.example.eksamen_prep.model.Sejlbaade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SejlbaadeRepository extends JpaRepository<Sejlbaade, Long> {
}
