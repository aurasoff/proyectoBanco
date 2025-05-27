package co.edu.uniquindio.banco.mariana;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Banco {
    private String nombre;
    private String nit;
    private String direccion;

    private List<Persona> personas;
    private List<CuentaBancaria> cuentas;
    private List<Transaccion> transacciones;
    private List<Reporte> reportes;

    public Banco(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.personas = new ArrayList<>();
        this.cuentas = new ArrayList<>();
        this.transacciones = new ArrayList<>();
        this.reportes = new ArrayList<>();
    }

    // Getters básicos
    public String getNombre() { return nombre; }
    public String getNit() { return nit; }
    public String getDireccion() { return direccion; }
    public List<Persona> getPersonas() { return personas; }
    public List<CuentaBancaria> getCuentas() { return cuentas; }
    public List<Transaccion> getTransacciones() { return transacciones; }
    public List<Reporte> getReportes() { return reportes; }

    // Registro y búsqueda de personas
    public void registrarPersona(Persona persona) throws Exception {
        if (persona.getCedula() == null || persona.getCedula().isEmpty()) {
            throw new Exception("La cédula es obligatoria");
        }
        if (persona.getNombre() == null || persona.getNombre().isEmpty()) {
            throw new Exception("El nombre es obligatorio");
        }
        if (persona.getDireccion() == null || persona.getDireccion().isEmpty()) {
            throw new Exception("La dirección es obligatoria");
        }
        if (persona.getCorreo() == null || persona.getCorreo().isEmpty()) {
            throw new Exception("El correo es obligatorio");
        }
        if (buscarPersona(persona.getCedula()) != null) {
            throw new Exception("Ya existe una persona con esa cédula");
        }
        personas.add(persona);
    }

    public Persona buscarPersona(String cedula) {
        return personas.stream()
                .filter(p -> p.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    public <T extends Persona> T buscarPersonaPorTipo(String cedula, Class<T> tipo) {
        for (Persona p : personas) {
            if (p.getCedula().equals(cedula) && tipo.isInstance(p)) {
                return tipo.cast(p);
            }
        }
        return null;
    }

    // Obtener lista de clientes
    public List<Cliente> getClientes() {
        return personas.stream()
                .filter(p -> p instanceof Cliente)
                .map(p -> (Cliente) p)
                .collect(Collectors.toList());
    }

    public List<Empleado> getEmpleados() {
        return personas.stream()
                .filter(p -> p instanceof Empleado)
                .map(p -> (Empleado) p)
                .collect(Collectors.toList());
    }

    public List<Administrador> getAdministradores() {
        return personas.stream()
                .filter(p -> p instanceof Administrador)
                .map(p -> (Administrador) p)
                .collect(Collectors.toList());
    }

    public List<Cajero> getCajeros() {
        return personas.stream()
                .filter(p -> p instanceof Cajero)
                .map(p -> (Cajero) p)
                .collect(Collectors.toList());
    }

    // Actualizar o eliminar personas
    public boolean actualizarPersona(String cedula, Persona datosActualizados) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(cedula)) {
                personas.set(i, datosActualizados);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPersona(String cedula) {
        return personas.removeIf(p -> p.getCedula().equals(cedula));
    }

    // Manejo de cuentas
    public void agregarCuenta(CuentaBancaria cuenta) {
        if (cuenta != null && cuenta.getNumeroCuenta() != null && !cuenta.getNumeroCuenta().isEmpty()) {
            if (!cuentas.contains(cuenta)) {
                cuentas.add(cuenta);
            }
        }
    }

    public Optional<CuentaBancaria> buscarCuenta(String numCuentaBancaria) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numCuentaBancaria))
                .findFirst();
    }

    public Cliente buscarClientePorCuenta(String numeroCuenta) {
        Optional<CuentaBancaria> cuentaOpt = buscarCuenta(numeroCuenta);
        if (cuentaOpt.isPresent()) {
            CuentaBancaria cuenta = cuentaOpt.get();
            String cedulaTitular = cuenta.getNumeroCuenta();  // Debe existir este método en CuentaBancaria
            return buscarPersonaPorTipo(cedulaTitular, Cliente.class);
        }
        return null;
    }

    // Transacciones
    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    // Reportes
    public void agregarReporte(Reporte reporte) {
        reportes.add(reporte);
    }

    public Reporte buscarReporte(String titulo) {
        for (Reporte reporte : reportes) {
            if (reporte.getTitulo().equals(titulo)) {
                return reporte;
            }
        }
        return null;
    }
}
