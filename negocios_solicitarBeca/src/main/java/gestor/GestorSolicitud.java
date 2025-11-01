/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import dto.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import objetosNegocio.mock.BecaBOMock;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class GestorSolicitud {
    BecaBOMock becaBO;

    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
        return becaBO.getInstance().obtenerBecas();
      

    }

}
