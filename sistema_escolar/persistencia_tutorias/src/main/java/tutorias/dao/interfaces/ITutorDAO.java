/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tutorias.dao.interfaces;

import java.util.List;
import tutorias.excepciones.TutorDAOException;
import tutorias.repository.documents.TutorDocument;

/**
 *
 * @author katia
 */
public interface ITutorDAO {
    List<TutorDocument> obtenerTutores() throws TutorDAOException;
    TutorDocument obtenerPorId(Long idTutor) throws TutorDAOException;
}
