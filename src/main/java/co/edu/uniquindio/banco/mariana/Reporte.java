package co.edu.uniquindio.banco.mariana;

import java.time.LocalDateTime;

public class Reporte {
    private String tipo; // Ej: "Transacciones", "Usuarios", "Operaciones sospechosas"
    private String contenido; // Texto con el resumen o análisis
    private LocalDateTime fechaGeneracion;
    private Administrador generadoPor;
    private String titulo;

    public Reporte(String tipo, String contenido, Administrador generadoPor, String titulo) {
        this.tipo = tipo;
        this.contenido = contenido;
        this.fechaGeneracion = LocalDateTime.now();
        this.generadoPor = generadoPor;
        this.titulo= titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public Administrador getGeneradoPor() {
        return generadoPor;
    }

    @Override
    public String toString() {
        return "Reporte [" + tipo + "] generado el " + fechaGeneracion + " por " + generadoPor.getNombre() + ":\n" +
                contenido;
    }

}



