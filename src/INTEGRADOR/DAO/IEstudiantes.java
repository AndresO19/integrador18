/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTEGRADOR.DAO;

import java.util.ArrayList;
import INTEGRADOR.ENTIDADES.Estudiante;

/**
 *
 * @author andresorozco
 */
public interface IEstudiantes {
    
    public int insertar (Estudiante estudiante) throws Exception;
    public int modificar (Estudiante estudiante) throws Exception; 
    public int eliminar (Estudiante estudiante) throws Exception;
    
    public Estudiante obtener (int codEstudiante) throws Exception;
    public ArrayList<Estudiante> obtener() throws Exception;
    
}
