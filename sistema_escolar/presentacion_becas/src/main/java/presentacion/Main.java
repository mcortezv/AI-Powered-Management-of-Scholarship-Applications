/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package presentacion;
import control.ControlGobierno;
import controles.ControlInicioSesion;
import controles.ControlItson;
import controles.ControlSolicitarBeca;
import solicitarBeca.dao.DocumentoDAO;
import solicitarBeca.dao.EstudianteDAO;
import solicitarBeca.dao.SolicitudDAO;
import solicitarBeca.dao.interfaces.IDocumentoDAO;
import solicitarBeca.dao.interfaces.IEstudianteDAO;
import solicitarBeca.dao.interfaces.ISolicitudDAO;
import fachada.FachadaGobierno;
import fachadas.FachadaInicioSesion;
import fachadas.FachadaItson;
import fachadas.FachadaSolicitarBeca;
import interfaces.*;
import objetosNegocio.*;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;

/**
 *
 * @author Cortez, Manuel;
 */
public class Main {

    public static void main(String[] args) {

        IFachadaITSON fachadaITSON = new FachadaItson(new ControlItson());
        IFachadaGobierno fachadaGobierno = new FachadaGobierno(new ControlGobierno());
        ISolicitudDAO solicitudDAO = new SolicitudDAO();
        IEstudianteDAO estudianteDAO = new EstudianteDAO();
        IDocumentoDAO documentoDAO = new DocumentoDAO();
        IBecasFiltradasBO becasFiltradasBO = new BecasFiltradasBO(fachadaGobierno);
        IDocumentoBO documentoBO = new DocumentoBO(documentoDAO);
        IEstudianteBO estudianteBO = new EstudianteBO(fachadaITSON, estudianteDAO);
        IHistorialAcademicoBO historialAcademicoBO = new HistorialAcademicoBO(fachadaITSON);
        IInformacionSocioeconomicaBO informacionSocioeconomicaBO =  new InformacionSocioeconomicaBO();
        ISolicitudBO solicitudBO = new SolicitudBO(fachadaGobierno, solicitudDAO);
        ITutorBO tutorBO  = new TutorBO();
        IFachadaInicioSesion fachadaInicioSesion = new FachadaInicioSesion( new ControlInicioSesion(estudianteBO));
        IFachadaSolicitarBeca fachadaSolicitarBeca = new FachadaSolicitarBeca(new ControlSolicitarBeca(solicitudBO,
                estudianteBO, tutorBO, becasFiltradasBO, documentoBO, historialAcademicoBO, informacionSocioeconomicaBO));

        CoordinadorAplicacion coordinadorAplicacion = new CoordinadorAplicacion(fachadaInicioSesion, fachadaSolicitarBeca);
    }
}
