/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author oscar
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private double promedio;

//Constructor simple
    public Alumno() {
    }
    public Alumno(String nombre, String apellidos, double promedio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.promedio = promedio;
    }
//Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getPromedio() {
        return promedio;
    }
    
//Setters    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + 
                "\nApellidos: " + apellidos + 
                "\nPromedio=" + promedio;
    }
}

