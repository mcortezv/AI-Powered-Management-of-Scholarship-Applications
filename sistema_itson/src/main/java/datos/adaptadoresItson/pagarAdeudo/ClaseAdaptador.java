package datos.adaptadoresItson.pagarAdeudo;

import datos.dominioItson.pagarAdeudo.Clase;
import datos.repositoryItson.documents.pagarAdeudo.ClaseDocument;

public class ClaseAdaptador {

    public static Clase toEntity(ClaseDocument document){
        Clase clase = new Clase();
        clase.setNombre(document.getNombre());
        clase.setHorario(document.getHorario());
        clase.setProfesor(clase.getProfesor());
        clase.setAula(clase.getAula());
        clase.setAula(String.valueOf(document.getCampus()));
        clase.setDetalles(document.getDetalles());
        return clase;
    }
}
