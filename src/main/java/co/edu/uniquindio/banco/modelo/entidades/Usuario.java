package co.edu.uniquindio.banco.modelo.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
public class Usuario {

    private String id, nombre, direccion, email, password;

}