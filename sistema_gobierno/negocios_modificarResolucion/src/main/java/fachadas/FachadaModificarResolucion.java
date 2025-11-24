package fachadas;

/**
 *
 * @author Cortez, Manuel;
 */
public class FachadaModificarResolucion {

    buscarResolucion(in nombre:String, in filtro:String): Resolucion

    resolverAtomatico(in solicitud:Solicitud): Resolucion

    resolverManual(in solicitud:Solicitud, in decision:String, in motivo:String): Resolucion

    modificarResolucion(in idResolucion:int, in nuevaResolucion:Resolucion): boolean
}
