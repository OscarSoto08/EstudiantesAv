<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro Estudiantes</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container">
        <form action="recibeDatos" method="post">
            <h2 class="text-center">Registro de Estudiantes</h2>
            <label class="form-label"><b>Datos Estudiante:</b></label>
            <div class="mb-3">
                <input type="text" name="nombre" class="form-control" id="nombre" placeholder="Nombre" required>
            </div>
            <div class="mb-3">
                <input type="text" name="apellidos" class="form-control" id="apellido" placeholder="Apellidos" required>
            </div>
            <div class="mb-3">
                <input type="number" name="promedio" class="form-control" id="promedio" placeholder="Promedio" step="0.01" required>
            </div>
            <div class="text-center f-flex justify-content-around">
                <button type="submit" name="submit" id="submit" class="btn btn-success">Enviar</button>
                <button type="reset" class="btn btn-danger">Borrar</button>
            </div>
        </form>
        
        <form action="muestraRegistro" method="post" class="text-center mt-4">
            <button type="submit" name="verAlumnos" class="btn btn-info" value="true">Ver Alumnos</button>
        </form>
    </div>
</body>
</html>
