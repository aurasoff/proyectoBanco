package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.Sesion;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;



public class ActualizarControlador implements Initializable {
    private Banco banco;
    private Sesion sesion;

    @FXML // fx:id="btnactualizar"
    private Button btnactualizar; // Value injected by FXMLLoader

    @FXML // fx:id="btnvolver"
    private Button btnvolver; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorreo"
    private TextField txtCorreo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDireccion"
    private TextField txtDireccion; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdentificacion"
    private TextField txtIdentificacion; // Value injected by FXMLLoader

    @FXML // fx:id="txtNombre"
    private TextField txtNombre; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassword"
    private PasswordField txtPassword; // Value injected by FXMLLoader

    public ActualizarControlador() {
        banco = Banco.getInstancia();
        sesion = Sesion.getInstance();
    }

    @FXML
    void ActualizarAction(ActionEvent event) {
        try{
            banco.ActualizarUsuario(
                    sesion.getUsuario(),
                    txtIdentificacion.getText(),
                    txtNombre.getText(),
                    txtDireccion.getText(),
                    txtCorreo.getText(),
                    txtPassword.getText());
            crearAlerta("Datos actualizados correctamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            navegarVentana("/panelCliente.fxml", "Banco - Panel de transferencias");
        }catch (Exception e){
            crearAlerta(e.getMessage(),Alert.AlertType.ERROR);
        }
    }

    @FXML
    void VolverAction(ActionEvent event) {
        cerrarVentana();
        navegarVentana("/panelCliente.fxml", "Banco - Panel de transferencias");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtNombre.setText(sesion.getUsuario().getNombre());
        txtIdentificacion.setText(sesion.getUsuario().getId());
        txtDireccion.setText(sesion.getUsuario().getDireccion());
        txtPassword.setText(sesion.getUsuario().getPassword());
        txtCorreo.setText(sesion.getUsuario().getEmail());
    }


    public void crearAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void cerrarVentana(){
        Stage stage = (Stage) txtIdentificacion.getScene().getWindow();
        stage.close();
    }


    public void navegarVentana(String nombreArchivoFxml, String tituloVentana) {
        try {


            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent root = loader.load();


            Scene scene = new Scene(root);


            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(tituloVentana);


            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

