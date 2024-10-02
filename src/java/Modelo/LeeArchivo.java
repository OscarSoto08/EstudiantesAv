/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;
import java.util.*;

/**
 *
 * @author oscar
 */
public class LeeArchivo {
    private int contador;
    private File archivo;
    private FileReader fr;
    private BufferedReader bf;
    
    static ArrayList<Alumno> alumnos = new ArrayList<>();
    
    public LeeArchivo(int contador, File archivo, FileReader fw, BufferedReader bf) {
        this.contador = contador;
        this.archivo = archivo;
        this.fr = fw;
        this.bf = bf;
    }

    public LeeArchivo() {}    
    
    public ArrayList<Alumno> leeAlumnos(String ruta){
        try{
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            bf = new BufferedReader(fr);
            
            //Valores para el objeto alumnos
            String nombre, apellidos;
            double promedio;
            
            //Parte donde se lee el archivo por lineas y se separa por tokens
            String linea;
            String[] tokens;
            
            linea = bf.readLine();
            while(linea != null){
                //Asigno valores o parametros
                tokens = linea.split(",");
                nombre = tokens[0];
                apellidos = tokens[1];
                promedio = Double.parseDouble(tokens[2]);
                //Le entrego los datos a través del constructor en una instancia local
                Alumno alumno = new Alumno(nombre, apellidos, promedio);
                
                //Lo agrego al arraylist
                alumnos.add(alumno);
                
                //Ahora sigo con la otra linea
                contador++;
                linea = bf.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(fr != null){
                    fr.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return alumnos;
    }
}
