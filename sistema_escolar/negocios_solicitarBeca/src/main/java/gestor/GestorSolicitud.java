/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import dto.BecaDTO;
import dto.RequisitosDTO;
import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class GestorSolicitud {

    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {

        java.time.LocalDate ahora = java.time.LocalDate.now();
        List<BecaDTO> listaBecas = new ArrayList<>();
        BecaDTO beca1 = new BecaDTO(1, "Apoyo Economico", "Moisés Vázquez Gudiño", "2025-2", 50, new RequisitosDTO(7.0, 12000.0, 30.0, 50.0, 30.0, false, true), ahora.plusMonths(1));
        BecaDTO beca2 = new BecaDTO(2, "Excelencia", "Beca Ara", "2025-2", 20, new RequisitosDTO(9.0, 999999.0, 10.0, 70.0, 10.0, false, false), ahora.plusMonths(1));
        BecaDTO beca3 = new BecaDTO(3, "Promedio", "Fundación Espinoza Rodríguez", "2025-2", 40, new RequisitosDTO(8.0, 15000.0, 20.0, 60.0, 20.0, false, false), ahora.plusMonths(1));
        BecaDTO beca4 = new BecaDTO(4, "Corporativa", "Constellation Brands", "2025-2", 15, new RequisitosDTO(8.5, 20000.0, 15.0, 70.0, 15.0, true, false), ahora.plusMonths(1));
        listaBecas.add(beca1);
        listaBecas.add(beca2);
        listaBecas.add(beca3);
        listaBecas.add(beca4);
        SolicitudBecasDisponiblesResponseDTO solicitudResponseDTO = new SolicitudBecasDisponiblesResponseDTO(listaBecas);
        return solicitudResponseDTO;

    }
}
