package co.edu.uniquindio.banco.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminControlador {

    @FXML
    public Button btnIngresar;
    @FXML
    public Button btnRegresar;
    @FXML
    private TextField txtINgreseUsuario;

    @FXML
    private PasswordField txtIngreseContraseña;


    @FXML
    void RegresarAElccion(ActionEvent event) {
        navegarVentana("/inicio.fxml", "Banco");
        cerrarVentana();

    }


    @FXML
    void IngresarComoCajero(ActionEvent event) {
        String usuario = txtINgreseUsuario.getText();
        String contrasena = txtIngreseContraseña.getText();

        if (usuario.equals("admin") && contrasena.equals("admin123"))
            navegarVentana("/loginAdmin.fxml", "Banco - Iniciar Sesión");
        else {
            mostrarAlerta("Error de autenticación", "Usuario o contraseña incorrectos.");
        }
    }
    @FXML
    public void navegarVentana(String nombreArchivoFxml, String tituloVentana) {

        try {
            // Cargar la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent root = loader.load();

            // Crear la escena
            Scene scene = new Scene(root);

            // Crear un nuevo escenario (ventana)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(tituloVentana);

            // Mostrar la nueva ventana
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cerrarVentana(){
        Stage stage = (Stage) btnRegresar.getScene().getWindow();
        stage.close();
    }


    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

