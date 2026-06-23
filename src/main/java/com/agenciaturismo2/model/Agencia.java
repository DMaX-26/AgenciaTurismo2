package com.agenciaturismo2.model;

import com.agenciaturismo2.exception.EdadInvalidaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clase principal que representa una agencia
 * Posee atributo: nombre
 * Agencia tiene un/a direccion, proveedorAlojamiento, proveedorTransporte
 * Agencia tiene varios clientes
 */
public class Agencia {
    private String nombreAgencia; /** Nombre de la agencia */
    private Direccion direccion; /** Dirección de la agencia */
    private ProveedorAlojamiento proveedorAlojamiento; /** Proveedor de alojamiento de la agencia */
    private ProveedorTransporte proveedorTransporte; /** Proveedor de transporte de la agencia */
    private List<Cliente> clientes; /** Clientes de la agencia */
    private HashMap<String, List<Cliente>> busqueda;/** Hashmap para filtrar datos*/

    /**
     * Constructor para crear instancias de la clase Agencia
     * @param nombreAgencia
     * @param direccion
     * @param proveedorAlojamiento
     * @param proveedorTransporte
     */
    public Agencia(String nombreAgencia, Direccion direccion, ProveedorAlojamiento proveedorAlojamiento, ProveedorTransporte proveedorTransporte) {
        this.nombreAgencia = nombreAgencia;
        this.direccion = direccion;
        this.proveedorAlojamiento = proveedorAlojamiento;
        this.proveedorTransporte = proveedorTransporte;
        this.clientes = new ArrayList<>();
        this.busqueda = new HashMap<>();
    }

    /**
     * Métodos Getter and Setter para obtener y modificar los atributos
     * @return
     */
    public String getNombreAgencia() {
        return nombreAgencia;
    }
    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public ProveedorAlojamiento getProveedorAlojamiento() {
        return proveedorAlojamiento;
    }
    public void setProveedorAlojamiento(ProveedorAlojamiento proveedorAlojamiento) {
        this.proveedorAlojamiento = proveedorAlojamiento;
    }

    public ProveedorTransporte getProveedorTransporte() {
        return proveedorTransporte;
    }
    public void setProveedorTransporte(ProveedorTransporte proveedorTransporte) {
        this.proveedorTransporte = proveedorTransporte;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public HashMap<String, List<Cliente>> getBusqueda() {
        return busqueda;
    }

    /**
     * Metodo que agrega Cliente a la lista clientes
     * Y agrega Cliente al HashMap
     * Puede lanzar una excepción
     * @param cliente
     */
    public void agregarClientes(Cliente cliente) throws EdadInvalidaException {
        if (cliente.getEdad()<=0){
            throw new EdadInvalidaException("La edad ingresada no es válida");
        }
        clientes.add(cliente);

        /**
         * Si la nacionalidad obtenida de cliente no existe en el hashmap
         */
        if (!busqueda.containsKey(cliente.getNacionalidad())){
            /**
             * Al hashmap se añade la nacionalidad como clave y una lista vacia como valor para esa nacionalidad
             */
            busqueda.put(cliente.getNacionalidad(), new ArrayList<>());
        }
        /**
         * Se obtiene la nacionalidad como clave
         * Se añade cliente a la lista asociada a esa nacionalidad
         */
        busqueda.get(cliente.getNacionalidad()).add(cliente);
    }

    /**
     * Metodo que imprime la nacionalidad obtenida (clave) y el cliente asociado (valor) dentro del hashmap
     * @param nacionalidad
     */
    public void buscarPorNacionalidad(String nacionalidad){
        System.out.println("Filtrar por nacionalidad: "+nacionalidad);
        System.out.println(busqueda.get(nacionalidad));
    }

    /**
     * Metodo que muestra la lista con todos los clientes
     */
    public void mostrarClientes(){
        System.out.println("Clientes:");
        for (Cliente c : clientes){
            System.out.println(c);
        }
    }

    /**
     * Metodo que muestra el ProveedorAlojamiento
     */
    public void mostrarProveedorAlojamiento(){
        System.out.println(proveedorAlojamiento);
    }

    /**
     * Metodo que muestra el ProveedorTransporte
     */
    public void mostrarProveedorTransporte(){
        System.out.println(proveedorTransporte);
    }

    /**
     * Metodo que muestra nombre y direccion de la agencia en formato textual
     * @return
     */
    @Override
    public String toString() {
        return "Agencia: "+nombreAgencia+", "+direccion;
    }
}
