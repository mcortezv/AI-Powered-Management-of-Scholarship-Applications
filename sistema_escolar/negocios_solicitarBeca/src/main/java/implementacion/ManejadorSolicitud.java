/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;
import dto.*;
import gestor.GestorSolicitud;
import interfaz.IManejadorSolicitud;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ManejadorSolicitud implements IManejadorSolicitud {
    private GestorSolicitud gestor;
    
    public ManejadorSolicitud(GestorSolicitud gestor){
        this.gestor= gestor;
    }

    @Override
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO){
        return gestor.obtenerBecasDisponibles(solicitudDTO);
        
    }

    @Override
    public EstudianteResponseDTO validarInicioSesion(SolicitudLoginDTO solicitudLoginDTO) {
        return gestor.validarInicioSesion(solicitudLoginDTO);
    }

}
