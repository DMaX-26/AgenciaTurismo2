package com.agenciaturismo2.model;

/**
 * Subclase que representa a un ColaboradorExterno
 * Hereda atributos y métodos de la superclase "RecursoAgencia"
 * Contiene un atributo propio: tipoServicio
 */
public class ColaboradorExterno extends RecursoAgencia implements Registrable{
    private String tipoServicio;

    /**
     * Constructor para crear objetos e inicializar atributos heredados y propios
     * @param id
     * @param disponibilidad
     * @param tipoServicio
     */
    public ColaboradorExterno(int id, boolean disponibilidad, String tipoServicio) {
        /**
         * Llama al constructor de la clase padre para inicializar id y disponibilidad en el objeto "ColaboradorExterno"
         */
        super(id, disponibilidad);
        /**
         * Se inicializa el atributo propio
         */
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Metodo que sobrescribe toString de la clase padre y agrega el atributo propio "tipoServicio"
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+", Tipo de servicio: "+tipoServicio;
    }

    /**
     * Se implementa de forma personalizada el metodo mostrarResumen correspondiente a la interfaz "Registrable"
     */
    @Override
    public void mostrarResumen() {
        System.out.println();
        System.out.println(":::Colaborador externo:::");
        super.mostrarResumen();
        System.out.println("Tipo de servicio: "+tipoServicio);
    }
}
