/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tutorias.dao.interfaces;

import java.time.LocalDate;
import java.util.List;
import org.bson.types.ObjectId;
import tutorias.dominio.Cita;
import tutorias.dominio.enums.EstadoCita;
import tutorias.excepciones.CitaDAOException;
import tutorias.repository.documents.CitaDocument;

/**
 *
 * @author katia
 */
public interface ICitaDAO {
    Cita crear(Cita cita) throws CitaDAOException;
    List<Cita> obtenerHistorialCompletoAlumno(Long matriculaAlumno) throws CitaDAOException;
    List<Cita> obtenerHistorialPorFecha(Long matriculaAlumno, LocalDate fecha) throws CitaDAOException;
    List<Cita> obtenerHistorialPorMateria(Long matriculaAlumno, Long idMateria) throws CitaDAOException;
    List<Cita> obtenerHistorialPorFechaYMateria(Long matriculaAlumno, LocalDate fecha, Long idMateria) throws CitaDAOException;
    List<Cita> obtenerFuturasPorAlumno(Long matriculaAlumno) throws CitaDAOException;
    int contarCitasPorAlumnoYEstadoEnMes(Long matriculaAlumno, EstadoCita estado, int mes, int anio) throws CitaDAOException;
    Cita actualizarEstado(Long idCita, EstadoCita nuevoEstado) throws CitaDAOException;
    List<Cita> obtenerPorTutorYFecha(Long idTutor, LocalDate fecha) throws CitaDAOException;
}
