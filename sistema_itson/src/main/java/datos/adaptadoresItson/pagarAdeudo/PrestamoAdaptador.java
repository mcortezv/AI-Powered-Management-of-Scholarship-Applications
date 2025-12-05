package datos.adaptadoresItson.pagarAdeudo;

import banco.PrestamoDTOI;
import datos.dominioItson.pagarAdeudo.Prestamo;
import datos.repositoryItson.documents.pagarAdeudo.PrestamoDocument;
import itson.pagarAdeudo.PrestamoDTOItson;

import java.util.ArrayList;
import java.util.List;

public class PrestamoAdaptador {

    public static Prestamo toEntity(PrestamoDocument document){
        Prestamo prestamo = new Prestamo();
        prestamo.setFechaPrestamo(document.getFechaPrestamo());
        prestamo.setFechaDevolucionProgramada(document.getFechaDevolucionProgramada());
        prestamo.setIsbn(document.getIsbn());
        prestamo.setTitulo(document.getTitulo());
        prestamo.setCampus(document.getCampus());
        prestamo.setDetalles(document.getDetalles());
        return prestamo;
    }
    public static PrestamoDTOI toDtoItson(Prestamo prestamo){
        PrestamoDTOI dto = new PrestamoDTOI();
        dto.setFechaPrestamo(prestamo.getFechaPrestamo().toString());
        dto.setFechaDevolucion(prestamo.getFechaDevolucionProgramada().toString());
        dto.setIsbn(prestamo.getIsbn());
        dto.setTitulo(prestamo.getTitulo());
        dto.setCampus(prestamo.getCampus());
        dto.setDetalles(prestamo.getDetalles());
        return dto;
    }

    public static List<PrestamoDTOI> toDtoItson(List<Prestamo> prestamos){
        List<PrestamoDTOI> lista = new ArrayList<>();
        for (Prestamo p : prestamos) {
            lista.add(toDtoItson(p));
        }
        return lista;
    }
}
