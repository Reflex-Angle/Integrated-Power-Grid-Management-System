package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("PowerPlant.fxml"));
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
