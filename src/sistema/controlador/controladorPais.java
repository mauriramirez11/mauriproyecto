/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import sistema.consulta.consultaPais;
import sistema.modelo.modPais;
import sistema.vista.frmPaciente;

/**
 *
 * @author Administrator
 */
public class controladorPais {
    
    private final modPais tpais;
    private final consultaPais cPais;
    private final frmPaciente frmP;

    public controladorPais(modPais tpais, consultaPais cPais, frmPaciente frmP) {
        this.tpais = tpais;
        this.cPais = cPais;
        this.frmP = frmP;
    }

  
    };
