/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tutorias.dao.interfaces;

import java.time.LocalDate;
import java.util.List;
import org.bson.types.ObjectId;
import tutorias.excepciones.CitaDAOException;
import tutorias.repository.documents.CitaDocument;

/**
 *
 * @author katia
 */
public interface ICitaDAO {
    ObjectId create(CitaDocument entity) throws CitaDAOException;

    List<CitaDocument> obtenerHistorialPorFecha(Long matriculaAlumno, LocalDate fecha)
            throws CitaDAOException;

    List<CitaDocument> obtenerHistorialPorMateria(Long matriculaAlumno, Long idMateria)
            throws CitaDAOException;

    List<CitaDocument> obtenerHistorialPorFechaYMateria(Long matriculaAlumno, LocalDate fecha, Long idMateria)
            throws CitaDAOException;

    List<CitaDocument> obtenerHistorialCompletoAlumno(Long matriculaAlumno)
            throws CitaDAOException;

    List<CitaDocument> obtenerFuturasPorAlumno(Long matriculaAlumno)
            throws CitaDAOException;
}
