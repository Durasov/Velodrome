package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "result")
public class Result implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id", nullable = false)
    private int result_id;

    @ManyToOne(targetEntity = com.entity.Team.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;

    @ManyToOne(targetEntity = com.entity.Cyclist.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cyclist_id", referencedColumnName = "cyclist_id")
    private Cyclist cyclist;

    @Basic
    @Column(name = "race_type", nullable = true, length = 40)
    private String race_type;

    @Basic
    @Column(name = "result_place", nullable = true)
    private int result_place;

    public Result() {
    }

    public Result(int result_id , Team team, Cyclist cyclist, String race_type, int result_place) {
        this.result_id = result_id;
        this.team = team;
        this.cyclist = cyclist;
        this.race_type = race_type;
        this.result_place = result_place;
    }

    public Result(Team team, Cyclist cyclist, String race_type, int result_place) {
        this.team = team;
        this.cyclist = cyclist;
        this.race_type = race_type;
        this.result_place = result_place;
    }

    public int getResultId() {
        return result_id;
    }

    public void setResultId(int result_id) {
        this.result_id = result_id;
    }

    public Team getTeam(){
        return team;
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public Cyclist getCyclist(){
        return cyclist;
    }

    public void setCyclist(Cyclist cyclist){
        this.cyclist = cyclist;
    }

    public String getRaceType() {
        return race_type;
    }

    public void setRaceType(String race_type) {
        this.race_type = race_type;
    }

    public int getResultPlace() {
        return result_place;
    }

    public void setResultPlace(int result_place) {
        this.result_place = result_place;
    }
}
