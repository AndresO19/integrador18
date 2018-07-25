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
public class EstudianteImpl implements IEstudiantes {
    
       @Override
   
    public int insertar(Estudiante estudiante) throws Exception {
        int numFilas = 0;
            String sqlC = "INSERT INTO Estudiante (codigo, nombre, descripcion, codigo_sicoa) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, estudiante.getCodigo()));
        lisParametros.add(new Parametro(2, estudiante.getNombre()));
        lisParametros.add(new Parametro(3, estudiante.getDescripcion()));
        lisParametros.add(new Parametro(4, estudiante.getCedula()));
        lisParametros.add(new Parametro(5, estudiante.getCodigo_sicoa()));
        lisParametros.add(new Parametro(6, estudiante.getPeriodo().getCodigo()));
        lisParametros.add(new Parametro(7, estudiante.getNivel().getCodigo()));
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
    public int modificar(Estudiante estudiante) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Estudiante SET codEstudiante=?, nombre=?, descripcion=? WHERE codEstudiante=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, estudiante.getCodigo()));
        lisParametros.add(new Parametro(2, estudiante.getNombre()));
        lisParametros.add(new Parametro(3, estudiante.getDescripcion()));
        lisParametros.add(new Parametro(4, estudiante.getCedula()));
        lisParametros.add(new Parametro(5, estudiante.getCodigo_sicoa()));
        lisParametros.add(new Parametro(6, estudiante.getPeriodo().getCodigo()));
        lisParametros.add(new Parametro(7, estudiante.getNivel().getCodigo()));
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
    public int eliminar(Estudiante estudiante) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Estudiante WHERE codEstudiante=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, estudiante.getCodigo()));
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
        public ArrayList<Estudiante> obtener() throws Exception {
        ArrayList<Estudiante> listEstudiante = new ArrayList<>();
        String sqlC = "SELECT codEstudiante, nombre, descripcion FROM Estudiante";
        Conexion con = null;
        try {
            
            con = new Conexion();
            con.conectar();
            IPeriodo pr = new PeriodoImpl();          
            Periodo Per = null;
            INivel nv = new NivelImpl();
            Nivel ni = null;
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           
            while (rst.next()) {
                Estudiante nEstudiante = new Estudiante();
                nEstudiante.setCodigo(rst.getInt(1));
                nEstudiante.setNombre(rst.getString(2));
                nEstudiante.setDescripcion(rst.getString(3));
                nEstudiante.setCedula(rst.getString(4));
                nEstudiante.setCodigo_sicoa(rst.getInt(5));
                Per = new Periodo();
                Per = pr.obtener(rst.getInt(6));
                nEstudiante.setPeriodo(Per);
                ni = new Nivel();
                ni = nv.obtener(rst.getInt(7));
                nEstudiante.setNivel(ni);
                           
                listEstudiante.add(nEstudiante);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listEstudiante;
    }

    @Override
    public Estudiante obtener(int codEstudiante) throws Exception {
         Estudiante nEstudiante = null;
         Facultad fc = null;
        String sqlC = "SELECT codEstudiante, nombre, descripcion FROM Estudiante WHERE codEstudiante=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codEstudiante));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            
            while (rst.next()) {
               
                nEstudiante = new Estudiante();
                nEstudiante.setCodigo(rst.getInt(1));
                IPeriodo perio  = new PeriodoImpl();
                Periodo perd = null;
                perd = perio.obtener(rst.getInt(6));
                nEstudiante.setPeriodo(perd);
                INivel vn = new NivelImpl();
                Nivel niv = null;
                niv = vn.obtener(rst.getInt(7))
                nEstudiante.setNivel(niv);
                nEstudiante.setNombre(rst.getString(2));
                nEstudiante.setDescripcion(rst.getString(3));
                nEstudiante.setCedula(rst.getString(5));
                nEstudiante.setCodigo_sicoa(rst.getInt(4));
                
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nEstudiante;  }
  
}

    

