package com.entity;

import org.apache.openjpa.persistence.jdbc.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team")
//@Table(name = "team", schema = "public", catalog = "Velodrome")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id", nullable = false)
    private int team_id ;

    @Basic
    @Column(name = "team_name", nullable = true, length = 20)
    private String team_name;

    @Basic
    @Column(name = "team_country", nullable = true, length = 20)
    private String team_country;

    @OneToMany(targetEntity = com.entity.Cyclist.class, fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Cyclist> cyclists = new HashSet<Cyclist>(0);

    @OneToMany(targetEntity = com.entity.Result.class, fetch = FetchType.LAZY, mappedBy = "team")
    private Set<Result> results = new HashSet<Result>(0);

    //private Collection<Cyclist> cyclistsByTeamId;
    //private Collection<Result> resultsByTeamId;

    public Team() {
    }

    public Team(int team_id , String team_name, String team_country) {
        this.team_id  = team_id ;
        this.team_name = team_name;
        this.team_country = team_country;
    }

    public Team(String team_name, String team_country) {
        this.team_name = team_name;
        this.team_country = team_country;
    }

    public int getTeamId() {
        return team_id ;
    }

    public void setTeamId(int team_id) {
        this.team_id  = team_id ;
    }

    public String getTeamName() {
        return team_name;
    }

    public void setTeamName(String team_name) {
        this.team_name = team_name;
    }

    public String getTeamCountry() {
        return team_country;
    }

    public void setTeamCountry(String team_country) {
        this.team_country = team_country;
    }

    public Set<Cyclist> getCyclists(){
        return this.cyclists;
    }

    public void setCyclists(Set<Cyclist> cyclists){
        this.cyclists = cyclists;
    }

    public Set<Result> getResults(){
        return this.results;
    }

    public void setResults(Set<Result> results){
        this.results = results;
    }

/*    @OneToMany(mappedBy = "cyclistsByTeamId")
    public Collection<Cyclist> getCyclistsByTeamId() {
        return cyclistsByTeamId;
    }

    public void setCyclistsByTeamId(Collection<Cyclist> cyclistsByTeamId) {
        this.cyclistsByTeamId = cyclistsByTeamId;
    }*/

/*    @OneToMany(mappedBy = "resultsByTeamId")
    public Collection<Result> getResultsByTeamId() {
        return resultsByTeamId;
    }

    public void setResultsByTeamId(Collection<Result> resultsByTeamId) {
        this.resultsByTeamId = resultsByTeamId;
    }*/

}
