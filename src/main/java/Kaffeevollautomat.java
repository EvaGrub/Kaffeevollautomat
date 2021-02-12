import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Kaffeevollautomat extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(new URL("file:\\C:\\Users\\Eva\\Documents\\GitHub\\Kaffeevollautomat\\src\\main\\java\\sample.fxml"));
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("MEIN KAFFEEVOLLAUTOMAT");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
