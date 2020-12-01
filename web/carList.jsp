<%-- 
    Document   : carlist
    Created on : Jun 3, 2020, 3:39:08 PM
    Author     : dkats
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parking View</title>
        <link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>

    </head>
    <body>
        <div class="container">
            <form action="${pageContext.request.contextPath}/AddACarController" method="get">
                <input  class="btn btn-primary" type="submit" value="Add Car">
            </form>	
            <table class="table table-striped table-bordered" border="1" id="carTable" >
                <thead>
                    <tr class="thead-dark">
                    <th>Id</th>
                    <th>Model</th>
                    <th>Plate</th>
                    <th>Color</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items = "${list}" var = "car">
                    <tr>
                        <td>${car.id}</td>
                        <td>${car.model}</td>
                        <td>${car.plateNumber}</td>
                        <td>${car.color}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/EditACarController?action=editCar&id=${car.id}">Edit</a>
                            |
                            <a href="${pageContext.request.contextPath}/DeleteACarController?action=deleteCar&id=${car.id}">Delete</a>
                        </td>
                    </tr>	
                </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>  
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
        
        <script>
            $(document).ready(function(){
                $('#carTable').DataTable();
            });
        </script>    
        

    </body>
</html>
