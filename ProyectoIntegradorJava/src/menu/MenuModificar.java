package menu;

import models.Cliente;
import servicios.ClienteServicio;
import utils.*;

public class MenuModificar {

    private ClienteServicio clienteServicio;

    /**
     * Constructor de la clase MenuModificar.
     *
     * @param clienteServicio La instancia de ClienteServicio.
     */
    public MenuModificar(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    /**
     * Muestra el menú para modificar un cliente y gestiona la lógica de
     * modificación.
     */
    public void mostrarMenu() {
        int opcion;
        do {

            System.out.println("\n--- Modificar Cliente ---");
            System.out.println("1. Modificar datos principales");
            System.out.println("2. Modificar todos los datos (excepto DNI)");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Ingrese una opción: ");

            opcion = LectorDatosCliente.leerOpcion();

            switch (opcion) {
                case 1:
                    modificarDatosPrincipales();
                    break;
                case 2:
                    modificarTodosLosDatos();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    /**
     * Permite al usuario modificar los datos principales de un cliente.
     */
    private void modificarDatosPrincipales() {
        System.out.print("Ingrese el DNI del cliente a modificar: ");
        int dni = LectorDatosCliente.leerDocumentoModificar();

        Cliente cliente = clienteServicio.buscarCliente(dni);

        if (cliente != null) {
            System.out.println("\nDatos actuales del cliente:");
            mostrarDatosCliente(cliente);

            // Modificar email
            System.out.print("\n¿Desea modificar el email? (s/n): ");
            if (LectorDatosCliente.leerConfirmacion()) {
                cliente.setEmail(LectorDatosCliente.leerEmail());
            }

            // Modificar teléfono
            System.out.print("¿Desea modificar el teléfono? (s/n): ");
            if (LectorDatosCliente.leerConfirmacion()) {
                cliente.setTelefono(LectorDatosCliente.leerTelefono());
            }

            // Modificar dirección
            System.out.print("¿Desea modificar la dirección? (s/n): ");
            if (LectorDatosCliente.leerConfirmacion()) {
                cliente.setDireccion(LectorDatosCliente.leerDireccion());
            }

            // Modificar saldo
            System.out.print("¿Desea modificar el saldo? (s/n): ");
            if (LectorDatosCliente.leerConfirmacion()) {
                cliente.setSaldo(LectorDatosCliente.leerSaldo());
            }

            // Confirmar modificación
            System.out.println("\nDatos modificados del cliente:");
            mostrarDatosCliente(cliente);
            System.out.print("¿Confirma la modificación? (s/n): ");
            if (LectorDatosCliente.leerConfirmacion()) {
                if (clienteServicio.modificarCliente(dni, cliente)) {
                    System.out.println("\nCliente modificado correctamente.");
                } else {
                    System.out.println("\nError al modificar el cliente.");
                }
            } else {
                System.out.println("\nModificación cancelada.");
            }
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese DNI.");
        }

        LectorDatosCliente.esperarEnter();
    }

    /**
     * Permite al usuario modificar todos los datos de un cliente (excepto el DNI).
     */
    private void modificarTodosLosDatos() {
        System.out.print("Ingrese el DNI del cliente a modificar: ");
        int dni = LectorDatosCliente.leerDocumentoModificar(); // Leer el DNI del cliente a modificar

        Cliente cliente = clienteServicio.buscarCliente(dni); // Buscar el cliente en la base de datos

        if (cliente != null) { // Si se encontró el cliente
            System.out.println("\nDatos actuales del cliente:");
            mostrarDatosCliente(cliente); // Mostrar los datos actuales del cliente

            // Leer y actualizar todos los datos (excepto DNI)
            cliente.setNombre(LectorDatosCliente.leerNombre());
            cliente.setApellido(LectorDatosCliente.leerApellido());
            cliente.setEmail(LectorDatosCliente.leerEmail());
            cliente.setTelefono(LectorDatosCliente.leerTelefono());
            cliente.setDireccion(LectorDatosCliente.leerDireccion());
            cliente.setCodigoPostal(LectorDatosCliente.leerCodigoPostal());
            cliente.setProvincia(LectorDatosCliente.leerProvincia());
            cliente.setSaldo(LectorDatosCliente.leerSaldo());
            cliente.setActivo(LectorDatosCliente.leerEstado());
            cliente.setFechaNacimiento(LectorDatosCliente.leerFechaNacimiento());

            // Confirmar modificación
            System.out.println("\nDatos modificados del cliente:");
            mostrarDatosCliente(cliente);
            System.out.print("¿Confirma la modificación? (s/n): ");
            if (LectorDatosCliente.leerConfirmacion()) {
                if (clienteServicio.modificarCliente(dni, cliente)) {
                    System.out.println("\nCliente modificado correctamente.");
                } else {
                    System.out.println("\nError al modificar el cliente.");
                }
            } else {
                System.out.println("\nModificación cancelada.");
            }
        } else {
            System.out.println("\nNo se encontró ningún cliente con ese DNI.");
        }

        LectorDatosCliente.esperarEnter();
    }

    /**
     * Muestra los datos de un cliente (excepto el DNI).
     *
     * @param cliente El cliente a mostrar.
     */

    private void mostrarDatosCliente(Cliente cliente) {
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Código Postal: " + cliente.getCodigoPostal());
        System.out.println("Provincia: " + cliente.getProvincia());
        System.out.println("Saldo: " + cliente.getSaldo());
        System.out.println("Activo: " + cliente.isActivo());
        System.out.println("Fecha de Nacimiento: " + cliente.getFechaNacimiento());
    }
}
