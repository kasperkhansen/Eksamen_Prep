package org.example.eksamen_prep.service;

import org.example.eksamen_prep.model.Baadtype;
import org.example.eksamen_prep.model.Kapsejlads;
import org.example.eksamen_prep.repository.KapsejladsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class KapsejladsService {
    private final KapsejladsRepository repository;

    public KapsejladsService(KapsejladsRepository repository) {
        this.repository = repository;
    }

    public List<Kapsejlads> opretSaeson() {
        LocalDate startDato = LocalDate.of(2023, 5, 1);
        LocalDate slutDato = LocalDate.of(2023, 10, 1);
        List<Kapsejlads> kapsejladser = new ArrayList<>();

        while (!startDato.isAfter(slutDato)) {
            if (startDato.getDayOfWeek().getValue() == 3) { // Onsdag = 3
                for (Baadtype baadtype : Baadtype.values()) {
                    Kapsejlads kapsejlads = new Kapsejlads();
                    kapsejlads.setDato(startDato);
                    kapsejlads.setBaadtype(baadtype);
                    kapsejladser.add(kapsejlads);
                }
            }
            startDato = startDato.plusDays(1);
        }

        return repository.saveAll(kapsejladser);
    }



    public List<Kapsejlads> findAll() {
        return repository.findAll();
    }

    public Kapsejlads save(Kapsejlads kapsejlads) {
        return repository.save(kapsejlads);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

