package com.agenciaturismo2.model;

/**
 * Clase que representa una dirección
 * Posee los atributos: calle y ciudad
 */
public class Direccion {
    private String calle; /** Calle de la dirección */
    private String ciudad; /** Ciudad de la dirección */

    /**
     * Constructor para crear instancias de la clase Direccion
     * @param calle
     * @param ciudad
     */
    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    /**
     * Métodos Getter and Setter para obtener y modificar los atributos
     * @return
     */
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Metodo que retorna objeto Direccion convertido a texto
     * @return
     */
    @Override
    public String toString() {
        return "Dirección: "+calle+", Ciudad: "+ciudad;
    }
}
