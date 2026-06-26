package com.agenciaturismo2.model;

/**
 * Subclase que representa a una Ruta gastronómica
 * Hereda atributos y métodos de la clase padre "ServicioTuristico"
 * Posee un atributo propio: numeroDeParadas
 */
public class RutaGastronomica extends ServicioTuristico{
    private int numeroDeParadas;

    /**
     * Constructor para crear objetos e inicializar atributos heredados y propios
     * @param nombre
     * @param duracionHoras
     */
    public RutaGastronomica(String nombre, double duracionHoras, int numeroDeParadas) {
        /**
         * Llama al constructor de la clase padre para inicializar nombre y duracionHoras en el objeto "RutaGastronomica"
         */
        super(nombre, duracionHoras);
        /**
         * Se inicializa el atributo propio
         */
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    /**
     * Metodo que sobrescribe toString de la clase padre y agrega el atributo propio "numeroDeParadas"
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+", Número de paradas: "+numeroDeParadas;
    }
}
