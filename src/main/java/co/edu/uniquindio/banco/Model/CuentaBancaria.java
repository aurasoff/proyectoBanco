package co.edu.uniquindio.banco.Model;

public class CuentaBancaria {

        private String numeroCuenta;
        private double saldo;

        // conexion con otras clases
        private Cliente cliente;

        public CuentaBancaria(String numeroCuenta, double saldo) {
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
        }

        public String getNumeroCuenta() {
            return numeroCuenta;
        }

        public void setNumeroCuenta(String numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        @Override
        public String toString() {
            return "CuentaBancaria: "       +
                    "\n numero de cuenta: " + numeroCuenta +
                    "\n saldo: "            + saldo        +
                    "\n cliente: "          + cliente.getNombre();
        }
    }


