/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlNavegacion;

import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import interfaz.IManejadorSolicitud;
import presentacion.login.MainFrame;
import presentacion.login.panels.IniciarSesionPanel;
import presentacion.login.panels.NorthPanel;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.panels.*;


/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlNavegacion {
    
    
    IManejadorSolicitud manejador;
    
    public ControlNavegacion(IManejadorSolicitud manejador){
        this.manejador= manejador;
    }
    
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO){
        return manejador.obtenerBecasDisponibles(solicitudDTO);
    }
}