package org.example.eksamen_prep.controller;

import org.example.eksamen_prep.model.Sejlbaade;
import org.springframework.web.bind.annotation.*;
import org.example.eksamen_prep.service.SejlbaadeService;

import java.util.List;

@RestController
@RequestMapping("/api/sejlbaade")
public class SejlbaadeController {

    private SejlbaadeService sejlbaadeService;

    public SejlbaadeController(SejlbaadeService sejlbaadeService) {
        this.sejlbaadeService = sejlbaadeService;
    }

    // ----------------- Operations ---------------------

    @GetMapping
    public List<Sejlbaade> getAll() {
        return sejlbaadeService.getSejlbaade();
    }

    @PostMapping
    public Sejlbaade create(@RequestBody Sejlbaade sejlbaade) {
        return sejlbaadeService.createSejlbaade(sejlbaade);
    }

    @PutMapping("/{id}")
    public Sejlbaade update(@PathVariable Long id, @RequestBody  Sejlbaade sejlbaade) {
        return sejlbaadeService.updateSejlbaade(id, sejlbaade);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sejlbaadeService.deleteSejlbaade(id);
    }


}
