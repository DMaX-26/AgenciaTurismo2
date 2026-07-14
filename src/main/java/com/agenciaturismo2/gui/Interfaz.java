package com.agenciaturismo2.gui;

import com.agenciaturismo2.model.ColaboradorExterno;
import com.agenciaturismo2.model.GuiaTuristico;
import com.agenciaturismo2.model.Vehiculo;
import com.agenciaturismo2.model.RecursoAgencia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.function.Function;

public class Interfaz extends JFrame {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ArrayList<ColaboradorExterno> colaboradoresExternos = new ArrayList<>();
    private ArrayList<GuiaTuristico> guiasTuristicos = new ArrayList<>();

    // Lista visual de organizadores (campo para poder refrescarla desde agregarOrganizador)
    private final JList<Vehiculo> vehiculosList = new JList<>();
    private final JList<ColaboradorExterno> colaboradoresExternosList = new JList<>();
    private final JList<GuiaTuristico> guiasTuristicosList = new JList<>();

    //Constructor
    public Interfaz(){
        //Titulo
        setTitle("Gestión de entidades");
        //Tamaño ventana
        setSize(500, 450);
        //Ubicar ventana al centro de la pantalla
        setLocationRelativeTo(null);
        //organizar las componentes en 5 zonas
        setLayout(new BorderLayout());
        //Cerrar la ventana al presionar "x"
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Se muestra toda la información especificada del objeto Vehículo en el Jlist
        vehiculosList.setCellRenderer(new IdRenderer<Vehiculo>(v -> "ID: "+ v.getId()+ " | Disponibilidad: "+ v.isDisponibilidad()+ " | Patente: " +v.getPatente()+ " | Tipo Vehículo: "+v.getTipoVehiculo()));
        //Se muestra toda la información especificada del objeto ColaboradorExterno en el Jlist
        colaboradoresExternosList.setCellRenderer(new IdRenderer<ColaboradorExterno>( c -> "ID: "+c.getId() + " | Disponibilidad: "+c.isDisponibilidad()+ " | Tipo de servicio: "+c.getTipoServicio()));
        //Se muestra toda la información especificada del objeto GuiaTuristico en el Jlist
        guiasTuristicosList.setCellRenderer(new IdRenderer<GuiaTuristico>(g -> "ID: "+g.getId()+ " | Disponibilidad: "+g.isDisponibilidad()+" | Nombre: "+g.getNombre()+ " | Edad: "+g.getEdad()+" | Idiomas: "+g.getIdiomas()));

        JTabbedPane tabs = new JTabbedPane(); // Contenedor de pestañas
        tabs.addTab("Vehículos", crearPanelVehiculos()); // Pestaña 1: gestión de vehículos
        tabs.addTab("Colaboradores Externos", crearPanelColaboradoresExternos()); // Pestaña 2: gestión de colaboradores externos
        tabs.addTab("Guías Turísticos", crearPanelGuiasTuristicos()); // Pestaña 3: gestión de guías turísticos

        setContentPane(tabs); // Las pestañas ocupan todo el contenido de la ventana
    }

    private Component crearPanelVehiculos() {
        JPanel form = new JPanel(new GridLayout(0, 2, 5, 5)); // Grilla de 2 columnas (etiqueta + campo)

        //Se crean las cajas de texto
        JTextField txtId = new JTextField();
        JTextField txtDisponibilidad = new JTextField();
        JTextField txtPatente = new JTextField();
        JTextField txtTipoVehiculo = new JTextField();

        //Se crean las etiquetas, se agregan las etiquetas y las cajas de texto al JPanel
        form.add(new JLabel("ID:"));
        form.add(txtId);
        form.add(new JLabel("DISPONIBILIDAD (SI / NO):"));
        form.add(txtDisponibilidad);
        form.add(new JLabel("PATENTE:"));
        form.add(txtPatente);
        form.add(new JLabel("TIPO DE VEHÍCULO:"));
        form.add(txtTipoVehiculo);

        form.setBorder(BorderFactory.createTitledBorder("Nuevo Vehículo")); // Se ingresa un título al marco del JPanel
        JButton btnRegistrarVehiculo = new JButton("Registrar Vehículo"); //se crea un botón para registrar un Vehículo
        //Se agrega la accion registrarVehiculo (se le pasan los cuatro JTextField))
        btnRegistrarVehiculo.addActionListener(ActiveEvent -> registrarVehiculo(txtId, txtDisponibilidad, txtPatente, txtTipoVehiculo));
        JButton btnVisualizarRegistros = new JButton("Visualizar Vehículos Registrados");//Se crea un botón para ver los vehículos registrados
        btnVisualizarRegistros.addActionListener(ActiveEvent -> visualizarVehiculos());//Se agrega la acción visualizarVehiculos al botón
        JButton btnSalir = new JButton("Salir");//se crea un botón "Salir"
        btnSalir.addActionListener(ActiveEvent -> salir());//se agrega la acción salir() al botón

        //Se crea un JPanel con 3 filas y una columna y se agregan botones al JPanel "botones"
        JPanel botones = new JPanel(new GridLayout(3, 1, 5, 5));
        botones.add(btnRegistrarVehiculo);
        botones.add(btnVisualizarRegistros);
        botones.add(btnSalir);

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(botones, BorderLayout.SOUTH);

        JPanel panel = new JPanel(new BorderLayout(10, 10)); // Panel general de la pestaña
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes internos
        panel.add(top, BorderLayout.NORTH); // Formulario arriba
        panel.add(new JScrollPane(vehiculosList), BorderLayout.CENTER); // Lista con scroll al centro

        return panel;
    }

    private Component crearPanelColaboradoresExternos() {
        // JPanel con 2 columnas (etiquetas + cajas de texto)
        JPanel form = new JPanel(new GridLayout(0, 2, 5, 5));

        //Cajas de texto
        JTextField txtId = new JTextField();
        JTextField txtDisponibilidad = new JTextField();
        JTextField txtTipoServicio = new JTextField();

        //Se crean las etiquetas, se agregan las etiquetas y las cajas de texto al JPanel
        form.add(new JLabel("ID:"));
        form.add(txtId);
        form.add(new JLabel("DISPONIBILIDAD (SI / NO):"));
        form.add(txtDisponibilidad);
        form.add(new JLabel("TIPO DE SERVICIO:"));
        form.add(txtTipoServicio);

        form.setBorder(BorderFactory.createTitledBorder("Nuevo Colaborador Externo")); // Se ingresa un título al marco del JPanel
        JButton btnRegistrarColaborador = new JButton("Registrar Colaborador Externo"); //Se crea un botón para registrar colaborador
        //Se agrega la acción registrarColaborador al botón (se le pasan tres JTextField)
        btnRegistrarColaborador.addActionListener(ActiveEvent -> registrarColaborador(txtId, txtDisponibilidad, txtTipoServicio));
        JButton btnVisualizarRegistros = new JButton("Visualizar Colaboradores Registrados"); //Se crea un botón para visualizar registros
        btnVisualizarRegistros.addActionListener(ActiveEvent -> visualizarColaboradores());//Se agrega una acción al botón visualizar registros
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(ActionEvent -> salir());

        //Se crea un JPanel con dos filas y una columna, y se agregan los botones
        JPanel botones = new JPanel(new GridLayout(3, 1, 5, 5));
        botones.add(btnRegistrarColaborador);
        botones.add(btnVisualizarRegistros);
        botones.add(btnSalir);

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(botones, BorderLayout.SOUTH);

        JPanel panel = new JPanel(new BorderLayout(10, 10)); // Panel general de la pestaña
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes internos
        panel.add(top, BorderLayout.NORTH); // Formulario arriba
        panel.add(new JScrollPane(colaboradoresExternosList), BorderLayout.CENTER); // Lista con scroll al centro

        return panel;
    }

    private Component crearPanelGuiasTuristicos() {
        // JPanel con 2 columnas (etiquetas + cajas de texto)
        JPanel form = new JPanel(new GridLayout(0, 2, 5, 5));

        //Se crean las cajas de texto
        JTextField txtId = new JTextField();
        JTextField txtDisponibilidad = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtEdad = new JTextField();
        JTextField txtIdiomas = new JTextField();

        //Se crean las etiquetas, se agregan las etiquetas y las cajas de texto al JPanel
        form.add(new JLabel("ID:"));
        form.add(txtId);
        form.add(new JLabel("DISPONIBILIDAD (SI / NO):"));
        form.add(txtDisponibilidad);
        form.add(new JLabel("NOMBRE:"));
        form.add(txtNombre);
        form.add(new JLabel("EDAD:"));
        form.add(txtEdad);
        form.add(new JLabel("IDIOMAS:"));
        form.add(txtIdiomas);

        form.setBorder(BorderFactory.createTitledBorder("Nuevo Guía Turístico")); // Se ingresa un título al marco del JPanel
        JButton btnRegistrarGuiaTuristico = new JButton("Registrar Guía Turístico");//Crea un botón con un título
        //Agrega la acción "registrarGuia" al botón (se le pasan 5 JTextField)
        btnRegistrarGuiaTuristico.addActionListener(ActiveEvent -> registrarGuia(txtId, txtDisponibilidad, txtNombre, txtEdad, txtIdiomas));
        JButton btnVisualizarGuias = new JButton("Visualizar Guías Turísticos Registrados");//Se crea el botón visualizarGuias
        btnVisualizarGuias.addActionListener(ActiveEvent -> visualizarGuias());//Se le agrega la acción visualizarGuias
        JButton btnSalir = new JButton("Salir");//se crea un botón "Salir"
        btnSalir.addActionListener(ActiveEvent -> salir());//se agrega la acción salir() al botón

        //Se crea un JPanel con dos filas y una columna, y se agregan los botones
        JPanel botones = new JPanel(new GridLayout(3, 1, 5, 5));
        botones.add(btnRegistrarGuiaTuristico);
        botones.add(btnVisualizarGuias);
        botones.add(btnSalir);

        JPanel top = new JPanel(new BorderLayout()); // Contenedor para formulario + botón
        top.add(form, BorderLayout.CENTER); // El formulario ocupa el centro
        top.add(botones, BorderLayout.SOUTH); // Se agregan los botones debajo del formulario

        JPanel panel = new JPanel(new BorderLayout(10, 10)); // Panel general de la pestaña
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes internos
        panel.add(top, BorderLayout.NORTH); // Formulario arriba
        panel.add(new JScrollPane(guiasTuristicosList), BorderLayout.CENTER); // Lista con scroll al centro

        return panel;
    }

    //Metodo que registra cada vehículo. Se le pasan los 4 parámetros de tipo JTextField (para leer los datos ingresados)
    public void registrarVehiculo(JTextField txtId, JTextField txtDisponibilidad, JTextField txtPatente, JTextField txtTipoVehiculo){
        //Se crean todas las variables como tipo "String"
        String id;
        String disponibilidad;
        String patente;
        String tipoVehiculo;

        //Se obtienen los datos de las cajas de texto y se guardan en sus variables correspondientes
        id = txtId.getText();
        disponibilidad = txtDisponibilidad.getText();
        patente = txtPatente.getText();
        tipoVehiculo = txtTipoVehiculo.getText();

        if (id.trim().isEmpty() || disponibilidad.trim().isEmpty() || patente.trim().isEmpty() || tipoVehiculo.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "No pueden haber campos vacíos");
            return;
        }

        //Try catch para manejo de excepciones
        try {
            //Se convierte la variable "id" a tipo int y se guarda en la variable "idVehiculo"
            int idVehiculo = Integer.parseInt(id);
            boolean disponible;

            if (idVehiculo <= 0){
                JOptionPane.showMessageDialog(this, "El ID debe ser mayor a Cero");
                return;//Se corta la ejecución
            }

            //Si lo ingresado en "disponibilidad" es "si"
            if (disponibilidad.equalsIgnoreCase("si")){
                //disponible es true
                disponible = true;
                //Si lo ingresado en "d" es "no"
            }else if (disponibilidad.equalsIgnoreCase("no")) {
                //disponible es false
                disponible = false;
            }else{
                JOptionPane.showMessageDialog(null, "DISPONIBILIDAD debe ser respondida con un 'SI' O 'NO'");
                return;//corta la ejecución
            }

            //Se crea una instancia de "Vehiculo" y se ingresa id, disponible, patente y tipoVehiculo
            Vehiculo vehiculo = new Vehiculo(idVehiculo, disponible, patente, tipoVehiculo);
            //Se agrega la instancia a la lista "vehiculos"
            vehiculos.add(vehiculo);

            JOptionPane.showMessageDialog(rootPane, ">>> Vehículo registrado correctamente <<<");//mensaje dentro de una ventana emergente

            //Se vacían las cajas de texto al final
            txtId.setText("");
            txtDisponibilidad.setText("");
            txtPatente.setText("");
            txtTipoVehiculo.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un valor numérico");
        }
    }

    //Metodo que registra cada colaborador externo. Se le pasan los 3 parámetros de tipo JTextField (para obtener los datos ingresados)
    public void registrarColaborador(JTextField txtId, JTextField txtDisponibilidad, JTextField txtTipoServicio){
        //Se crean las variables como String para
        String id;
        String disponibilidad;
        String tipoServicio;

        //Obtener los datos ingresados en las cajas de texto y guardarlos en sus variables correspondientes
        id = txtId.getText();
        disponibilidad = txtDisponibilidad.getText();
        tipoServicio = txtTipoServicio.getText();

        //Si hay algún campo de texto vacío, se abre una ventana con un mensaje
        if (id.trim().isEmpty() || disponibilidad.trim().isEmpty() || tipoServicio.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "No pueden haber campos de texto vacíos");
            return;
        }

        //Try-catch para manejo de excepciones
        try {
            //El "id" se convierte a int y se guarda en la variable idColaborador
            int idColaborador = Integer.parseInt(id);
            boolean disponible;

            //Validar el ingreso del idColaborador
            if (idColaborador <= 0){
                JOptionPane.showMessageDialog(this, "El ID debe ser mayor a Cero");
                return;//Se corta la ejecución
            }

            //Validar ingreso de disponibilidad
            if (disponibilidad.equalsIgnoreCase("si")){
                disponible = true;
            } else if (disponibilidad.equalsIgnoreCase("no")) {
                disponible = false;
            }else{
                JOptionPane.showMessageDialog(this, "DISPONIBILIDAD debe ser respondida con un 'SI' O 'NO'");
                return;//Se corta ñla ejecución
            }

            //Se crea una instancia de ColaboradorExterno y se ingresa: idColaborador, disponible y tipoServicio
            ColaboradorExterno colaboradorExterno = new ColaboradorExterno(idColaborador, disponible, tipoServicio);
            colaboradoresExternos.add(colaboradorExterno);

            JOptionPane.showMessageDialog(this, ">>> Colaborador externo registrado correctamente! <<<");

            //Se vacían las cajas de texto al final
            txtId.setText("");
            txtDisponibilidad.setText("");
            txtTipoServicio.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error! El ID debe ser un valor numérico");
        }
    }

    //Metodo que registra cada guía turístico. Se le pasan los 5 parámetros de tipo JTextField (para obtener los datos ingresados)
    public void registrarGuia(JTextField txtId, JTextField txtDisponibilidad, JTextField txtNombre, JTextField txtEdad, JTextField txtIdiomas){
        //Se crean todas las variables como tipo "String"
        String id;
        String disponibilidad;
        String nombre;
        String edad;
        String idiomas;

        //Se obtienen los datos de las cajas de texto y se guardan en las variables correspondientes
        id = txtId.getText();
        disponibilidad = txtDisponibilidad.getText();
        nombre = txtNombre.getText();
        edad = txtEdad.getText();
        idiomas = txtIdiomas.getText();
        
        if (id.trim().isEmpty() || disponibilidad.trim().isEmpty() || nombre.trim().isEmpty() || edad.trim().isEmpty() || idiomas.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "No pueden haber campos de texto vacíos");
            return;//Se corta la ejecución
        }

        //Try-catch para manejo de excepciones
        try {
            //Conversion de variables de String a int y de String a boolean
            int idGuia = Integer.parseInt(id);
            boolean disponible;
            int edadGuia = Integer.parseInt(edad);

            //Validar el ingreso del idGuia
            if (idGuia <= 0){
                JOptionPane.showMessageDialog(this, "El ID debe ser mayor a Cero");
                return;
            }

            //Si disponibilidad es "si"
            if (disponibilidad.equalsIgnoreCase("si")){
                //está disponible
                disponible = true;
            //Si disponibilidad es "no"
            }else if (disponibilidad.equalsIgnoreCase("no")) {
                //no está disponible
                disponible = false;
            }else{
                JOptionPane.showMessageDialog(this, "DISPONIBILIDAD debe ser respondida con un 'SI' O 'NO'");
                return;//Se corta la ejecución
            }

            if (edadGuia <= 0){
                JOptionPane.showMessageDialog(this, "La edad ingresada no es válida");
                return;
            }

            //Se crea una instancia de GuiaTuristico y se ingresan idGuia, disponible, nombre, edadGuia e idiomas
            GuiaTuristico guiaTuristico = new GuiaTuristico(idGuia, disponible, nombre, edadGuia, idiomas);
            //Se agrega la instancia creada a la lista "guiasTuristicos"
            guiasTuristicos.add(guiaTuristico);

            JOptionPane.showMessageDialog(this, ">>> Guía Turístico registrado correctamente! <<<");

            //Vaciar cajas de texto al final
            txtId.setText("");
            txtDisponibilidad.setText("");
            txtNombre.setText("");
            txtEdad.setText("");
            txtIdiomas.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID y la EDAD deben ser valores numéricos");
        }
    }

    //Metodo para visualizar todos los vehiculos registrados
    public void visualizarVehiculos(){
        if (vehiculos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No existen vehículos registrados");
        }else{
            //convierte el arraylist vehiculos en una arreglo y muestra el contenido en el JList
            vehiculosList.setListData(vehiculos.toArray(new Vehiculo[0]));
        }
    }

    //Metodo para visualizar todos los colaboradores externos registrados
    public void visualizarColaboradores(){
        if (colaboradoresExternos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No existen colaboradores registrados");
        }else{
            colaboradoresExternosList.setListData(colaboradoresExternos.toArray(new ColaboradorExterno[0]));
        }
    }

    //Metodo para visualizar todos los guías turísticos registrados
    public void visualizarGuias(){
        if (guiasTuristicos.isEmpty()){
            JOptionPane.showMessageDialog(this, "No existen Guías Turísticos registrados");
        }else{
            guiasTuristicosList.setListData(guiasTuristicos.toArray(new GuiaTuristico[0]));
        }
    }

    public void salir(){
        System.exit(0);
    }

    // Renderer genérico: muestra en la lista/combo el "id" del objeto (según la función recibida)
    // en vez del toString() por defecto, sin necesitar una clase envoltorio ni tocar los modelos.
    private static class IdRenderer<T> extends DefaultListCellRenderer {
        private final Function<T, String> obtenerId; // Cómo sacar el "id" del objeto T

        IdRenderer(Function<T, String> obtenerId) {
            this.obtenerId = obtenerId;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            // Primero deja que el renderer por defecto arme el componente base
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
                setText(obtenerId.apply((T) value)); // Reemplaza el texto por el "id" del objeto
            }
            return this;
        }
    }
}

