package com.agenciaturismo2.model;

/**
 * Clase padre que representa a un servicio turístico
 */
public class ServicioTuristico {
    private String nombre;
    private double duracionHoras;

    /**
     * Constructor para crear objetos e inicializar sus atributos
     * @param nombre
     * @param duracionHoras
     */
    public ServicioTuristico(String nombre, double duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracionHoras() {
        return duracionHoras;
    }
    public void setDuracionHoras(double duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Metodo que muestra la información de un Servicio turístico
     */
    public void mostrarInformacion(){
        System.out.println("Servicio Turístico: "+nombre);
        System.out.println("Duración en horas: "+duracionHoras);
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+", Duración en Horas: "+duracionHoras;
    }
}
