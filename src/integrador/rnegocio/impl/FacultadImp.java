/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.rnegocio.impl;
import integrador.rnegocio.dao.*;
import integrador.rnegocio.entidad.*;
import integrador.accesodatos.*;
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
    public boolean actualizar(Facultad ambitos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Facultad ambitos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Facultad obtenerCodigo(int codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Facultad obtenerCodigo_Sicoa(int codigoSicoa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Facultad> obtenerNombre() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Facultad> obtenerDescripcion() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Facultad> obtenerGeneral() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
