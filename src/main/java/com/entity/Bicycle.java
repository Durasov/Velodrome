package com.entity;

import org.apache.openjpa.persistence.jdbc.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bicycle")
//@Table(name = "bicycle", schema = "public", catalog = "Velodrome")
public class Bicycle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bicycle_id", nullable = false)
    private int bicycle_id;

    @ManyToOne(targetEntity = com.entity.Cyclist.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cyclist_id", referencedColumnName = "cyclist_id")
    private Cyclist cyclist;

    //private Cyclist bicyclesByCyclistId;

    //private int cyclist_id ;

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

    public Bicycle(int bicycle_id, int cyclist_id, String bicycle_name, String bicycle_material, byte bicycle_weight) {
        this.bicycle_id = bicycle_id;
        //this.cyclist_id = cyclist_id;
        this.bicycle_name = bicycle_name;
        this.bicycle_material = bicycle_material;
        this.bicycle_weight = bicycle_weight;
    }

    public Bicycle(int cyclist_id, String bicycle_name, String bicycle_material, byte bicycle_weight) {
        //this.cyclist_id = cyclist_id;
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

/*    @ManyToOne
    @JoinColumn(name = "cyclist_id", referencedColumnName = "cyclist_id")
    public Cyclist getBicyclesByCyclistId() {
        return bicyclesByCyclistId;
    }

    public void setBicyclesByCyclistId(Cyclist bicyclesByCyclistId) {
        this.bicyclesByCyclistId = bicyclesByCyclistId;
    }

    public void setBicycleId(int bicycle_id) {
        this.bicycle_id = bicycle_id;
    }

    public int getCyclistId() { return cyclist_id; }

    public void setCyclistId(int cyclist_id) { this.cyclist_id = cyclist_id; }*/

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
