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
            <form action="${pageContext.request.contextPath}/EditACarController" method="post">
                <div class="row">
                    <div class="form-group col-xs-4">
                        <label for="carId" class="font-weight-bold">Id</label>
                        <input type="text" class="form-control" id="carId" name="carid" value="${car.id}" readonly/><br>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-4">
                        <label for="modelName" class="font-weight-bold">Model</label>
                        <input type="text" class="form-control" id="modelName" name="model" value="${car.model}"/><br>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-4">
                        <label for="plateNo" class="font-weight-bold">Plate No.</label>
                        <input type="text" class="form-control" id="plateNo" name="plate" value="${car.plateNumber}"/><br>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-4">
                        <label for="colour" class="font-weight-bold">Color</label>
                        <input type="text"  class="form-control" id="colour" name="color" value="${car.color}"/><br>
                    </div>
                </div>
                <div class="row">
                    <button class="btn btn-primary" type="submit">Submit</button>
                </div>
            </form>
        </div>
    </body>
</html>
