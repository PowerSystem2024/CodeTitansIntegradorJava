package utils;

import servicios.ClienteServicio;

import java.util.Scanner;

public class LectorDatosCliente {
    // Instancia de la clase Scanner para leer datos del usuario
    private static final Scanner scanner = new Scanner(System.in);

    // Métodos para leer los datos del cliente (con validaciones)
    public static int leerDocumento(ClienteServicio clienteServicio) {
        int dni;
        do {
            System.out.print("Ingrese el documento: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido para el documento.");
                scanner.next(); // Consumir la entrada inválida
                System.out.println("Ingrese el documento: ");
            }
            dni = scanner.nextInt();
            scanner.nextLine();

            if (Validaciones.documentoDuplicado(clienteServicio, dni)) {
                System.out.println("Error: El documento ya existe. Ingrese otro documento.");
            }
        } while (Validaciones.documentoDuplicado(clienteServicio, dni));
        return dni;
    }

    // Métodos para leer los datos del cliente (con validaciones)
    public static int leerDocumentoModificar() {
        int dni;

        System.out.print("Ingrese el documento: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Ingrese un número válido para el documento.");
            scanner.next(); // Consumir la entrada inválida
        }
        dni = scanner.nextInt();
        scanner.nextLine();

        return dni;
    }

    public static String leerNombre() { // Método para leer el nombre del cliente
        String nombre; // Variable para almacenar el nombre
        do {
            System.out.print("Ingrese el nombre: ");
            nombre = scanner.nextLine();
            if (!Validaciones.nombreValido(nombre)) {
                System.out.println("Error: El nombre solo puede contener letras.");
            }
        } while (!Validaciones.nombreValido(nombre));
        return nombre;
    }

    public static String leerApellido() { // Método para leer el apellido del cliente
        String apellido;
        do {
            System.out.print("Ingrese el apellido: ");
            apellido = scanner.nextLine();
            if (!Validaciones.apellidoValido(apellido)) {
                System.out.println("Error: El apellido solo puede contener letras.");
            }
        } while (!Validaciones.apellidoValido(apellido));
        return apellido;
    }

    public static String leerEmail() { // Método para leer el email del cliente
        String email;
        do {
            System.out.print("Ingrese el email: ");
            email = scanner.nextLine();
            if (!Validaciones.emailValido(email)) {
                System.out.println("Error: El formato del email es inválido. Ingrese un email válido.");
            }
        } while (!Validaciones.emailValido(email));
        return email;
    }

    // Método para leer la fecha de nacimiento del cliente
    public static String leerFechaNacimiento() {
        String fechaNacimiento;
        do {
            System.out.print("Ingrese la fecha de nacimiento (dd/mm/aaaa): ");
            fechaNacimiento = scanner.nextLine();
            if (!Validaciones.fechaNacimientoValida(fechaNacimiento)) {
                System.out.println(
                        "Error: Formato de fecha inválido o cliente menor de edad. Ingrese una fecha válida (dd/mm/aaaa).");
            }
        } while (!Validaciones.fechaNacimientoValida(fechaNacimiento));
        return fechaNacimiento;
    }

    public static String leerTelefono() { // Método para leer el teléfono del cliente
        String telefono;
        do {
            System.out.print("Ingrese el teléfono: ");
            telefono = scanner.nextLine();
            if (!Validaciones.telefonoValido(telefono)) {
                System.out.println("Error: El formato del teléfono es inválido. Ingrese un teléfono válido.");
            }
        } while (!Validaciones.telefonoValido(telefono));
        return telefono;
    }

    public static String leerDireccion() { // Método para leer la dirección del cliente
        String direccion;
        do {
            System.out.print("Ingrese la dirección: ");
            direccion = scanner.nextLine();
            if (!Validaciones.direccionValida(direccion)) {
                System.out.println("Error: La dirección no puede estar vacía.");
            }
        } while (!Validaciones.direccionValida(direccion));
        return direccion;
    }

    public static String leerCodigoPostal() { // Método para leer el código postal del cliente
        String codigoPostal;
        do {
            System.out.print("Ingrese el código postal: ");
            codigoPostal = scanner.nextLine();
            if (!Validaciones.codigoPostalValido(codigoPostal)) {
                System.out.println("Error: El código postal solo puede contener números.");
            }
        } while (!Validaciones.codigoPostalValido(codigoPostal));
        return codigoPostal;
    }

    public static String leerProvincia() { // Método para leer la provincia del cliente
        String provincia;
        do {
            System.out.print("Ingrese la provincia: ");
            provincia = scanner.nextLine();
            if (!Validaciones.provinciaValida(provincia)) {
                System.out.println("Error: La provincia no puede estar vacía.");
            }
        } while (!Validaciones.provinciaValida(provincia));
        return provincia;
    }

    public static double leerSaldo() { // Método para leer el saldo del cliente
        double saldo;
        do {
            System.out.print("Ingrese el saldo: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Error: Ingrese un número válido para el saldo.");
                scanner.next(); // Consumir la entrada inválida
            }
            saldo = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea

            if (!Validaciones.saldoValido(saldo)) {
                System.out.println("Error: El saldo debe ser mayor o igual a cero.");
            }
        } while (!Validaciones.saldoValido(saldo));
        return saldo;
    }

    public static boolean leerEstado() { // Método para leer el estado del cliente (activo o inactivo)

        boolean activo;
        while (true) {
            System.out.print("¿El cliente está activo? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (respuesta.equals("s")) {
                activo = true;
                break;
            } else if (respuesta.equals("n")) {
                activo = false;
                break;
            } else {
                System.out.println("Error: Ingrese 's' para activo o 'n' para inactivo.");
            }
        }
        return activo;
    }

    public static boolean leerConfirmacion() {
        String respuesta;
        do {
            respuesta = scanner.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s") && !respuesta.equals("n")) {
                System.out.println("Respuesta inválida. Ingrese 's' o 'n'.");
            }
        } while (!respuesta.equals("s") && !respuesta.equals("n"));
        return respuesta.equals("s");
    }

    public static int leerOpcion() { // Método para leer la opción del usuario
        return scanner.nextInt();
    }

    public static void esperarEnter() { // Método para esperar a que el usuario presione Enter para continuar
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }

}
