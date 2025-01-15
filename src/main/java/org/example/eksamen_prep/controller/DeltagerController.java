package org.example.eksamen_prep.controller;

import org.example.eksamen_prep.model.Deltager;
import org.example.eksamen_prep.model.Sejlbaade;
import org.example.eksamen_prep.service.DeltagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deltagere")
public class DeltagerController {
    private final DeltagerService service;

    public DeltagerController(DeltagerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Deltager> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Deltager create(@RequestBody Deltager deltager) {
        return service.save(deltager);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/most-active-sejlbaade")
    public List<Sejlbaade> getMostActiveSejlbaade() {
        return service.findMostActiveSejlbaade();
    }
}
