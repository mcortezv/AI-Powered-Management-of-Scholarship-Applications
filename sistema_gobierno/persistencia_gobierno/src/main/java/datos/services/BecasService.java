/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.services;
import datos.repository.dao.BecaDAO;
import datos.repository.dao.excepciones.SolicitudDAOException;
import gobierno.RequisitosDTOGobierno;
import solicitarBeca.dominio.BecasFiltradas;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class BecasService {
    private final BecaDAO becaDAO;

    public BecasService() {
        this.becaDAO = new BecaDAO();
    }

    public BecasFiltradas obtenerBecas(RequisitosDTOGobierno requisitos) throws SolicitudDAOException {
        return becaDAO.findByRequisitos(requisitos);
    }
}
