package com.agenciaturismo2.model;

/**
 * Clase que representa a un guía turístico
 * Posee los atributos: nombre, edad, manejoDeIdiomas
 */
public class GuiaTuristico {
    private String nombreGuia; /** Nombre del guía turístico */
    private int edadGuia; /** Edad del guía turístico en años */
    private String idiomas; /** Idiomas que maneja el guía turístico */

    /**
     * Constructor para crear instancias de la clase GuiaTuristico
     * @param nombreGuia
     * @param edadGuia
     * @param idiomas
     */
    public GuiaTuristico(String nombreGuia, int edadGuia, String idiomas) {
        this.nombreGuia = nombreGuia;
        this.edadGuia = edadGuia;
        this.idiomas = idiomas;
    }

    /**
     * Métodos Getter and Setter para obtener y modificar los atributos
     * @return
     */
    public String getNombreGuia() {
        return nombreGuia;
    }
    public void setNombre(String nombreGuia) {
        this.nombreGuia = nombreGuia;
    }

    public int getEdadGuia() {
        return edadGuia;
    }
    public void setEdad(int edadGuia) {
        this.edadGuia = edadGuia;
    }

    public String getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }


    /**
     * Metodo que retorna objeto GuiaTuristico convertido a texto
     * @return
     */
    @Override
    public String toString() {
        return "\n"+"Guía turístico: "+nombreGuia+", Edad: "+edadGuia+", Idioma/s: " +idiomas+"\n";
    }
}
