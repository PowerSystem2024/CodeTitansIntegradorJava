package models;

public class Cliente {

    // atributos
    private int dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String fechaNacimiento;
    private String direccion;
    private String codigoPostal;
    private String provincia;
    private double saldo;
    private boolean activo;

    // Constructor de la clase Cliente
    public Cliente(int dni, String nombre, String apellido, String email, String telefono, String direccion,
            String codigoPostal, String provincia, double saldo, boolean activo, String fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.saldo = saldo;
        this.activo = activo;
    }

    // Getters y Setters

    public int getDni() {
        return dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente(DNI: ").append(dni);
        sb.append(", Nombre: '").append(nombre);
        sb.append("', Apellido: '").append(apellido);
        sb.append("', Email: '").append(email);
        sb.append("', Telefono: ").append(telefono);
        sb.append(", Codigo Postal: ").append(codigoPostal);
        sb.append(", Provincia: '").append(provincia);
        sb.append("', Saldo: ").append(saldo);
        sb.append(", Activo: '").append(activo);
        sb.append("', Fecha de Nacimiento: ").append(fechaNacimiento);
        sb.append(")");
        return sb.toString();
    }
}
