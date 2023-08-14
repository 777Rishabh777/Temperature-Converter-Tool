package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		launch(args);
	}
	@Override

	public void init() throws Exception{
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode, 350, 350);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();

	}
	private MenuBar createMenu(){
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event ->
		{System.out.println("new Menu Item Clicked");
		});

		SeparatorMenuItem separateMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem, separateMenuItem, quitMenuItem);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);

		return menuBar;
	}

	private void aboutApp(){
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFx");
		alertDialog.setContentText("I am just a beginner but soon i will be pro and start developing awesome games and apps");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType NoBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn,NoBtn);

		Optional<ButtonType>clickedBtn=alertDialog.showAndWait();
		if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
			System.out.println("Yes Button Clicked !");
		} else {
			System.out.println("No Button Clicked !");
		}

	}

	@Override
	public void stop() throws Exception{
		System.out.println("stop");
		super.stop();
	}
}
