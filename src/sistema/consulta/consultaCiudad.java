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
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sistema.conexion.conexion;
import sistema.modelo.modCiudad;

/**
 *
 * @author Administrator
 */
public class consultaCiudad {
    
    conexion metodoconexion = new conexion();
    
    public void consultar_ciudad(JComboBox combociudad) {

        // objeto del tipo Connection
        java.sql.Connection con = null;

        //creamos la consulta SQL
        String SQL = "SELECT * FROM pruebabasetercerparcial2.ciudad";

        //establecemos el bloque de try-catch-finally
        try {
            //establecer conexion con la bd
            con = metodoconexion.getConexion();
            //preparamos la consulta sql
            PreparedStatement pst = con.prepareStatement(SQL);
            //ejecutamos la consulta
            ResultSet resultado = pst.executeQuery();

            //llenamos nuestro combo
            combociudad.addItem("Seleccione una opcion");
            
            while (resultado.next()) {
                
                combociudad.addItem(resultado.getString("Descripcion"));
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            
        } finally {
            
            if (con != null) {
                
                try {
                    con.close();
                } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }
       
    
}