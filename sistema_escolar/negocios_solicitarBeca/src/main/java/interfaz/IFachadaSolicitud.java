/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.*;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IFachadaSolicitud {
    SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO);
    boolean guardarSolicitud(SolicitudDTO solicitudDTO);
}
