/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTEGRADOR.DAO;
import INTEGRADOR.ENTIDADES.Modalidad;
import java.util.ArrayList;
/**
 *
 * @author andresorozco
 */
public interface IModalidad {
    
    public int insertar (Modalidad modalidad) throws Exception;
    public int modificar (Modalidad modalidad) throws Exception; 
    public int eliminar (Modalidad modalidad) throws Exception;
    
    public Modalidad obtener (int codModalidad) throws Exception;
    public ArrayList<Modalidad> obtener() throws Exception;
    
    
    
    
    
    
}
