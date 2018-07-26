/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.impl;import integrador.accesodatos.*;
import integrador.rnegocio.entidad.*;
import java.sql.*;
import java.util.ArrayList;
import java.io.Serializable;
import integrador.rnegocio.impl.*;
import static integrador.rnegocio.impl.FacultadImp.*;
import static integrador.rnegocio.impl.EscuelaImpl.*;

/**
 *
 * @author Jhon
 */
public class PeriodoImpl implements Serializable {
    
    public static boolean Insertar(Periodo periodo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fi_periodos(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, periodo.getNombre()));
            lstP.add(new Parametro(2, periodo.getFecha_inicio()));
            lstP.add(new Parametro(3, periodo.getFecha_fin()));
            lstP.add(new Parametro(4, periodo.getTipo()));
            lstP.add(new Parametro(5, periodo.getObservaciones()));
            lstP.add(new Parametro(6, periodo.getCodigo_sicoa()));
            lstP.add(new Parametro(7, periodo.getEstado()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
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
        Facultad facultad=null;
        try {
            while (rs.next()) {
                facultad=new Facultad();
                periodo = new Periodo(rs.getInt("pcodigo_sicoa"), rs.getString("pnombre"), rs.getDate("pnombre"), rs.getDate("pnombre"), rs.getInt("pcodigo_sicoa"), rs.getString("pnombre"), rs.getInt("pcodigo_sicoa"), rs.getInt("pcodigo_sicoa"));
        //(r, rs.getInt("pcodigo_sicoa") , rs.getString("pnombre"), rs.getString("pnombre"), rs.getString("pnombre"), ObtenerFacultadDadoCodigo(rs.getInt("pcodigo_facultad")));
                lst.add(periodo);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Periodo> ObtenerPeriodos() throws Exception {
        ArrayList<Periodo> lst = new ArrayList<Periodo>();
        try {
            String sql = "select * from actividades.fc_obtener_datos_generales_periodo()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPeriodos(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Periodo ObtenerPeriodoDadoCodigo(int codigo) throws Exception {
        Periodo lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_periodo_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Periodo();
            lst = llenarPeriodos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Periodo ObtenerPeriodoDadoCodigoSicoa(int codigo) throws Exception {
        Periodo lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_periodo_codigosicoa(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Periodo();
            lst = llenarPeriodos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Periodo ObtenerPeriodoDadoNombre(String nombre) throws Exception {
        Periodo lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_periodo_nombre(?)";
            lstP.add(new Parametro(1, nombre));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Periodo();
            lst = llenarPeriodos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Periodo ObtenerPeriodoDadoModalidad(String modalidad) throws Exception {
        Periodo lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_periodo_modalidad(?)";
            lstP.add(new Parametro(1, modalidad));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Periodo();
            lst = llenarPeriodos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Periodo ObtenerPeriodoDadoParalelo(String paralelo) throws Exception {
        Periodo lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_periodo_paralelo(?)";
            lstP.add(new Parametro(1, paralelo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Periodo();
            lst = llenarPeriodos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Periodo ObtenerPeriodoDadoEscuela(Escuela escuela) throws Exception {
        Periodo lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_periodo_codigo_escuela(?)";
            lstP.add(new Parametro(1, escuela.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Periodo();
            lst = llenarPeriodos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static boolean actualizar(Periodo periodo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fa_periodo(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, periodo.getCodigo_sicoa()));
            lstP.add(new Parametro(2, periodo.getNombre()));
            lstP.add(new Parametro(3, periodo.getParalelo()));
            lstP.add(new Parametro(4, periodo.getModalidad()));
            lstP.add(new Parametro(5, periodo.getCodigo_escuela().getCodigo()));
            lstP.add(new Parametro(6, periodo.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean eliminar(Periodo periodo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fe_periodo(?)";
            lstP.add(new Parametro(1, periodo.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
}