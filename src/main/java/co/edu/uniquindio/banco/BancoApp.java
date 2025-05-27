package co.edu.uniquindio.banco;

import co.edu.uniquindio.banco.modelo.entidades.Banco;
import co.edu.uniquindio.banco.modelo.entidades.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BancoApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        cargarDatos();
        FXMLLoader loader = new FXMLLoader(BancoApp.class.getResource("/inicio.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Banco");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(BancoApp.class, args);
    }

    private void cargarDatos() throws Exception {
        Banco banco = Banco.getInstancia();
        banco.registrarUsuario("1091203010","Brandon","Calarca", "brandonValencia@gmail.com", "1234");
        banco.registrarUsuario("012345678","Paco","Por ahí por un monte", "paco@gmail.com", "4321");
        banco.recargarBilletera(banco.buscarBilleteraUsuario("1091203010").getNumero(),500000);
        banco.recargarBilletera(banco.buscarBilleteraUsuario("012345678").getNumero(),1000000);
    }

}
