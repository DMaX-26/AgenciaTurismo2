package com.agenciaturismo2.model;

/**
 * Subclase que representa a un Vehículo
 * Hereda atributos y metodos de la superclase "RecursoAgencia"
 * Contiene atributos propios: patente y tipoVehiculo
 * Implementa la interfaz "Registrable"
 */
public class Vehiculo extends RecursoAgencia implements Registrable {
    private String patente;
    private String tipoVehiculo;

    /**
     * Constructor para crear objetos e inicializar atributos heredados y propios
     * Se le pasan los parámetros:
     * @param id
     * @param disponibilidad
     * @param patente
     * @param tipoVehiculo
     */
    public Vehiculo(int id, boolean disponibilidad, String patente, String tipoVehiculo) {
        /**
         * Llama al constructor de la clase padre para inicializar id y disponibilidad en el objeto "Vehículo"
         */
        super(id, disponibilidad);
        /**
         * Se inicializan los atributos propios
         */
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPatente() {
        return patente;
    }
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    @Override
    public String toString() {
        return super.toString()+", Patente: "+patente+", Tipo de vehículo: "+tipoVehiculo;
    }

    /**
     * Se implementa de forma personalizada el metodo mostrarResumen correspondiente a la interfaz "Registrable"
     */
    @Override
    public void mostrarResumen() {
        System.out.println();
        System.out.println("<<<Vehículo>>>");
        super.mostrarResumen();
        System.out.println("Patente: "+patente);
        System.out.println("Tipo de vehículo: "+tipoVehiculo);
    }
}
