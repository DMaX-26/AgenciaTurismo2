🧠 Actividad Sumativa 3: Interfaces e integración con colecciones genéricas

👤 Autor del proyecto
```text
Nombre completo: Maximiliano Alvear
Sección: DESARROLLO ORIENTADO A OBJETOS I_003A
Carrera: Analista Programador Computacional
Sede: Sede Online
```
---

📘 Descripción general del sistema

Este proyecto corresponde a la Actividad Sumativa 3 de la asignatura Desarrollo Orientado a Objetos I. Consiste en el desarrollo de un sistema para la agencia de turismo Llanquihue Tour, el cual permite cargar información desde un archivo Excel, incluyendo datos de la agencia, proveedores de alojamiento y transporte, clientes y guías turísticos.

Además, se implementan las clases ServicioTuristico, RutaGastronomica, PaseoLacustre y ExcursionCultural, junto con una clase encargada de gestionar estos servicios turísticos. Cada una de estas clases incorpora un método para mostrar la información específica del servicio correspondiente.

Como parte de la actividad, también se desarrollan las clases RecursoAgencia, Vehiculo y ColaboradorExterno, las cuales representan distintos tipos de entidades de la agencia. Asimismo, se implementa la interfaz Registrable, que define un método común que debe ser implementado por todas las clases que la utilizan.

Para administrar estas entidades, se crea la clase GestorEntidades, responsable de crear instancias de cada entidad que implementa la interfaz Registrable y almacenarlas en una colección para su posterior gestión.

Finalmente, se desarrolla una interfaz gráfica que permite registrar vehículos, colaboradores externos y guías turísticos de una manera más intuitiva y visual, facilitando la interacción del usuario con el sistema. 

El proyecto fue desarrollado a partir de un caso contextualizado, abordando problemáticas reales y proponiendo una solución estructurada, modular y reutilizable.

🧱 Estructura general del proyecto
```text
📁 src/
├── ui/          # Clase principal con el método main
├── model/       # Clases de dominio (Agencia, Cliente, Direccion, GuiaTuristico, ProveedorAlojamiento, ProveedorTransporte, ServicioTuristico, RutaGastronomica, PaseoLacustre, ExcursionCultural, RecursoAgencia, Vehiculo, ColaboradorExterno, Registrable)
├── exception/   # Excepciones personalizadas (EdadInvalidaException)
├── data/        # Gestión y acceso de datos (GestorDatos, GestorServicios, GestorEntidades)
└── gui/         # Interfaz gráfica de usuario (Interfaz)
```
---
⚙️ Instrucciones para compilar y ejecutar el proyecto
```text
Abre el proyecto en IntelliJ IDEA

Dirígete a File > Open - selecciona la carpeta del proyecto y presiona el botón "Select Folder".

Ejecuta el archivo Main.java desde el paquete ui.

Repositorio GitHub: [https://github.com/DMaX-26/AgenciaTurismo2] Fecha de entrega: 13/07/2026
```
---