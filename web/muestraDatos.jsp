<%-- 
    Document   : index
    Created on : 1 oct 2024, 22:27:37
    Author     : oscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Alumno" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Estudiantes</title>
        <!-- CSS here -->
        <!-- Bootstrap here-->
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="style.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <% Alumno alumno = (Alumno) request.getAttribute("attrAlumno"); %>
        <div class="container">
            <div class="text-center">
                <h2>Datos estudiante</h2>
            </div>
                <table class="table table-striped">
                <thead>
                  <tr class="table-primary">
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellidos</th>
                    <th scope="col">Promedio</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <td><%= alumno.getNombre() %></td>
                    <td><%= alumno.getApellidos() %></td>
                    <td><%= alumno.getPromedio() %></td>
                  </tr>
                    </tbody>
              </table>
              <div class="text-center">
                  <form action="index.jsp">
                        <button type="submit" class="btn btn-primary">Volver</button>
                  </form>
              </div>
          </div>
    </body>
</html>
    