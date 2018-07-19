/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.dao;

import java.util.ArrayList;
import integrador.rnegocio.entidad.Ambitos;

/**
 *
 * @author andresorozco
 */
public interface IAmbito {
    
    
    
    public int insertar (Ambitos ambitos) throws Exception;
    public int modificar (Ambitos ambitos) throws Exception; 
    public int eliminar (Ambitos ambitos) throws Exception;
    
    public Ambitos obtener (int codAmbitos) throws Exception;
    public ArrayList<Ambitos> obtener() throws Exception;
    
}
