/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.entidad;

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


     @Override

    public String toString() {
        return nombre;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getCodigo_sicoa() {
        return codigo_sicoa;
    }

    public void setCodigo_sicoa(int codigo_sicoa) {
        this.codigo_sicoa = codigo_sicoa;
    }

    public int getCodigo_periodo() {
        return codigo_periodo;
    }

    public void setCodigo_periodo(int codigo_periodo) {
        this.codigo_periodo = codigo_periodo;
    }

    public int getCodigo_nivel() {
        return codigo_nivel;
    }

    public void setCodigo_nivel(int codigo_nivel) {
        this.codigo_nivel = codigo_nivel;
    }
    
    
}
