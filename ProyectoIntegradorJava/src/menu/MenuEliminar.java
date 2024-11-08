package menu;

import models.Cliente;
import servicios.ClienteServicio;
//import utils.LectorDatosCliente;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuEliminar {

    private ClienteServicio clienteServicio;
    private ArrayList<Cliente> listaClientes;
    private Scanner entrada;

    public MenuEliminar(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
        this.listaClientes = clienteServicio.getLista();
        this.entrada = new Scanner(System.in);
    }

    public void eliminarCliente() {
        // Verificar si hay clientes
        if (listaClientes.isEmpty()) {
            System.out.println("No hay registros a eliminar. ¿Desea agregar un nuevo cliente? (si/no): ");
            String respuesta = entrada.nextLine();

            // Validación de la respuesta del usuario
            if (respuesta.equalsIgnoreCase("si")) {

                // Si el usuario responde "si", permitir al usuario agregar uno
                MenuIngresar menuIngresar = new MenuIngresar(clienteServicio);
                menuIngresar.mostrarMenu();
            } else if (respuesta.equalsIgnoreCase("no")) {

                System.out.println("Regresando al menú principal...");

            } else {

                // En caso de que la entrada no sea "si" o "no"
                System.out.println("Entrada incorrecta. Por favor, ingrese 'si' o 'no'.");
            }
        } else {
            motrarClientes();
        }

    }

    public void motrarClientes() {

        // Mostrar la lista de clientes
        System.out.println("------ Eliminar Registro ------");
        System.out.println("Lista de clientes:");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println((i + 1) + ". DNI: " + listaClientes.get(i).getDni());
        }
        // Le pedimos al usuario que ingrese el dni
        System.out.println("Ingrese el número de dni del registro que desea eliminar o " +
                "escriba 'esc' para volver al menu principal:");
        String option = entrada.nextLine();

        // Salir si el usuario escribe 'esc' se regresa al menu
        if (option.equalsIgnoreCase("esc")) {
            System.out.println("Regresando al menú principal...");
            return;
        }
        // Si el usuario ingresa cualquier otra cosa se llama al metodo
        // confirmarEliminar y se le pasa el argumento option
        confirmacionEliminar(option);
    }

    public void confirmacionEliminar(String option) {
        try {
            int dni = Integer.parseInt(option);
            boolean encontrado = false;

            // Recorremos la lista de clientes
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).getDni() == dni) {
                    encontrado = true; // Se encontró un cliente
                    mostrarDetalleCliente(listaClientes.get(i)); // Mostrar los detalles del cliente

                    System.out.println("Escriba 'confirmar' para eliminar o cualquier otra tecla para cancelar.");
                    String confirmacion = entrada.nextLine();

                    // Confirmación de eliminación
                    if (confirmacion.equalsIgnoreCase("confirmar")) {
                        listaClientes.remove(i); // Eliminar el cliente de la lista
                        System.out.println("------ Registro eliminado con éxito. ------");
                    } else {
                        System.out.println("Operación cancelada. Regresando al menú principal...");
                    }

                    break; // Salimos del bucle ya que encontramos el cliente
                }
            }

            // Si no se encontró el cliente
            if (!encontrado) {
                System.out.println("DNI no encontrado.");
            }

            // Después de haber gestionado la eliminación, mostramos el menú principal
            gestionarEliminacionAdicional();

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un DNI válido.");
            eliminarCliente(); // Llamada a sí mismo en caso de error
        }
    }

    public void mostrarDetalleCliente(Cliente cliente) {

        System.out.println("------ CONFIRMAR ELIMINACIÓN ------");
        System.out.println("¿Está seguro que desea eliminar el siguiente registro?");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("DNI: " + cliente.getDni());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Direccion: " + cliente.getDireccion());
        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println("Codigo postal: " + cliente.getCodigoPostal());
        System.out.println("Provincia: " + cliente.getProvincia());
        System.out.println("Saldo: " + cliente.getSaldo());

    }

    private void gestionarEliminacionAdicional() {
        // Mostrar la lista actualizada de clientes si hay alguno
        if (!listaClientes.isEmpty()) {
            System.out.println("¿Desea eliminar otro registro? (si/no)");
            String option = entrada.nextLine();
            if (option.equalsIgnoreCase("si")) {
                eliminarCliente();
            } else {
                System.out.println("Regresando al menú principal...");
            }

        } else {
            System.out.println("La base de datos ahora está vacía.");
        }
    }
}
