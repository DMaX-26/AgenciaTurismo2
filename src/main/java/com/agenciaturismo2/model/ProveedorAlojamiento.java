package com.agenciaturismo2.model;

/**
 * Clase que representa a un proveedor de alojamiento
 * Posee los atributos: nombreHotel, correo, numeroTelefonico, precioPorNoche
 * ProveedorAlojamiento tiene una Direccion
 */
public class ProveedorAlojamiento {
    private String nombre; /** Nombre del hotel perteneciente al proveedor de alojamiento */
    private String correo; /** Correo del proveedor de alojamiento */
    private String numeroTelefonico; /** Número telefónico del proveedor de alojamiento */
    private double precioPorNoche; /** Precio por noche del proveedor de alojamiento */
    private Direccion direccion; /** Direccion del proveedor de alojamiento */

    /**
     * Constructor para crear instancias de la clase ProveedorAlojamiento
     * @param nombre
     * @param correo
     * @param numeroTelefonico
     * @param precioPorNoche
     * @param direccion
     */
    public ProveedorAlojamiento(String nombre, String correo, String numeroTelefonico, double precioPorNoche, Direccion direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.numeroTelefonico = numeroTelefonico;
        this.precioPorNoche = precioPorNoche;
        this.direccion = direccion;
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

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }
    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo que retorna objeto ProveedorAlojamiento convertido a texto
     * Concatena el objeto Direccion
     * @return
     */
    @Override
    public String toString() {
        return "Proveedor Alojamiento: "+nombre+", Correo: "+correo+", Número telefónico: "+numeroTelefonico+
                ", Precio por noche: "+precioPorNoche+", "+direccion;
    }
}
