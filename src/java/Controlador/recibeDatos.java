package Controlador;

import Modelo.Alumno;
import Modelo.EscribeArchivo;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author oscar
 */
public class recibeDatos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            double promedio = Double.parseDouble(request.getParameter("promedio"));

            Alumno alumno = new Alumno(nombre, apellidos, promedio);
//            out.println("<h1>Registro de Estudiante</h1>");
//            out.println("<p>Nombre: " + alumno.getNombre() + "</p>");
//            out.println("<p>Apellidos: " + alumno.getApellidos() + "</p>");
//            out.println("<p>Promedio: " + alumno.getPromedio() + "</p>");

            ServletContext sc = this.getServletContext();
            String path = sc.getRealPath("/WEB-INF/Promedios.txt");
            path = path.replace('\\', '/');
            
//            out.println("<p>Ruta: " + path + "</p>");
            // Guardar el alumno en el archivo
            EscribeArchivo.add(alumno, path);
            request.setAttribute("attrAlumno", alumno);
            request.getRequestDispatcher("/muestraDatos.jsp").forward(request, response);
        } finally {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para registrar estudiantes";
    }
}
