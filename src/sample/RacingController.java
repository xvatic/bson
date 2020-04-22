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

public class RacingController {

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
                ObservableList<String> racings1 = FXCollections.observableArrayList();
                List<Racing> racings = service.getRacing();
                for (Racing racing : racings){
                    racings1.add(racing.getName());
                }
                ObjectComboBox.setItems(racings1);

            }
        });

        AddButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean result = service.setRacing(new Racing(autoIncrement.autoIncrement(), NameSpace.getText(), Integer.parseInt(ParameterSpace.getText())));
                System.out.println(result);
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

        DeleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean result = service.delete(new Racing(Integer.parseInt(IdSpace.getText()), NameSpace.getText(), Integer.parseInt(ParameterSpace.getText())));
                System.out.println(result);
            }
        });

        ChangeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean result = service.changeRacing(new Racing(Integer.parseInt(IdSpace.getText()), NameSpace.getText(), Integer.parseInt(ParameterSpace.getText())));
                System.out.println(result);

            }
        });
    }
    @FXML
    void initialize() {

        work();

    }
}
