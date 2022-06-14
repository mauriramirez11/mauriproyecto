/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sistema.modelo.modUsuario;
import sistema.consulta.consultaValidarSesion;
import sistema.vista.frmLogin;
import sistema.vista.frmPrincipal;

/**
 *
 * @author Administrator
 */
public class controladorSesion implements ActionListener{
    
    public consultaValidarSesion validarSesion;
    public modUsuario usuario;
    public frmLogin login;
    public frmPrincipal principal;
    

    public controladorSesion(consultaValidarSesion validarSesion, modUsuario usuario, frmLogin login ) {
        this.validarSesion = validarSesion;
        this.usuario = usuario;
        this.login = login;
        this.login.btnAceptar.addActionListener(this);
      
    }

  
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login.btnAceptar){
            usuario.setIdUsuario(login.txtUsuario.getText());
            if(validarSesion.buscar(usuario)){
                    login.dispose();
                    frmPrincipal pantPrincipal = new frmPrincipal();
                    pantPrincipal.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario incorrecto, vuelva a intentarlo. ");
                }
            }
        }
    }
    

