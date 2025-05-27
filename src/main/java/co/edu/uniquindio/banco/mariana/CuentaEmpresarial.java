package co.edu.uniquindio.banco.mariana;

public class CuentaEmpresarial extends CuentaBancaria{
    private String nombreEmpresa;
    private int limiteMensualTransacciones;

    public CuentaEmpresarial(String numeroCuenta, Cliente propietario, String nombreEmpresa, int limiteTransacciones) {
        super(numeroCuenta, propietario);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteMensualTransacciones = limiteTransacciones;
    }


}
