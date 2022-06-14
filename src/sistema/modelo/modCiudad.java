/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import sistema.conexion.conexion;

/**
 *
 * @author Administrator
 */
public class modCiudad {
    
    
    private int idCiudad;
    private String Descripcion;
    private int idPais;

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    
    public String toString() {
       return this.Descripcion;  
    }
   

    
    
//       conexion metodoconexion = new conexion();
//    public Vector<modCiudad> mostrarCiudad(int pais) {
//        
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        java.sql.Connection con = null;
//        con = metodoconexion.getConexion();
//
//        Vector<modCiudad> datos = new Vector<modCiudad>();
//        modCiudad dat = null;
//
//        try {
//
//            String sql = "SELECT * FROM pruebabasetercerparcial2.ciudad WHERE Pais_Descripcion="+pais;
//            ps = con.prepareStatement(sql);
//            ps.setString(1, tpais.getDescripcion());
//            rs = ps.executeQuery();
//
//            dat = new modCiudad();
//            dat.setIdCiudad(0);
//            dat.setDescripcion("Seleccionar ciudad");
//            datos.add(dat);
//
//            while (rs.next()) {
//                dat = new modCiudad();
//                dat.setIdCiudad(rs.getInt("idCiudad"));
//                dat.setDescripcion(rs.getString("Descripcion"));
//                datos.add(dat);
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            System.err.println("Error consulta :" + ex.getMessage());
//        }
//        return datos;
//    }
    
    public Vector<modCiudad> mostrarCiudad(modPais tpais) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion conn = new conexion();
        Connection con = conn.getConexion();

        Vector<modCiudad> datos = new Vector<modCiudad>();
        modCiudad dat = null;

        try {

            String sql = "SELECT * FROM pruebaverdadera2.ciudad WHERE idPais='"+tpais.getIdPais()+"';";
             
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new modCiudad();
            dat.setIdCiudad(0);
            dat.setDescripcion("Seleccionar ciudad");
            datos.add(dat);

            while (rs.next()) {
                dat = new modCiudad();
                dat.setIdCiudad(rs.getInt("idCiudad"));
                dat.setDescripcion(rs.getString("Descripcion"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
