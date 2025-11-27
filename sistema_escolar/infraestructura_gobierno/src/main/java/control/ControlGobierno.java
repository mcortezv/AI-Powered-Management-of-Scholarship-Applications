package control;
import datos.api_publica.GobiernoAPI;
import datos.api_publica.interfaz.IGobiernoAPI;
import datos.dto.BecasResponseDTOI;
import datos.dto.RequisitosDTOI;
import dto.*;
import solicitarBeca.dominio.enums.TipoBeca;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Cortez, Manuel;
 */
public class ControlGobierno {

    IGobiernoAPI gobiernoAPI;
    
    public ControlGobierno(){
        this.gobiernoAPI= new GobiernoAPI();
    }

    public BecasResponseDTOI solicitarBecas(RequisitosDTO requisitosDTO) {
        
        RequisitosDTOI requisitosDTOI= new RequisitosDTOI();
        requisitosDTOI.setPromedioMinimo(requisitosDTO.getPromedioMinimo());
        requisitosDTOI.setIngresoFamiliarMaximo(requisitosDTO.getIngresoFamiliarMaximo());
        requisitosDTOI.setProcentajeBajas(requisitosDTO.getProcentajeBajas());
        requisitosDTOI.setCargaAcademica(requisitosDTO.getCargaAcademica());
        requisitosDTOI.setIndiceReprobacion(requisitosDTO.getIndiceReprobacion());
        requisitosDTOI.setTrabajo(requisitosDTO.isTrabajo());
        requisitosDTOI.setDeudas(requisitosDTO.isDeudas());
        return gobiernoAPI.solicitarBecas(requisitosDTOI);
        
        
        
//        BecasDisponiblesResponseDTO becasDisponiblesResponseDTO = new BecasDisponiblesResponseDTO();
//        ArrayList<BecaResponseDTO> becas = new ArrayList<>();
//        RequisitosResponseDTO misRequisitos = new RequisitosResponseDTO();
//        BecaResponseDTO nuevaBeca = new BecaResponseDTO();
//        nuevaBeca.setCodigo(1001L);
//        nuevaBeca.setNombre("Beca de Excelencia Académica 2024");
//        nuevaBeca.setDescripcion("Apoyo económico para estudiantes con promedio superior a 9.5");
//        nuevaBeca.setTipo(TipoBeca.CONSTANCIA);
//        nuevaBeca.setBecasDisponibles(50);
//        nuevaBeca.setFechaInicio(LocalDate.now());
//        nuevaBeca.setFechaFin(LocalDate.of(2024, 11, 30));
//        nuevaBeca.setFechaResultados(LocalDate.of(2024, 12, 15));
//        nuevaBeca.setRequisitos(misRequisitos);
//        becas.add(nuevaBeca);
//        becasDisponiblesResponseDTO.setBecas(becas);
//        return becasDisponiblesResponseDTO;
}

    public boolean enviarSolicitud(SolicitudDTO solicitudDTO) {
        return true;
    }
}