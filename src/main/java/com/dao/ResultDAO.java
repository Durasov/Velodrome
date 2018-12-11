package com.dao;

import com.entity.Cyclist;
import com.entity.Result;
import com.entity.Team;

import java.util.List;

public interface ResultDAO {

    public void createResult(Team team, Cyclist cyclist, String race_type, int result_place);

    public void deleteResult(int result_id);

    public void updateResult(Result result);

    public List<Result> getResults();

}
