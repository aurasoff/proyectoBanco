package co.edu.uniquindio.banco.mariana;

import java.time.LocalDate;

public interface IValidarDatos {
    boolean validarDatos(String codigo, LocalDate fecha, String monto, String descripcion, TipoTransaccion tipoTransaccion) throws Exception;
}
