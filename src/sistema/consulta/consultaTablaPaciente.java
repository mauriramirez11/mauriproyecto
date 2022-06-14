/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sistema.conexion.conexion;

/**
 *
 * @author Administrator
 */
public class consultaTablaPaciente {
    
    public void rellenartabla(JTable table){
        
 
     try 
        {
            DefaultTableModel modelo = new DefaultTableModel();
            table.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            conexion conn = new conexion();
            Connection con = conn.getConexion();
            
            String sql = "SELECT idPaciente, Nombre, Apellido, Documento, Direccion, Telefono, Correo, idCiudad, idPais FROM pruebaverdadera2.paciente";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            
            modelo.addColumn("idPaciente");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Documento");
            modelo.addColumn("Direccion");
            modelo.addColumn("Telefono");
            modelo.addColumn("Correo");
            modelo.addColumn("idCiudad");
            modelo.addColumn("idPais");
            
           
            
            while(rs.next()){
                
                Object[] filas = new Object[cantidadColumnas];
                
                for(int i = 0;i < cantidadColumnas; i++)
                {
                    filas[i] = rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }
            
        } catch(SQLException ex){
            System.err.println(ex.toString());
        }
}
}
