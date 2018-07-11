/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.dao;

import integrador.entidad.Nivel;
import java.util.ArrayList;

/**
 *
 * @author andresorozco
 */
public interface INivel {
    
    public int insertar (Nivel nivel) throws Exception;
    public int modificar (Nivel nivel) throws Exception; 
    public int eliminar (Nivel nivel) throws Exception;
    
    public Nivel obtener (int codNivel) throws Exception;
    public ArrayList<Nivel> obtener() throws Exception;
    
    
    
}
