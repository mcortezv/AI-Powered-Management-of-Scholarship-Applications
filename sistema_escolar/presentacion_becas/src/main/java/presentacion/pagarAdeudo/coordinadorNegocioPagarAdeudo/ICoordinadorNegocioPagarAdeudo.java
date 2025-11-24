package presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo;

import dto.EstudianteDTO;

public interface ICoordinadorNegocioPagarAdeudo {
    double obtenerAdeudoBiblioteca(EstudianteDTO estudianteDTO);
}
