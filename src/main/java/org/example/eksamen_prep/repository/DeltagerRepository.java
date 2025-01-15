package org.example.eksamen_prep.repository;

import org.example.eksamen_prep.model.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeltagerRepository extends JpaRepository<Deltager, Long> {}
