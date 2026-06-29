package com.agenciaturismo2.model;

/**
 * Subclase que representa a un Paseo lacustre
 * Hereda atributos y metodos de la superclase "ServicioTuristico"
 * Posee un atributo: tipoEmbarcacion
 */
public class PaseoLacustre extends ServicioTuristico{
    private String tipoEmbarcacion;

    /**
     * Constructor para crear objetos e inicializar atributos heredados y propios
     * @param nombre
     * @param duracionHoras
     */
    public PaseoLacustre(String nombre, double duracionHoras, String tipoEmbarcacion) {
        /**
         * Llama al constructor de la clase padre para inicializar nombre y duracionHoras en el objeto "PaseoLacustre"
         */
        super(nombre, duracionHoras);
        /**
         * Se inicializa el atributo propio
         */
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    /**
     * Metodo que sobrescribe toString de la clase padre y agrega el atributo propio "tipoEmbarcacion"
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+", Tipo de embarcación: "+tipoEmbarcacion;
    }
}
