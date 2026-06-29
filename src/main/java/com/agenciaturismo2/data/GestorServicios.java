package com.agenciaturismo2.data;

import com.agenciaturismo2.model.ExcursionCultural;
import com.agenciaturismo2.model.PaseoLacustre;
import com.agenciaturismo2.model.RutaGastronomica;
import com.agenciaturismo2.model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Gestor de servicios
 * Posee como atributo una lista de tipo "ServicioTuristico"
 */
public class GestorServicios {
    private List<ServicioTuristico> serviciosTuristicos;

    /**
     * Constructor que inicializa "serviciosTuristicos" con un ArrayList
     */
    public GestorServicios() {
        this.serviciosTuristicos = new ArrayList<>();
    }

    /**
     * Metodo que crea los objetos de tipo List<ServicioTuristico>
     * Cada instancia se agrega a la lista "serviciosTuristicos"
     * Retorna la lista
     * @return
     */
    public List<ServicioTuristico> crearServicios(){
        /**
         * Se crea una lista de "ServicioTuristico". Se instancia con un ArrayList
         */
        List<ServicioTuristico> serviciosTuristicos = new ArrayList<>();

        /**
         * Se crean los objetos de cada subclase y se agregan a la lista "serviciosTuristicos"
         */
        serviciosTuristicos.add(new RutaGastronomica("Ruta del queso", 2, 4));
        serviciosTuristicos.add(new RutaGastronomica("Ruta del vino", 2, 3));
        serviciosTuristicos.add(new PaseoLacustre("Paseo por Puerto Varas", 2, "Lancha"));
        serviciosTuristicos.add(new PaseoLacustre("Navegación por el lago LLanquihue", 2, "Barco"));
        serviciosTuristicos.add(new ExcursionCultural("Ruta histórica de Frutillar", 2, "Museo Colonial Alemán"));
        serviciosTuristicos.add(new ExcursionCultural("Tour Patrimonial de Puerto Varas", 3, "Iglesia del Sagrado Corazón de Jesús"));

        /**
         * Se retorna la lista
         */
        return serviciosTuristicos;
    }

    /**
     * Metodo que recorre la lista serviciosTuristicos y la imprime
     * Se pasa "List<ServicioTuristico>" como parámetro
     * @param serviciosTuristicos
     */
    public void mostrarServicios(List<ServicioTuristico> serviciosTuristicos){
        System.out.println("\nServicios Turísticos:");
        for (ServicioTuristico st : serviciosTuristicos){
            System.out.println(st);
        }
    }

    /**
     * Metodo que convierte el objeto "GestorServicios" a una representación textual
     * @return
     */
    @Override
    public String toString() {
        return "Servicios Turísticos: "+serviciosTuristicos;
    }
}
