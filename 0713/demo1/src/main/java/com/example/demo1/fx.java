package com.example.demo1;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class fx extends Application {
    private TextField display;
    private double num1, num2;
    private String operator;

    @Override
    public void start(Stage primaryStage) {
        display = new TextField();
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        String[] names = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String name = names[i * 4 + j];
                Button button = new Button(name);
                button.setMinSize(50, 50);
                button.setOnAction(event -> process(name));
                grid.add(button, j, i);
            }
        }

        grid.add(display, 0, 4, 4, 1);

        Scene scene = new Scene(grid, 250, 250);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void process(String value) {
        switch (value) {
            case "+":
            case "-":
            case "*":
            case "/":
                operator = value;
                num1 = Double.parseDouble(display.getText());
                display.clear();
                break;
            case "=":
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case "+": display.setText(String.valueOf(num1 + num2)); break;
                    case "-": display.setText(String.valueOf(num1 - num2)); break;
                    case "*": display.setText(String.valueOf(num1 * num2)); break;
                    case "/": display.setText(String.valueOf(num1 / num2)); break;
                }
                operator = null;
                break;
            default:
                display.appendText(value);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}