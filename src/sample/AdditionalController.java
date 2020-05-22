package sample;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

public class AdditionalController {
    private static Scanner scanner = new Scanner(System.in);
    private static AutoIncrement autoIncrement = new AutoIncrement();
    private static Service service = new Service();
    private Stage primaryStage;
    private LoadingEngine engine;
    final FileChooser fileChooser = new FileChooser();

    @FXML
    public RadioButton ReadyButton;


    @FXML
    public ComboBox ObjectComboBox;

    @FXML
    public  CheckBox checkexternal;

    @FXML
    public TextField NameSpace;

    @FXML
    public TextField IdSpace;

    @FXML
    public TextField ParameterSpace;

    @FXML
    public Label ParameterLabel;

    @FXML
    public RadioButton AddButton;
    @FXML
    public Button LoadButton;

    @FXML
    public RadioButton DeleteButton;

    @FXML
    public RadioButton ChangeButton;

    @FXML
    public Button SwitchButton;

    @FXML
    public ToggleGroup BtnGroup;

    public void work() {



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



        LoadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null){
                    String path = file.getPath();
                    Class additionalClass = LoadingEngine.start(path, file.getName());
                    Object newObject = null;

                    if(BtnGroup.getSelectedToggle() == AddButton){
                        try {
                            newObject = additionalClass.newInstance();
                            int a = 0;
                             try {
                                 a = Integer.parseInt(ParameterSpace.getText());
                             } catch (NumberFormatException ignore) {

                             }
                            File filef = fileChooser.showOpenDialog(primaryStage);
                            if (filef != null) {
                                String pathf = file.getPath();
                                Class additionalFun = LoadingEngine.start(pathf, filef.getName());

                                if(checkexternal.isSelected()){
                                    Object newFun = additionalFun.newInstance();
                                    ExternalAdapter adapter = new ExternalAdapter((AdditionalExternalProcessing)newFun);
                                    if (a != 0) {
                                        service.addNewClass(((Games) newObject), NameSpace.getText(), a, adapter);
                                    } else {
                                        service.addNewClass(((Games) newObject), NameSpace.getText(), ParameterSpace.getText(),adapter);
                                    }
                                }
                                else {
                                    Object newFun = additionalFun.newInstance();
                                    if (a != 0) {
                                        service.addNewClass(((Games) newObject), NameSpace.getText(), a, ((AdditionalProcessing)newFun));
                                    } else {
                                        service.addNewClass(((Games) newObject), NameSpace.getText(), ParameterSpace.getText(),((AdditionalProcessing)newFun));
                                    }
                                }

                            }
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    if(BtnGroup.getSelectedToggle() == ChangeButton){
                        try {

                            newObject = additionalClass.newInstance();
                            int a = 0;
                            try{
                                a = Integer.parseInt(ParameterSpace.getText());
                            } catch (NumberFormatException ignore) {

                            }
                            File filef = fileChooser.showOpenDialog(primaryStage);
                            if (filef != null) {
                                String pathf = file.getPath();
                                Class additionalFun = LoadingEngine.start(pathf, filef.getName());
                                if(checkexternal.isSelected()){
                                    Object newFun = additionalFun.newInstance();
                                    ExternalAdapter adapter = new ExternalAdapter((AdditionalExternalProcessing)newFun);
                                    if (a != 0) {
                                        service.changeAdditional(((Games) newObject), Integer.parseInt(IdSpace.getText()), NameSpace.getText(), a, adapter);
                                    } else {
                                        service.changeAdditional(((Games) newObject), Integer.parseInt(IdSpace.getText()), NameSpace.getText(), ParameterSpace.getText(), adapter);
                                    }
                                }
                                else {
                                    Object newFun = additionalFun.newInstance();
                                    if (a != 0) {
                                        service.changeAdditional(((Games) newObject), Integer.parseInt(IdSpace.getText()), NameSpace.getText(), a, ((AdditionalProcessing)newFun));
                                    } else {
                                        service.changeAdditional(((Games) newObject), Integer.parseInt(IdSpace.getText()), NameSpace.getText(), ParameterSpace.getText(), ((AdditionalProcessing)newFun));
                                    }
                                }



                            }
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    if(BtnGroup.getSelectedToggle() == DeleteButton){
                        try {
                            newObject = additionalClass.newInstance();
                            service.deleteAdditional(((Games)newObject), Integer.parseInt(IdSpace.getText()));

                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    if(BtnGroup.getSelectedToggle() == ReadyButton){
                        List<Games> games = null;
                        ObjectComboBox.valueProperty().set(null);
                        ObservableList<String> additional = FXCollections.observableArrayList();
                        try {
                            newObject = additionalClass.newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        File filef = fileChooser.showOpenDialog(primaryStage);
                        if (filef != null) {
                            String pathf = file.getPath();
                            Class additionalFun = LoadingEngine.start(pathf, filef.getName());
                            try {
                                if(checkexternal.isSelected()){
                                    Object newFun = additionalFun.newInstance();
                                    ExternalAdapter adapter = new ExternalAdapter((AdditionalExternalProcessing)newFun);
                                    games = service.getAdditional(((Games)newObject),adapter);
                                }
                                else {
                                    Object newFun = additionalFun.newInstance();
                                    games = service.getAdditional(((Games)newObject),((AdditionalProcessing)newFun));
                                }

                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (NoSuchAlgorithmException e) {
                                e.printStackTrace();
                            } catch (NoSuchPaddingException e) {
                                e.printStackTrace();
                            } catch (BadPaddingException e) {
                                e.printStackTrace();
                            } catch (IllegalBlockSizeException e) {
                                e.printStackTrace();
                            } catch (InvalidKeyException e) {
                                e.printStackTrace();
                            }
                        }

                        for (Games game : games){
                            Field[] fields = game.getClass().getDeclaredFields();
                            int i=1;
                            for(Field field: fields){
                                java.lang.annotation.Annotation annotation = field.getAnnotation(Deprecated.class);


                                if (annotation == null){
                                    continue;
                                }

                                field.setAccessible(true);
                                field.getType();
                                if (i==1){
                                    try {
                                        additional.add((String) field.get(game));
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                    field.setAccessible(false);
                                    break;
                                }


                            }
                        }
                        ObjectComboBox.setItems(additional);
                    }


                }


            }
        });
    }

    @FXML
    void initialize() {

        work();

    }
}
