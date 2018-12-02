package com.dao.impl;

import com.dao.CyclistDAO;
import com.entity.Cyclist;
import com.entity.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CyclistDAOimpl implements CyclistDAO {

    public void createCyclist(Team team, String cyclist_name, int cyclist_age) {
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Cyclist cyclist = new Cyclist();
            cyclist.setTeam(team);
            cyclist.setCyclistName(cyclist_name);
            cyclist.setCyclistAge(cyclist_age);

            ORMHelper.create(cyclist);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public void deleteCyclist(int cyclist_id){
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Cyclist cyclist = ORMHelper.getCurrentSession().find(Cyclist.class,cyclist_id);
            ORMHelper.delete(cyclist);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public void updateCyclist(Cyclist cyclist){
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            ORMHelper.update(cyclist);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public List<Cyclist> getCyclists(){
        ORMHelper.openSession();
        List<Cyclist> cyclists = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT c FROM Cyclist c ORDER BY c.cyclist_name");
            cyclists = query.getResultList();
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
        return cyclists;
    }

    public Cyclist getCyclist(String cyclistName){
        ORMHelper.openSession();
        List<Cyclist> cyclists = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Cyclist cyclist;
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT c FROM Cyclist c where c.cyclist_name LIKE: param")
                    .setParameter("param",cyclistName);
            cyclists = query.getResultList();
            Team team = cyclists.get(0).getTeam();
            String cyclist_name = cyclists.get(0).getCyclistName();
            int cyclist_age = cyclists.get(0).getCyclistAge();
            cyclist = new Cyclist(team,cyclist_name,cyclist_age);
            ORMHelper.commitTransaction();
            return cyclist;
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }
}
