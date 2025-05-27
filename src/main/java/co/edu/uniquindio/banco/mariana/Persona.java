package co.edu.uniquindio.banco.mariana;

public abstract class Persona {
    //Atributos
    protected String nombre;
    protected String cedula;
    protected String correo;
    protected String telefono;
    protected  String direccion;


    //Constructor
    public Persona(String nombre, String cedula, String correo, String telefono, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
}

