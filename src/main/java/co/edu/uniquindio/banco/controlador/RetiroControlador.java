package co.edu.uniquindio.banco.controlador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import co.edu.uniquindio.banco.mariana.CuentaBancaria;

public class RetiroControlador {
    @FXML private TextField txtNumeroCuenta;
    @FXML private TextField txtMonto;
    @FXML private Text mensaje;
    @FXML private Button btnRetirar;

    private CuentaBancaria cuenta;

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @FXML
    private void initialize() {
        btnRetirar.setOnAction(e -> realizarRetiro());
    }

    private void realizarRetiro() {
        try {
            double monto = Double.parseDouble(txtMonto.getText());
            if (cuenta != null) {
                double saldoAntes = cuenta.getSaldo();
                cuenta.retirar(monto);
                if (cuenta.getSaldo() < saldoAntes) {
                    mensaje.setText("Retiro exitoso. Nuevo saldo: $" + cuenta.getSaldo());
                } else {
                    mensaje.setText("No se pudo realizar el retiro. Verifica el saldo o monto.");
                }
            } else {
                mensaje.setText("Cuenta no encontrada.");
            }
        } catch (NumberFormatException ex) {
            mensaje.setText("Monto inválido");
        }
    }
}



