package presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo;

import dto.EstudianteDTO;

public interface ICoordinadorAplicacionPagarAdeudo {
    void seleccionarAdeudoBiblioteca(EstudianteDTO estudianteDTO);
    void seleccionarAdeudoColegiatura(EstudianteDTO estudianteDTO);
    void verDetalle();
    void seleccionarRealizarPago();
    void seleccionarMetodoPago(String metodoPago) throws Exception;

}
