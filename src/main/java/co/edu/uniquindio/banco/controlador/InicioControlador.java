package co.edu.uniquindio.banco.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**

 */
public class InicioControlador {


    @FXML
    public Button btnregistraru;
    @FXML
    private Button btniniciarsesion;

    @FXML
    private Button btnregistrarse;


    public void irIniciarSesion(ActionEvent actionEvent) {
        navegarVentana("/EleccionUsuario.fxml", "Banco - Iniciar Sesión");
        cerrarVentana();
    }


    public void irRegistroCliente(ActionEvent actionEvent) {
        navegarVentana("/registro.fxml", "Banco - Registro de Cliente");
        cerrarVentana();
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
        Stage stage = (Stage) btnregistraru.getScene().getWindow();
        stage.close();
    }


}