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
public class AmbitoImpl implements IAmbito{
    
    @Override

     public int insertar(Ambitos ambitos) throws Exception {
        int numFilas = 0;
            String sqlC = "INSERT INTO Ambitos (codigo, nombre, descripcion, codigo_sicoa) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, ambitos.getCodigo()));
        lisParametros.add(new Parametro(2, ambitos.getNombre()));
        lisParametros.add(new Parametro(3, ambitos.getObservacion()));
        lisParametros.add(new Parametro(4, ambitos.getEstado()));
        
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
    public int modificar(Ambitos ambitos) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Ambitos SET codAmbitos=?, nombre=?, descripcion=? WHERE codAmbitos=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, ambitos.getCodigo()));
        lisParametros.add(new Parametro(2, ambitos.getNombre()));
        lisParametros.add(new Parametro(3, ambitos.getObservacion()));
        lisParametros.add(new Parametro(4, ambitos.getEstado()));
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
    public int eliminar(Ambitos ambitos) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Ambitos WHERE codAmbitos=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, ambitos.getCodigo()));
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
    public ArrayList<Ambitos> obtener() throws Exception {
        ArrayList<Ambitos> listAmbitos = new ArrayList<>();
        String sqlC = "SELECT codAmbitos, nombre, descripcion FROM Ambitos";
        Conexion con = null;
        try {
           
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           
            while (rst.next()) {
                Ambitos nAmbitos = new Ambitos();
                nAmbitos.setCodigo(rst.getInt(1));
                nAmbitos.setNombre(rst.getString(2));
                nAmbitos.setObservacion(rst.getString(3));
                nAmbitos.setEstado(rst.getInt(4));
              
                listAmbitos.add(nAmbitos);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listAmbitos;
    }

    @Override
    public Ambitos obtener(int codAmbitos) throws Exception {
         Ambitos nAmbitos = null;
         Facultad fc = null;
        String sqlC = "SELECT codAmbitos, nombre, descripcion FROM Ambitos WHERE codAmbitos=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codAmbitos));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            
            while (rst.next()) {
               
                nAmbitos = new Ambitos();
                nAmbitos.setCodigo(rst.getInt(1));
                nAmbitos.setNombre(rst.getString(2));
                nAmbitos.setObservacion(rst.getString(3));
                nAmbitos.setCodigo(rst.getInt(4));
                
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nAmbitos;  }
  
}

    

