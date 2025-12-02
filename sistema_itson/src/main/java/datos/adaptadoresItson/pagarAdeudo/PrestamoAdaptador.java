package datos.adaptadoresItson.pagarAdeudo;

import datos.dominioItson.pagarAdeudo.Prestamo;
import datos.repositoryItson.documents.pagarAdeudo.PrestamoDocument;

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
}
