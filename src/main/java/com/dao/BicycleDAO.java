package com.dao;

import com.entity.Bicycle;

import java.util.List;

public interface BicycleDAO {

    public void createBicycle(int cyclist_id, String bicycle_name, String bicycle_material, byte bicycle_weight);

    public void deleteBicycle(int bicycle_id);

    public List<Bicycle> getBicycles();

}
