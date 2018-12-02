package com.dao;

import com.entity.Cyclist;

import java.util.List;

public interface CyclistDAO {

    public void createCyclist(int team_id,String cyclist_name, int cyclist_age);

    public void deleteCyclist(int cyclist_id);

    public List<Cyclist> getCyclists();

}
