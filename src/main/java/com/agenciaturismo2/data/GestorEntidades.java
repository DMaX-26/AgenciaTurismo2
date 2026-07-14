package com.agenciaturismo2.data;

import com.agenciaturismo2.model.ColaboradorExterno;
import com.agenciaturismo2.model.GuiaTuristico;
import com.agenciaturismo2.model.Registrable;
import com.agenciaturismo2.model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    private List<Registrable> lista;

    /**
     * Metodo para crear entidades y agregarlas a una lista
     * @return
     */
    public List<Registrable> crearEntidades(){
        /**
         * Se crea un ArrayList que puede almacenar objetos que implementen la interfaz "Registrable"
         */
        ArrayList<Registrable> lista = new ArrayList<>();

        /**
         * Se crean las instancias de cada objeto y se agregan a la lista
         */
        lista.add(new Vehiculo(1, true, "TGHKLJ-7", "Bus"));
        lista.add(new ColaboradorExterno(1, true, "Transporte"));
        lista.add(new GuiaTuristico(1, true, "Felipe", 33, "Español/Ingles"));

        return lista;
    }
}
