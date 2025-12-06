/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tutorias.dao.interfaces;

import java.util.List;
import org.bson.types.ObjectId;
import tutorias.dominio.Tutor;
import tutorias.excepciones.TutorDAOException;
import tutorias.repository.documents.TutorDocument;

/**
 *
 * @author katia
 */
public interface ITutorDAO {
    Tutor crear(Tutor tutor) throws TutorDAOException;
    List<Tutor> obtenerTutores() throws TutorDAOException;
    Tutor obtenerPorId(Long idTutor) throws TutorDAOException;
}
