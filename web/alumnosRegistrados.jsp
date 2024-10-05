<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro Estudiantes</title>
    <!-- CSS here -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<% 
    // Obtener los atributos de la solicitud
    ArrayList<Alumno> alumnos = (ArrayList<Alumno>) request.getAttribute("Alumnos");
    String CantidadRegistros = (String) request.getAttribute("Contador");
%>

<div class="container">
    <div class="text-center">
        <h2>Datos Estudiantes</h2>
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
            <% 
                if (alumnos != null) {
                    int i = 0; // Inicializar el contador aquí
                    for (Alumno alumno : alumnos) {
                        i++;
            %>
            <tr>
                <th scope="row"><%= i %></th>
                <td><%= alumno.getNombre() %></td>
                <td><%= alumno.getApellidos() %></td>
                <td><%= alumno.getPromedio() %></td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="4" class="text-center">No hay registros disponibles.</td>
            </tr>
            <% 
                } 
            %>
        </tbody>
    </table>
        <div class="text-center">
            <h4>Cantidad de registros: <%=CantidadRegistros%></h4>
        </div>
    <div class="text-center">
        <form action="index.jsp">
            <button type="submit" class="btn btn-primary">Volver</button>
        </form>
    </div>
</div>
</body>
</html>
