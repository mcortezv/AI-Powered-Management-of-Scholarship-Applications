///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package implementacion;
//
//import dto.*;
//
//import interfaces.IBecaBOMock;
//import objetosNegocio.mock.BecaBOMock;
//import objetosNegocio.mock.EstudianteMock;
//import objetosNegocio.mock.GobiernoMock;
//
//import java.util.ArrayList;
//
///**
// *
// * @author janethcristinagalvanquinonez
// */
//public class ControlSolicitud {
//
//    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
//        SolicitudBecasDisponiblesResponseDTO responseDTO = BecaBOMock.getInstance().obtenerBecasDisponibles(solicitudDTO);
//        if (responseDTO == null || responseDTO.getBecas() == null) {
//            return new SolicitudBecasDisponiblesResponseDTO(new ArrayList<>());
//        }
//        if (comprobarCriterioCantidad(responseDTO)) {
//            return responseDTO;
//        }
//        return new SolicitudBecasDisponiblesResponseDTO(new ArrayList<>());
//    }
//
//    public boolean comprobarCriterioCantidad(SolicitudBecasDisponiblesResponseDTO becasDTO) {
//        if (becasDTO == null || becasDTO.getBecas() == null) {
//            return false;
//        }
//        int numBecas = becasDTO.getBecas().size();
//        return numBecas > 1;
//
//    }
//
//    public boolean guardarSolicitud(SolicitudDTO solicitudDTO){
//        return GobiernoMock.enviarSolicitud(solicitudDTO);
//    }
//
//
//}
