
package com.myWebApp.controllers;

import com.myWebApp.dao.CarDAO;
import com.myWebApp.dao.CarDAOImpl;
import com.myWebApp.entities.Car;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dkats
 */
public class AddACarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addCar.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CarDAO carDao = new CarDAOImpl();
        //check
        if (carDao.save(new Car( request.getParameter("model"), request.getParameter("plate"), request.getParameter("color")))) {
            request.setAttribute("msg", "A new record in your dataBase!");
        }
      
        RequestDispatcher dispatcher = request.getRequestDispatcher("addCar.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
