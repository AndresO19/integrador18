/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.impl;

import integrador.accesodatos.Conexion;
import integrador.accesodatos.Parametro;
import integrador.rnegocio.dao.*;
import integrador.rnegocio.entidad.*;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jhon
 */
public class ModalidadTutoriaImpl implements IModalidad{
    
      @Override
   
    public boolean insertar(Modalidad modalidad) throws Exception {
        int numFilas = 0;
            String sqlC = "INSERT INTO Modalidad (codigo, nombre, descripcion, codigo_sicoa) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, modalidad.getCodigo()));
        lisParametros.add(new Parametro(2, modalidad.getNombre()));
        lisParametros.add(new Parametro(3, modalidad.getDescripcion()));
        lisParametros.add(new Parametro(4, modalidad.getEstado()));
        
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

     @Override
    public boolean modificar(Modalidad modalidad) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Modalidad SET codModalidad=?, nombre=?, descripcion=? WHERE codModalidad=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, modalidad.getCodigo()));
        lisParametros.add(new Parametro(2, modalidad.getNombre()));
        lisParametros.add(new Parametro(3, modalidad.getDescripcion()));
        lisParametros.add(new Parametro(4, modalidad.getEstado()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

      @Override
    public boolean eliminar(Modalidad modalidad) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Modalidad WHERE codModalidad=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, modalidad.getCodigo()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

    
      @Override
    public ArrayList<Modalidad> obtener() throws Exception {
        ArrayList<Modalidad> listModalidad = new ArrayList<>();
        String sqlC = "SELECT codModalidad, nombre, descripcion FROM Modalidad";
        Conexion con = null;
        try {
            
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           
            while (rst.next()) {
                Modalidad nModalidad = new Modalidad();
                nModalidad.setCodigo(rst.getInt(1));
                nModalidad.setNombre(rst.getString(2));
                nModalidad.setDescripcion(rst.getString(3));
                nModalidad.setEstado(rst.getInt(4));
                listModalidad.add(nModalidad);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listModalidad;
    }

    @Override
    public Modalidad obtener(int codModalidad) throws Exception {
         Modalidad nModalidad = null;
        
        String sqlC = "SELECT codModalidad, nombre, descripcion FROM Modalidad WHERE codModalidad=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codModalidad));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            IEscuela escu = new EscuelaImpl();
            Escuela es = null;
            while (rst.next()) {
               
                
                nModalidad.setCodigo(rst.getInt(1));
                nModalidad.setNombre(rst.getString(2));
                nModalidad.setDescripcion(rst.getString(3));
                nModalidad.setEstado(rst.getInt(4));
                
                
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nModalidad;  }
  
}

    
    


    
    


    

