/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.impl;

import integrador.accesodatos.Conexion;
import integrador.accesodatos.Parametro;
import integrador.rnegocio.entidad.*;
import integrador.rnegocio.dao.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jhon
 */
public class NivelImpl implements INivel{
    
     @Override
   
    public boolean insertar(Nivel nivel) throws Exception {
        int numFilas = 0;
            String sqlC = "INSERT INTO Nivel (codigo, nombre, descripcion, codigo_sicoa) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, nivel.getCodigo()));
        lisParametros.add(new Parametro(2, nivel.getCodigo_sicoa()));
        lisParametros.add(new Parametro(3, nivel.getNombre()));
        lisParametros.add(new Parametro(4, nivel.getParalelo()));
        lisParametros.add(new Parametro(5, nivel.getModalidad()));
        lisParametros.add(new Parametro(6, nivel.getCodigo_escuela().getCodigo()));
        
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
    public boolean modificar(Nivel nivel) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Nivel SET codNivel=?, nombre=?, descripcion=? WHERE codNivel=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
                lisParametros.add(new Parametro(1, nivel.getCodigo()));
        lisParametros.add(new Parametro(2, nivel.getCodigo_sicoa()));
        lisParametros.add(new Parametro(3, nivel.getNombre()));
        lisParametros.add(new Parametro(4, nivel.getParalelo()));
        lisParametros.add(new Parametro(5, nivel.getModalidad()));
        lisParametros.add(new Parametro(6, nivel.getCodigo_escuela().getCodigo()));
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
    public boolean eliminar(Nivel nivel) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Nivel WHERE codNivel=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, nivel.getCodigo()));
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
    public ArrayList<Nivel> obtener() throws Exception {
        ArrayList<Nivel> listNivel = new ArrayList<>();
        String sqlC = "SELECT codNivel, nombre, descripcion FROM Nivel";
        Conexion con = null;
        try {
            
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           
            while (rst.next()) {
                Nivel nNivel = new Nivel();
                nNivel.setCodigo(rst.getInt(1));
                nNivel.setCodigo_sicoa(rst.getInt(2));
                nNivel.setNombre(rst.getString(3));
                nNivel.setParalelo(rst.getString(4));
                nNivel.setModalidad(rst.getString(5));
                IEscuela escu = new EscuelaImpl();
                Escuela es = null;
                es = escu.obtener(rst.getInt(6));
                nNivel.setCodigo_escuela(es);
              
                listNivel.add(nNivel);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listNivel;
    }

    @Override
    public Nivel obtener(int codNivel) throws Exception {
         Nivel nNivel = null;
        
        String sqlC = "SELECT codNivel, nombre, descripcion FROM Nivel WHERE codNivel=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codNivel));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            IEscuela escu = new EscuelaImpl();
            Escuela es = null;
            while (rst.next()) {
               
                
                nNivel.setCodigo(rst.getInt(1));
                nNivel.setCodigo_sicoa(rst.getInt(2));
                nNivel.setNombre(rst.getString(3));
                nNivel.setParalelo(rst.getString(4));
                nNivel.setModalidad(rst.getString(5));  
                es = escu.obtener(rst.getInt(6));
                nNivel.setCodigo_escuela(es);
                
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nNivel;  }
  
}

    
    


    
    
}
