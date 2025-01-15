package org.example.eksamen_prep.model;

import jakarta.persistence.*;
import org.example.eksamen_prep.model.Kapsejlads;
import org.example.eksamen_prep.model.Sejlbaade;

@Entity
public class Deltager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sejlbaad_id", nullable = false)
    private Sejlbaade sejlbaade;

    @ManyToOne
    @JoinColumn(name = "kapsejlads_id", nullable = false)
    private Kapsejlads kapsejlads;

    private int point;

    // Getters, setters og constructors


    public Deltager() {
    }

    public Deltager(Long id, Sejlbaade sejlbaade, Kapsejlads kapsejlads, int point) {
        this.id = id;
        this.sejlbaade = sejlbaade;
        this.kapsejlads = kapsejlads;
        this.point = point;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sejlbaade getSejlbaade() {
        return sejlbaade;
    }

    public void setSejlbaade(Sejlbaade sejlbaade) {
        this.sejlbaade = sejlbaade;
    }

    public Kapsejlads getKapsejlads() {
        return kapsejlads;
    }

    public void setKapsejlads(Kapsejlads kapsejlads) {
        this.kapsejlads = kapsejlads;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
