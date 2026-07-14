package com.agenciaturismo2.data;

import com.agenciaturismo2.exception.EdadInvalidaException;
import com.agenciaturismo2.model.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private String rutaArchivo;

    public GestorDatos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    //Metodo que carga una lista de tipo Cliente desde un archivo Excel
    public List<Cliente> cargarClientes() throws IOException, EdadInvalidaException {
        //Se crea una lista de tipo "Cliente", se inicializa con un ArrayList.
        List<Cliente> lista = new ArrayList<>();

        FileInputStream archivo = new FileInputStream(rutaArchivo);//Abre un archivo ya existente
        Workbook libro = new XSSFWorkbook(archivo);//Se crea un objeto libro desde "archivo"
        Sheet hoja = libro.getSheetAt(0);//Se obtiene la primera hoja de libro creado

        //Recorrido de todas las filas de la hoja
        for (Row fila : hoja) {
            //Si se obtiene la fila "0"
            if (fila.getRowNum() == 0) continue; // saltar encabezado (la primera fila lleva los títulos)

            //Proceso para que cada celda se lea según el tipo de dato que contiene

            //Datos Cliente
            String nombre = fila.getCell(0).getStringCellValue();//Obtiene "nombre" de la columna 0 como String
            int edad = (int) fila.getCell(1).getNumericCellValue();//Obtiene "edad" de la columna 1 (la celda lo lee como int)
            String correo = fila.getCell(2).getStringCellValue();//Obtiene "correo" de la columna 2 como String
            String nacionalidad = fila.getCell(3).getStringCellValue();//Obtiene "nacionalidad" de la columna 3 como String

            //Datos GuiaTuristico
            int id = (int) fila.getCell(5).getNumericCellValue();//Obtiene "id" de la columna 5 (la celda lo lee como int)
            boolean disponibilidad = Boolean.parseBoolean(fila.getCell(6).getStringCellValue());//Obtiene "estado" de la columna 6 como boolean
            String nombreGuia = fila.getCell(7).getStringCellValue();//Obtiene "nombre" de la columna 5 como String
            int edadGuia = (int) fila.getCell(8).getNumericCellValue();//Obtiene "edadGuia" de la columna 6 (la celda lo lee como int)
            String idiomas = fila.getCell(9).getStringCellValue();//Obtiene "idiomas" de la columna 7 como String

            //Se crea una instancia de tipo GuiaTuristico dentro del archivo
            GuiaTuristico guiaTuristico = new GuiaTuristico(id, disponibilidad, nombreGuia, edadGuia, idiomas);

            //Si la edadGuia es menor o igual a 0, se lanza una excepción
            if (edadGuia<=0){
                throw new EdadInvalidaException("La edad ingresada no es válida");
            }

            //Se crea una instancia de Cliente y se agrega a la "lista"
            lista.add(new Cliente(nombre, edad, correo, nacionalidad, guiaTuristico));
        }
        libro.close();//Se cierra el libro
        archivo.close();//Se cierra el archivo

        return lista;
    }

    //Metodo que carga un ProveedorAlojamiento desde un archivo Excel (se le pasa un libro como parámetro)
    public ProveedorAlojamiento cargarProveedorAlojamiento(Workbook libro) throws IOException {

        Sheet hoja2 = libro.getSheetAt(1);//Se obtiene la segunda hoja de libro creado

        //Se toma la segunda fila de hoja2 y se guarda en la variable "fila"
        Row fila = hoja2.getRow(1);

        //Datos Direccion
        String calle = fila.getCell(4).getStringCellValue();//Obtiene "calle" de la columna 4 como String
        String ciudad = fila.getCell(5).getStringCellValue();//Obtiene "ciudad" de la columna 5 como String

        //Se crea una instancia de Direccion
        Direccion direccion = new Direccion(calle, ciudad);

        //Datos ProveedorAlojamiento
        String nombre = fila.getCell(0).getStringCellValue();//Obtiene "nombre" de la columna 0 como String
        String correo = fila.getCell(1).getStringCellValue();//Obtiene "correo" de la columna 1 como String
        String numeroTelefonico = fila.getCell(2).getStringCellValue();//Obtiene "numeroTelefonico" de la columna 2 como String
        double precioPorNoche = fila.getCell(3).getNumericCellValue();//Obtiene "precioPorNoche" de la columna 3 como número

        //Se crea una instancia de ProveedorAlojamiento y se le pasa la Direccion
        ProveedorAlojamiento proveedorAlojamiento = new ProveedorAlojamiento(nombre, correo, numeroTelefonico, precioPorNoche, direccion );

        libro.close();

        return proveedorAlojamiento;
    }

    //Metodo que carga un ProveedorTransporte desde un archivo Excel (se le pasa un libro como parámetro)
    public ProveedorTransporte cargarProveedorTransporte(Workbook libro) throws IOException {

        //Se obtiene la tercera hoja de libro creado
        Sheet hoja3 = libro.getSheetAt(2);

        //Se toma la segunda fila de hoja3 y se guarda en la variable "fila"
        Row fila = hoja3.getRow(1);

        //Datos Direccion
        String calle = fila.getCell(4).getStringCellValue();//Obtiene "calle" de la columna 4 como String
        String ciudad = fila.getCell(5).getStringCellValue();//Obtiene "ciudad" de la columna 5 como String

        //Se crea una instancia de Direccion
        Direccion direccion = new Direccion(calle, ciudad);

        //Datos ProveedorTransporte
        String nombre = fila.getCell(0).getStringCellValue();//Obtiene "nombre" de la columna 0 como String
        String correo = fila.getCell(1).getStringCellValue();//Obtiene "correo" de la columna 1 como String
        String numeroTelefonico = fila.getCell(2).getStringCellValue();//Obtiene "numeroTelefonico" de la columna 2 como String
        String tipoTransporte = fila.getCell(3).getStringCellValue();//Obtiene "tipoTransporte" de la columna 3 como String

        //Se crea una instancia de ProveedorTransporte y se le pasa la Direccion
        ProveedorTransporte proveedorTransporte = new ProveedorTransporte(nombre, correo, numeroTelefonico, tipoTransporte, direccion);

        libro.close();

        return proveedorTransporte;
    }

    //Metodo que carga una Agencia desde un archivo Excel
    public Agencia cargarAgencia() throws IOException {

        FileInputStream archivo = new FileInputStream(rutaArchivo);//Abre un archivo ya existente
        Workbook libro = new XSSFWorkbook(archivo);//Se crea un objeto libro desde "archivo"
        Sheet hoja4 = libro.getSheetAt(3);//Se obtiene la cuarta hoja de libro creado

        //Se toma la segunda fila de hoja4 y se guarda en la variable "fila"
        Row fila = hoja4.getRow(1);

        //Datos Direccion
        String calle = fila.getCell(1).getStringCellValue();//Obtiene "calle" de la columna 1 como String
        String ciudad = fila.getCell(2).getStringCellValue();//Obtiene "ciudad" de la columna 2 como String

        //Se crea una instancia de Direccion
        Direccion direccion = new Direccion(calle, ciudad);

        //Datos de Agencia
        String nombre = fila.getCell(0).getStringCellValue();//Obtiene "nombre" de la columna 0 como String

        //Se crea una variable de tipo "ProveedorAlojamiento" que guarda el metodo "cargarProveedorAlojamiento"
        ProveedorAlojamiento alojamiento = cargarProveedorAlojamiento(libro);
        //Se crea una variable de tipo "ProveedorTransporte" que guarda el metodo "cargarProveedorTransporte"
        ProveedorTransporte transporte = cargarProveedorTransporte(libro);

        //Se crea una instancia de Agencia, se le pasa una direccion, un ProveedorAlojamiento y un ProveedorTransporte
        Agencia agencia = new Agencia(nombre, direccion, alojamiento, transporte);

        libro.close();
        archivo.close();

        return agencia;
    }
}
