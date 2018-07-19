/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.dao;

import integrador.entidad.Tutor;
import java.util.ArrayList;
/**
 *
 * @author andresorozco
 */
public interface ITutor {
    
        public int insertar (Tutor tutor) throws Exception;
    public int modificar (Tutor tutor) throws Exception; 
    public int eliminar (Tutor tutor) throws Exception;
    
    public Tutor obtener (int codTutor) throws Exception;
    public ArrayList<Tutor> obtener() throws Exception;
    
}
