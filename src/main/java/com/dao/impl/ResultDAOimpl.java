package com.dao.impl;

import com.dao.ResultDAO;
import com.entity.Cyclist;
import com.entity.Result;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResultDAOimpl implements ResultDAO {

    public void createResult(int team_id, int cyclist_id, String race_type, int result_place) {
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Result result = new Result();
            //result.setTeamId(team_id);
            //result.setCyclistId(cyclist_id);
            result.setRaceType(race_type);
            result.setResultPlace(result_place);

            ORMHelper.create(result);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public void deleteResult(int result_id){
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Result result = ORMHelper.getCurrentSession().find(Result.class,result_id);
            ORMHelper.delete(result);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public void updateResult(Result result){
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            ORMHelper.update(result);
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

    public List<Result> getResults(){
        ORMHelper.openSession();
        List<Result> results = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT r FROM Result r ORDER BY r.result_place");
            results = query.getResultList();
            ORMHelper.commitTransaction();
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
        return results;
    }

}
