package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bicycle")
public class Bicycle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bicycle_id", nullable = false)
    private int bicycle_id;

    @ManyToOne(targetEntity = com.entity.Cyclist.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cyclist_id", referencedColumnName = "cyclist_id")
    private Cyclist cyclist;

    @Basic
    @Column(name = "bicycle_name", nullable = true, length = 40)
    private String bicycle_name ;

    @Basic
    @Column(name = "bicycle_material", nullable = true, length = 20)
    private String bicycle_material ;

    @Basic
    @Column(name = "bicycle_weight", nullable = true)
    private byte bicycle_weight ;

    public Bicycle() {
    }

    public Bicycle(int bicycle_id, Cyclist cyclist, String bicycle_name, String bicycle_material, byte bicycle_weight) {
        this.bicycle_id = bicycle_id;
        this.cyclist = cyclist;
        this.bicycle_name = bicycle_name;
        this.bicycle_material = bicycle_material;
        this.bicycle_weight = bicycle_weight;
    }

    public Bicycle(Cyclist cyclist, String bicycle_name, String bicycle_material, byte bicycle_weight) {
        this.cyclist = cyclist;
        this.bicycle_name = bicycle_name;
        this.bicycle_material = bicycle_material;
        this.bicycle_weight = bicycle_weight;
    }

    public int getBicycleId() {
        return bicycle_id;
    }

    public Cyclist getCyclist(){
        return cyclist;
    }

    public void setCyclist(Cyclist cyclist){
        this.cyclist = cyclist;
    }

    public String getBicycleName() {
        return bicycle_name;
    }

    public void setBicycleName(String bicycle_name) {
        this.bicycle_name = bicycle_name;
    }

    public String getBicycleMaterial() {
        return bicycle_material;
    }

    public void setBicycleMaterial(String bicycle_material) {
        this.bicycle_material = bicycle_material;
    }

    public byte getBicycleWeight() {
        return bicycle_weight;
    }

    public void setBicycleWeight(byte bicycle_weight) {
        this.bicycle_weight = bicycle_weight;
    }
}
