package co.edu.uniquindio.banco.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import co.edu.uniquindio.banco.mariana.CuentaBancaria;

public class ConsultaSaldoControlador {
    @FXML private TextField txtNumeroCuenta;
    @FXML private Text txtResultado;
    @FXML private Button btnConsultar;

    private CuentaBancaria cuenta;

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @FXML
    private void initialize() {
        btnConsultar.setOnAction(e -> consultarSaldo());
    }

    private void consultarSaldo() {
        if (cuenta != null) {
            txtResultado.setText("Saldo actual: $" + cuenta.getSaldo());
        } else {
            txtResultado.setText("Cuenta no encontrada.");
        }
    }
}

