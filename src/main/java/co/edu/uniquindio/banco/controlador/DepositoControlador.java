package co.edu.uniquindio.banco.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import co.edu.uniquindio.banco.mariana.CuentaBancaria;

public class DepositoControlador {
    @FXML private TextField txtNumeroCuenta;
    @FXML private TextField txtMonto;
    @FXML private Text mensaje;
    @FXML private Button btnDepositar;

    private CuentaBancaria cuenta;

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @FXML
    private void initialize() {
        btnDepositar.setOnAction(e -> realizarDeposito());
    }

    private void realizarDeposito() {
        try {
            double monto = Double.parseDouble(txtMonto.getText());
            if (cuenta != null) {
                cuenta.depositar(monto);
                mensaje.setText("Depósito exitoso. Nuevo saldo: $" + cuenta.getSaldo());
            } else {
                mensaje.setText("Cuenta no encontrada.");
            }
        } catch (NumberFormatException ex) {
            mensaje.setText("Monto inválido");
        }
    }
}


