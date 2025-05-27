package co.edu.uniquindio.banco.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class EleccionControlador {



        @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="btnAdmin"
        private Button btnAdmin;// Value injected by FXMLLoader

        @FXML // fx:id="btnCajero"
        private Button btnCajero; // Value injected by FXMLLoader

        @FXML // fx:id="btnCliente"
        private Button btnCliente;






        @FXML
        void IrAAdmin(ActionEvent event) {
                navegarVentana("/IngresoAdmnin.fxml", "Banco - Iniciar Sesión Administrador");
        }

        @FXML
        void IrACaejro(ActionEvent event) {
                navegarVentana("/IngresoCajero.fxml", "Banco - Iniciar Sesión Administrador");




}

        @FXML
        void irACLiente(ActionEvent event) {
                navegarVentana("/login.fxml", "Banco - Iniciar Sesión Administrador");


        }

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert btnAdmin != null : "fx:id=\"btnAdmin\" was not injected: check your FXML file 'EleccionUsuario.fxml'.";
            assert btnCajero != null : "fx:id=\"btnCajero\" was not injected: check your FXML file 'EleccionUsuario.fxml'.";
            assert btnCliente != null : "fx:id=\"btnCliente\" was not injected: check your FXML file 'EleccionUsuario.fxml'.";

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



    }


