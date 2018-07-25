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
public class PeriodoImpl implements IPeriodo {
    
    @Override
   
    public boolean insertar(Periodo periodo) throws Exception {
        int numFilas = 0;
            String sqlC = "INSERT INTO Periodo (codigo, nombre, descripcion, codigo_sicoa) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, periodo.getCodigo()));
        lisParametros.add(new Parametro(2, periodo.getNombre()));
        lisParametros.add(new Parametro(3, periodo.getFecha_inicio()));
        lisParametros.add(new Parametro(4, periodo.getFecha_fin()));
        lisParametros.add(new Parametro(5, periodo.getTipo()));
        lisParametros.add(new Parametro(6, periodo.getObservaciones()));
        lisParametros.add(new Parametro(7, periodo.getCodigo_sicoa()));
        lisParametros.add(new Parametro(8, periodo.getEstado()));
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
    public boolean modificar(Periodo periodo) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Periodo SET codPeriodo=?, nombre=?, descripcion=? WHERE codPeriodo=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, periodo.getCodigo()));
        lisParametros.add(new Parametro(2, periodo.getNombre()));
        lisParametros.add(new Parametro(3, periodo.getFecha_inicio()));
        lisParametros.add(new Parametro(4, periodo.getFecha_fin()));
        lisParametros.add(new Parametro(5, periodo.getTipo()));
        lisParametros.add(new Parametro(6, periodo.getObservaciones()));
        lisParametros.add(new Parametro(7, periodo.getCodigo_sicoa()));
        lisParametros.add(new Parametro(8, periodo.getEstado()));
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
    public boolean eliminar(Periodo periodo) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Periodo WHERE codPeriodo=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, periodo.getCodigo()));
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
    public ArrayList<Periodo> obtener() throws Exception {
        ArrayList<Periodo> listPeriodo = new ArrayList<>();
        String sqlC = "SELECT codPeriodo, nombre, descripcion FROM Periodo";
        Conexion con = null;
        try {
            
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           
            while (rst.next()) {
                Periodo nPeriodo = new Periodo();
                nPeriodo.setCodigo(rst.getInt(1));
                nPeriodo.setNombre(rst.getString(2));
                nPeriodo.setFecha_inicio(rst.getDate(3));
                nPeriodo.setFecha_fin(rst.getDate(4));
                nPeriodo.setTipo(rst.getInt(5));
                nPeriodo.setObservaciones(rst.getString(6));
                nPeriodo.setCodigo_sicoa(rst.getInt(7));
                nPeriodo.setEstado(rst.getInt(8));
              
                listPeriodo.add(nPeriodo);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listPeriodo;
    }

    @Override
    public Periodo obtener(int codPeriodo) throws Exception {
         Periodo nPeriodo = null;
        
        String sqlC = "SELECT codPeriodo, nombre, descripcion FROM Periodo WHERE codPeriodo=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codPeriodo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            
            while (rst.next()) {
               
                nPeriodo = new Periodo();
                 nPeriodo.setCodigo(rst.getInt(1));
                nPeriodo.setNombre(rst.getString(2));
                nPeriodo.setFecha_inicio(rst.getDate(3));
                nPeriodo.setFecha_fin(rst.getDate(4));
                nPeriodo.setTipo(rst.getInt(5));
                nPeriodo.setObservaciones(rst.getString(6));
                nPeriodo.setCodigo_sicoa(rst.getInt(7));
                nPeriodo.setEstado(rst.getInt(8));
                
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nPeriodo;  }
  
}

    
    

