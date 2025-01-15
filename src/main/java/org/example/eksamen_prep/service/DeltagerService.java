package org.example.eksamen_prep.service;

import org.example.eksamen_prep.model.Deltager;
import org.example.eksamen_prep.model.Kapsejlads;
import org.example.eksamen_prep.model.Sejlbaade;
import org.example.eksamen_prep.repository.DeltagerRepository;
import org.example.eksamen_prep.repository.KapsejladsRepository;
import org.example.eksamen_prep.repository.SejlbaadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeltagerService {
    private final DeltagerRepository deltagerRepository;
    private final SejlbaadeRepository sejlbaadeRepository;
    private final KapsejladsRepository kapsejladsRepository;

    public DeltagerService(DeltagerRepository deltagerRepository,
                           SejlbaadeRepository sejlbaadeRepository,
                           KapsejladsRepository kapsejladsRepository) {
        this.deltagerRepository = deltagerRepository;
        this.sejlbaadeRepository = sejlbaadeRepository;
        this.kapsejladsRepository = kapsejladsRepository;
    }

    public Deltager save(Deltager deltager) {
        if (deltager.getSejlbaade() == null || deltager.getSejlbaade().getId() == null) {
            throw new RuntimeException("Sejlbaad ID mangler eller er ugyldigt.");
        }
        if (deltager.getKapsejlads() == null || deltager.getKapsejlads().getId() == null) {
            throw new RuntimeException("Kapsejlads ID mangler eller er ugyldigt.");
        }

        Long sejlbaadId = deltager.getSejlbaade().getId();
        Long kapsejladsId = deltager.getKapsejlads().getId();

        Sejlbaade sejlbaad = sejlbaadeRepository.findById(sejlbaadId)
                .orElseThrow(() -> new RuntimeException("Sejlbaad med ID " + sejlbaadId + " findes ikke."));
        Kapsejlads kapsejlads = kapsejladsRepository.findById(kapsejladsId)
                .orElseThrow(() -> new RuntimeException("Kapsejlads med ID " + kapsejladsId + " findes ikke."));

        deltager.setSejlbaade(sejlbaad);
        deltager.setKapsejlads(kapsejlads);
        return deltagerRepository.save(deltager);
    }

    public List<Sejlbaade> findMostActiveSejlbaade() {
        return deltagerRepository.findAll().stream()
                .collect(Collectors.groupingBy(deltager -> deltager.getSejlbaade().getId(), Collectors.counting()))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .map(entry -> {
                    Sejlbaade sejlbaad = new Sejlbaade();
                    sejlbaad.setId(entry.getKey());
                    sejlbaad.setAntalDeltagelser(entry.getValue()); // Tilføj evt. ny felt "antalDeltagelser"
                    return sejlbaad;
                })
                .collect(Collectors.toList());
    }


    public List<Deltager> findAll() {
        return deltagerRepository.findAll();
    }

    public void deleteById(Long id) {
        deltagerRepository.deleteById(id);
    }
}
