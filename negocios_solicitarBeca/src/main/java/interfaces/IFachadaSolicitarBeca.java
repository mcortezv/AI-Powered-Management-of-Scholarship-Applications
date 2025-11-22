/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.*;
import excepciones.SolicitudInvalidaException;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IFachadaSolicitarBeca {

    SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO);

    boolean validarRequisitos(RequisitosDTO requisitos);

    boolean validarSolicitudNoExistente(int idEstudiante, int idSolicitud);

    BecaDTO recuperarBeca(int idBeca);

    EstudianteDTO solicitarDatosEstudiante(int  idEstudiante);

    SolicitudDTO crearSolicitud();

    boolean guardarSolicitud(SolicitudDTO solicitud);

    boolean enviarSolicitudGobierno(SolicitudDTO solicitudDTO);
    
     public SolicitudDTO iniciarNuevaSolicitud() throws SolicitudInvalidaException;
}
