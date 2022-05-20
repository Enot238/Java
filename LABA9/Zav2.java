package com.example.demo2;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class Zav2 {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button ButtonO;
    @FXML
    void initialize() {}
    @FXML public void zaaav1(){
        Stage stage = new Stage();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
            HelloApplication.a1=stage;
            HelloApplication.a2.close();
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Помилка!");
            alert.setHeaderText(null);
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }
    @FXML private TextField input;
    @FXML public void CalculatoeYear(){
        String n = new String();
        System.out.println("RABOTAI ");
        int age=0;
        try{
            age = Integer.parseInt(input.getText());
            if(age < 20 || age >= 70){
                throw new Exception();
            }
            else {
                System.out.print(age);
                switch (age) {
                    case 20:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 65:
                    case 67:
                    case 68:
                    case 69:
                        n=("Вам " + String.valueOf(age) + "років");
                        break;
                    case 22:
                    case 23:
                    case 24:
                    case 32:
                    case 33:
                    case 34:
                    case 42:
                    case 43:
                    case 44:
                    case 52:
                    case 53:
                    case 54:
                    case 62:
                    case 63:
                    case 64:
                        n=("Вам " + String.valueOf(age) + "роки");
                        break;
                    case 21:
                    case 31:
                    case 41:
                    case 51:
                    case 61:
                        n=("Вам " + String.valueOf(age) + "рік");
                        break;
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Результат");
                alert.setContentText(n);
                alert.show();
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

