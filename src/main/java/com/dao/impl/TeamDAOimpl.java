package com.dao.impl;

import com.dao.TeamDAO;
import com.entity.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamDAOimpl implements TeamDAO {

    public void createTeam(String team_name, String team_country) {
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Team team = new Team();
            team.setTeamName(team_name);
            team.setTeamCountry(team_country);

            ORMHelper.create(team);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public void deleteTeam(int team_id){
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Team team = ORMHelper.getCurrentSession().find(Team.class,team_id);
            ORMHelper.delete(team);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public void updateTeam(Team team){
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            ORMHelper.update(team);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public List<Team> getTeams(){
        ORMHelper.openSession();
        List<Team> teams = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Team team = new Team();
            //ORMHelper.retrieve(Team.class,team); //Не работает
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT t FROM Team t ORDER BY t.team_name");
            teams = query.getResultList();
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
        return teams;
    }

    public Team getTeam(String teamName){
        ORMHelper.openSession();
        List<Team> teams = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Team team;
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT t FROM Team t where t.team_name LIKE: param")
                    .setParameter("param",teamName);
            teams = query.getResultList();
            String team_name = teams.get(0).getTeamName();
            String team_country = teams.get(0).getTeamCountry();
            team = new Team(team_name,team_country);
            ORMHelper.commitTransaction();
            return team;
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public Team getTeam(int team_id){
        ORMHelper.openSession();
        List<Team> teams = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Team team;
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT t FROM Team t where t.team_id =: param")
                    .setParameter("param",team_id);
            teams = query.getResultList();
            String team_name = teams.get(0).getTeamName();
            String team_country = teams.get(0).getTeamCountry();
            team = new Team(team_name,team_country);
            ORMHelper.commitTransaction();
            return team;
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }
}
