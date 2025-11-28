package control;
import datos.api_publica.GobiernoAPI;
import datos.api_publica.interfaz.IGobiernoAPI;
import datos.dto.BecasResponseDTOI;
import datos.dto.RequisitosDTOI;
import dto.*;
import solicitarBeca.dominio.enums.TipoBeca;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cortez, Manuel;
 */
public class ControlGobierno {

    IGobiernoAPI gobiernoAPI;
    
    public ControlGobierno(){
        this.gobiernoAPI= new GobiernoAPI();
    }

    public BecasFiltradasDTO solicitarBecas(RequisitosDTO requisitosDTO) {
        
        RequisitosDTOI requisitosDTOI= new RequisitosDTOI();
        requisitosDTOI.setPromedioMinimo(requisitosDTO.getPromedioMinimo());
        requisitosDTOI.setIngresoFamiliarMaximo(requisitosDTO.getIngresoFamiliarMaximo());
        requisitosDTOI.setProcentajeBajas(requisitosDTO.getProcentajeBajas());
        requisitosDTOI.setCargaAcademica(requisitosDTO.getCargaAcademica());
        requisitosDTOI.setIndiceReprobacion(requisitosDTO.getIndiceReprobacion());
        requisitosDTOI.setTrabajo(requisitosDTO.isTrabajo());
        requisitosDTOI.setDeudas(requisitosDTO.isDeudas());
        
        BecasResponseDTOI becasResponseDTOI = gobiernoAPI.solicitarBecas(requisitosDTOI);
        
        BecasFiltradasDTO becasFiltradasDTO = new BecasFiltradasDTO();
        List<BecaDTO> becasDTO = new ArrayList<>();
        
        if (becasResponseDTOI != null && becasResponseDTOI.getBecas() != null) {
            for (datos.dominio.Beca b : becasResponseDTOI.getBecas()) {
                BecaDTO dto = new BecaDTO();
                dto.setCodigo((long) b.getCodigo());
                dto.setNombre(b.getNombre());
                dto.setDescripcion(b.getDescripcion());
                dto.setFechaInicio(b.getFechaInicio());
                dto.setFechaFin(b.getFechaFin());
                dto.setFechaResultados(b.getFechaResultados());
                dto.setBecasDisponibles(b.getBecasDisponibles());
                dto.setTipo(b.getTipo().name());

                RequisitosDTO rDTO = new RequisitosDTO();
                rDTO.setPromedioMinimo(b.getRequisitos().getPromedioMinimo());
                rDTO.setIngresoFamiliarMaximo(b.getRequisitos().getIngresoFamiliarMaximo());
                rDTO.setTrabajo(b.getRequisitos().isTrabajo());

                dto.setRequisitos(rDTO);

                becasDTO.add(dto);
            }
        }
        becasFiltradasDTO.setBecas(becasDTO);
        
        return becasFiltradasDTO;
        
        
        
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