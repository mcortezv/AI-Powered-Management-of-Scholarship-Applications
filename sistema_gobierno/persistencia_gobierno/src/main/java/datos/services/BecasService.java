/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.services;
import datos.dao.BecaDAO;
import datos.dao.excepciones.SolicitudDAOException;
import dto.gobierno.BecasDisponiblesDTOGobierno;
import dto.gobierno.RequisitosDTOGobierno;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class BecasService {
    private final BecaDAO becaDAO;

    public BecasService() {
        this.becaDAO = new BecaDAO();
    }

    public BecasDisponiblesDTOGobierno obtenerBecas(RequisitosDTOGobierno requisitos) throws SolicitudDAOException {
        return becaDAO.obtenerBecas(requisitos);
    }
}
