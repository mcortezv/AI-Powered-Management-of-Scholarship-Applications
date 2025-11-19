/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;

import dto.*;

import objetosNegocio.mock.BecaBOMock;
import objetosNegocio.mock.EstudianteMock;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlSolicitud {

    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
        SolicitudBecasDisponiblesResponseDTO becas = BecaBOMock.getInstance().obtenerBecasDisponibles(solicitudDTO);
        if (comprobarCriterioCantidad(becas)) {
            return becas;
        };
        return null;
    }

    public boolean comprobarCriterioCantidad(SolicitudBecasDisponiblesResponseDTO becasDTO) {
        if (becasDTO ==null || becasDTO.getBecas() == null) {
            return false;
        }
        int numBecas = becasDTO.getBecas().size();
        return numBecas > 1;

    }

//    public boolean enviaSolicitudBeca(SolicitudDTO solicitudDTO){
//        boolean respuesta =
//    }
    
//    public boolean enviarSolicitudGobierno(SolicitudDTO solicitudDTO){
//        
//    }

}
