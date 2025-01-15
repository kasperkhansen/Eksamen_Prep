package org.example.eksamen_prep.model;

import jakarta.persistence.*;

@Entity
public class Sejlbaade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String navn;

    @Enumerated(EnumType.STRING)
    private Baadtype baadtype;

    @Transient
    private Long antalDeltagelser;

    public Sejlbaade() {
    }

    public Sejlbaade(String navn, Baadtype baadtype) {
        this.navn = navn;
        this.baadtype = baadtype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Baadtype getBaadtype() {
        return baadtype;
    }

    public void setBaadtype(Baadtype baadtype) {
        this.baadtype = baadtype;
    }

    public Long getAntalDeltagelser() {
        return antalDeltagelser;
    }

    public void setAntalDeltagelser(Long antalDeltagelser) {
        this.antalDeltagelser = antalDeltagelser;
    }
}
