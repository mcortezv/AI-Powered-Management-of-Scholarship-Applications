package controles;
import apiGobierno.GobiernoAPI;
import apiGobierno.interfaces.IGobiernoAPI;
import gobierno.BecasDisponiblesDTOGobierno;
import gobierno.RequisitosDTOGobierno;
import gobierno.SolicitudDTOGobierno;

/**
 *
 * @author Cortez, Manuel;
 */
public class ControlGobierno {

    IGobiernoAPI gobiernoAPI;
    
    public ControlGobierno(){
        this.gobiernoAPI= new GobiernoAPI();
    }

    public BecasDisponiblesDTOGobierno solicitarBecas(RequisitosDTOGobierno requisitosDTO) {
        return gobiernoAPI.obtenerBecas(requisitosDTO);
        
        
        
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

    public boolean enviarSolicitud(SolicitudDTOGobierno solicitudDTO) {
        return true;
    }
}