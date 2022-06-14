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
import sistema.conexion.conexion;
import sistema.modelo.modPaciente;
import sistema.modelo.modPais;
import sistema.vista.frmPaciente;

/**
 *
 * @author Administrator
 */
public class consultaPaciente extends conexion{
    
    
    public boolean registrar(modPaciente paciente) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO pruebaverdadera2.paciente (idPaciente, Nombre, Apellido,"
                + "Documento, Direccion, Telefono, Correo, idCiudad, idPais) VALUES(default,?,?,?,"
                + "?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getDocumento());
            ps.setString(4, paciente.getDireccion());
            ps.setString(5, paciente.getTelefono());
            ps.setString(6, paciente.getCorreo()); 
            ps.setInt(7, paciente.getIdCiudad());
            ps.setInt(8, paciente.getIdPais());
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
    
      public boolean buscar(modPaciente paciente) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM pruebaverdadera2.paciente WHERE idPaciente = ? ";
        try {
            ps = con.prepareStatement(sql);
      
            ps.setString(1, paciente.getIdPaciente());
            rs = ps.executeQuery();
            if (rs.next()) {
                paciente.setIdPaciente(rs.getString("idPaciente"));
                paciente.setNombre(rs.getString("Nombre"));
                paciente.setApellido(rs.getString("Apellido"));
                paciente.setDocumento(rs.getString("Documento"));
                paciente.setDireccion(rs.getString("Direccion"));
                paciente.setTelefono(rs.getString("Telefono"));
                paciente.setCorreo(rs.getString("Correo"));
                paciente.setIdCiudad(rs.getInt("idCiudad"));
                paciente.setIdPais(rs.getInt("idPais"));
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
    
    public boolean eliminar(modPaciente paciente) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM pruebaverdadera2.paciente WHERE idPaciente = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getIdPaciente());
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
    
    public boolean modificar(modPaciente paciente, String Nombre, String Apellido, String Documento, String Direccion, String Telefono, String Correo, String idCiudad, String idPais, String IdPaciente ) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE pruebaverdadera2.paciente SET Nombre=?, Apellido=?,Documento=?,"
                + "Direccion=?,Telefono=?,Correo=?,idCiudad=?, "
                + "idPais=? WHERE idPaciente=?";
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getDocumento());
            ps.setString(4, paciente.getDireccion());
            ps.setString(5, paciente.getTelefono());
            ps.setString(6, paciente.getCorreo()); 
            ps.setInt(7, paciente.getIdCiudad());
            ps.setInt(8, paciente.getIdPais());
            ps.setString(9, paciente.getIdPaciente());
            
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
