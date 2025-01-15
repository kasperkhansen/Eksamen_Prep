package org.example.eksamen_prep.repository;

import org.example.eksamen_prep.model.Kapsejlads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KapsejladsRepository extends JpaRepository<Kapsejlads, Long> {}
