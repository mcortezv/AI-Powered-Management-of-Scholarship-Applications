/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorias.seeder;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import tutorias.dao.CitaDAO;
import tutorias.dao.HorarioDAO;
import tutorias.dao.MateriaDAO;
import tutorias.dao.TutorDAO;
import tutorias.dominio.Cita;
import tutorias.dominio.Horario;
import tutorias.dominio.Materia;
import tutorias.dominio.Tutor;
import tutorias.dominio.enums.EstadoCita;
import tutorias.dominio.enums.EstadoDisponibilidad;
import tutorias.dominio.enums.Modalidad;
import tutorias.excepciones.CitaDAOException;
import tutorias.excepciones.HorarioDAOException;
import tutorias.excepciones.MateriaDAOException;
import tutorias.excepciones.TutorDAOException;
import tutorias.repository.documents.CitaDocument;
import tutorias.repository.documents.HorarioDocument;
import tutorias.repository.documents.MateriaDocument;
import tutorias.repository.documents.TutorDocument;

/**
 *
 * @author katia
 */
public class Seeder {
    public static void main(String[] args) {
//        MateriaDAO materiaDAO = new MateriaDAO();
//        TutorDAO tutorDAO = new TutorDAO();
//        HorarioDAO horarioDAO = new HorarioDAO();
//        CitaDAO citaDAO = new CitaDAO();
//        
//        try {
//            
//            Materia matProg = new Materia();
//            matProg.setId(1L);
//            matProg.setNombre("Programación I");
//            materiaDAO.crear(matProg);
//
//            Materia matCalc = new Materia();
//            matCalc.setId(2L);
//            matCalc.setNombre("Cálculo Diferencial");
//            materiaDAO.crear(matCalc);
//
//            Materia matBd = new Materia();
//            matBd.setId(3L);
//            matBd.setNombre("Bases de Datos");
//            materiaDAO.crear(matBd);
//
//            System.out.println("Materias insertadas.");
//
//            
//            Tutor tutor1 = new Tutor();
//            tutor1.setId(1L);
//            tutor1.setNombre("Karla López");
//            tutor1.setCarrera("Ingeniería en Software");
//            tutor1.setCubiculo("B-201");
//            tutor1.setEnlace("https://meet.google.com/karla");
//            tutorDAO.crear(tutor1);
//
//            Tutor tutor2 = new Tutor();
//            tutor2.setId(2L);
//            tutor2.setNombre("Pedro Escalante");
//            tutor2.setCarrera("Matemáticas");
//            tutor2.setCubiculo("C-305");
//            tutor2.setEnlace("https://meet.google.com/pedro");
//            tutorDAO.crear(tutor2);
//
//            System.out.println("Tutores insertados.");
//
//            
//            LocalDate hoy = LocalDate.now();
//            LocalDate maniana = hoy.plusDays(1);
//            LocalDate pasado = hoy.plusDays(2);
//
//            insertarHorario(horarioDAO, 1L, maniana, LocalTime.of(10, 0), EstadoDisponibilidad.DISPONIBLE);
//            insertarHorario(horarioDAO, 1L, maniana, LocalTime.of(11, 0), EstadoDisponibilidad.DISPONIBLE);
//            insertarHorario(horarioDAO, 1L, maniana, LocalTime.of(12, 0), EstadoDisponibilidad.OCUPADO);
//
//            insertarHorario(horarioDAO, 2L, pasado, LocalTime.of(9, 0), EstadoDisponibilidad.DISPONIBLE);
//            insertarHorario(horarioDAO, 2L, pasado, LocalTime.of(10, 0), EstadoDisponibilidad.DISPONIBLE);
//
//            System.out.println("Horarios insertados.");
//
//       
//            Long matriculaEjemplo = 258835L;
//
//            Cita citaPasada = new Cita();
//            citaPasada.setId(1001L);
//            citaPasada.setMatriculaAlumno(matriculaEjemplo);
//            citaPasada.setIdTutor(1L);
//            Materia materiaProg = new Materia();
//            materiaProg.setId(1L);
//            citaPasada.setMateria(materiaProg);
//            citaPasada.setTema("Repaso de arreglos");
//            citaPasada.setModalidad(Modalidad.PRESENCIAL);
//            citaPasada.setFecha(hoy.minusDays(5));
//            citaPasada.setHora(LocalTime.of(10, 0));
//            citaPasada.setUbicacion("B-201");
//            citaPasada.setEstado(EstadoCita.ATENDIDA);
//            citaDAO.crear(citaPasada);
//
//            Cita citaCancelada1 = new Cita();
//            citaCancelada1.setId(1002L);
//            citaCancelada1.setMatriculaAlumno(matriculaEjemplo);
//            citaCancelada1.setIdTutor(1L);
//            Materia materiaCalc = new Materia();
//            materiaCalc.setId(2L);
//            citaCancelada1.setMateria(materiaCalc);
//            citaCancelada1.setTema("Derivadas básicas");
//            citaCancelada1.setModalidad(Modalidad.VIRTUAL);
//            citaCancelada1.setFecha(hoy.minusDays(3));
//            citaCancelada1.setHora(LocalTime.of(11, 0));
//            citaCancelada1.setUbicacion("https://meet.google.com/karla");
//            citaCancelada1.setEstado(EstadoCita.CANCELADA);
//            citaDAO.crear(citaCancelada1);
//
//            Cita citaCancelada2 = new Cita();
//            citaCancelada2.setId(1003L);
//            citaCancelada2.setMatriculaAlumno(matriculaEjemplo);
//            citaCancelada2.setIdTutor(2L);
//            Materia materiaBD = new Materia();
//            materiaBD.setId(3L);
//            citaCancelada2.setMateria(materiaBD);
//            citaCancelada2.setTema("Normalización");
//            citaCancelada2.setModalidad(Modalidad.PRESENCIAL);
//            citaCancelada2.setFecha(hoy.minusDays(1));
//            citaCancelada2.setHora(LocalTime.of(9, 0));
//            citaCancelada2.setUbicacion("C-305");
//            citaCancelada2.setEstado(EstadoCita.CANCELADA);
//            citaDAO.crear(citaCancelada2);
//
//            Cita citaFutura = new Cita();
//            citaFutura.setId(1004L);
//            citaFutura.setMatriculaAlumno(matriculaEjemplo);
//            citaFutura.setIdTutor(1L);
//            Materia materiaProg2 = new Materia();
//            materiaProg2.setId(1L);
//            citaFutura.setMateria(materiaProg2);
//            citaFutura.setTema("Listas enlazadas");
//            citaFutura.setModalidad(Modalidad.VIRTUAL);
//            citaFutura.setFecha(maniana);
//            citaFutura.setHora(LocalTime.of(10, 0));
//            citaFutura.setUbicacion("https://meet.google.com/karla");
//            citaFutura.setEstado(EstadoCita.PENDIENTE);
//            citaDAO.crear(citaFutura);
//
//            System.out.println("Citas insertadas.");
//
//            System.out.println("SeederTutorias finalizado correctamente.");
//        } catch (MateriaDAOException | TutorDAOException | HorarioDAOException | CitaDAOException ex) {
//            System.err.println("Error al cargar datos de tutorías: " + ex.getMessage());
//        } catch (Exception ex) {
//            System.err.println("Error inesperado en SeederTutorias: " + ex.getMessage());
//        }
//    }
//
//    
//    private static void insertarHorario(HorarioDAO horarioDAO,
//                                    Long idTutor,
//                                    LocalDate fecha,
//                                    LocalTime hora,
//                                    EstadoDisponibilidad estado){
//        Horario h = new Horario();
//        h.setIdTutor(idTutor);
//        h.setFecha(fecha);
//        h.setHora(hora);
//        h.setEstadoDisponibilidad(estado);
//        horarioDAO.crear(h);
//    }
//
//    private static long contadorHorario = 1L;
//
//    private static synchronized Long generarIdHorario(){
//        return contadorHorario++;
    }
    
}
