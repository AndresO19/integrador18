package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import integrador.accesodatos.*;
import integrador.rnegocio.impl.FacultadImp;
import integrador.rnegocio.entidad.Facultad;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jhon
 */
public class TestFacultad {
    
    
    public TestFacultad() {
    }
    
    @Test
    public void testGeneral() {
        Facultad nFac=new Facultad(20, "Facultad de Bagos", "Facultad de bagos", 123123);
        boolean res=false;
        try {
            res=FacultadImp.Insertar(nFac);
            if(res){
                System.out.println("Ingreso Correcto");
            }
            else{
                System.out.println("Ingreso Erroneo");
            }   
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage() +"  "+e.getLocalizedMessage());
        }
        assertTrue(res);
    }
    
}
