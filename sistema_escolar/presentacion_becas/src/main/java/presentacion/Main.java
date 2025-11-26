/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package presentacion;
import control.ControlGobierno;
import controles.*;
import fachadas.*;
import interfaces.pagarAdeudo.IAdeudoBO;
import objetosNegocio.pagarAdeudo.AdeudoBO;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import solicitarBeca.repository.dao.DocumentoDAO;
import solicitarBeca.repository.dao.EstudianteDAO;
import solicitarBeca.repository.dao.SolicitudDAO;
import solicitarBeca.repository.IDocumentoDAO;
import solicitarBeca.repository.IEstudianteDAO;
import solicitarBeca.repository.ISolicitudDAO;
import fachada.FachadaGobierno;
import interfaces.*;
import objetosNegocio.*;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;

/**
 *
 * @author Cortez, Manuel;
 */
public class Main {

    public static void main(String[] args) {

        //pagar adeudo
        IAdeudoBO adeudoBO = new AdeudoBO();
        IFachadaBanco fachadaBanco = new FachadaBanco(new ControlBanco());
        IFachadaPayPal fachadaPayPal = new FachadaPayPal(new ControlPayPal());
        IFachadaPago fachadaPago = new FachadaPago(new ControlPago(adeudoBO,fachadaBanco,fachadaPayPal));
        CoordinadorAplicacionPagarAdeudo coordinadorAplicacionPagarAdeudo = new CoordinadorAplicacionPagarAdeudo(fachadaPago);
        //pagar adeudo

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
        CoordinadorAplicacion coordinadorAplicacion = new CoordinadorAplicacion(fachadaInicioSesion, fachadaSolicitarBeca,coordinadorAplicacionPagarAdeudo);
        coordinadorAplicacion.iniciarGUI();

    }
}
