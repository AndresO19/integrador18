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
public class Tutor {
    
    private int codiga;
    private int codigo_nivel;
    private int codigo_periodo;
    private int codigo_usuario_rol;

    public Tutor(int codiga, int codigo_nivel, int codigo_periodo, int codigo_usuario_rol) {
        this.codiga = codiga;
        this.codigo_nivel = codigo_nivel;
        this.codigo_periodo = codigo_periodo;
        this.codigo_usuario_rol = codigo_usuario_rol;
    }

    public Tutor() {
    }

    public int getCodiga() {
        return codiga;
    }

    public void setCodiga(int codiga) {
        this.codiga = codiga;
    }

    public int getCodigo_nivel() {
        return codigo_nivel;
    }

    public void setCodigo_nivel(int codigo_nivel) {
        this.codigo_nivel = codigo_nivel;
    }

    public int getCodigo_periodo() {
        return codigo_periodo;
    }

    public void setCodigo_periodo(int codigo_periodo) {
        this.codigo_periodo = codigo_periodo;
    }

    public int getCodigo_usuario_rol() {
        return codigo_usuario_rol;
    }

    public void setCodigo_usuario_rol(int codigo_usuario_rol) {
        this.codigo_usuario_rol = codigo_usuario_rol;
    }
    
    
    
}
