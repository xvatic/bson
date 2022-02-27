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

public class IndieController {
    private static Scanner scanner = new Scanner(System.in);
    private static AutoIncrement autoIncrement = new AutoIncrement();
    private static ObjectEditingService service = new ObjectEditingService();

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
                ObservableList<String> indies1 = FXCollections.observableArrayList();
                List<Indie> indies = service.getIndie();
                for (Indie indie : indies){
                    indies1.add(indie.getName());
                }
                ObjectComboBox.setItems(indies1);

            }
        });

        AddButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean result = service.setIndie(new Indie(autoIncrement.autoIncrement(), NameSpace.getText(),ParameterSpace.getText()));
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
                Boolean result = service.delete(new Stealth(Integer.parseInt(IdSpace.getText()), NameSpace.getText(),ParameterSpace.getText() ));
                System.out.println(result);
            }
        });

        ChangeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean result = service.changeIndie(new Indie(Integer.parseInt(IdSpace.getText()), NameSpace.getText(),ParameterSpace.getText()));
                System.out.println(result);

            }
        });
    }

    @FXML
    void initialize() {

         work();

    }
}
