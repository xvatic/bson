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

public class FightingController {

    private static Scanner scanner = new Scanner(System.in);
    private static AutoIncrement autoIncrement = new AutoIncrement();
    private static ObjectEditingService service = new ObjectEditingService();


    ObservableList<String> types = FXCollections.observableArrayList("Shooter","Indie","Racing", "Fighting", "Stealth");

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
                ObservableList<String> fightings1 = FXCollections.observableArrayList();
                List<Fighting> fightings = service.getFighting();
                for (Fighting fighting : fightings){
                    fightings1.add(fighting.getName());
                }
                ObjectComboBox.setItems(fightings1);

            }
        });

        AddButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean result = service.setFighting(new Fighting(autoIncrement.autoIncrement(), NameSpace.getText(),Integer.parseInt(ParameterSpace.getText())));
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
                Boolean result = service.delete(new Fighting(Integer.parseInt(IdSpace.getText()), NameSpace.getText(),Integer.parseInt(ParameterSpace.getText())));
                System.out.println(result);
            }
        });

        ChangeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean result = service.changeFighting(new Fighting(Integer.parseInt(IdSpace.getText()), NameSpace.getText(),Integer.parseInt(ParameterSpace.getText())));
                System.out.println(result);

            }
        });
    }

    @FXML
    void initialize() {

       work();

    }

}
