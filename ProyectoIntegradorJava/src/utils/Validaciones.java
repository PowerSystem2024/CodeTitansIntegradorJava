package utils;

import models.Cliente;
import servicios.ClienteServicio;

import java.util.ArrayList; // Importa la clase ArrayList para trabajar con listas
import java.util.regex.Pattern; // Importa la clase Pattern para usar expresiones regulares
import java.util.regex.Matcher; // Importa la clase Matcher para usar expresiones regulares
import java.time.LocalDate; // Importa la clase LocalDate para trabajar con fechas
import java.time.Period; // Importa la clase Period para trabajar con periodos de tiempo
import java.time.format.DateTimeFormatter; // Importa la clase DateTimeFormatter para formatear fechas
import java.time.format.DateTimeParseException; // Importa la clase DateTimeParseException para manejar errores de formato

public class Validaciones {

    // Verifica si un documento ya existe en la base de datos.
    public static boolean documentoDuplicado(ClienteServicio clienteServicio, int dni) {
        ArrayList<Cliente> listaClientes = clienteServicio.getLista();

        for (Cliente cliente : listaClientes) {
            if (cliente.getDni() == dni) {
                return true; // El documento ya existe
            }
        }
        return false; // El documento no existe
    }

    // Verifica si un nombre es válido (solo letras)
    public static boolean nombreValido(String nombre) {
        return nombre.matches("[a-zA-Z]+"); // Expresión regular para verificar que solo contenga letras
    }

    public static boolean apellidoValido(String apellido) {
        return apellido.matches("[a-zA-Z]+"); // Expresión regular para verificar que solo contenga letras
    }

    /**
     * Verifica si un email es válido (formato correcto)
     * Expresión regular para validar el formato del email
     */
    public static boolean emailValido(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Verifica si un teléfono es válido (formato correcto).
     * valida un teléfono de 10 dígitos
     */
    public static boolean telefonoValido(String telefono) {
        String regex = "^\\d{10}$";
        return telefono.matches(regex);
    }

    /**
     * Verifica si una fecha de nacimiento es válida (formato dd/mm/aaaa) y si el
     * cliente es mayor de edad.
     */
    public static boolean fechaNacimientoValida(String fechaNacimiento) {
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        if (!fechaNacimiento.matches(regex)) { // Verifica el formato de la fecha
            return false; // Formato inválido
        }

        try { // Intenta convertir la fecha de nacimiento a LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato de fecha
            // Convierte la fecha de nacimiento a LocalDate
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);
            LocalDate fechaActual = LocalDate.now(); // Obtiene la fecha actual
            Period periodo = Period.between(fechaNac, fechaActual); // Calcula el periodo entre las dos fechas
            int edad = periodo.getYears(); // Obtiene la edad del cliente

            return edad >= 18; // Verifica si es mayor de edad
        } catch (DateTimeParseException e) { // Captura errores de formato
            return false; // Error al convertir la fecha
        }
    }

    // Verifica si un cliente es mayor de edad, en formato dd/mm/aaaa.
    public static boolean esMayorDeEdad(String fechaNacimiento) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato de fecha
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);
            LocalDate fechaActual = LocalDate.now(); // Obtiene la fecha actual

            Period periodo = Period.between(fechaNac, fechaActual); // Calcula el periodo entre las dos fechas
            int edad = periodo.getYears(); // Obtiene la edad del cliente

            return edad >= 18; // Verifica si es mayor de edad
        } catch (DateTimeParseException e) { // Captura errores de formato
            return false; // Error al convertir la fecha
        }
    }

    public static boolean direccionValida(String direccion) {
        return !direccion.isEmpty(); // Verifica que la dirección no esté vacía
    }

    public static boolean codigoPostalValido(String codigoPostal) {
        return codigoPostal.matches("\\d+"); // Verifica que el código postal solo contenga dígitos
    }

    /**
     * Verifica si una provincia es válida (no vacía).
     * true si la provincia es válida, false si no lo es.
     */
    public static boolean provinciaValida(String provincia) {
        return !provincia.isEmpty();
    }

    // Verifica si un saldo es válido (mayor o igual a cero).
    public static boolean saldoValido(double saldo) {
        return saldo >= 0;
    }
}
