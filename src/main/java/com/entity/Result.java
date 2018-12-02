package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "result")
//@Table(name = "result", schema = "public", catalog = "Velodrome")
public class Result implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id", nullable = false)
    private int result_id;

    @ManyToOne(targetEntity = com.entity.Team.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;

    @ManyToOne(targetEntity = com.entity.Cyclist.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "cyclist_id", referencedColumnName = "cyclist_id")
    private Cyclist cyclist;

    //private Team resultsByTeamId;

    //private int team_id;

    //private Cyclist resultsByCyclistId;

    //private int cyclist_id;

    @Basic
    @Column(name = "race_type", nullable = true, length = 40)
    private String race_type;

    @Basic
    @Column(name = "result_place", nullable = true)
    private int result_place;

    public Result() {
    }

    public Result(int result_id ,int team_id, int cyclist_id, String race_type, int result_place) {
        this.result_id = result_id;
        //this.team_id = team_id;
        //this.cyclist_id = cyclist_id;
        this.race_type = race_type;
        this.result_place = result_place;
    }

    public Result(int team_id, int cyclist_id, String race_type, int result_place) {
        //this.team_id = team_id;
        //this.cyclist_id = cyclist_id;
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

/*    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    public Team getResultsByTeamId() {
        return resultsByTeamId;
    }

    public void setResultsByTeamId(Team resultsByTeamId) {
        this.resultsByTeamId = resultsByTeamId;
    }

    public int getTeamId() {
        return team_id;
    }

    public void setTeamId(int team_id) {
        this.team_id = team_id;
    }*/

/*    @ManyToOne
    @JoinColumn(name = "cyclist_id", referencedColumnName = "cyclist_id")
    public Cyclist getResultsByCyclistId() {
        return resultsByCyclistId;
    }

    public void setResultsByCyclistId(Cyclist resultsByCyclistId) {
        this.resultsByCyclistId = resultsByCyclistId;
    }*/

/*    public int getCyclistId() {
        return cyclist_id;
    }

    public void setCyclistId(int cyclist_id) {
        this.cyclist_id = cyclist_id;
    }*/

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
