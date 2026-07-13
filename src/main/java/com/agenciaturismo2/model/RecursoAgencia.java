package com.agenciaturismo2.model;

/**
 * Superclase abstracta que representa a un recurso de la Agencia
 */
public abstract class RecursoAgencia implements Registrable {
    private int id;
    private boolean disponibilidad;

    /**
     * Constructor
     * @param id
     * @param disponibilidad
     */
    public RecursoAgencia(int id, boolean disponibilidad) {
        this.id = id;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Metodo que convierte el objeto "RecursoAgencia" en texto
     * @return
     */
    @Override
    public String toString() {
        return "id: " +id+", Disponibilidad: "+disponibilidad;
    }

    /**
     * Se implementa de forma personalizada el metodo mostrarResumen correspondiente a la interfaz "Registrable"
     */
    @Override
    public void mostrarResumen() {
        System.out.println("Id: "+id);
        System.out.println("Disponibilidad: "+disponibilidad);
    }
}
