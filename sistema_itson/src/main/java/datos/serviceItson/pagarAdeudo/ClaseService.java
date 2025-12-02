package datos.serviceItson.pagarAdeudo;

import datos.dominioItson.pagarAdeudo.Clase;
import datos.repositoryItson.daoItson.pagarAdeudo.impl.ClaseDAO;

import java.util.List;
import java.util.Optional;

public class ClaseService {
    private final ClaseDAO claseDAO;

    public ClaseService(){
        this.claseDAO = new ClaseDAO();
    }

    public Optional<List<Clase>> solicitarListaClases(Long matricula){
        return claseDAO.obtenerListaClasesByMatricula(matricula);
    }
}
