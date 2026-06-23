package com.agenciaturismo2.model;

/**
 * Clase que representa a un proveedor de transporte
 * Posee los atributos: nombre, correo, numeroTelefonico, tipoTransporte
 * ProveedorTransporte tiene una direccion
 */
public class ProveedorTransporte {
    private String nombre; /** Nombre del proveedor de transporte */
    private String correo; /** Correo del proveedor de transporte */
    private String numeroTelefonico; /** Número telefónico del proveedor de transporte */
    private String tipoTransporte; /** Tipo de transporte */
    private Direccion direccion; /** Dirección del proveedor de transporte */

    /**
     * Constructor para crear instancias de la clase ProveedorTransporte
     * @param nombre
     * @param correo
     * @param numeroTelefonico
     * @param tipoTransporte
     * @param direccion
     */
    public ProveedorTransporte(String nombre, String correo, String numeroTelefonico, String tipoTransporte, Direccion direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.numeroTelefonico = numeroTelefonico;
        this.tipoTransporte = tipoTransporte;
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

    public String getTipoTransporte() {
        return tipoTransporte;
    }
    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo que retorna objeto ProveedorTransporte convertido a texto
     * Concatena el objeto Direccion
     * @return
     */
    @Override
    public String toString() {
        return "Proveedor de Transporte: "+nombre+", Correo: "+correo+", Número Telefónico: "+numeroTelefonico+
                ", tipo de Transporte: "+tipoTransporte+", "+direccion+"\n";
    }
}
