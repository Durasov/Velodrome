package com.dao.impl;

import com.dao.BicycleDAO;
import com.entity.Bicycle;
import com.entity.Result;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BicycleDAOimpl implements BicycleDAO {

    public void createBicycle(int cyclist_id, String bicycle_name, String bicycle_material, byte bicycle_weight) {
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Bicycle bicycle = new Bicycle();
            //bicycle.setCyclistId(cyclist_id);
            bicycle.setBicycleName(bicycle_name);
            bicycle.setBicycleMaterial(bicycle_material);
            bicycle.setBicycleWeight(bicycle_weight);

            ORMHelper.create(bicycle);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public void deleteBicycle(int bicycle_id){
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Bicycle bicycle = ORMHelper.getCurrentSession().find(Bicycle.class,bicycle_id);
            ORMHelper.delete(bicycle);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public List<Bicycle> getBicycles(){
        ORMHelper.openSession();
        List<Bicycle> bicycles = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT b FROM bicycle b ORDER BY b.bicycle_name");
            bicycles = query.getResultList();
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
        return bicycles;
    }

}
