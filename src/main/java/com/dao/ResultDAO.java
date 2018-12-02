package com.dao;

import com.entity.Result;

import java.util.List;

public interface ResultDAO {

    public void createResult(int team_id, int cyclist_id, String race_type, int result_place);

    public void deleteResult(int result_id);

    public List<Result> getResults();

}
