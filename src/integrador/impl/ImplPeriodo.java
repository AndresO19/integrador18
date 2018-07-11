/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.impl;

import integrador.entidad.Periodo;
import integrador.dao.IPeriodo;
import integrador.accesodatos.Parametro;
import integrador.accesodatos.AccesoDatos;
import integrador.accesodatos.ConjuntoResultado;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author andresorozco
 */
public class ImplPeriodo  implements IPeriodo {
    
    @Override
    public boolean insertar(Periodo periodo) throws Exception {
        boolean eje = false;
        try{
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        String sql = "select * from master.finsert_facultad(?,?,?,?,?,?,?,?)";

        lisParametros.add(new Parametro(1, periodo.getCodigoP()));
        lisParametros.add(new Parametro(2, periodo.getNombre()));
        lisParametros.add(new Parametro(3, periodo.getFecha_inicio()));
        lisParametros.add(new Parametro(4, periodo.getFecha_fin()));
        lisParametros.add(new Parametro(5, periodo.getTipo()));
        lisParametros.add(new Parametro(6, periodo.getObservaciones()));
        lisParametros.add(new Parametro(7, periodo.getCodigo_sicoa()));
        lisParametros.add(new Parametro(8, periodo.getEstado()));
        ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lisParametros);
        while (rs. next()){
            if(rs.getString(0).equals("true"));
            eje = true;
        }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        
        return eje;
    }
    
     public static ArrayList<Periodo> llenarPeriodos(ConjuntoResultado rs) throws Exception {
        ArrayList<Periodo> lst = new ArrayList<Periodo>();
        Periodo periodo = null;
        try {
            while (rs.next()) {
                periodo = new Periodo(rs.getInt("codigoP"), rs.getString("nombre"), rs.getDate("fecha_inicio"), rs.getInt("fecha_fin"), rs.getInt("tipo"), rs.getString("observaciones"), rs.getInt("codigo_sicoa"), rs.getInt("estado")  );
                lst.add(periodo);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    

    public boolean modificar(Periodo periodo) throws Exception {
        boolean eje = false;
        try{
        String sqlC = "UPDATE Periodo SET codPeriodo=?, nombre=?, descripcion=? WHERE codPeriodo=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, periodo.getCodPeriodo()));
        lisParametros.add(new Parametro(2, periodo.getNombre()));
        lisParametros.add(new Parametro(3, periodo.getDescripcion()));
        lisParametros.add(new Parametro(4, periodo.getCodPeriodo()));
        ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sqlC, lisParametros);
           while (rs.next()) {
               if (rs.getString(0).equals("true"));
               eje=true;
           }
        } catch (SQLException  exConec) {
            throw new Exception(exConec.getMessage());
        
        }
        return eje;
    }

      
    public boolean eliminar(Periodo periodo) throws Exception {
     boolean eje = false;
     try{
        String sqlC = "DELETE FROM Periodo WHERE codPeriodo=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, periodo.getCodPeriodo()));
        ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sqlC,lisParametros);
            while (rs.next()){
                if (rs.getString(0).equals("true"));
               eje=true;
            }
        } catch (SQLException  exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
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
                nPeriodo.setCodPeriodo(rst.getInt(1));
                nPeriodo.setNombre(rst.getString(2));
                nPeriodo.setDescripcion(rst.getString(3));
              
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
                nPeriodo.setCodPeriodo(rst.getInt(1));
                nPeriodo.setNombre(rst.getString(2));
                nPeriodo.setDescripcion(rst.getString(3));
                
                
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
