/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sistema.conexion.conexion;
import sistema.modelo.modPais;


/**
 *
 * @author Administrator
 */
public class consultaPais extends conexion {
    
    conexion metodoconexion = new conexion();
    
//    public void consultar_paises(JComboBox combopaises) {
//
//         objeto del tipo Connection
//        java.sql.Connection con = null;
//
//        creamos la consulta SQL
//        String SQL = "SELECT * FROM pruebabasetercerparcial2.pais";
//
//        establecemos el bloque de try-catch-finally
//        try {
//            establecer conexion con la bd
//            con = metodoconexion.getConexion();
//            preparamos la consulta sql
//            PreparedStatement pst = con.prepareStatement(SQL);
//            ejecutamos la consulta
//            ResultSet resultado = pst.executeQuery();
//
//            llenamos nuestro combo
//            combopaises.addItem("Seleccione una opcion");
//            
//            while (resultado.next()) {
//                
//                combopaises.addItem(resultado.getString("Descripcion"));
//            }
//            
//        } catch (Exception e) {
//            
//            JOptionPane.showMessageDialog(null, e);
//            
//        } finally {
//            
//            if (con != null) {
//                
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//            }
//            
//        }
//        
//    }
    
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
}
