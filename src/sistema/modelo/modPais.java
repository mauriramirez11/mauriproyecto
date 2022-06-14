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
public class modPais {
    
    private int idPais;
    private String Descripcion;

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public String toString() {
       return this.Descripcion;  
    }

    
//    conexion metodoconexion = new conexion();
//    public Vector<modPais> mostrarPais() {
//
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        java.sql.Connection con = null;
//        con = metodoconexion.getConexion();
//
//        Vector<modPais> datos = new Vector<modPais>();
//        modPais dat = null;
//        try {
//
//            String sql = "SELECT * FROM pruebabasetercerparcial2.pais";
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            dat = new modPais();
//            dat.setIdPais(0);
//            dat.setDescripcion("Selecciona pais");
//            datos.add(dat);
//
//            while (rs.next()) {
//                dat = new modPais();
//                dat.setIdPais(rs.getInt("idPais"));
//                dat.setDescripcion(rs.getString("Descripcion"));
//                datos.add(dat);
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            System.err.println("Error consulta :" + ex.getMessage());
//        }
//        return datos;
//    }
//    
    public Vector<modPais> mostrarPais() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion conn = new conexion();
        Connection con = conn.getConexion();

        Vector<modPais> datos = new Vector<modPais>();
        modPais dat = null;
        try {

            String sql = "SELECT * FROM pruebaverdadera2.pais";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new modPais();
            dat.setIdPais(0);
            dat.setDescripcion("Selecciona pais");
            datos.add(dat);

            while (rs.next()) {
                dat = new modPais();
                dat.setIdPais(rs.getInt("idPais"));
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
