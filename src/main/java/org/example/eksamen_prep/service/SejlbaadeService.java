package org.example.eksamen_prep.service;

import org.example.eksamen_prep.model.Sejlbaade;
import org.example.eksamen_prep.repository.SejlbaadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SejlbaadeService {

    private final SejlbaadeRepository sejlbaadeRepository;

    public SejlbaadeService(SejlbaadeRepository sejlbaadeRepository) {
        this.sejlbaadeRepository = sejlbaadeRepository;
    }

    // ----------------- Operations ---------------------

    // ----------------- CRUD Operations ---------------------

    // ----------------- 1. Create ---------------------

    public Sejlbaade createSejlbaade(Sejlbaade sejlbaade) {
        return sejlbaadeRepository.save(sejlbaade);
    }

    // ----------------- 2. Read ---------------------

    public Sejlbaade getSejlbaade(Long id) {
        return sejlbaadeRepository.findById(id).orElse(null);
    }

    public List<Sejlbaade> getSejlbaade() {
        return sejlbaadeRepository.findAll();
    }

    // ----------------- 3. Update ---------------------

    public Sejlbaade updateSejlbaade(Long id, Sejlbaade sejlbaade) {
        return sejlbaadeRepository.findById(id)
                .map(existing -> {
                    existing.setNavn(sejlbaade.getNavn());
                    existing.setBaadtype(sejlbaade.getBaadtype());
                    return sejlbaadeRepository.save(existing);
                })
                .orElseThrow(()-> new RuntimeException("Sejlbaade not found"));
    }

    // ----------------- 4. Delete ---------------------

    public void deleteSejlbaade(Long id) {
        sejlbaadeRepository.deleteById(id);
    }
}
