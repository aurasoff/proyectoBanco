package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.Model.BancoU;
import co.edu.uniquindio.banco.Model.Cliente;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.stream.Collectors;

public class LoginAdminControlador {


    public Button btnNuevaCuenta;
    public Button btnMostrarReporte;
    public Button btnBuscar;
    public TextField txtNuevoNumCuenta;
    private Banco banco;
    private BancoU bancoU;
    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    public TableView tableClientes;
    @FXML
    private TextField txtbuscar;
    @FXML
    private TextField txtINgreseUsuario;

    @FXML
    private PasswordField txtIngreseContraseña;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRegresar;
    public LoginAdminControlador() {banco = Banco.getInstancia();}

    @FXML
    void IngresarComoCajero(ActionEvent event) {

    }

    @FXML
    void RegresarAElccion(ActionEvent event) {
        System.out.println("Regresando al menú anterior...");
        // Aquí deberías cargar la ventana anterior (por ejemplo, la de selección de rol)
    }
    @FXML
    public void initialize() {

        // Aquí deberías inicializar las columnas y cargar la lista de clientes
        // Suponiendo que ya están configuradas las columnas en el FXML

        // Datos de ejemplo
        listaClientes.addAll(
                new Cliente("123", "Carlos López", "carlos@banco.com","09"),
                new Cliente("456", "María Pérez", "maria@banco.com","89"),
                new Cliente("789", "Juan García", "juan@banco.com","78")
        );

        tableClientes.setItems(listaClientes);
    }

    @FXML
    public void irbuscarc(ActionEvent event) {
        String textoBuscar = txtbuscar.getText().toLowerCase();
        bancoU.buscarCuenta(textoBuscar);
    }

    public void mostrarReporte(ActionEvent actionEvent) {
    }

    public void mostrarNuevaCuenta(ActionEvent actionEvent) {
    }
}
