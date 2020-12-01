package com.myWebApp.dao;

import com.myWebApp.dbUtil.DBConnectionUtil;
import com.myWebApp.entities.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dkats
 */
public class CarDAOImpl implements CarDAO {

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    @Override
    public List<Car> getCars() {
        List<Car> listOfCars = null;
        try {
            listOfCars = new ArrayList<Car>();

            // create sql query
            String sqlQuery = "SELECT * FROM car";

            // get the database connection
            connection = DBConnectionUtil.getConnection();

            // create prepared statement
            pstmt = connection.prepareStatement(sqlQuery);

            // execute sql query
            resultSet = pstmt.executeQuery();

            // process
            if (resultSet != null) {
                while (resultSet.next()) {
                    // add car to list
                    listOfCars.add(new Car(resultSet.getInt("carId"), resultSet.getString("model"),
                            resultSet.getString("plate"), resultSet.getString("color")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return the list
        return listOfCars;
    }

    @Override
    public boolean save(Car c) {

        boolean isTrue = false;

        try {
            // create sql query
            String sqlQuery = "INSERT INTO car "
                    + "(model, plate, color) "
                    + "VALUES ('" + c.getModel() + "','" + c.getPlateNumber() + "','" + c.getColor() + "')";

            // get the database connection
            connection = DBConnectionUtil.getConnection();

            // create prepared statement
            pstmt = connection.prepareStatement(sqlQuery);

            // execute sql query
            pstmt.executeUpdate();

            isTrue = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return isTrue;
    }

    @Override
    public Car getCarById(int id) {
        Car car = null;
        try {

            String sqlQuery = "SELECT * FROM car WHERE carId=" + id;

            // get the database connection
            connection = DBConnectionUtil.getConnection();

            // create prepared statement
            pstmt = connection.prepareStatement(sqlQuery);

            // execute sql query
            resultSet = pstmt.executeQuery();

            // process
            if (resultSet != null) {
                while (resultSet.next()) {
                    // make a car 
                    car = new Car(resultSet.getInt("carId"), resultSet.getString("model"),
                            resultSet.getString("plate"), resultSet.getString("color"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public boolean update(Car c) {
        boolean isTrue = false;
        try {
            String sqlQuery = "UPDATE car SET model='" + c.getModel()
                    + "' , plate='" + c.getPlateNumber()
                    + "' , color='" + c.getColor()
                    + "' WHERE carId="
                    + c.getId();

            // get the database connection
            connection = DBConnectionUtil.getConnection();

            // create prepared statement
            pstmt = connection.prepareStatement(sqlQuery);

            // execute sql query
            pstmt.executeUpdate();

            isTrue = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isTrue;
    }

    @Override
    public boolean delete(Car c) {
        boolean isTrue = false;
        try {
            String sqlQuery = "DELETE FROM car WHERE carId=" + c.getId(); 

            // get the database connection
            connection = DBConnectionUtil.getConnection();

            // create prepared statement
            pstmt = connection.prepareStatement(sqlQuery);

            // execute sql query
            pstmt.executeUpdate();

            isTrue = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isTrue;
    }
}
