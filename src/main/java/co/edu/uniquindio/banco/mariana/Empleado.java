package co.edu.uniquindio.banco.mariana;

public abstract class Empleado extends Persona{
    private String codigoEmpleado;
    private String cargo;  // Ejemplo: "Cajero", "Administrador"
    private String contrasena; // Para autenticación interna
    public Empleado(String nombre, String cedula, String correo, String telefono, String direccion,
                    String codigoEmpleado, String cargo, String contrasena) {
        super(nombre, cedula, correo, telefono, direccion);
        this.codigoEmpleado = codigoEmpleado;
        this.cargo = cargo;
        this.contrasena = contrasena;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Empleado: " + getNombre() + " | Cargo: " + cargo;
    }




}
