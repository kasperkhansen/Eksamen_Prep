package org.example.eksamen_prep.controller;

import org.example.eksamen_prep.model.Kapsejlads;
import org.example.eksamen_prep.service.KapsejladsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kapsejladser")
public class KapsejladsController {
    private final KapsejladsService service;

    public KapsejladsController(KapsejladsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Kapsejlads> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Kapsejlads create(@RequestBody Kapsejlads kapsejlads) {
        return service.save(kapsejlads);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/saeson")
    public List<Kapsejlads> opretSaeson() {
        return service.opretSaeson();
    }
}
