package co.edu.uniquindio.banco.mariana;

public class CuentaAhorro extends CuentaBancaria {
    private double tasaInteres;

    public CuentaAhorro(String numeroCuenta, Cliente propietario, double tasaInteres) {
        super(numeroCuenta, propietario);
        this.tasaInteres = tasaInteres;
    }
}
