package com.example.demo2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HelloController {
    @FXML private TextField input;
    @FXML private TextField Outout_v;
    @FXML private TextField Outout_s;

    @FXML public void zaaav2(){
        Stage stage = new Stage();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zav2.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Калькулятор");
            stage.setScene(scene);
            stage.show();
            HelloApplication.a2=stage;
            HelloApplication.a1.close();
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Помилка!");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }
    @FXML public void Calcul(){
        double v,s=0;
        double in=0;
        try{
            in = Double.parseDouble(input.getText());
            v =  Math.pow(in,3);
            s = Math.pow(in,2) *6;
            BigDecimal v1 = new BigDecimal(v);
            v1=v1.setScale(3, RoundingMode.HALF_UP);
            BigDecimal s1 = new BigDecimal(s);
            s1=s1.setScale(3, RoundingMode.HALF_UP);
            Outout_v.setText(String.valueOf(v1));
            Outout_s.setText(String.valueOf(s1));
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Помилка!");
            alert.setHeaderText(null);
            alert.setContentText("Не коректно введені значення!");
            alert.show();
        }

    }
}
