package menu;

import java.util.Scanner;
import servicios.ClienteServicio;
import servicios.OrdenamientoServicio;
import utils.LectorDatosCliente;

public class MenuOrdenar {
  private Scanner scanner;
  private ClienteServicio clienteServicio;
  private OrdenamientoServicio ordenamientoServicio;

  public MenuOrdenar(ClienteServicio clienteServicio) {
    this.scanner = new Scanner(System.in);
    this.clienteServicio = clienteServicio;
    this.ordenamientoServicio = new OrdenamientoServicio();
  }

  public void mostrarMenu() {
    int opcion;
    String orden;
    do {
      System.out.println("\n--- Ordenar Clientes ---");
      System.out.println("1. Por Apellido");
      System.out.println("2. Por Estado de actividad");
      System.out.println("3. Por DNI");
      System.out.println("4. Por Nombre");
      System.out.println("5. Por Saldo");
      System.out.println("6. Volver al Menú Principal");
      System.out.print("Ingrese una opción: ");
      opcion = LectorDatosCliente.leerOpcion();

      // Solo pedir el orden si la opción no es 6
      if (opcion != 6) {
        do {
          System.out.println("Ingrese el orden que desea:");
          System.out.println("'asc' para ordenar de modo Ascendente, 'desc' para ordenarlos de modo Descendente");
          orden = scanner.nextLine().trim().toLowerCase(); // Normalizar la entrada a minúsculas y eliminar espacios
          if (!orden.equals("asc") && !orden.equals("desc")) {
            System.out.println("Error: Ingrese una opción válida ('asc' o 'desc').");
          }
        } while (!orden.equals("asc") && !orden.equals("desc"));

        // Llamar al método de ordenamiento según la opción seleccionada
        switch (opcion) {
          case 1:
            ordenarClientes("apellido", orden);
            break;
          case 2:
            ordenarClientes("activo", orden);
            break;
          case 3:
            ordenarClientes("dni", orden);
            break;
          case 4:
            ordenarClientes("nombre", orden);
            break;
          case 5:
            ordenarClientes("saldo", orden);
            break;
          default:
            System.out.println("Opción inválida. Intente nuevamente.");
        }
      } else {
        System.out.println("Volviendo al menú principal...");
      }
    } while (opcion != 6);
  }

  private void ordenarClientes(String atributo, String orden) {
    this.ordenamientoServicio.ordenarClientes(atributo, orden, clienteServicio);
    System.out.println("\nClientes ordenados por " + atributo + " en orden " + orden + ":");
    this.clienteServicio.listarClientes();
    LectorDatosCliente.esperarEnter();
  }
}
