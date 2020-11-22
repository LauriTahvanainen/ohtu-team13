package Scenes;

import Database.SqlDbBookDao;
import Database.SqlDbUrlDao;
import Service.VinkkiService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChooseAddScene {

    AddBookScene addBookScene;
    AddURLScene addURLScene;
    Stage primaryStage;
    ListBooksScene listBooksScene;
    
    public ChooseAddScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
        addBookScene = new AddBookScene(this);
        addURLScene = new AddURLScene(this);
        listBooksScene = new ListBooksScene(this);
    }

    public Scene createScene() throws Exception {
        VinkkiService vinkkiService = new VinkkiService(new SqlDbBookDao(),
                        new SqlDbUrlDao());
        int kirjojenmaara = vinkkiService.listBooks().size();
        int urlienmaara = vinkkiService.listURLs().size();
        //BorderPane root = new BorderPane();
        Label label = new Label("Kirjoja tietokannassa: " + kirjojenmaara
            + "\nUrleja tietokannassa: " + urlienmaara);
        
        label.setId("maara_label");
        // set id for example test
        Label helloworld = new Label("Hello world!");
        helloworld.setId("hello-world-label");
        //root.setCenter(label);
        //root.setBottom(helloworld);

        Button switchToAddBookScene = new Button("Lisää uusi kirja");
        Button switchToAddURLScene = new Button("Lisää URL");
        Button switchToListBooksScene = new Button("Listaa kirjat");

        VBox elements = new VBox(10);
        elements.setPadding(new Insets(100, 0, 50, 200));
        //new Insets(top, right, bottom, left)
        VBox.setVgrow(switchToAddBookScene, Priority.ALWAYS);
        VBox.setVgrow(switchToAddURLScene, Priority.ALWAYS);
        VBox.setVgrow(switchToListBooksScene, Priority.ALWAYS);

        switchToAddBookScene.setOnAction(e -> {
            primaryStage.setScene(addBookScene.createScene());
        });

        switchToAddURLScene.setOnAction(e -> {
            primaryStage.setScene(addURLScene.createScene());
        });

        switchToListBooksScene.setOnAction(e -> {
            primaryStage.setScene(listBooksScene.createScene(
                vinkkiService.listBooks()));
        });

        elements.getChildren().addAll(label, switchToAddBookScene,
            switchToAddURLScene, switchToListBooksScene, helloworld);

        //root.setRight(elements);
        Scene chooseAddScene = new Scene(elements, 600, 400);
        return chooseAddScene;
    }

    public void returnHere() throws Exception {
        primaryStage.setScene(createScene());
        primaryStage.show();
    }
}
