package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.mariana.Administrador;
import co.edu.uniquindio.banco.mariana.Reporte;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GenerarReporteControlador {

    @FXML
    private TextField campoTitulo, campoTipo;

    @FXML
    private TextArea areaContenido;

    @FXML
    private ListView<String> listaReportes;

    private Administrador administrador;

    public void inicializar(Administrador admin) {
        this.administrador = admin;
        actualizarLista();
    }

    @FXML
    private void generarReporte() {
        String tipo = campoTipo.getText();
        String contenido = areaContenido.getText();
        String titulo = campoTitulo.getText();

        Reporte nuevo = administrador.generarReporte(tipo, contenido, titulo);
        listaReportes.getItems().add(nuevo.getTitulo() + " - " + nuevo.getTipo());
    }

    private void actualizarLista() {
        listaReportes.setItems(FXCollections.observableArrayList(
                administrador.getReportesGenerados().stream().map(r -> r.getTitulo() + " - " + r.getTipo()).toList()
        ));
    }
}

