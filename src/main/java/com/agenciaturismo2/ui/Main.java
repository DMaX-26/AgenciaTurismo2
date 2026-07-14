package com.agenciaturismo2.ui;

import com.agenciaturismo2.data.GestorDatos;
import com.agenciaturismo2.data.GestorEntidades;
import com.agenciaturismo2.data.GestorServicios;
import com.agenciaturismo2.exception.EdadInvalidaException;
import com.agenciaturismo2.gui.Interfaz;
import com.agenciaturismo2.model.*;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Creación de la ventana en el EDT para que la GUI funcione correctamente y sin errores
        SwingUtilities.invokeLater(() -> {
            //Se crea una instancia de la clase "Interfaz"
            Interfaz ventana = new Interfaz();
            //Hace visible la ventana
            ventana.setVisible(true);
        });

        //Try-catch para manejo de excepciones
        try {
            //Se crea una instancia de GestorDatos y se le pasa la ruta del archivo
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

            //Se recorre la lista "st" de tipo ServicioTuristico
            for (ServicioTuristico s: st){//Cada elemento del recorrido se guarda en la variable "s"
                s.mostrarInformacion();//"s" llama al metodo y se muestra la información específica de cada clase
            }

            //Se crea una instancia de gestorEntidades para acceder a sus métodos
            GestorEntidades gestorEntidades = new GestorEntidades();

            //gestorEntidades llama al metodo crearEntidades y se guarda dentro de la variable "registros"
            List<Registrable> registros = gestorEntidades.crearEntidades();

            //Se recorre la lista "registros"
            for (Registrable l : registros){
                //Si el recorrido es de tipo "Vehiculo"
                if (l instanceof Vehiculo){
                    Vehiculo v = (Vehiculo) l;//Trata a "l" como un Vehiculo y el contenido de la clase se guarda en la variable "v"
                    v.mostrarResumen();//"v" llama al metodo mostrarResumen específico de la clase Vehículo
                //Por el contrario, si el recorrido es de tipo ColaboradorExterno
                } else if (l instanceof ColaboradorExterno) {
                    ColaboradorExterno c = (ColaboradorExterno) l;//Trata a "l" como un ColaboradorExterno y el contenido se guarda en la variable "c"
                    c.mostrarResumen();//"c" llama al metodo mostrarResumen específico de la clase ColaboradorExterno
                //Por el contrario, si el recorrido es de tipo GuiaTuristico
                } else if (l instanceof GuiaTuristico) {
                    GuiaTuristico g = (GuiaTuristico) l;//Trata a "l" como un GuiaTuristico y guarda el contenido dentro de la variable "g"
                    g.mostrarResumen();//"g" llama al metodo mostrarResumen específico de la clase GuiaTuristico
                }
            }

        } catch (EdadInvalidaException e) {
            System.out.println("Error! "+e.getMessage());
        }  catch (Exception e) {
            System.out.println("Error al cargar archivo");
            e.printStackTrace();
        }
    }
}