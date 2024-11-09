package menu;

import utils.LectorDatosCliente;
import models.Cliente;
import servicios.ClienteServicio; //importamos la clase ClienteServicio

//clase MenuConsultar
public class MenuConsultar {

    private ClienteServicio clienteServicio; // llamamos a la clase ClienteServicio

    /**
     * Constructor de la clase MenuConsultar.
     * 
     * @param baseDeDatos La base de datos de clientes.
     */
    public MenuConsultar(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    // Muestra el menu de consulta y gestiona las opciones del usuario
    public void mostrarMenu() {
        int opcion; // declaramos la variable opcion
        do {
            System.out.println("\n--- Consultar Clientes ---");
            System.out.println("1. Consultar por Documento");
            System.out.println("2. Listar Todos los Clientes");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Ingrese una opción: ");

            opcion = LectorDatosCliente.leerOpcion();
            switch (opcion) {
                case 1:
                    consultarPorDocumento();
                    break;
                case 2:
                    listarTodosLosClientes();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    // Consulta un cliente por documento
    private void consultarPorDocumento() {
        System.out.print("Ingrese el documento del cliente: ");
        int dni = LectorDatosCliente.leerDocumento(clienteServicio);

        Cliente cliente = clienteServicio.buscarCliente(dni);

        if (cliente != null) {
            System.out.println("\nCliente encontrado:");
            System.out.println(cliente); // Utiliza el método toString() de "Cliente"
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese documento.");
        }

        LectorDatosCliente.esperarEnter();
    }

    // Lista todos los clientes de la base de datos
    private void listarTodosLosClientes() {
        clienteServicio.listarClientes();
        LectorDatosCliente.esperarEnter();
    }
}