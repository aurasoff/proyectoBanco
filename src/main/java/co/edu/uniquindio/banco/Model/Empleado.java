package co.edu.uniquindio.banco.Model;
import javafx.beans.property.*;
public class Empleado {
        private final IntegerProperty id;
        private final StringProperty nombre;
        private final StringProperty puesto;

        public Empleado(int id, String nombre, String puesto) {
            this.id = new SimpleIntegerProperty(id);
            this.nombre = new SimpleStringProperty(nombre);
            this.puesto = new SimpleStringProperty(puesto);
        }

        public int getId() {
            return id.get();
        }

        public IntegerProperty idProperty() {
            return id;
        }

        public String getNombre() {
            return nombre.get();
        }

        public StringProperty nombreProperty() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre.set(nombre);
        }

        public String getPuesto() {
            return puesto.get();
        }

        public StringProperty puestoProperty() {
            return puesto;
        }

        public void setPuesto(String puesto) {
            this.puesto.set(puesto);
        }
    }

