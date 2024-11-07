package menu;

import servicios.BaseDeDatos; // Importa la clase BaseDeDatos para acceder a la base de datos
import servicios.ClienteServicio; // Importa la clase ClienteServicio para realizar operaciones con clientes
import utils.LectorDatosCliente;

// Clase que contiene el menú principal del programa.

public class MenuPrincipal {

    private ClienteServicio clienteServicio; // llamamos a la clase ClienteServicio

    public MenuPrincipal(BaseDeDatos baseDeDatos) { // Constructor de la clase MenuPrincipal
        clienteServicio = new ClienteServicio(); // Inicializa el servicio de clientes
    }

    // Método que muestra el menú principal y lee la opción seleccionada por el
    // usuario.
    public void mostrarMenu() {
        int opcion; // Opción seleccionada por el usuario

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Ingresar Cliente");
            System.out.println("2. Consultar Clientes");
            System.out.println("3. Ordenar Cliente");
            System.out.println("4. Modificar Cliente");
            System.out.println("5. Eliminar Cliente");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");

            opcion = LectorDatosCliente.leerOpcion();

            switch (opcion) {
                case 1:
                    // Llamar al menú de ingresar cliente
                    MenuIngresar menuIngresar = new MenuIngresar(clienteServicio);
                    menuIngresar.mostrarMenu();
                    break;
                case 2:
                // Llamar al menú de consultar clientes
                    MenuConsultar menuConsultar = new MenuConsultar(clienteServicio);
                    menuConsultar.mostrarMenu();
                    break;
                case 3:
                    // Llamar al menú de ordenar clientes
                    MenuOrdenar menuOrdenar = new MenuOrdenar(clienteServicio);
                    menuOrdenar.mostrarMenu();
                    break;
                case 4:
                    // Llamar al menú de modificar cliente
                    MenuModificar menuModificar = new MenuModificar(clienteServicio);
                    menuModificar.mostrarMenu();
                    break;
                case 5:
                    // Llamar al menú de eliminar cliente
                    MenuEliminar menuEliminar = new MenuEliminar(clienteServicio);
                    menuEliminar.eliminarCliente();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);

    }

}