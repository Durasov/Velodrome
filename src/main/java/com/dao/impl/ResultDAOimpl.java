package com.dao.impl;

import com.dao.ResultDAO;
import com.entity.Cyclist;
import com.entity.Result;
import com.entity.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResultDAOimpl implements ResultDAO {

    public void createResult(Team team, Cyclist cyclist, String race_type, int result_place) {
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            Result result = new Result();
            result.setTeam(team);
            result.setCyclist(cyclist);
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
            Result updatedResult = (Result) ORMHelper.retrieve(Result.class,result.getResultId());
            updatedResult.setTeam(result.getTeam());
            updatedResult.setCyclist(result.getCyclist());
            updatedResult.setRaceType(result.getRaceType());
            updatedResult.setResultPlace(result.getResultPlace());

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

    public Result getResult(int resultId){
        ORMHelper.openSession();
        List<Result> results = new ArrayList<>();
        try {
            ORMHelper.beginTransaction();
            Result result;
            Query query = ORMHelper.getCurrentSession().createQuery("SELECT r FROM Result r where r.result_id =: param")
                    .setParameter("param",resultId);
            results = query.getResultList();
            int result_id = results.get(0).getResultId();
            Cyclist cyclist = results.get(0).getCyclist();
            Team team = results.get(0).getTeam();
            String race_type = results.get(0).getRaceType();
            int result_place = results.get(0).getResultPlace();
            result = new Result(result_id , team, cyclist, race_type, result_place);
            ORMHelper.commitTransaction();
            return result;
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            ORMHelper.closeSession();
        }
    }

}
