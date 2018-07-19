/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.dao;

import integrador.rnegocio.entidad.Periodo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andresorozco
 */
public interface IPeriodo {
    
    public boolean insertar (Periodo periodo) throws Exception;
    public boolean modificar (Periodo periodo) throws Exception; 
    public boolean eliminar (Periodo periodo) throws Exception;
    public Periodo obtener (int codPeriodo) throws Exception;
    public List<Periodo> obtener() throws Exception;
    
    
}
