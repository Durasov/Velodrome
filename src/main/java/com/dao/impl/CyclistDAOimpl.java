package com.dao.impl;

import com.dao.CyclistDAO;
import com.entity.Cyclist;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CyclistDAOimpl implements CyclistDAO {

    public void createCyclist(int team_id,String cyclist_name, int cyclist_age) {
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Cyclist cyclist = new Cyclist();
            //cyclist.setTeamId(team_id);
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

    public List<Cyclist> getCyclists(){
        ORMHelper.openSession();
        List<Cyclist> cyclists = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT c FROM cyclist c ORDER BY c.cyclist_name");
            cyclists = query.getResultList();
            //String test = cyclists.get(0).getTeam().getTeamName();
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
        return cyclists;
    }
}