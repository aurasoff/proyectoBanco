package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.Model.BancoU;
import co.edu.uniquindio.banco.Model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;

public class CajeroControlador {
        private Cliente cliente;
        private BancoU banco;


        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnIRaRegistrarCliente;

        @FXML
        private Button btnIrAhacerTransaccion;

        @FXML
        private Button btnIrAingresocomocajero;

        @FXML
        private Button btnIrListaDeclientes;

        @FXML
        void IngresarComoCajero(ActionEvent event) {


        }

        @FXML
        void RegresarAElccion(ActionEvent event) {

        }

        @FXML
        void initialize() {
            assert btnIRaRegistrarCliente != null : "fx:id=\"btnIRaRegistrarCliente\" was not injected: check your FXML file 'Cajero.fxml'.";
            assert btnIrAhacerTransaccion != null : "fx:id=\"btnIrAhacerTransaccion\" was not injected: check your FXML file 'Cajero.fxml'.";
            assert btnIrAingresocomocajero != null : "fx:id=\"btnIrAingresocomocajero\" was not injected: check your FXML file 'Cajero.fxml'.";
            assert btnIrListaDeclientes != null : "fx:id=\"btnIrListaDeclientes\" was not injected: check your FXML file 'Cajero.fxml'.";

        }

        public void registrarc(ActionEvent actionEvent) {
                navegarVentana("/registro.fxml", "Banco - Registrarse");
        }


    public void listac(ActionEvent actionEvent) {
            banco.getListUsuarios();
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

        } catch (IOException e) {
            e.printStackTrace();
        }
}

    public void salir(ActionEvent actionEvent) {
    }

    public void hacerTransaccion(ActionEvent actionEvent) {
        navegarVentana("/transferencia.fxml", "Banco - Registrarse");


    }
}


