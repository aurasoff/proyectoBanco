package co.edu.uniquindio.banco.mariana;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cajero extends Empleado implements IValidarDatos{

    private List<Transaccion> transaccionesRegistradas;
    private List<Cliente> clientesRegistrados;

    public Cajero(String nombre, String cedula, String correo, String telefono, String direccion, String codigoEmpleado, String cargo, String contrasena) {
        super(nombre,cedula,correo,telefono,direccion, codigoEmpleado, cargo, contrasena);
        this.transaccionesRegistradas = new ArrayList<>();
        this.clientesRegistrados= new ArrayList<>();
    }
    public List<Cliente> getClientesRegistrados(){
        return clientesRegistrados;
    }


    // 1. Registrar cliente
    public Cliente registrarCliente(String nombre, String cedula, String correo, String telefono,
                                    String direccion, CuentaBancaria cuenta) {
        // Verificar si ya existe un cliente con la misma cédula
        for (Cliente c : clientesRegistrados) {
            if (c.getCedula().equals(cedula)) {
                System.out.println("Error: Ya existe un cliente con esa cédula.");
                return null;
            }
        }

        // Si no existe, se crea y se agrega
        Cliente nuevoCliente = new Cliente(nombre, cedula, correo, telefono, direccion);
        nuevoCliente.agregarCuenta(cuenta);
        clientesRegistrados.add(nuevoCliente);
        return nuevoCliente;
    }

    public void depositar(CuentaBancaria cuenta, double monto) {
        cuenta.depositar(monto);
        Transaccion t = new Transaccion(TipoTransaccion.DEPOSITO, cuenta, null, monto);
        transaccionesRegistradas.add(t);
        cuenta.getPropietario().agregarTransaccion(t); // 👈 agregar al cliente
    }

    // 3. Retiro
    public void retirar(CuentaBancaria cuenta, double monto) {
        cuenta.retirar(monto);
        Transaccion t = new Transaccion(TipoTransaccion.RETIRO, cuenta, null, monto);
        transaccionesRegistradas.add(t);
        cuenta.getPropietario().agregarTransaccion(t);
    }

    // 4. Consulta de saldo
    public double consultarSaldo(CuentaBancaria cuenta) {
        return cuenta.getSaldo();
    }

    // 5. Transferencia
    public void transferir(CuentaBancaria origen, CuentaBancaria destino, double monto) {
        origen.retirar(monto);
        destino.depositar(monto);
        Transaccion t = new Transaccion(TipoTransaccion.TRANSFERENCIA, origen, destino, monto);
        transaccionesRegistradas.add(t);
        origen.getPropietario().agregarTransaccion(t);  // cliente origen
        destino.getPropietario().agregarTransaccion(t); // cliente destino
    }

    // 6. Generar reporte de transacciones por cliente
    public void generarReportePorCliente(Cliente cliente) {
        System.out.println("=== Reporte para cliente: " + cliente.getNombre() + " ===");
        for (Transaccion t : transaccionesRegistradas) {
            if (t.getCuentaOrigen().getPropietario().equals(cliente)) {
                System.out.println(t);
            }
        }
    }

    private boolean esNumeroValido(String montoTexto) {
        try {
            Double.parseDouble(montoTexto); // ✅ Usa `Double.parseDouble()` para mayor precisión
            return true;
        } catch (NumberFormatException e) {
            return false; // ❌ Si contiene letras o caracteres inválidos, retorna falso
        }
    }


    @Override
    public boolean validarDatos(String codigo, LocalDate fecha, String monto, String descripcion, TipoTransaccion tipoTransaccion) throws Exception {
        if (!esNumeroValido(monto)) {
            throw new Exception("❌ El monto debe ser un número válido, sin letras ni símbolos.");
        }
        double montoDouble = Double.parseDouble(monto);

        if (codigo == null || codigo.isEmpty()) {
            throw new Exception("❌ El código de la transacción no puede estar vacío.");
        }
        if (montoDouble <= 0) {
            throw new Exception("❌ El monto debe ser mayor a cero.");
        }
        if (fecha == null) {
            throw new Exception("❌ La fecha no puede ser nula.");
        }
        if (tipoTransaccion == null) {
            throw new Exception("❌ Tipo de transacción inválido.");
        }
        return true;
    }

}
