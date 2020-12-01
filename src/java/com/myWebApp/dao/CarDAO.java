package com.myWebApp.dao;

/**
 *
 * @author dkats
 */
import java.util.List;

import com.myWebApp.entities.Car;

public interface CarDAO {

    List<Car> getCars();
   
    boolean save(Car c);
    
    Car getCarById(int id);
    
    boolean update(Car c);
    
     boolean delete(Car c);
}
