/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosGobierno.servicesGobierno;
import datosGobierno.adaptadoresGobierno.BecaAdaptador;
import datosGobierno.repositoryGobierno.daoGobierno.BecaDAO;
import datosGobierno.repositoryGobierno.daoGobierno.excepcionesGobierno.SolicitudDAOException;
import datosGobierno.repositoryGobierno.documents.BecaDocument;
import gobierno.RequisitosDTOGobierno;
import solicitarBeca.dominio.Beca;
import solicitarBeca.dominio.BecasFiltradas;

import java.util.ArrayList;
import java.util.List;

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
        List<BecaDocument> becasDocuments = becaDAO.findByRequisitos(requisitos);
        List<Beca> becas = new ArrayList<>();
        for (BecaDocument becaDocument : becasDocuments) {
            becas.add(BecaAdaptador.toEntity(becaDocument));
        }
        return new BecasFiltradas(becas);
    }
}
