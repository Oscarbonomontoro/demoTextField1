package com.example.demotextfield1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class HelloController {

    @FXML
    private Label label4;
    @FXML
    private TextField texto1;
    @FXML
    private TextField texto3;
    @FXML
    private Button botonEdad;
    @FXML
    private Button botonEnviar;
    @FXML
    private TextField texto2;
    @FXML
    private Button botonBorrar;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;

    @FXML
    public void initialize() {
        // Texto por defecto en los TextField
        texto1.setPromptText("Introduce tu nombre");
        texto2.setPromptText("Introduce tus apellidos");
        texto3.setPromptText("Introduce tu edad");

        // Eventos para mostrar teclas presionadas
        texto1.addEventFilter(KeyEvent.KEY_PRESSED, event -> label1.setText("Tecla presionada: " + event.getText()));
        texto2.addEventFilter(KeyEvent.KEY_PRESSED, event -> label2.setText("Tecla presionada: " + event.getText()));
        texto3.addEventFilter(KeyEvent.KEY_PRESSED, event -> label3.setText("Tecla presionada: " + event.getText()));

        // Acción del botón Enviar
        botonEnviar.setOnAction(event -> enviarInformacion());

        // Acción del botón Borrar
        botonBorrar.setOnAction(event -> borrarInformacion());

        // Acción del botón Edad Random
        botonEdad.setOnAction(event -> generarEdadRandom());
    }

    // Método para enviar información
    private void enviarInformacion() {
        // Muestra mensaje de envío en label4
        label4.setText("La información se ha enviado correctamente");
    }

    // Método para borrar información
    private void borrarInformacion() {
        // Limpia los campos de texto
        texto1.clear();
        texto2.clear();
        texto3.clear();

        // Limpia las etiquetas de teclas presionadas
        label1.setText("Tecla presionada: ");
        label2.setText("Tecla presionada: ");
        label3.setText("Tecla presionada: ");

        // Muestra mensaje de borrado en label4
        label4.setText("Información borrada correctamente");
    }

    // Método para generar una edad random entre 0 y 100
    private void generarEdadRandom() {
        Random random = new Random();
        int edadRandom = random.nextInt(101); // Genera un número entre 0 y 100
        texto3.setText(String.valueOf(edadRandom));
    }
}