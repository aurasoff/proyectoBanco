package co.edu.uniquindio.banco.Model;

import java.time.LocalDate;

public interface IvalidarDatos {


        boolean validarDatos(String codigo, LocalDate fecha, String monto, String descripcion, TipoTransaccion tipoTransaccion) throws Exception;
    }


