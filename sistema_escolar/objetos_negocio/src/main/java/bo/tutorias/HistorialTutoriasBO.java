/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.tutorias;

import adaptadores.tutorias.CitaAdaptador;
import bo.tutorias.excepciones.HistorialTutoriasException;
import dto.tutorias.CitaDTO;
import interfaces.tutorias.IHistorialTutoriasBO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tutorias.dao.interfaces.ICitaDAO;
import tutorias.dominio.Cita;
import tutorias.repository.documents.CitaDocument;

/**
 *
 * @author katia
 */
public class HistorialTutoriasBO implements IHistorialTutoriasBO{
    private final ICitaDAO citaDAO;

    public HistorialTutoriasBO(ICitaDAO citaDAO) {
        this.citaDAO = citaDAO;
    }

    @Override
    public List<CitaDTO> obtenerHistorialCompletoAlumno(Long matriculaAlumno)
            throws HistorialTutoriasException {
        try {
            List<CitaDocument> documentos =
                    citaDAO.obtenerHistorialCompletoAlumno(matriculaAlumno);

            return convertirListaDocumentADTO(documentos);
        } catch (Exception ex) {
            throw new HistorialTutoriasException("Error al obtener el historial completo del alumno");
        }
    }

    @Override
    public List<CitaDTO> obtenerHistorialPorFecha(Long matriculaAlumno, LocalDate fecha)
            throws HistorialTutoriasException {
        if (fecha == null) {
            throw new HistorialTutoriasException("La fecha no puede ser nula");
        }

        try {
            List<CitaDocument> documentos =
                    citaDAO.obtenerHistorialPorFecha(matriculaAlumno, fecha);

            return convertirListaDocumentADTO(documentos);
        } catch (Exception ex) {
            throw new HistorialTutoriasException("Error al obtener el historial por fecha");
        }
    }

    @Override
    public List<CitaDTO> obtenerHistorialPorMateria(Long matriculaAlumno, Long idMateria)
            throws HistorialTutoriasException {
        if (idMateria == null) {
            throw new HistorialTutoriasException("La materia no puede ser nula");
        }

        try {
            List<CitaDocument> documentos =
                    citaDAO.obtenerHistorialPorMateria(matriculaAlumno, idMateria);

            return convertirListaDocumentADTO(documentos);
        } catch (Exception ex) {
            throw new HistorialTutoriasException("Error al obtener el historial por materia");
        }
    }

    @Override
    public List<CitaDTO> obtenerHistorialPorFechaYMateria(
            Long matriculaAlumno,
            LocalDate fecha,
            Long idMateria) throws HistorialTutoriasException {

        if (fecha == null || idMateria == null) {
            throw new HistorialTutoriasException("La fecha y la materia no pueden ser nulas");
        }

        try {
            List<CitaDocument> documentos =
                    citaDAO.obtenerHistorialPorFechaYMateria(matriculaAlumno, fecha, idMateria);
            return convertirListaDocumentADTO(documentos);
        } catch (Exception ex) {
            throw new HistorialTutoriasException("Error al obtener el historial por fecha y materia");
        }
    }

    private List<CitaDTO> convertirListaDocumentADTO(List<CitaDocument> documentos) {
        List<CitaDTO> resultado = new ArrayList<>();
        if (documentos == null || documentos.isEmpty()) {
            return resultado;
        }
        for (CitaDocument doc : documentos) {
            Cita cita = CitaAdaptador.toEntity(doc);
            CitaDTO dto = CitaAdaptador.toDTO(cita);
            resultado.add(dto);
        }
        return resultado;
    }
}
