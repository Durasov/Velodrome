package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cyclist")
public class Cyclist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cyclist_id", nullable = false)
    private int cyclist_id;

    @ManyToOne(targetEntity = com.entity.Team.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;

    @Basic
    @Column(name = "cyclist_name", nullable = true, length = 40)
    private String cyclist_name;

    @Basic
    @Column(name = "cyclist_age", nullable = true)
    private int cyclist_age;

    @OneToMany(targetEntity = com.entity.Bicycle.class, mappedBy = "cyclist", cascade = CascadeType.ALL)
    private Set<Bicycle> bicycles = new HashSet<Bicycle>(0);

    @OneToMany(targetEntity = com.entity.Result.class, fetch = FetchType.LAZY, mappedBy = "cyclist")
    private Set<Result> results = new HashSet<Result>(0);

    public Cyclist() {
    }

    public Cyclist(int cyclist_id, Team team, String cyclist_name, int cyclist_age) {
        this.cyclist_id = cyclist_id;
        this.team = team;
        this.cyclist_name = cyclist_name;
        this.cyclist_age = cyclist_age;
    }

    public Cyclist(Team team, String cyclist_name, int cyclist_age) {
        this.team = team;
        this.cyclist_name = cyclist_name;
        this.cyclist_age = cyclist_age;
    }

    public int getCyclistId() {
        return cyclist_id;
    }

    public void setCyclistId(int cyclist_id) {
        this.cyclist_id = cyclist_id;
    }

    public Team getTeam(){
        return team;
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public String getCyclistName() {
        return cyclist_name;
    }

    public void setCyclistName(String cyclist_name) {
        this.cyclist_name = cyclist_name;
    }

    public int getCyclistAge() {
        return cyclist_age;
    }

    public void setCyclistAge(int cyclist_age) {
        this.cyclist_age = cyclist_age;
    }

    public Set<Bicycle> getBicycles(){
        return this.bicycles;
    }

    public void setBicycles(Set<Bicycle> bicycles){
        this.bicycles = bicycles;
    }

    public Set<Result> getResults(){
        return this.results;
    }

    public void setResults(Set<Result> results){
        this.results = results;
    }

}
