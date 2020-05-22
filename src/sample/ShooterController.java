package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ShooterController {
    private static Scanner scanner = new Scanner(System.in);
    private static AutoIncrement autoIncrement = new AutoIncrement();
    private static Service service = new Service();
    @FXML
    public Button ReadyButton;


    @FXML
    public ComboBox ObjectComboBox;



    @FXML
    public TextField NameSpace;

    @FXML
    public TextField IdSpace;

    @FXML
    public TextField ParameterSpace;

    @FXML
    public Label ParameterLabel;

    @FXML
    public Button AddButton;

    @FXML
    public Button DeleteButton;

    @FXML
    public Button ChangeButton;

    @FXML
    public Button SwitchButton;

    public void work(){


        ReadyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ObjectComboBox.valueProperty().set(null);
                ObservableList<String> shooters = FXCollections.observableArrayList();
                List<Shooter> shooters1 = service.getShooter();
                for (Shooter shooter : shooters1){
                    shooters.add(shooter.getName());
                }
                ObjectComboBox.setItems(shooters);

            }
        });

        SwitchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) SwitchButton.getScene().getWindow();
                stage.close();
                Parent root1 = null;
                try {
                    root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Racing");
                stage.setScene(new Scene(root1));
                stage.show();
            }
        });

        AddButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean result = service.setShooter(new Shooter(autoIncrement.autoIncrement(), NameSpace.getText()));
                System.out.println(result);
            }
        });

        DeleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean result = service.delete(new Shooter(Integer.parseInt(IdSpace.getText()), NameSpace.getText()));
                System.out.println(result);
            }
        });

        ChangeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean result = service.changeShooter(new Shooter(Integer.parseInt(IdSpace.getText()), NameSpace.getText()));
                System.out.println(result);

            }
        });
    }

    @FXML
    void initialize() {
        work();


    }
}
