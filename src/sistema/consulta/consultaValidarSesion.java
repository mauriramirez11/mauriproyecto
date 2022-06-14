/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.consulta;

import sistema.conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistema.modelo.modUsuario;

/**
 *
 * @author Administrator
 */
    public class consultaValidarSesion  extends conexion{
        
    public boolean buscar(modUsuario usuario){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = getConexion();
        String sql = "SELECT * FROM pruebabasetercerparcial2.usuario WHERE idUsuario = ?";
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getIdUsuario());
            rs = ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Bienvenido");
                usuario.setNombre(rs.getString("Nombre"));
    
                return true;
            }
            return false;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        } 
    }
        
        
        
}

