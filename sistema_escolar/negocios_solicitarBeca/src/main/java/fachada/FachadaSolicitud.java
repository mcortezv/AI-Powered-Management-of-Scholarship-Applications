/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;
import dto.*;
import implementacion.ControlSolicitud;
import interfaz.IFachadaSolicitud;

/**
 *                          FACHADA
 * @author janethcristinagalvanquinonez
 */
public class FachadaSolicitud implements IFachadaSolicitud {
    private final ControlSolicitud controlSolicitud;
    
    public FachadaSolicitud(ControlSolicitud gestor){
        this.controlSolicitud= gestor;
    }

    @Override
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
        return null;
    }

}
