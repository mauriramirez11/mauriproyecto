/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import sistema.consulta.consultaPaciente;
import sistema.modelo.modPaciente;
import sistema.vista.frmPaciente;
import sistema.vista.frmTablaPaciente;



/**
 *
 * @author Administrator
 */
public class controladorPaciente implements ActionListener {
    
    private final modPaciente paciente;
    private final consultaPaciente cPaciente;
    private final frmPaciente frmP;
   

    public controladorPaciente(modPaciente paciente, consultaPaciente cPaciente, frmPaciente frmP) {
        this.paciente = paciente;
        this.cPaciente = cPaciente;
        this.frmP = frmP;
        this.frmP.btnInsertar.addActionListener(this);
        this.frmP.btnModificar.addActionListener(this);
        this.frmP.btnEliminar.addActionListener(this);
        this.frmP.btnBuscar.addActionListener(this);
        this.frmP.btnTablaPaciente.addActionListener(this);
        this.frmP.btnInsertar.addMouseListener(habilitar);
    }

    
    
    
    public void iniciar() {
        frmP.setTitle("Registro de paciente");
        frmP.setLocationRelativeTo(null);
    }
    

    
    MouseListener habilitar = new MouseListener() {

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
            if (e.getSource() == frmP.btnInsertar ) {
                deshabilitar_id();
                frmP.txtIdPaciente.setText("Deshabilitado");
            } 
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == frmP.btnInsertar ) {
               habilitar_id();
               frmP.txtIdPaciente.setText("");
            } 
        }
            
            };
    
    @Override
    public void actionPerformed(ActionEvent e) {
           
        
        if (e.getSource() == frmP.btnInsertar) {
            String s = frmP.comboPais.getSelectedItem().toString();
            
            paciente.setIdPaciente(null);
            paciente.setNombre(frmP.txtNombre.getText());
            paciente.setApellido(frmP.txtApellido.getText());
            paciente.setDocumento(frmP.txtDocumento.getText());
            paciente.setDireccion(frmP.txtDireccion.getText());
            paciente.setTelefono(frmP.txtTelefono.getText());
            paciente.setCorreo(frmP.txtCorreo.getText());
            paciente.setIdCiudad(frmP.comboCiudad.getSelectedIndex());
            paciente.setIdPais(frmP.comboPais.getSelectedIndex());
            
            if (cPaciente.registrar(paciente)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
       if (e.getSource() == frmP.btnBuscar) {
            paciente.setIdPaciente(frmP.txtIdPaciente.getText());

            if (cPaciente.buscar(paciente)) {

                JOptionPane.showMessageDialog(null, "Registro Encontrado");
                buscar();

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
       
       if (e.getSource() == frmP.btnEliminar) {
            paciente.setIdPaciente(frmP.txtIdPaciente.getText());
  
            if (cPaciente.eliminar(paciente)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
       
        if (e.getSource() == frmP.btnModificar) {
               
            paciente.setNombre(frmP.txtNombre.getText());
            paciente.setApellido(frmP.txtApellido.getText());
            paciente.setDocumento(frmP.txtDocumento.getText());
            paciente.setDireccion(frmP.txtDireccion.getText());
            paciente.setTelefono(frmP.txtTelefono.getText());
            paciente.setCorreo(frmP.txtCorreo.getText());
            paciente.setIdCiudad(frmP.comboCiudad.getSelectedIndex());
            paciente.setIdPais(frmP.comboPais.getSelectedIndex());
            paciente.setIdPaciente(frmP.txtIdPaciente.getText());
            
            if (cPaciente.modificar(paciente,frmP.txtNombre.getText(),frmP.txtApellido.getText(),frmP.txtDocumento.getText(),frmP.txtDireccion.getText(),frmP.txtTelefono.getText(),frmP.txtCorreo.getText(), frmP.comboCiudad.getSelectedItem().toString(),frmP.comboPais.getSelectedItem().toString(), frmP.txtIdPaciente.getText())) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == frmP.btnTablaPaciente) {
            
            frmTablaPaciente formu = new frmTablaPaciente();
            formu.setVisible(true);
            
        }
    }
               
    
    
     private void buscar(){
        paciente.setIdPaciente(frmP.txtIdPaciente.getText());
        if(cPaciente.buscar(paciente)){
            frmP.txtNombre.setText(paciente.getNombre());
            frmP.txtApellido.setText(paciente.getApellido());
            frmP.txtDocumento.setText(paciente.getDocumento());
            frmP.txtDireccion.setText(paciente.getDireccion());
            frmP.txtTelefono.setText(paciente.getTelefono());
            frmP.txtCorreo.setText(paciente.getCorreo());
            frmP.comboCiudad.setSelectedItem(paciente.getIdCiudad());
            frmP.comboPais.setSelectedItem(paciente.getIdPais());
         }
      } 
     
     private void limpiar(){
            frmP.txtIdPaciente.setText("");
            frmP.txtNombre.setText("");
            frmP.txtApellido.setText("");
            frmP.txtDocumento.setText("");
            frmP.txtDireccion.setText("");
            frmP.txtTelefono.setText("");
            frmP.txtCorreo.setText("");
            frmP.comboPais.setSelectedItem("");
            frmP.comboCiudad.setSelectedItem("");
         }
       public void deshabilitar_id(){
          frmP.txtIdPaciente.setEnabled(false);
      } 
       public void habilitar_id(){
          frmP.txtIdPaciente.setEnabled(true);
      } 
       
       
       
    }
   

            
    

    

