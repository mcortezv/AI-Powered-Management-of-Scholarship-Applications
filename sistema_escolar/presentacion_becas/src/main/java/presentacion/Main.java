package presentacion;
import control.ControlGobierno;
import controles.*;
import fachadas.*;
import interfaces.pagarAdeudo.IAdeudoBO;
import interfaces.solicitarBeca.*;
import objetosNegocio.pagarAdeudo.AdeudoBO;
import objetosNegocio.solicitarBeca.*;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import fachada.FachadaGobierno;
import interfaces.*;
import interfaces.actividades.IActividadBO;
import itson.org.repository.IActividadDAO;
import itson.org.repository.impl.ActividadDAO;
import objetosNegocio.actividades.ActividadBO;
import presentacion.actividadesExtracurriculares.coordinador.CoordinadorAplicacionActividades;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import solicitarBeca.repository.IDocumentoDAO;
import solicitarBeca.repository.IEstudianteDAO;
import solicitarBeca.repository.ISolicitudDAO;
import solicitarBeca.repository.dao.DocumentoDAO;
import solicitarBeca.repository.dao.EstudianteDAO;
import solicitarBeca.repository.dao.SolicitudDAO;

/**
 *
 * @author Cortez, Manuel;
 */
public class Main {

    public static void main(String[] args) {

        // Controles unicos para mantenerl el singleton
        ControlItson controlItson = new ControlItson();
        ControlGobierno controlGobierno = new ControlGobierno();
        ControlBanco controlBanco = new ControlBanco();
        ControlPayPal controlPayPal = new ControlPayPal();
        
       

        //  Caso pagar Adeudo
        IAdeudoBO adeudoBO = new AdeudoBO();
        


        // creacion de fachadas
      
        IFachadaBanco fachadaBanco = new FachadaBanco(controlBanco);
        IFachadaPayPal fachadaPayPal = new FachadaPayPal(controlPayPal);
        IFachadaPago fachadaPago = new FachadaPago(new ControlPago(adeudoBO, fachadaBanco, fachadaPayPal));
        IFachadaITSON fachadaITSON = new FachadaItson(controlItson);
        IFachadaGobierno fachadaGobierno = new FachadaGobierno(controlGobierno);
       
        
        //Caso actividades 
      //  IActividadBO actividadBO= new ActividadBO(fachadaITSON, actividadDAO);
       // ControlActividad controlActividad= new ControlActividad(actividadBO);
       
        
        IActividadDAO actividadDAO= new ActividadDAO();
        IActividadBO actividadBO= new ActividadBO(fachadaITSON, actividadDAO);
       ControlActividad controlActividad= new ControlActividad(actividadBO);
        IFachadaActividad fachadaActividad= new FachadaActividad(controlActividad);

        // creacion de daos
        ISolicitudDAO solicitudDAO = new SolicitudDAO();
        IEstudianteDAO estudianteDAO = new EstudianteDAO();
        IDocumentoDAO documentoDAO = new DocumentoDAO();
     //   IActividadDAO actividadDAO= new ActividadDAO();


        // creacion de las bo
        IBecasFiltradasBO becasFiltradasBO = new BecasFiltradasBO(fachadaGobierno);
        IDocumentoBO documentoBO = new DocumentoBO(documentoDAO);
        IEstudianteBO estudianteBO = new EstudianteBO(fachadaITSON, estudianteDAO);
        IHistorialAcademicoBO historialAcademicoBO = new HistorialAcademicoBO(fachadaITSON);
        IInformacionSocioeconomicaBO infoSocioBO = new InformacionSocioeconomicaBO();
        ISolicitudBO solicitudBO = new SolicitudBO(fachadaGobierno, solicitudDAO);
        ITutorBO tutorBO = new TutorBO();
//         IActividadBO actividadBO= new ActividadBO(fachadaITSON, actividadDAO);
         

        IFachadaInicioSesion fachadaInicioSesion = new FachadaInicioSesion(new ControlInicioSesion(estudianteBO));
        IFachadaSolicitarBeca fachadaSolicitarBeca = new FachadaSolicitarBeca(new ControlSolicitarBeca(solicitudBO, estudianteBO, tutorBO, becasFiltradasBO, documentoBO, historialAcademicoBO, infoSocioBO));

        // coordinadores de subsistemas
        CoordinadorAplicacionPagarAdeudo coordAdeudo = new CoordinadorAplicacionPagarAdeudo(fachadaPago);
        CoordinadorAplicacionActividades coordinadorActividades= new CoordinadorAplicacionActividades(fachadaActividad);

        // Coordinador general
        CoordinadorAplicacion coordinadorAplicacion = new CoordinadorAplicacion(fachadaInicioSesion, fachadaSolicitarBeca, coordAdeudo, coordinadorActividades);

        // iniciar la interfaz
        coordinadorAplicacion.iniciarGUI();
    }
}
