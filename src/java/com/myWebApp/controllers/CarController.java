package com.myWebApp.controllers;

import com.myWebApp.dao.CarDAO;
import com.myWebApp.dao.CarDAOImpl;
import com.myWebApp.entities.Car;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dkats
 */
public class CarController extends HttpServlet {

    //ref for CarDAO
    CarDAO carDao = null;

    public CarController() {
        super();
        carDao = new CarDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //call dao method to get the list of cars
        List<Car> list = carDao.getCars();

        //add it to a request obj
        request.setAttribute("list", list);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("carList.jsp");

        dispatcher.forward(request, response);
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
