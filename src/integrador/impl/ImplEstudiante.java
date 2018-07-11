/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.impl;
import integrador.entidad.Estudiante;
import integrador.dao.IEstudiantes;
import  integrador.accesodatos.Parametro;
import integrador.accesodatos.Conexion;
   
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author andresorozco
 */
public class ImplEstudiante implements IEstudiantes {

    @Override
    public int insertar(Estudiante estudiante) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO Estudiantes (codEstudiantes, nombre, descripcion, cedula, codigo_sicoa, codigo_periodo, codigo_nivel ) VALUES (?,?,?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, estudiante.getCodEstudiante()));
        lisParametros.add(new Parametro(2, estudiante.getNombre()));
        lisParametros.add(new Parametro(3, estudiante.getDescripcion()));
        lisParametros.add(new Parametro(4, estudiante.getCedula()));
        lisParametros.add(new Parametro(5, estudiante.getCodigo_sicoa()));
        lisParametros.add(new Parametro(6, estudiante.getCodigo_periodo()));
        lisParametros.add(new Parametro(7, estudiante.getCodigo_nivel()));
        
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
        String sqlC = "UPDATE Estudiante SET codEstudiante=?, nombre=?, descripcion=?, cedula=?, codigo_sicoa=?, codigo_periodo=?, codigo_nivel=? WHERE codEstudiante=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, estudiante.getCodEstudiante()));
        lisParametros.add(new Parametro(2, estudiante.getNombre()));
        lisParametros.add(new Parametro(3, estudiante.getDescripcion()));
        lisParametros.add(new Parametro(4, estudiante.getCedula()));
        lisParametros.add(new Parametro(5, estudiante.getCodigo_sicoa()));
        lisParametros.add(new Parametro(6, estudiante.getCodigo_periodo()));
        lisParametros.add(new Parametro(7, estudiante.getCodigo_nivel()));
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
        lisParametros.add(new Parametro(1, estudiante.getCodEstudiante()));
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
        String sqlC = "SELECT codEstudiante, nombre, descripcion, cedula, codigo_sicoa, codigo_periodo, codigo_nivel FROM Estudiante";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           
            while (rst.next()) {
                Estudiante nEstudiante = new Estudiante();
                nEstudiante.setCodEstudiante(rst.getInt(1));
                nEstudiante.setNombre(rst.getString(2));
                nEstudiante.setDescripcion(rst.getString(3));
                nEstudiante.setCedula(rst.getString(4));
                nEstudiante.setCodigo_sicoa(rst.getInt(5));
                nEstudiante.setCodigo_periodo(rst.getInt(6));
                nEstudiante.setCodigo_nivel(rst.getInt(7));
              
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
                nEstudiante.setCodEstudiante(rst.getInt(1));
                nEstudiante.setNombre(rst.getString(2));
                nEstudiante.setDescripcion(rst.getString(3));
                nEstudiante.setCedula(rst.getString(4));
                nEstudiante.setCodigo_sicoa(rst.getInt(5));
                nEstudiante.setCodigo_periodo(rst.getInt(6));
                nEstudiante.setCodigo_nivel(rst.getInt(7));
                
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
