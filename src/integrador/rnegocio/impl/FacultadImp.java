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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jhon
 */
public class FacultadImp implements IFacultad{

    @Override
    public boolean insertar(Facultad facultad) throws Exception {
        boolean resultado=false;
        try {
            ArrayList<Parametro> listP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fi_facultad(?,?,?,?)";
            listP.add(new Parametro(1, facultad.getCodigo()));
            listP.add(new Parametro(2, facultad.getNombre()));
            listP.add(new Parametro(3, facultad.getDescripcion()));
            listP.add(new Parametro(4, facultad.getCodigo_sicoa()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, listP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                resultado = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return resultado;
    }

    @Override
        public int modificar(Facultad facultad) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Facultad SET codFacultad=?, nombre=?, descripcion=? WHERE codFacultad=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facultad.getCodigo()));
        lisParametros.add(new Parametro(2, facultad.getNombre()));
        lisParametros.add(new Parametro(3, facultad.getDescripcion()));
        lisParametros.add(new Parametro(4, facultad.getCodigo_sicoa()));
       
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
     public int eliminar(Facultad facultad) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Facultad WHERE codFacultad=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facultad.getCodigo()));
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
     public ArrayList<Facultad> obtener() throws Exception {
        ArrayList<Facultad> listFacultad= new ArrayList<>();
        String sqlC = "SELECT codEstudiante, nombre, descripcion FROM Estudiante";
        Conexion con = null;
        try {
            
            con = new Conexion();
            con.conectar();
           
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           
            while (rst.next()) {
                Facultad nFacultad = new Facultad();
                nFacultad.setCodigo(rst.getInt(1));
                nFacultad.setNombre(rst.getString(2));
                nFacultad.setDescripcion(rst.getString(3));
                nFacultad.setCodigo_sicoa(rst.getInt(4));
             
                listFacultad.add(nFacultad);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listFacultad;
    }

    @Override
    public Facultad obtener(int codEstudiante) throws Exception {
         Facultad nFacultad= null;
 
        String sqlC = "SELECT codEstudiante, nombre, descripcion FROM Estudiante WHERE codEstudiante=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, nFacultad.getCodigo()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            
            while (rst.next()) {
               
                nFacultad= new Facultad();
                nFacultad.setCodigo(rst.getInt(1));
                nFacultad.setNombre(rst.getString(2));
                nFacultad.setDescripcion(rst.getString(3));
                nFacultad.setCodigo_sicoa(rst.getInt(4));
                
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFacultad;  }
  
}


