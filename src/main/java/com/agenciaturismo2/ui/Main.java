package com.agenciaturismo2.ui;

import com.agenciaturismo2.data.GestorDatos;
import com.agenciaturismo2.data.GestorServicios;
import com.agenciaturismo2.exception.EdadInvalidaException;
import com.agenciaturismo2.model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Try-catch para manejo de excepciones
        try {
            GestorDatos gestorDatos = new GestorDatos("src/main/resources/registros.xlsx");

            //GestorDatos llama al metodo cargarClientes. Los datos se guardan en la variable "clientes"
            List<Cliente> clientes = gestorDatos.cargarClientes();

            //gestorDatos llama al metodo cargarAgencia. Los datos se guardan en la variable "agencia"
            Agencia agencia = gestorDatos.cargarAgencia();

            //Se imprime agencia
            System.out.println(agencia);

            //agencia llama al metodo "mostrarProveedorAlojamiento"
            agencia.mostrarProveedorAlojamiento();
            //agencia llama al metodo "mostrarProveedorTransporte"
            agencia.mostrarProveedorTransporte();

            //Se recorre la lista clientes
            for (Cliente c : clientes){
                agencia.agregarClientes(c);//Mediante el metodo "agregarClientes", cada elemento del recorrido se agrega a "agencia"
            }

            //agencia llama al metodo "mostrarClientes"
            agencia.mostrarClientes();

            //agencia llama al metodo buscarPorNacionalidad que filtra los datos por nacionalidad Rusa
            agencia.buscarPorNacionalidad("Rusa");

            //Se crea una instancia de GestorServicios
            GestorServicios gestorServicios = new GestorServicios();

            //GestorServicios llama al metodo crearServicios. Los datos se guardan en la variable "st"
            List<ServicioTuristico> st = gestorServicios.crearServicios();

            //gestorServicios llama al metodo "mostrarServicios" y le pasa "st" con todos los servicios creados
            gestorServicios.mostrarServicios(st);

        } catch (EdadInvalidaException e) {
            System.out.println("Error! "+e.getMessage());
        }  catch (Exception e) {
            System.out.println("Error al cargar archivo");
            e.printStackTrace();
        }
    }
}