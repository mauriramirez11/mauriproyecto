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
import sistema.conexion.conexion;

/**
 *
 * @author Administrator
 */
public class modSucursal {
    private int idSucursal;
    private String Descripcion;
    private String Ciudad_Descripcion;
    private String Pais_Descripcion;

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCiudad_Descripcion() {
        return Ciudad_Descripcion;
    }

    public void setCiudad_Descripcion(String Ciudad_Descripcion) {
        this.Ciudad_Descripcion = Ciudad_Descripcion;
    }

    public String getPais_Descripcion() {
        return Pais_Descripcion;
    }

    public void setPais_Descripcion(String Pais_Descripcion) {
        this.Pais_Descripcion = Pais_Descripcion;
    }
    
    public String toString() {
       return this.Descripcion;  
    }
    
    public Vector<modSucursal> mostrarSucursal(modCiudad ciudad) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion conn = new conexion();
        Connection con = conn.getConexion();

        Vector<modSucursal> datos = new Vector<modSucursal>();
        modSucursal dat = null;
        try {

            String sql = "SELECT * FROM pruebaverdadera2.sucursal WHERE idCiudad='"+ciudad.getIdCiudad()+"';";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new modSucursal();
            dat.setIdSucursal(0);
            dat.setDescripcion("Selecciona sucursal");
            datos.add(dat);

            while (rs.next()) {
                dat = new modSucursal();
                dat.setIdSucursal(rs.getInt("idSucursal"));
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
