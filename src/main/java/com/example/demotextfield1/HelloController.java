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
        texto1.addEventFilter(KeyEvent.KEY_TYPED, event -> label1.setText("Tecla presionada: " + event.getCharacter()));
        texto2.addEventFilter(KeyEvent.KEY_TYPED, event -> label2.setText("Tecla presionada: " + event.getCharacter()));
        texto3.addEventFilter(KeyEvent.KEY_TYPED, event -> label3.setText("Tecla presionada: " + event.getCharacter()));

        // Acción del botón Enviar
        botonEnviar.setOnAction(event -> enviarInformacion());

        // Acción del botón Borrar
        botonBorrar.setOnAction(event -> borrarInformacion());

        // Acción del botón Edad Random
        botonEdad.setOnAction(event -> generarEdadRandom());

        // Eventos adicionales
        addExtraEvents();
    }

    // Método para enviar información
    private void enviarInformacion() {
        label4.setText("La información se ha enviado correctamente");
    }

    // Método para borrar información
    private void borrarInformacion() {
        texto1.clear();
        texto2.clear();
        texto3.clear();

        label1.setText("Tecla presionada: ");
        label2.setText("Tecla presionada: ");
        label3.setText("Tecla presionada: ");
        label4.setText("Información borrada correctamente");
    }

    // Método para generar una edad random entre 0 y 100
    private void generarEdadRandom() {
        Random random = new Random();
        int edadRandom = random.nextInt(101); // Genera un número entre 0 y 100
        texto3.setText(String.valueOf(edadRandom));
    }

    private void mostrarTeclaPresionada(KeyEvent event, Label label) {
        // Muestra la tecla presionada en el label correspondiente
        label.setText("Tecla presionada: " + event.getCharacter());
    }

    // Método para agregar eventos adicionales
    private void addExtraEvents() {
        // Evento de enfoque en texto1 (nombre) que cambia el estilo si está vacío
        texto1.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && texto1.getText().trim().isEmpty()) {
                texto1.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
                label1.setText("El campo nombre no puede estar vacío");
            } else {
                texto1.setStyle("");
                label1.setText("");
            }
        });

        // Evento de restricción de longitud máxima (30 caracteres) en texto1 (nombre)
        texto1.textProperty().addListener((obs, oldText, newText) -> {
            if (newText.length() > 30) {
                texto1.setText(newText.substring(0, 30));
                label1.setText("El nombre no puede tener más de 30 caracteres");
            }
        });

        // Evento de validación para que el nombre comience con mayúscula
        texto1.textProperty().addListener((obs, oldText, newText) -> {
            if (!newText.isEmpty() && !Character.isUpperCase(newText.charAt(0))) {
                label1.setText("El nombre debe comenzar con una letra mayúscula");
            } else {
                label1.setText("");
            }
        });

        // Evento de validación para que los apellidos comiencen con mayúscula
        texto2.textProperty().addListener((obs, oldText, newText) -> {
            if (!newText.isEmpty() && !Character.isUpperCase(newText.charAt(0))) {
                label2.setText("Los apellidos deben comenzar con una letra mayúscula");
            } else {
                label2.setText("");
            }
        });

        // Evento de doble clic en texto1 para seleccionar todo el texto
        texto1.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                texto1.selectAll(); // Selecciona todo el texto al hacer doble clic
                label1.setText("Texto seleccionado: " + texto1.getText());
            }
        });

        // Evento de enfoque en texto3 (edad) para validar si el campo está vacío
        texto3.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && texto3.getText().trim().isEmpty()) {
                texto3.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
                label3.setText("El campo edad no puede estar vacío");
            } else {
                texto3.setStyle("");
                label3.setText("");
            }
        });
    }
}