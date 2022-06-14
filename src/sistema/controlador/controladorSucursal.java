/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import sistema.consulta.consultaPais;
import sistema.consulta.consultaSucursal;
import sistema.modelo.modPais;
import sistema.modelo.modSucursal;
import sistema.vista.frmOdontologo;
import sistema.vista.frmPaciente;

/**
 *
 * @author Administrator
 */
public class controladorSucursal {
    
    private final modSucursal sucursal;
    private final consultaSucursal cSucursal;
    private final frmOdontologo frmO;

    public controladorSucursal(modSucursal sucursal, consultaSucursal cSucursal, frmOdontologo frmO) {
        this.sucursal = sucursal;
        this.cSucursal = cSucursal;
        this.frmO = frmO;
    }
    
    
}
