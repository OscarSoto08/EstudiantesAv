package Controlador;

import Modelo.Alumno;
import Modelo.LeeArchivo;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author oscar
 */
public class muestraRegistro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet muestraRegistro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet muestraRegistro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       // processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            
            //Lectura del dato:
            String submit = request.getParameter("verAlumnos");
            if("true".equals(submit)){
            // Definición de la ruta
            ServletContext sc = this.getServletContext();
            String path = sc.getRealPath("/WEB-INF/Promedios.txt");
            path = path.replace('\\', '/');

            // Lectura de datos
            
            ArrayList<Alumno> alumnos;
            alumnos = LeeArchivo.leeAlumnos(path);
            
            String contador = LeeArchivo.getContador() + "";
            LeeArchivo.clearContador();
            
            out.println("<p>Ruta: " + request.getContextPath() + "</p>");
            out.println("<p>Valor del envio: " + submit + "</p>");
            for(Alumno alumno: alumnos){
                out.println("<p>" + alumno.toString() + "</p>");
            }
                out.println("<p> Cantidad de registros: " + contador + "</p>");
            
            // Ahora enviamos los datos
            request.setAttribute("Alumnos", alumnos);
            request.setAttribute("Contador",contador);
           request.getRequestDispatcher("/alumnosRegistrados.jsp").forward(request, response);
            }
            else{
                out.println("<h2> Ocurrio un error inesperado, por favor intentelo de nuevo </h2>");
            }
        } catch (IOException e) {
            // Manejo del error (puedes registrar el error o enviar un mensaje al usuario)
            if (out != null) {
                out.println("<html><body><h3>Error al procesar la solicitud: " + e.getMessage() + "</h3></body></html>");
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
