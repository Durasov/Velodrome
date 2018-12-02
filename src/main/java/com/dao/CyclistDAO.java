package com.dao;

import com.entity.Cyclist;
import com.entity.Team;

import java.util.List;

public interface CyclistDAO {

    public void createCyclist(Team team, String cyclist_name, int cyclist_age);

    public void deleteCyclist(int cyclist_id);

    public void updateCyclist(Cyclist cyclist);

    public List<Cyclist> getCyclists();

}
