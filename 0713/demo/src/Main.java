package com.example.demo4;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private TextField num1Field, num2Field, resultField;

    @Override
    public void start(Stage primaryStage) {
        num1Field = new TextField();
        num2Field = new TextField();
        resultField = new TextField();
        resultField.setEditable(false);

        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double result = num1 + num2;
                resultField.setText(String.valueOf(result));
            }
        });

        HBox hbox1 = new HBox(10, num1Field, num2Field);
        HBox hbox2 = new HBox(10, addButton, resultField);
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(10, hbox1, hbox2);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
試試看這一個範例，調整顏色及大小： (來自 chatGPT)

        import javafx.application.Application;
        import javafx.geometry.Insets;
        import javafx.scene.Scene;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.Label;
        import javafx.scene.control.Slider;
        import javafx.scene.layout.VBox;
        import javafx.scene.paint.Color;
        import javafx.scene.text.Font;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;

public class JavaFXApp extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Text text = new Text("Hello, JavaFX!");
        text.setFont(Font.font(20));

        ComboBox<String> colorBox = new ComboBox<>();
        colorBox.getItems().addAll("Black", "Blue", "Red", "Green", "Purple");
        colorBox.setValue("Black");

        colorBox.valueProperty().addListener((obs, oldColor, newColor) -> {
            text.setFill(Color.valueOf(newColor));
        });

        Slider slider = new Slider(10, 100, 20);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(10);

        slider.valueProperty().addListener((obs, oldSize, newSize) -> {
            text.setFont(Font.font(newSize.doubleValue()));
        });

        root.getChildren().addAll(new Label("Select color:"), colorBox, new Label("Select size:"), slider, text);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFX App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


    Another a little complicated example

        package com.example.demo4;
        import javafx.application.Application;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.GridPane;
        import javafx.stage.Stage;

public class HelloApplication extends Application {
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