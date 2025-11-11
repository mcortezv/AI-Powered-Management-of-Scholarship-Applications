/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;
import dto.*;
import gestor.ControlSolicitud;
import interfaz.IManejadorSolicitud;

/**
 *                          FACHADA
 * @author janethcristinagalvanquinonez
 */
public class FachadaSolicitud implements IManejadorSolicitud {
    private final ControlSolicitud gestor;
    
    public FachadaSolicitud(ControlSolicitud gestor){
        this.gestor= gestor;
    }

    @Override
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO){
        return gestor.obtenerBecasDisponibles(solicitudDTO);
        
    }

    @Override
    public EstudianteResponseDTO validarInicioSesion(SolicitudLoginDTO solicitudLoginDTO) {
        return null;
    }


}
