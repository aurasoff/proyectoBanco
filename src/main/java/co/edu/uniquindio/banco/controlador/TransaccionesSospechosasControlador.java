package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.mariana.Administrador;
import co.edu.uniquindio.banco.mariana.Transaccion;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class TransaccionesSospechosasControlador {

    @FXML
    private ListView<String> listaSospechosas;

    public void inicializar(Administrador admin, List<Transaccion> transacciones) {
        listaSospechosas.getItems().clear();

        for (Transaccion t : transacciones) {
            if (t.getMonto() > 10000) {
                listaSospechosas.getItems().add("⚠️ " + t.toString());
            }
        }
    }
}

