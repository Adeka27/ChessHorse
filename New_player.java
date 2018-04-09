
//Imported classes
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


//Class with method that contain scene with creating a new user in game
public class New_player {

    public static void display() throws Exception {

        //Create a new stage
        Stage window = new Stage();
        //Add icon to app
        window.getIcons().add(new Image("icon.png"));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("NEW PLAYER");

        //TextField where user can enter his name
        TextField name = new TextField();
        name.setAlignment(Pos.CENTER);

        //Give a property for textfield that check what user press key if it is space than nothing do
        name.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.matches(".* .*")) {
                        name.setText(oldValue);
                    }
                });

        //Set a size for textfield
        name.setMaxSize(220, 60);
        name.setId("name");

        //Set a text limit for textfield
        addTextLimiter(name, 8);

        //Create a button okey
        Button ok = new Button();
        ok.setPrefSize(113, 49);
        ok.setId("ok");

        //Create a label notification
        Label notification = new Label("");

        //Create a action for button
        ok.setOnAction(event -> {

            //Play a media when button is pressed
            Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/gta.mp3");
            Main.mediaPlayer = new MediaPlayer(media);
            Main.mediaPlayer.play();

            //If textfield is null just close a window
            if (name.getText().equals("")) {
                window.close();
            } else {

                //Check textfield there is a new name or name that has already
                boolean haveWay = false;
                for (int index = 0; index < Main.names.size(); index++) {
                    if (Main.names.get(index).equals(name.getText())) {
                        haveWay = true;
                    }
                }

                //If there is already name from textfield than do some notification
                if (haveWay) {
                    notification.setText("This account already exists");
                } else {

                    //Read a file
                    java.io.File file = new java.io.File("C:/Users/Adilbek/Desktop/feduk.txt");
                    Scanner in = null;
                    try {
                        in = new Scanner(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    //Put all information from file to string text
                    String text = "";
                    while (in.hasNextLine()) {
                        text += in.nextLine() + "\n";
                    }
                    in.close();
                    PrintWriter fileWriter = null;
                    try {
                        fileWriter = new PrintWriter(new FileOutputStream("C:/Users/Adilbek/Desktop/feduk.txt"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    //Create a new file writer that again write information with new user
                    fileWriter.print(text);
                    fileWriter.print(name.getText() + "    " + 0);
                    fileWriter.close();
                    Main.scores.add(name.getText() + "    " + 0);
                    Main.score.add(0);
                    Main.names.add(name.getText());
                    Main.score_player = 0;
                    Main.name_player = name.getText();
                    Main.statistic.setText(Main.name_player + "\nScore: " + Main.score_player);
                    Main.window.setScene(Main.mainmenu);
                    window.close();
                    Main.window.setFullScreen(true);
                }
            }
        });

        //Create vboxes
        VBox final_page = new VBox();
        VBox menu = new VBox();

        //Set id for button
        notification.setId("notification");
        menu.getChildren().addAll(name, ok, notification);
        menu.setSpacing(30);
        menu.setAlignment(Pos.TOP_CENTER);
        Label space = new Label("");
        final_page.getChildren().addAll(space, menu);
        final_page.setAlignment(Pos.TOP_CENTER);
        final_page.setSpacing(90);
        Scene scene = new Scene(final_page, 382, 304);
        scene.getStylesheets().addAll(New_player.class.getResource("new.css").toString());
        window.setScene(scene);
        window.initStyle(StageStyle.UNDECORATED);
        window.setResizable(false);
        window.showAndWait();
    }

    //Method that checks a textfield
    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {

                //If text length is longer than maxLength don't enter any letter
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

}
