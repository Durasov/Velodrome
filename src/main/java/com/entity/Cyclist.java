package com.entity;

import org.apache.openjpa.persistence.LRS;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "cyclist")
//@Table(name = "cyclist", schema = "public", catalog = "Velodrome")
public class Cyclist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cyclist_id", nullable = false)
    private int cyclist_id;

    @ManyToOne(targetEntity = com.entity.Team.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;

    //private Team cyclistsByTeamId;

    //private int team_id;

    @Basic
    @Column(name = "cyclist_name", nullable = true, length = 40)
    private String cyclist_name;

    @Basic
    @Column(name = "cyclist_age", nullable = true)
    private int cyclist_age;

    @OneToMany(targetEntity = com.entity.Bicycle.class, fetch = FetchType.LAZY, mappedBy = "cyclist")
    private Set<Bicycle> bicycles = new HashSet<Bicycle>(0);

    //private Collection<Bicycle> bicyclesByCyclistId;

    @OneToMany(targetEntity = com.entity.Result.class, fetch = FetchType.LAZY, mappedBy = "cyclist")
    private Set<Result> results = new HashSet<Result>(0);

    //private Collection<Result> resultsByCyclistId;

    public Cyclist() {
    }

    public Cyclist(int cyclist_id,int team_id, String cyclist_name, int cyclist_age) {
        this.cyclist_id = cyclist_id;
        //this.team_id = team_id;
        this.cyclist_name = cyclist_name;
        this.cyclist_age = cyclist_age;
    }

    public Cyclist(int team_id, String cyclist_name, int cyclist_age) {
        //this.team_id = team_id;
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

/*    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    public Team getCyclistsByTeamId() {
        return cyclistsByTeamId;
    }

    public void setCyclistsByTeamId(Team cyclistsByTeamId) {
        this.cyclistsByTeamId = cyclistsByTeamId;
    }*/

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

/*    public int getTeamId() {
        return team_id;
    }

    public void setTeamId(int team_id) {
        this.team_id = team_id;
    }*/

/*    @OneToMany(mappedBy = "bicyclesByCyclistId")
    public Collection<Bicycle> getBicyclesByCyclistId() {
        return bicyclesByCyclistId;
    }

    public void setBicyclesByCyclistId(Collection<Bicycle> bicyclesByCyclistId) {
        this.bicyclesByCyclistId = bicyclesByCyclistId;
    }*/

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

/*    @OneToMany(mappedBy = "resultsByCyclistId")
    public Collection<Result> getResultsByCyclistId() {
        return resultsByCyclistId;
    }

    public void setResultsByCyclistId(Collection<Result> resultsByCyclistId) {
        this.resultsByCyclistId = resultsByCyclistId;
    }*/
}
