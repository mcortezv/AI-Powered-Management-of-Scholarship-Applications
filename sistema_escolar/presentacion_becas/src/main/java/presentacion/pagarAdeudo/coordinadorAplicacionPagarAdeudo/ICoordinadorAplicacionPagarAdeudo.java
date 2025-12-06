package presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo;

import dtoGobierno.EstudianteDTO;

public interface ICoordinadorAplicacionPagarAdeudo {
    void seleccionarAdeudoBiblioteca(EstudianteDTO estudianteDTO);
    void seleccionarAdeudoColegiatura(EstudianteDTO estudianteDTO);
    void seleccionarRealizarPago();
    void seleccionarMetodoPago(String metodoPago) throws Exception;
}
