/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.vista;

import sistema.controlador.controladorSesion;
import sistema.modelo.modUsuario;
import sistema.consulta.consultaValidarSesion;


/**
 *
 * @author Administrator
 */
public class Arranque {
    
    
    public static void main(String[] args) {
        modUsuario usuario = new modUsuario();
        consultaValidarSesion validarSesion = new consultaValidarSesion();
        frmLogin login = new frmLogin();
        controladorSesion sesion = new controladorSesion(validarSesion, usuario, login);
        login.setVisible(true);
    }
    
}
