/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.dao;

import integrador.rnegocio.entidad.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Jhon
 */
public interface IFacultad {
    public boolean insertar (Facultad ambitos) throws Exception;
    public boolean actualizar (Facultad ambitos) throws Exception; 
    public boolean eliminar (Facultad ambitos) throws Exception;
    public Facultad obtenerCodigo (int codigo) throws Exception;
    public Facultad obtenerCodigo_Sicoa (int codigoSicoa) throws Exception;
    public ArrayList<Facultad> obtenerNombre() throws Exception;
    public ArrayList<Facultad> obtenerDescripcion() throws Exception;
    public ArrayList<Facultad> obtenerGeneral() throws Exception;
}
