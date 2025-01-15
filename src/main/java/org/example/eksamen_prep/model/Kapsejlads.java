package org.example.eksamen_prep.model;

import jakarta.persistence.*;
import org.example.eksamen_prep.model.Baadtype;

import java.time.LocalDate;

@Entity
public class Kapsejlads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dato;

    @Enumerated(EnumType.STRING)
    private Baadtype baadtype;

    // Getters, setters og constructors
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public Baadtype getBaadtype() {
        return baadtype;
    }

    public void setBaadtype(Baadtype baadtype) {
        this.baadtype = baadtype;
    }

    public Kapsejlads() {
    }

    public Kapsejlads(Long id, LocalDate dato, Baadtype baadtype) {
        this.id = id;
        this.dato = dato;
        this.baadtype = baadtype;
    }
}
