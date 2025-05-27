package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.mariana.Banco;
import co.edu.uniquindio.banco.Model.Cliente;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaClientesControlador {

    private Banco banco; // Referencia al banco, se debe establecer desde fuera
    private ObservableList<Cliente> listaClientes;
    private Cliente cliente;

    @FXML
    private TableView<Cliente> tablaClientes;

    @FXML
    private TableColumn<Cliente, String> columnaNombre;

    @FXML
    private TableColumn<Cliente, String> columnaCedula;

    @FXML
    private TableColumn<Cliente, String> columnaCorreo;

    @FXML
    private TableColumn<Cliente, String> columnaTelefono;

    public void initialize() {
        // Inicializa las columnas de la tabla
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    }

    /**
     * Método que debe ser llamado desde el exterior para inyectar la instancia del banco.
     */
    public void setBanco(Banco banco) {
        this.banco = banco;
        cargarClientes();
    }

    private void cargarClientes() {;
        }
    }


