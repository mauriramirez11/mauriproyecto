/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.consulta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sistema.conexion.conexion;

/**
 *
 * @author Administrator
 */
public class consultaSucursal extends conexion {
    
    conexion metodoconexion = new conexion();
    
    public void consultar_sucursal(JComboBox combosucursal) {

        // objeto del tipo Connection
        java.sql.Connection con = null;

        //creamos la consulta SQL
        String SQL = "SELECT * FROM pruebabasetercerparcial2.sucursal";

        //establecemos el bloque de try-catch-finally
        try {
            //establecer conexion con la bd
            con = metodoconexion.getConexion();
            //preparamos la consulta sql
            PreparedStatement pst = con.prepareStatement(SQL);
            //ejecutamos la consulta
            ResultSet resultado = pst.executeQuery();

            //llenamos nuestro combo
            combosucursal.addItem("Seleccione una opcion");
            
            while (resultado.next()) {
                
                combosucursal.addItem(resultado.getString("Descripcion"));
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
