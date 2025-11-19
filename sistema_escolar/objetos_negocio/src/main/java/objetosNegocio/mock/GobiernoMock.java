package objetosNegocio.mock;

import dto.SolicitudDTO;

public class GobiernoMock {

    private static GobiernoMock instancia;


    public GobiernoMock(){}
    public static GobiernoMock getInstance(){
        if(instancia==null){
            instancia= new GobiernoMock();
        }
        return instancia;
    }

    public static boolean enviarSolicitud(SolicitudDTO solicitudDTO){
        return true;
    }

}
