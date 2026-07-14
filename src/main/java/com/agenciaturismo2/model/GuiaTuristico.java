package com.agenciaturismo2.model;

/**
 * Clase que representa a un guía turístico
 * Hereda atributos y métodos de la superclase "RecursoAgencia"
 * Contiene atributos propios: nombre, edad e idiomas.
 */
public class GuiaTuristico extends RecursoAgencia implements Registrable {
    private String nombre;/** Nombre del guía turístico */
    private int edad; /** Edad del guía turístico en años */
    private String idiomas; /** Idiomas que maneja el guía turístico */

    /**
     * Constructor para crear instancias de la clase GuiaTuristico
     * @param id
     * @param disponibilidad
     * @param nombre
     * @param edad
     * @param idiomas
     */
    public GuiaTuristico(int id, boolean disponibilidad, String nombre, int edad, String idiomas) {
        /**
         * Llama al constructor de la clase padre para inicializar id y disponibilidad en el objeto "GuiaTuristico"
         */
        super(id, disponibilidad);
        /**
         * Se inicializan los atributos propios
         */
        this.nombre = nombre;
        this.edad = edad;
        this.idiomas = idiomas;
    }

    /**
     * Métodos Getter and Setter para obtener y modificar los atributos
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getIdiomas() {
        return idiomas;
    }

    /**
     * Metodo que retorna objeto GuiaTuristico convertido a texto
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+", Nombre del Guía: "+nombre+", Edad: "+edad+", Idiomas: "+idiomas;
    }

    /**
     * Se implementa de forma personalizada el metodo mostrarResumen correspondiente a la interfaz "Registrable"
     */
    @Override
    public void mostrarResumen() {
        System.out.println();
        System.out.println("---Guía turístico---");
        super.mostrarResumen();
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: "+edad);
        System.out.println("Idiomas: "+idiomas);
    }
}
