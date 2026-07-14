package com.agenciaturismo2.model;

/**
 * Clase que representa a un cliente
 * Posee los atributos: nombre, edad y nacionalidad.
 * Cliente tiene un GuiaTuristico
 */
public class Cliente {
    private String nombre; /** Nombre del cliente */
    private int edad; /** Edad del cliente en años */
    private String correo; /** Correo del cliente */
    private String nacionalidad; /** Nacionalidad del cliente */
    private GuiaTuristico guiaTuristico; /** Guía turístico que se le asigna al cliente */

    /**
     * Constructor para crear instancias de la clase Cliente
     * @param nombre
     * @param edad
     * @param correo
     * @param nacionalidad
     */
    public Cliente(String nombre, int edad, String correo, String nacionalidad, GuiaTuristico guiaTuristico) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
        this.guiaTuristico = guiaTuristico;
    }

    /**
     * Métodos Getter and Setter para obtener y modificar los atributos
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public GuiaTuristico getGuiaTuristico() {
        return guiaTuristico;
    }
    public void setGuiaTuristico(GuiaTuristico guiaTuristico) {
        this.guiaTuristico = guiaTuristico;
    }

    /**
     * Metodo que retorna objeto Cliente convertido a texto
     * Concatena el objeto GuiaTuristico
     * @return
     */
    @Override
    public String toString() {
        return "Nombre cliente: "+nombre+", Edad: "+edad+", Correo: "+correo+", Nacionalidad: " +nacionalidad+" -> "+guiaTuristico;
    }
}
