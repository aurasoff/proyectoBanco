package co.edu.uniquindio.banco.mariana;

import java.time.LocalDate;

public abstract class CuentaBancaria {
    protected String numeroCuenta;
    protected double saldo;
    protected
    Cliente propietario;
    protected LocalDate fechaCreacion;
    protected boolean activa;

    public CuentaBancaria(String numeroCuenta, Cliente propietario) {
        this.numeroCuenta = numeroCuenta;
        this.propietario = propietario;
        this.saldo = 0.0;
        this.fechaCreacion = LocalDate.now();
        this.activa = true;
    }

    public void depositar(double monto) {
        if (monto > 0 && activa) {
            saldo += monto;
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo && activa) {
            saldo -= monto;
        }
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}



