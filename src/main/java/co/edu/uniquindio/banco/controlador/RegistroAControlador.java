package co.edu.uniquindio.banco.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import co.edu.uniquindio.banco.Model.BancoU;
import javafx.stage.Stage;


public class RegistroAControlador {
    public Button btnRegistrar;
    public Button btnLimpiar;
    public Button btnEditar;
    public Button btnEliminar;
    public Button btnBuscar;
    public TextField txtIdentificacion;
    public TextField txtNombre;
    public TextField txtCorreo;
    public TextField txtPassword;
    public ComboBox cbCargo;
    private Banco banco;
    private BancoU bancoU;

    public void RegistrarUsuario(ActionEvent actionEvent) {
        try {
            // Se intenta agregar el usuario al banco
            bancoU.registrarUsuario(
                    txtCorreo.getText(),
                    txtNombre.getText(),
                    txtCorreo.getText(),
                    txtPassword.getText()
            );

            // Se muestra un mensaje de éxito y se cierra la ventana
            crearAlerta("Usuario registrado correctamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            navegarVentana("/inicio.fxml", "Banco");
        }catch (Exception e){
            crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void LimpiarUsuario(ActionEvent actionEvent) {
        txtNombre.clear();
        txtCorreo.clear();
        txtPassword.clear();
    }

    public void EditarUsuario(ActionEvent actionEvent) {
    }

    public void EliminarUsuario(ActionEvent actionEvent) {
        bancoU.eliminarUsuario(txtIdentificacion.getText());
    }

    public void BuscarUsuario(ActionEvent actionEvent) {
        bancoU.buscarUsuario(txtIdentificacion.getText());
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
    public void cerrarVentana(){
        Stage stage = (Stage) txtIdentificacion.getScene().getWindow();
        stage.close();
    }
    public void crearAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
