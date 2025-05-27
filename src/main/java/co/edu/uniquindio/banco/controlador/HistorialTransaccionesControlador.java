package co.edu.uniquindio.banco.controlador;
import co.edu.uniquindio.banco.mariana.Transaccion;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import co.edu.uniquindio.banco.mariana.Transaccion;

import java.util.List;


public class HistorialTransaccionesControlador {
    private Transaccion transaccion;
    @FXML
    private TableView<Transaccion> tablaTransacciones;

    @FXML
    private TableColumn<Transaccion, String> tipoColumna;

    @FXML
    private TableColumn<Transaccion, String> cuentaColumna;

    @FXML
    private TableColumn<Transaccion, Double> montoColumna;

    @FXML
    private TableColumn<Transaccion, String> fechaColumna;

    @FXML
    private Button salirBtn;

    private List<Transaccion> listaTransacciones;

    public void inicializarTransacciones(List<Transaccion> transacciones) {
        this.listaTransacciones = transacciones;
        tablaTransacciones.getItems().setAll(transacciones);
    }

    @FXML
    public void initialize() {
        tipoColumna.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        cuentaColumna.setCellValueFactory(new PropertyValueFactory<>("numeroCuenta"));
        montoColumna.setCellValueFactory(new PropertyValueFactory<>("monto"));
        fechaColumna.setCellValueFactory(new PropertyValueFactory<>("fecha"));
    }

    @FXML
    void salir(MouseEvent event) {
        Stage stage = (Stage) salirBtn.getScene().getWindow();
        stage.close();
    }


}
