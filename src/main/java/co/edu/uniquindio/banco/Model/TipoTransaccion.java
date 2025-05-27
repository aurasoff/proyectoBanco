package co.edu.uniquindio.banco.Model;

public enum TipoTransaccion {


        DEPOSITO(0),
        RETIRO(1),
        TRANSFERENCIA(2);

        private final int valor;

        TipoTransaccion(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }


