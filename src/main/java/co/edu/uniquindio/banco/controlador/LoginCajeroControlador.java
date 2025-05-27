package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.Sesion;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import co.edu.uniquindio.banco.modelo.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginCajeroControlador {


    @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="btn"
        private Button btn; // Value injected by FXMLLoader

        @FXML // fx:id="btnRegresar"
        private Button btnRegresar; // Value injected by FXMLLoader

        @FXML // fx:id="txtINgreseUsuario"
        private TextField txtINgreseUsuario; // Value injected by FXMLLoader

        @FXML // fx:id="txtIngreseCigoUnico"
        private PasswordField txtIngreseCigoUnico; // Value injected by FXMLLoader

        @FXML // fx:id="txtIngreseContraceña"
        private PasswordField txtIngreseContraseña; // Value injected by FXMLLoader
    public Banco banco;

    @FXML
        void IngresarComoCajero(ActionEvent event) {
            String usuario = txtINgreseUsuario.getText();
            String contrasena = txtIngreseContraseña.getText();

            if (usuario.equals("bank") && contrasena.equals("12")) {
                navegarVentana("/Cajero.fxml", "Banco - Iniciar Sesión");
            } else {
                mostrarAlerta("Error de autenticación", "Usuario o contraseña incorrectos.");
            }
        }
    public void crearAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }




    @FXML
        void RegresarAElccion(ActionEvent event) {
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

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
            assert btnRegresar != null : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
            assert txtINgreseUsuario != null : "fx:id=\"txtINgreseUsuario\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
            assert txtIngreseCigoUnico != null : "fx:id=\"txtIngreseCigoUnico\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";
            assert txtIngreseContraseña != null : "fx:id=\"txtIngreseContraceña\" was not injected: check your FXML file 'IngresoDeCajero.fxml'.";

        }
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

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Método que se encarga de cerrar la ventana actual
     */
    public void cerrarVentana(){
        Stage stage = (Stage) btnRegresar.getScene().getWindow();
        stage.close();
    }


    }



