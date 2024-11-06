package menu;

import models.Cliente;
import servicios.ClienteServicio;
import utils.*;

public class MenuIngresar {

    private ClienteServicio clienteServicio;

    /**
     * Constructor de la clase MenuIngresar.
     * 
     * @param clienteServicio Instancia de la clase ClienteServicio para realizar
     *                        operaciones con clientes
     */
    public MenuIngresar(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio; // Inicializa el servicio de clientes
    }

    public void mostrarMenu() {
        System.out.println("\n--- Ingresar Nuevo Cliente ---");

        // llama a la clase lectorDatosCliente y usa los metodos para "leer"
        int dni = LectorDatosCliente.leerDocumento(clienteServicio);
        String nombre = LectorDatosCliente.leerNombre();
        String apellido = LectorDatosCliente.leerApellido();
        String email = LectorDatosCliente.leerEmail();
        String fechaNacimiento = LectorDatosCliente.leerFechaNacimiento();
        String telefono = LectorDatosCliente.leerTelefono();
        String direccion = LectorDatosCliente.leerDireccion();
        String codigoPostal = LectorDatosCliente.leerCodigoPostal();
        String provincia = LectorDatosCliente.leerProvincia();
        double saldo = LectorDatosCliente.leerSaldo();
        boolean activo = LectorDatosCliente.leerEstado();

        // Crear un nuevo objeto Cliente con los datos ingresados
        Cliente nuevoCliente = new Cliente(dni, nombre, apellido, email, telefono, direccion, codigoPostal,
                provincia, saldo, activo, fechaNacimiento);

        // Agregar el cliente a la base de datos
        clienteServicio.agregarCliente(nuevoCliente);

        System.out.println("\nCliente ingresado correctamente.");
        System.out.println(nuevoCliente); // Mostrar los datos del cliente ingresado

        LectorDatosCliente.esperarEnter();
    }

}
