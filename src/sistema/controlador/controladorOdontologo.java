/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import sistema.consulta.consultaOdontologo;
import sistema.modelo.modOdontologo;
import sistema.vista.frmOdontologo;
import sistema.vista.frmTablaOdontologo;


/**
 *
 * @author Administrator
 */
public class controladorOdontologo implements ActionListener {
    private final modOdontologo odontologo;
    private final consultaOdontologo cOdontologo;
    private final frmOdontologo frmO;

    public controladorOdontologo(modOdontologo odontologo, consultaOdontologo cOdontologo, frmOdontologo frmO) {
        this.odontologo = odontologo;
        this.cOdontologo = cOdontologo;
        this.frmO = frmO;
        this.frmO.btnInsertar.addActionListener(this);
        this.frmO.btnBuscar.addActionListener(this);
        this.frmO.btnEliminar.addActionListener(this);
        this.frmO.btnModificar.addActionListener(this);
        this.frmO.btnTablaOdontologo.addActionListener(this);
        this.frmO.btnInsertar.addMouseListener(habilitarOdontologo);
    }
    
     
    MouseListener habilitarOdontologo = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
    
        }

        @Override
        public void mousePressed(MouseEvent e) {
     
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == frmO.btnInsertar ) {
                deshabilitar_id();
                frmO.txtIdOdontologo.setText("Deshabilitado");
            } 
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == frmO.btnInsertar ) {
               habilitar_id();
               frmO.txtIdOdontologo.setText("");
            } 
        }
            
     };
    
    @Override
    public void actionPerformed(ActionEvent e) {
           
        if (e.getSource() == frmO.btnInsertar) {
            odontologo.setIdOdontologo(null);
            odontologo.setNombre(frmO.txtNombre.getText());
            odontologo.setApellido(frmO.txtApellido.getText());
            odontologo.setDocumento(frmO.txtDocumento.getText());
            odontologo.setTelefono(frmO.txtTelefono.getText());
            odontologo.setCorreo(frmO.txtCorreo.getText());
            odontologo.setIdCiudad(frmO.comboCiudad.getSelectedIndex());
            odontologo.setIdPais(frmO.comboPais.getSelectedIndex());
            odontologo.setIdSucursal(frmO.comboSucursal.getSelectedIndex());
            if (cOdontologo.registrar(odontologo)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        if (e.getSource() == frmO.btnBuscar) {
            odontologo.setIdOdontologo(frmO.txtIdOdontologo.getText());

            if (cOdontologo.buscar(odontologo)) {

                JOptionPane.showMessageDialog(null, "Registro Encontrado");
                buscar();

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
         if (e.getSource() == frmO.btnEliminar) {
            odontologo.setIdOdontologo(frmO.txtIdOdontologo.getText());
  
            if (cOdontologo.eliminar(odontologo)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
         
          if (e.getSource() == frmO.btnModificar) {           
            odontologo.setNombre(frmO.txtNombre.getText());
            odontologo.setApellido(frmO.txtApellido.getText());
            odontologo.setTelefono(frmO.txtTelefono.getText());
            odontologo.setCorreo(frmO.txtCorreo.getText());
            odontologo.setDocumento(frmO.txtDocumento.getText());
            odontologo.setIdPais(frmO.comboPais.getSelectedIndex());
            odontologo.setIdCiudad(frmO.comboCiudad.getSelectedIndex());
            odontologo.setIdSucursal(frmO.comboSucursal.getSelectedIndex());
            odontologo.setIdOdontologo(frmO.txtIdOdontologo.getText());
            
            if (cOdontologo.modificar(odontologo,frmO.txtNombre.getText(),frmO.txtApellido.getText(),frmO.txtTelefono.getText(),frmO.txtCorreo.getText(),frmO.txtDocumento.getText(), frmO.comboPais.getSelectedItem().toString(), frmO.comboCiudad.getSelectedItem().toString(),frmO.comboSucursal.getSelectedItem().toString(), frmO.txtIdOdontologo.getText())) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
          
          if (e.getSource() == frmO.btnTablaOdontologo) {
            
            frmTablaOdontologo formulario = new frmTablaOdontologo();
            formulario.setVisible(true);
            
        }
    }
    
    public void iniciar() {
        frmO.setTitle("Registro de odontologo");
        frmO.setLocationRelativeTo(null);
    }
    
    private void limpiar(){
            frmO.txtIdOdontologo.setText("");
            frmO.txtNombre.setText("");
            frmO.txtApellido.setText("");
            frmO.txtDocumento.setText("");
            frmO.txtTelefono.setText("");
            frmO.txtCorreo.setText("");
            frmO.comboPais.setSelectedItem(null);
            frmO.comboCiudad.setSelectedItem(null);
            frmO.comboSucursal.setSelectedItem(null);
         }
    public void deshabilitar_id(){
          frmO.txtIdOdontologo.setEnabled(false);
      } 
       public void habilitar_id(){
          frmO.txtIdOdontologo.setEnabled(true);
      }
      
     private void buscar(){
        odontologo.setIdOdontologo(frmO.txtIdOdontologo.getText());
        if(cOdontologo.buscar(odontologo)){
            frmO.txtNombre.setText(odontologo.getNombre());
            frmO.txtApellido.setText(odontologo.getApellido());
            frmO.txtTelefono.setText(odontologo.getTelefono());
            frmO.txtCorreo.setText(odontologo.getCorreo());
            frmO.txtDocumento.setText(odontologo.getDocumento());
            frmO.comboPais.setSelectedIndex(odontologo.getIdPais());
            frmO.comboCiudad.setSelectedIndex(odontologo.getIdCiudad());
            frmO.comboSucursal.setSelectedIndex(odontologo.getIdSucursal());
         }
      }   
       
}
