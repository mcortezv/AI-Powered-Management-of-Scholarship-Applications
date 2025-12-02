package datos.repositoryItson.daoItson.pagarAdeudo;

import datos.dominioItson.pagarAdeudo.Clase;

import java.util.List;
import java.util.Optional;

public interface IClaseDAO {
    Optional<List<Clase>> obtenerListaClasesByMatricula(Long matricula);
}
