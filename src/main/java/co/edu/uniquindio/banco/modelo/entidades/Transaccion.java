package co.edu.uniquindio.banco.modelo.entidades;

import co.edu.uniquindio.banco.modelo.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaccion {
    private String id;
    private float monto;
    private LocalDateTime fecha;
    private Categoria tipo;
    private BilleteraVirtual billeteraOrigen, billeteraDestino;
    private float comision;

}
