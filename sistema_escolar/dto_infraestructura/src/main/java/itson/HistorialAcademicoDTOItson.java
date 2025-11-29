package itson;

/**
 * @author Escalante, Sebastian.
 */
public class HistorialAcademicoDTOItson {
    private String carrera;
    private double promedio;
    private double porcentajeBajas;
    private double cargaAcademica;
    private int semestre;
    private double indiceReprobacion;

    public HistorialAcademicoDTOItson() {
    }

    public HistorialAcademicoDTOItson(String carrera, double promedio, double porcentajeBajas, double cargaAcademica, int semestre, double indiceReprobacion) {
        this.carrera = carrera;
        this.promedio = promedio;
        this.porcentajeBajas = porcentajeBajas;
        this.cargaAcademica = cargaAcademica;
        this.semestre = semestre;
        this.indiceReprobacion = indiceReprobacion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getPorcentajeBajas() {
        return porcentajeBajas;
    }

    public void setPorcentajeBajas(double porcentajeBajas) {
        this.porcentajeBajas = porcentajeBajas;
    }

    public double getCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(double cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getIndiceReprobacion() {
        return indiceReprobacion;
    }

    public void setIndiceReprobacion(double indiceReprobacion) {
        this.indiceReprobacion = indiceReprobacion;
    }
}
