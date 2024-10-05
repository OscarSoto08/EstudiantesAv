package Modelo;

import java.io.*;
import java.util.*;

/**
 *
 * @author oscar
 */
public class LeeArchivo {
    private static int contador;
    private static File archivo;
    
    static ArrayList<Alumno> alumnos;

    public LeeArchivo() {}

    public static ArrayList<Alumno> leeAlumnos(String ruta) {
        BufferedReader bf = null; // Declarar el BufferedReader aquí para asegurar su cierre
        alumnos = new ArrayList<>(); //Toca inicializar la variable para que no se acumulen los datos
        try {
            archivo = new File(ruta);
            FileReader fr = new FileReader(archivo);
            bf = new BufferedReader(fr);

            // Valores para el objeto alumnos
            String nombre, apellidos;
            double promedio;

            // Parte donde se lee el archivo por líneas y se separa por tokens
            String linea;
            String[] tokens;

            linea = bf.readLine();
            while (linea != null) {
                // Asigno valores o parámetros
                tokens = linea.split(",");
                nombre = tokens[0].trim(); // Eliminamos espacios innecesarios
                apellidos = tokens[1].trim(); // Eliminamos espacios innecesarios
                promedio = Double.parseDouble(tokens[2].trim()); // Eliminamos espacios innecesarios

                // Le entrego los datos a través del constructor en una instancia local
                Alumno alumno = new Alumno(nombre, apellidos, promedio);

                // Lo agrego al ArrayList
                alumnos.add(alumno);

                // Ahora sigo con la otra línea
                contador++;
                linea = bf.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo básico de errores, puedes mejorarlo
        } catch (NumberFormatException e) {
            System.err.println("Error al parsear el promedio: " + e.getMessage());
        } finally {
            // Cierre del BufferedReader en el bloque finally
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return alumnos;
    }

    public static int getContador() {
        return contador;
    }

    public static void clearContador() {
        contador = 0;
    }
}
