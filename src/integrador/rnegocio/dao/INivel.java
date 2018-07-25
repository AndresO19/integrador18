/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.dao;

import integrador.rnegocio.entidad.Nivel;
import java.util.ArrayList;

/**
 *
 * @author andresorozco
 */
public interface INivel {
    
    public boolean insertar (Nivel nivel) throws Exception;
    public boolean modificar (Nivel nivel) throws Exception; 
    public boolean eliminar (Nivel nivel) throws Exception;
    
    public Nivel obtener (int codNivel) throws Exception;
    public ArrayList<Nivel> obtener() throws Exception;
    
    
    
}
