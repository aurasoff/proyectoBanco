package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.mariana.Cajero;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GestionEmpleadoControl {

    @FXML
    private TextField campoNombre;

    @FXML
    private TextField campoCedula;

    @FXML
    private TextField campoCorreo;

    @FXML
    private TextField campoTelefono;

    @FXML
    private TextField campoDireccion;

    @FXML
    private TextField campoCargo;

    @FXML
    private TextField campoContrasena;

    /**
     * Método que se ejecuta cuando se quiere agregar un nuevo empleado.
     * Crea un nuevo objeto Cajero y lo muestra en consola (luego puedes guardarlo en una lista).
     */
    @FXML
    private void agregarEmpleado() {
        Cajero nuevo = new Cajero(
                campoNombre.getText(),
                campoCedula.getText(),
                campoCorreo.getText(),
                campoTelefono.getText(),
                campoDireccion.getText(),
                "EMP-" + campoCedula.getText(),
                campoCargo.getText(),
                campoContrasena.getText()
        );

        // Aquí puedes agregarlo a una lista global o notificar a la interfaz
        System.out.println("✅ Cajero creado: " + nuevo);
    }
}
