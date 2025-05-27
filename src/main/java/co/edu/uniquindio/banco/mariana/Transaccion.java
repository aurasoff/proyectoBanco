package co.edu.uniquindio.banco.mariana;

import java.time.LocalDateTime;

public class Transaccion {

        private TipoTransaccion tipoTransaccion; // depósito, retiro, transferencia
        private CuentaBancaria cuentaOrigen;
        private CuentaBancaria cuentaDestino;
        private double monto;
        private LocalDateTime fecha;

        public Transaccion(TipoTransaccion tipoTransaccion, CuentaBancaria origen, CuentaBancaria destino, double monto) {
            this.tipoTransaccion = tipoTransaccion;
            this.cuentaOrigen = origen;
            this.cuentaDestino = destino;
            this.monto = monto;
            this.fecha = LocalDateTime.now();
        }

        public CuentaBancaria getCuentaOrigen() {
            return cuentaOrigen;
        }

        public TipoTransaccion getTipoTransaccion() {
            return tipoTransaccion;
        }

        public CuentaBancaria getCuentaDestino() {
            return cuentaDestino;
        }

        public double getMonto() {
            return monto;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public String toString() {
            return tipoTransaccion + " - Monto: $" + monto + " - Fecha: " + fecha;
        }
    }


