package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
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
import java.util.Scanner;

public class MainController {

    private static Scanner scanner = new Scanner(System.in);
    private static AutoIncrement autoIncrement = new AutoIncrement();
    private static ObjectEditingService service = new ObjectEditingService();
    final FileChooser fileChooser = new FileChooser();

    ObservableList<String> types = FXCollections.observableArrayList("Shooter","Indie","Racing", "Fighting", "Stealth");

    @FXML
    public Button ReadyButton;

    @FXML
    public ComboBox ObjectComboBox;

    @FXML
    public ComboBox TypeComboBox;

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

    @FXML
    public Button LoadButton;

    public void work(){
        ReadyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) SwitchButton.getScene().getWindow();
                stage.close();
                Parent root1 = null;
                try {
                    root1 = FXMLLoader.load(getClass().getResource("fightingform.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Fighting");
                stage.setScene(new Scene(root1));
                stage.show();

            }
        });
        SwitchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) SwitchButton.getScene().getWindow();
                stage.close();
                Parent root1 = null;
                try {
                    root1 = FXMLLoader.load(getClass().getResource("racingform.fxml"));
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
                Stage stage = (Stage) SwitchButton.getScene().getWindow();
                stage.close();
                Parent root1 = null;
                try {
                    root1 = FXMLLoader.load(getClass().getResource("shooterform.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Shooter");
                stage.setScene(new Scene(root1));
                stage.show();


            }
        });

        DeleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) SwitchButton.getScene().getWindow();
                stage.close();
                Parent root1 = null;
                try {
                    root1 = FXMLLoader.load(getClass().getResource("indieform.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Indie");
                stage.setScene(new Scene(root1));
                stage.show();

            }
        });

        ChangeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) SwitchButton.getScene().getWindow();
                stage.close();
                Parent root1 = null;
                try {
                    root1 = FXMLLoader.load(getClass().getResource("stealthform.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Stealth");
                stage.setScene(new Scene(root1));
                stage.show();

            }
        });

        LoadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) SwitchButton.getScene().getWindow();
                stage.close();
                Parent root1 = null;
                try {
                    root1 = FXMLLoader.load(getClass().getResource("additionalform.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Additional");
                stage.setScene(new Scene(root1));
                stage.show();
            }
        });

    }

    @FXML
    void initialize() {
        TypeComboBox.setItems(types);
        work();

    }
}
