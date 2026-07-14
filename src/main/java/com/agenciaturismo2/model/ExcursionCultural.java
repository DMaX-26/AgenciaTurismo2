package com.agenciaturismo2.model;

public class ExcursionCultural extends ServicioTuristico{
    private String lugarHistorico;

    /**
     * Constructor para crear objetos e inicializar atributos heredados y propios
     * @param nombre
     * @param duracionHoras
     */
    public ExcursionCultural(String nombre, double duracionHoras, String lugarHistorico) {
        /**
         * Llama al constructor de la clase padre para inicializar nombre y duracionHoras en el objeto "ExcursionCultural"
         */
        super(nombre, duracionHoras);
        /**
         * Se inicializa el atributo propio
         */
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    /**
     * Reutiliza el metodo de la clase padre y agrega información específica de esta clase
     */
    @Override
    public void mostrarInformacion() {
        System.out.println();
        System.out.println("<<<Excursión Cultural>>>");
        super.mostrarInformacion();
        System.out.println("Lugar histórico: "+lugarHistorico);
    }

    /**
     * Metodo que sobrescribe toString de la clase padre y agrega el atributo propio "lugarHistorico"
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+" Lugar histórico: "+lugarHistorico;
    }
}
