package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.entidades.Banco;
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

/**
 * Clase que representa el controlador de la ventana de registro de usuario
 * @author caflorezvi
 */
public class RegistroControlador {

    @FXML
    private TextField txtIdentificacion;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtDireccion;
    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnvolver;

    private final Banco banco;

    /**
     * Constructor de la clase, inicializa el banco
     */
    public RegistroControlador(){
        banco = Banco.getInstancia();
    }

    /**
     * Método que se ejecuta al presionar el botón de registrarse
     * @param actionEvent evento de acción
     */
    public void registrarse(ActionEvent actionEvent) {

        try {
            // Se intenta agregar el usuario al banco
            banco.registrarUsuario(
                    txtIdentificacion.getText(),
                    txtNombre.getText(),
                    txtDireccion.getText(),
                    txtCorreo.getText(),
                    txtPassword.getText() );

            // Se muestra un mensaje de éxito y se cierra la ventana
            crearAlerta("Usuario registrado correctamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            navegarVentana("/inicio.fxml", "Banco");
        }catch (Exception e){
            crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    @FXML
    void VolverAction(ActionEvent event) {
        cerrarVentana();
        navegarVentana("/inicio.fxml", "Banco");
    }

    /**
     * Método que se encarga de mostrar una alerta en pantalla
     * @param mensaje mensaje a mostrar
     * @param tipo tipo de alerta
     */
    public void crearAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    /**
     * Método que se encarga de cerrar la ventana actual
     */
    public void cerrarVentana(){
        Stage stage = (Stage) txtIdentificacion.getScene().getWindow();
        stage.close();
    }

    /**
     * Método que permite ir a la venana indicada por el nombre del archivo FXML
     * @param nombreArchivoFxml Nombre del archivo FXML
     * @param tituloVentana Título de la ventana
     */
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
}
