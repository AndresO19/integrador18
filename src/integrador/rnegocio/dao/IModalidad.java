/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.dao;
import integrador.rnegocio.entidad.Modalidad;
import java.util.ArrayList;
/**
 *
 * @author andresorozco
 */
public interface IModalidad {
    
    public boolean insertar (Modalidad modalidad) throws Exception;
    public boolean modificar (Modalidad modalidad) throws Exception; 
    public boolean eliminar (Modalidad modalidad) throws Exception;
    
    public Modalidad obtener (int codModalidad) throws Exception;
    public ArrayList<Modalidad> obtener() throws Exception;
    
    
    
    
    
    
}
