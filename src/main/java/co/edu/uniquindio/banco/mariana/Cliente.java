package co.edu.uniquindio.banco.mariana;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    private List<CuentaBancaria> cuentas;
    private List<Transaccion> historialTransacciones; // Nueva lista


    public Cliente(String nombre, String cedula, String correo, String contrasena, String direccion) {
        super(nombre, cedula, correo, contrasena, direccion );
        this.cuentas = new ArrayList<>();
        this.historialTransacciones= new ArrayList<>();
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String getTelefono() {
        return super.getTelefono();
    }

    public void setCuentas(List<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    public void agregarTransaccion(Transaccion transaccion) {
        historialTransacciones.add(transaccion);
    }

    public List<Transaccion> getHistorialTransacciones() {
        return historialTransacciones;
    }



}
