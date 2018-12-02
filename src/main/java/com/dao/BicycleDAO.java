package com.dao;

import com.entity.Bicycle;
import com.entity.Cyclist;

import java.util.List;

public interface BicycleDAO {

    public void createBicycle(Cyclist cyclist, String bicycle_name, String bicycle_material, byte bicycle_weight);

    public void deleteBicycle(int bicycle_id);

    public void updateBicycle(Bicycle bicycle);

    public List<Bicycle> getBicycles();

}
