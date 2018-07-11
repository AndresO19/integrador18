/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTEGRADOR.ENTIDADES;

/**
 *
 * @author andresorozco
 */
public class Estudiante {
    
    
    private int codEstudiante;
    private String nombre;
    private String descripcion;
    private String cedula;
    private int codigo_sicoa;
    private int codigo_periodo;
    private int codigo_nivel;

    public Estudiante(int codEstudiante, String nombre, String descripcion, String cedula, int codigo_sicoa, int codigo_periodo, int codigo_nivel) {
        this.codEstudiante = codEstudiante;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cedula = cedula;
        this.codigo_sicoa = codigo_sicoa;
        this.codigo_periodo = codigo_periodo;
        this.codigo_nivel = codigo_nivel;
    }

    

    public Estudiante() {
    }


    public int getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(int codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
     @Override

    public String toString() {
        return nombre;
    }
    
    
}