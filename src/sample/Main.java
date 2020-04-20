package sample;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.bson.*;
import java.io.*;
import org.bson.BsonDocument;
import org.bson.codecs.RawBsonDocumentCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
    }






    public static byte[] Serialization(String json) {
        RawBsonDocument rawBsonDoc = RawBsonDocument.parse(json);
        ByteBuf b = rawBsonDoc.getByteBuffer();
        return b.array();
    }
    public static String Deserialization(byte[] arr) {
        RawBsonDocument rawdo = new RawBsonDocument(arr);
        return rawdo.toJson();
    }

    public static void Serialize() {
        String filename = "file.ser";
        if(true){
            try{
                FileOutputStream file = new FileOutputStream(filename);
                Shooter shooter = new Shooter(2017, "PUBG", new String[]{"FPS", "PC,PS4,XBOX"});
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(shooter);
                RawBsonDocument raw = RawBsonDocument.parse(json);
                ByteBuf b = raw.getByteBuffer();
                b.array();
                file.write(b.array());
                file.close();
                System.out.println("Serialized");
            }
            catch (IOException ex) {
                System.out.println("IOException is caught");
            }
        }
    }

    public static void Deserialize() {
        String filename = "file.ser";
        try {
            if(true){
                FileInputStream file = new FileInputStream(filename);
                byte[] x = new byte[1000];
                file.read(x);
                file.close();
                RawBsonDocument rawdo = new RawBsonDocument(x);
                System.out.println("Deserialized");
                System.out.println(rawdo.toString());
            }
        }
        catch (IOException ex){
            System.out.println("IOException is caught");
        }

    }


    public static void main(String[] args) {
        Serialize();
        Deserialize();
        launch(args);

    }



}
