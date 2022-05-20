package com.example.demo1;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class HelloController {
    @FXML private TextField input;
    @FXML private Label Output;
    @FXML public void call(){
        int n;
        try {
            n = Integer.parseInt(input.getText());
            if (n %2 == 0){
                Output.setText("Число " + n + " є парним ");
            }
            else {
                Output.setText("Число " + n + " є не парним ");
            }
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Помилка");
            alert.setContentText("Не допустиме значення!");
            alert.show();
            return;
        }
    }
}
