package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Scanner;

public class Controller {

    private static Scanner scanner = new Scanner(System.in);
    private static AutoIncrement autoIncrement = new AutoIncrement();
    private static Service service = new Service();


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

    public void work(){
        ReadyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String des = TypeComboBox.getValue().toString();
                switch (des){
                    case "Shooter":
                        ObjectComboBox.valueProperty().set(null);
                        ObservableList<String> shooters = FXCollections.observableArrayList();
                        List<Shooter> shooters1 = service.getShooter();
                        for (Shooter shooter : shooters1){
                            shooters.add(shooter.getName());
                        }
                        ObjectComboBox.setItems(shooters);
                        break;
                    case "Racing":
                        ObjectComboBox.valueProperty().set(null);
                        ObservableList<String> racings1 = FXCollections.observableArrayList();
                        List<Racing> racings = service.getRacing();
                        for (Racing racing : racings){
                            racings1.add(racing.getName());
                        }
                        ObjectComboBox.setItems(racings1);
                        break;
                    case "Indie":
                        ObjectComboBox.valueProperty().set(null);
                        ObservableList<String> indies1 = FXCollections.observableArrayList();
                        List<Indie> indies = service.getIndie();
                        for (Indie indie : indies){
                            indies1.add(indie.getName());
                        }
                        ObjectComboBox.setItems(indies1);
                        break;
                    case "Stealth":
                        ObjectComboBox.valueProperty().set(null);
                        ObservableList<String> stealths1 = FXCollections.observableArrayList();
                        List<Stealth> stealths = service.getStealth();
                        for (Stealth stealth : stealths){
                            stealths1.add(stealth.getName());
                        }
                        ObjectComboBox.setItems(stealths1);
                        break;
                    case "Fighting":
                        ObjectComboBox.valueProperty().set(null);
                        ObservableList<String> fightings1 = FXCollections.observableArrayList();
                        List<Fighting> fightings = service.getFighting();
                        for (Fighting fighting : fightings){
                            fightings1.add(fighting.getName());
                        }
                        ObjectComboBox.setItems(fightings1);
                        break;
                }
            }
        });

        AddButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String des = TypeComboBox.getValue().toString();
                switch (des){
                    case "Shooter":
                       if(service.setShooter(new Shooter(autoIncrement.autoIncrement(), NameSpace.getText()))){
                           System.out.println("Success ");
                       }
                       break;
                    case "Racing":
                        if(service.setRacing(new Racing(autoIncrement.autoIncrement(), NameSpace.getText(), Integer.parseInt(ParameterSpace.getText())))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Indie":
                        if(service.setIndie(new Indie(autoIncrement.autoIncrement(), NameSpace.getText(),ParameterSpace.getText()))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Stealth":
                        if(service.setStealth(new Stealth(autoIncrement.autoIncrement(), NameSpace.getText(),ParameterSpace.getText() ))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Fighting":
                        if(service.setFighting(new Fighting(autoIncrement.autoIncrement(), NameSpace.getText(),Integer.parseInt(ParameterSpace.getText())))){
                            System.out.println("Success ");
                        }
                        break;
                }

            }
        });

        DeleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String des = TypeComboBox.getValue().toString();
                switch (des){
                    case "Shooter":
                        if(service.delete(new Shooter(Integer.parseInt(IdSpace.getText()), NameSpace.getText()))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Racing":
                        if(service.delete(new Racing(Integer.parseInt(IdSpace.getText()), NameSpace.getText(), Integer.parseInt(ParameterSpace.getText())))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Indie":
                        if(service.delete(new Indie(Integer.parseInt(IdSpace.getText()), NameSpace.getText(),ParameterSpace.getText()))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Stealth":
                        if(service.delete(new Stealth(Integer.parseInt(IdSpace.getText()), NameSpace.getText(),ParameterSpace.getText() ))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Fighting":
                        if(service.delete(new Fighting(Integer.parseInt(IdSpace.getText()), NameSpace.getText(),Integer.parseInt(ParameterSpace.getText())))){
                            System.out.println("Success ");
                        }
                        break;
                }

            }
        });

        ChangeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String des = TypeComboBox.getValue().toString();
                switch (des){
                    case "Shooter":
                        if(service.changeShooter(new Shooter(Integer.parseInt(IdSpace.getText()), NameSpace.getText()))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Racing":
                        if(service.changeRacing(new Racing(Integer.parseInt(IdSpace.getText()), NameSpace.getText(), Integer.parseInt(ParameterSpace.getText())))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Indie":
                        if(service.changeIndie(new Indie(Integer.parseInt(IdSpace.getText()), NameSpace.getText(),ParameterSpace.getText()))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Stealth":
                        if(service.changeStealth(new Stealth(Integer.parseInt(IdSpace.getText()), NameSpace.getText(),ParameterSpace.getText() ))){
                            System.out.println("Success ");
                        }
                        break;
                    case "Fighting":
                        if(service.changeFighting(new Fighting(Integer.parseInt(IdSpace.getText()), NameSpace.getText(),Integer.parseInt(ParameterSpace.getText())))){
                            System.out.println("Success ");
                        }
                        break;
                }

            }
        });
    }









    @FXML
    void initialize() {
        TypeComboBox.setItems(types);
        work();

    }
}
