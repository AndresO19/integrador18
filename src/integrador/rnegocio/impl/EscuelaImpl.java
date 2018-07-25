/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.impl;

import integrador.rnegocio.dao.*;
import integrador.rnegocio.entidad.*;
import integrador.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jhon
 */
public class EscuelaImpl  implements  IEscuela {
    
   @Override
   
    public int insertar(Escuela escuela) throws Exception {
        int numFilas = 0;
            String sqlC = "INSERT INTO Escuela (codigo, nombre, descripcion, codigo_sicoa) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, escuela.getCodigo()));
        lisParametros.add(new Parametro(2, escuela.getFacultad().getCodigo()));
        lisParametros.add(new Parametro(3, escuela.getNombre()));
        lisParametros.add(new Parametro(4, escuela.getDescripcion()));
        lisParametros.add(new Parametro(5, escuela.getCodigo_sicoa()));
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
    public int modificar(Escuela escuela) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Escuela SET codEscuela=?, nombre=?, descripcion=? WHERE codEscuela=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
       lisParametros.add(new Parametro(1, escuela.getCodigo()));
        lisParametros.add(new Parametro(2, escuela.getFacultad().getCodigo()));
        lisParametros.add(new Parametro(3, escuela.getNombre()));
        lisParametros.add(new Parametro(4, escuela.getDescripcion()));
        lisParametros.add(new Parametro(5, escuela.getCodigo_sicoa()));
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
    public int eliminar(Escuela escuela) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Escuela WHERE codEscuela=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, escuela.getCodigo()));
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
    public ArrayList<Escuela> obtener() throws Exception {
        ArrayList<Escuela> listEscuela = new ArrayList<>();
        String sqlC = "SELECT codEscuela, nombre, descripcion FROM Escuela";
        Conexion con = null;
        try {
            IFacultad fc  = new FacultadImp();
            Facultad facu = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           
            while (rst.next()) {
                Escuela nEscuela = new Escuela();
                nEscuela.setCodigo(rst.getInt(1));
                facu = new Facultad();
                facu = fc.obtenerCodigo(rst.getInt(2));
                nEscuela.setFacultad(facu);
                nEscuela.setNombre(rst.getString(3));
                nEscuela.setDescripcion(rst.getString(4));
                nEscuela.setCodigo_sicoa(rst.getInt(5));
              
                listEscuela.add(nEscuela);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listEscuela;
    }

    @Override
    public Escuela obtener(int codEscuela) throws Exception {
         Escuela nEscuela = null;
         Facultad fc = null;
        String sqlC = "SELECT codEscuela, nombre, descripcion FROM Escuela WHERE codEscuela=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codEscuela));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            
            while (rst.next()) {
               
                nEscuela = new Escuela();
                nEscuela.setCodigo(rst.getInt(1));
                IFacultad fac  = new FacultadImp();
                Facultad facu = null;
                facu = fac.obtenerCodigo(rst.getInt(2));
                nEscuela.setFacultad(facu);
                nEscuela.setNombre(rst.getString(3));
                nEscuela.setDescripcion(rst.getString(4));
                nEscuela.setCodigo_sicoa(rst.getInt(5));
                
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nEscuela;  }
  
}

    
