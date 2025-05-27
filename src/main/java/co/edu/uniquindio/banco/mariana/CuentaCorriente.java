package co.edu.uniquindio.banco.mariana;

public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;

    public CuentaCorriente(String numeroCuenta, Cliente propietario, double limiteSobregiro) {
        super(numeroCuenta, propietario);
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && (saldo + limiteSobregiro) >= monto && activa) {
            saldo -= monto;
        }
    }


}
