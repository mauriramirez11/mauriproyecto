/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sistema.conexion.conexion;
import sistema.consulta.consultaCiudad;
import sistema.modelo.modCiudad;
import sistema.modelo.modPaciente;
import sistema.modelo.modPais;
import sistema.vista.frmPaciente;

/**
 *
 * @author Administrator
 */
public class controladorCiudad {
    
    private final modCiudad ciudad;
    private final consultaCiudad cCiudad;
    private final frmPaciente frmP;

    public controladorCiudad(modCiudad ciudad, consultaCiudad cCiudad, frmPaciente frmP) {
        this.ciudad = ciudad;
        this.cCiudad = cCiudad;
        this.frmP = frmP;
    }

    
    

   
}
