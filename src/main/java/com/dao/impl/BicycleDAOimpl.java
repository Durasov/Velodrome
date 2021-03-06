package com.dao.impl;

import com.dao.BicycleDAO;
import com.entity.Bicycle;
import com.entity.Cyclist;
import com.entity.Result;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BicycleDAOimpl implements BicycleDAO {

    public void createBicycle(Cyclist cyclist, String bicycle_name, String bicycle_material, byte bicycle_weight) {
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            /*Bicycle bicycle = new Bicycle();
            bicycle.setCyclist(cyclist);
            bicycle.setBicycleName(bicycle_name);
            bicycle.setBicycleMaterial(bicycle_material);
            bicycle.setBicycleWeight(bicycle_weight);*/

            Bicycle bicycle = new Bicycle(cyclist, bicycle_name, bicycle_material, bicycle_weight);

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

    public void updateBicycle(Bicycle bicycle){
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Bicycle updatedBicycle = (Bicycle) ORMHelper.retrieve(Bicycle.class,bicycle.getBicycleId());
            updatedBicycle.setBicycleName(bicycle.getBicycleName());
            updatedBicycle.setCyclist(bicycle.getCyclist());
            updatedBicycle.setBicycleMaterial(bicycle.getBicycleMaterial());
            updatedBicycle.setBicycleWeight(bicycle.getBicycleWeight());

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
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT b FROM Bicycle b ORDER BY b.bicycle_name");
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

    public Bicycle getBicycle(String bicycleName){
        ORMHelper.openSession();
        List<Bicycle> bicycles = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Bicycle bicycle;
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT b FROM Bicycle b where b.bicycle_name LIKE: param")
                    .setParameter("param",bicycleName);
            bicycles = query.getResultList();
            int bicycle_id = bicycles.get(0).getBicycleId();
            Cyclist cyclist = bicycles.get(0).getCyclist();
            String bicycle_name = bicycles.get(0).getBicycleName();
            String bicycle_material = bicycles.get(0).getBicycleMaterial();
            byte bicycle_weight = bicycles.get(0).getBicycleWeight();
            bicycle = new Bicycle(bicycle_id, cyclist, bicycle_name, bicycle_material, bicycle_weight);
            ORMHelper.commitTransaction();
            return bicycle;
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public Bicycle getBicycle(int bicycleId){
        ORMHelper.openSession();
        List<Bicycle> bicycles = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Bicycle bicycle;
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT b FROM Bicycle b where b.bicycle_id =: param")
                    .setParameter("param",bicycleId);
            bicycles = query.getResultList();
            int bicycle_id = bicycles.get(0).getBicycleId();
            Cyclist cyclist = bicycles.get(0).getCyclist();
            String bicycle_name = bicycles.get(0).getBicycleName();
            String bicycle_material = bicycles.get(0).getBicycleMaterial();
            byte bicycle_weight = bicycles.get(0).getBicycleWeight();
            bicycle = new Bicycle(bicycle_id, cyclist, bicycle_name, bicycle_material, bicycle_weight);
            ORMHelper.commitTransaction();
            return bicycle;
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

}
