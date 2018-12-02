package com.dao;

import com.entity.Team;

import java.util.List;

public interface TeamDAO {

    public void createTeam(String team_name, String team_country);

    public void deleteTeam(int team_id);

    public List<Team> getTeams();

    public Team getTeam(String team_name);

}
