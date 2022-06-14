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
import sistema.conexion.conexion;
import sistema.modelo.modOdontologo;
import sistema.modelo.modPaciente;

/**
 *
 * @author Administrator
 */
public class consultaOdontologo extends conexion {
    
    public boolean registrar(modOdontologo odontologo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO pruebaverdadera2.odontologo (idOdontologo, Nombre, Apellido,"
                + "Telefono, Correo, Documento, idPais, idCiudad, idSucursal) VALUES(default,?,?,?,"
                + "?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, odontologo.getNombre());
            ps.setString(2, odontologo.getApellido());
            ps.setString(3, odontologo.getTelefono());
            ps.setString(4, odontologo.getCorreo()); 
            ps.setString(5, odontologo.getDocumento());
            ps.setInt(6, odontologo.getIdPais());
            ps.setInt(7, odontologo.getIdCiudad());
            ps.setInt(8, odontologo.getIdSucursal());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
    public boolean buscar(modOdontologo odontologo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM pruebaverdadera2.odontologo WHERE idOdontologo = ? ";
        try {
            ps = con.prepareStatement(sql);
      
            ps.setString(1, odontologo.getIdOdontologo());
            rs = ps.executeQuery();
            if (rs.next()) {
                odontologo.setIdOdontologo(rs.getString("idOdontologo"));
                odontologo.setNombre(rs.getString("Nombre"));
                odontologo.setApellido(rs.getString("Apellido"));
                odontologo.setTelefono(rs.getString("Telefono"));
                odontologo.setCorreo(rs.getString("Correo"));
                odontologo.setDocumento(rs.getString("Documento"));
                odontologo.setIdPais(rs.getInt("idPais"));
                odontologo.setIdCiudad(rs.getInt("idCiudad"));
                odontologo.setIdSucursal(rs.getInt("idSucursal"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(modOdontologo odontologo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM pruebaverdadera2.odontologo WHERE idOdontologo= ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, odontologo.getIdOdontologo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(modOdontologo odontologo, String Nombre, String Apellido, String Telefono, String Correo, String Documento, String Pais_Descripcion, String Ciudad_Descripcion, String Sucursal_Descripcion, String IdOdontologo ) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE pruebaverdadera2.odontologo SET Nombre=?, Apellido=?,Telefono=?,"
                + "Correo=?,Documento=?,idPais=?,idCiudad=?, "
                + "idSucursal=? WHERE idOdontologo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, odontologo.getNombre());
            ps.setString(2, odontologo.getApellido());
            ps.setString(3, odontologo.getTelefono());
            ps.setString(4, odontologo.getCorreo());
            ps.setString(5, odontologo.getDocumento());
            ps.setInt(6, odontologo.getIdPais());
            ps.setInt(7, odontologo.getIdCiudad());
            ps.setInt(8, odontologo.getIdSucursal());
            ps.setString(9, odontologo.getIdOdontologo());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
