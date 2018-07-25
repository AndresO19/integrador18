/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.dao;

import integrador.rnegocio.entidad.Escuela;
import java.util.ArrayList;

/**
 *
 * @author Jhon
 */
public interface IEscuela {
    
      
    public int insertar (Escuela escuela) throws Exception;
    public int modificar (Escuela escuela) throws Exception; 
    public int eliminar (Escuela escuela) throws Exception;
    public Escuela obtener (int codEscuela) throws Exception;
    public ArrayList<Escuela> obtener() throws Exception;
    
}
