<%-- 
    Document   : addCar
    Created on : Jun 3, 2020, 3:58:13 PM
    Author     : dkats
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A Car</title>
        <link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <form action="${pageContext.request.contextPath}/CarController" method="get">
                <input  class="btn btn-link" type="submit" value="Go Back">
            </form>
            <p>${msg}</p>
            <form action="${pageContext.request.contextPath}/AddACarController" method="Post">
                <div class="row">
                    <div class="form-group col-xs-4">
                        <label for="modelName" class="font-weight-bold">Model</label>
                        <input type="text" class="form-control" id="modelName" name="model" placeholder="Fiat"/><br>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-4">
                        <label for="plateNo" class="font-weight-bold">Plate No.</label>
                        <input type="text" class="form-control" id="plateNo" name="plate" placeholder="ITA:121"/><br>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-4">
                        <label for="colour" class="font-weight-bold">Color</label>
                        <input type="text"  class="form-control" id="colour" name="color" placeholder="pink"/><br>
                    </div>
                </div>
                <div class="row">
                    <button class="btn btn-primary" type="submit">Submit</button>
                </div>
            </form>
        </div>
    </body>
</html>
