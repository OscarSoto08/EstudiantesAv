/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;

/**
 *
 * @author oscar
 */
public class EscribeArchivo {
    
    public static void add(Alumno est, String ruta) throws IOException{        
        File archivo;
        FileWriter fw = null;
        PrintWriter pw = null;
        try{
            archivo = new File(ruta);
            fw = new FileWriter(archivo, true);
            pw = new PrintWriter(fw);
            pw.println(est.getNombre()+ ", "+ est.getApellidos() + ", " + est.getPromedio());
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(pw != null){
                    pw.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
