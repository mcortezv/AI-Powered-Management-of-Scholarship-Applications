package control;
import dto.BecaDTO;
import dto.BecasDisponiblesResponseDTO;
import dto.RequisitosDTO;
import dto.SolicitudDTO;
import solicitarBeca.dominio.Beca;
import solicitarBeca.dominio.Requisitos;
import solicitarBeca.dominio.enums.TipoBeca;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Cortez, Manuel;
 */
public class ControlGobierno {

    public BecasDisponiblesResponseDTO solicitarBecas(RequisitosDTO requisitosDTO) {
        BecasDisponiblesResponseDTO becasDisponiblesResponseDTO = new BecasDisponiblesResponseDTO();
        ArrayList<Beca> becas = new ArrayList<>();
        Requisitos misRequisitos = new Requisitos();
        Beca nuevaBeca = new Beca();
        nuevaBeca.setCodigo(1001L);
        nuevaBeca.setNombre("Beca de Excelencia Académica 2024");
        nuevaBeca.setDescripcion("Apoyo económico para estudiantes con promedio superior a 9.5");
        nuevaBeca.setTipo(TipoBeca.CONSTANCIA);
        nuevaBeca.setBecasDisponibles(50);
        nuevaBeca.setFechaInicio(LocalDate.now());
        nuevaBeca.setFechaFin(LocalDate.of(2024, 11, 30));
        nuevaBeca.setFechaResultados(LocalDate.of(2024, 12, 15));
        nuevaBeca.setRequisitos(misRequisitos);
        becas.add(nuevaBeca);
        becasDisponiblesResponseDTO.setBecas(becas);
        return becasDisponiblesResponseDTO;
}

    boolean enviarSolicitud(SolicitudDTO solicitudDTO) {
        return true;
    }
}