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
public class EditACarController extends HttpServlet {

    CarDAO carDao = new CarDAOImpl();
    Car car = new Car();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("editCar".equals(action)) {
            String carid = request.getParameter("id");
            
            //parse string and pass it to method
            car = carDao.getCarById(Integer.parseInt(carid));

            request.setAttribute("car", car);

            RequestDispatcher dispatcher = request.getRequestDispatcher("editCar.jsp");

            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CarDAO carDao = new CarDAOImpl();
       
        if (carDao.update(new Car(Integer.parseInt(request.getParameter("carid")), request.getParameter("model"), request.getParameter("plate"), request.getParameter("color")))) {
            request.setAttribute("msg", "Successfully Updated!");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("editCar.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
