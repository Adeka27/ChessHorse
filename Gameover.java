//Import classes

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.application.Application.launch;

//Class that generate a scene with game over
public class Gameover {

    public static void display() {

        //Stop playing a music and start play another song
        Main.mediaPlayer_main.stop();
        Media media4 = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/nevergive.mp3");
        Main.mediaPlayer_main = new MediaPlayer(media4);
        Main.mediaPlayer_main.setAutoPlay(true);
        Main.mediaPlayer_main.setVolume(0.4);

        //If music is mute than doesn't play a song
        if (Chess.music.getId()=="music_on"){
            Main.mediaPlayer_main.setMute(true);
        }
        Stage window = new Stage();
        //Add icon to app
        window.getIcons().add(new Image("icon.png"));
        window.setFullScreen(true);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Notification");

        //Create buttons that retry go to game scene with new map and main button that go to menu scene
        Button retry = new Button();
        Button menu = new Button();
        retry.setPrefSize(291, 86);
        retry.getStyleClass().add("Retry");
        retry.setOnAction(event -> {

            //Stop song and set new song
            Main.mediaPlayer_main.stop();
            Media media5 = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/relax.mp3");
            Main.mediaPlayer_main = new MediaPlayer(media5);
            Main.mediaPlayer_main.play();
            Main.mediaPlayer_main.setVolume(0.4);
            Main.mediaPlayer_main.setAutoPlay(true);

            //If music turn off don't play
            if (Chess.music.getId()=="music_on"){
                Main.mediaPlayer_main.setMute(true);
            }

            //Clear all variables of chess class
            Chess.previous.clear();
            Chess.counter = 0;
            Chess.score=0;
            Chess.score_score.setText(String.valueOf(Chess.score));
            Chess.new_record.setText("");

            //Set standart ids of all chess buttons
            for (int index = 0; index < Chess.buttons.size(); index++) {
                Chess.buttons.get(index).getStyleClass().add("Cell");
                Chess.buttons.get(index).getStyleClass().remove("Horse");
                Chess.buttons.get(index).getStyleClass().remove("TrueWay");
                Chess.buttons.get(index).setVisible(true);
                String rnd_num = String.valueOf(Chess.rnd_cell);

                //If it is horse cell than change a id
                if (Chess.buttons.get(index).getText().equals(rnd_num)) {
                    Chess.buttons.get(index).getStyleClass().add("Horse");
                    Chess.previous.add(Chess.buttons.get(index));
                }
            }

            //Set a way for player
            Chess.doYouKnowTheWay();
            window.close();
            Main.window.setFullScreen(true);
        });
        menu.setOnAction(event -> {

            //Clear a score and play new song if it's mute than doesn't play
            Chess.score=0;
            Main.mediaPlayer_main.stop();
            Media media5 = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/sad.mp3");
            Main.mediaPlayer_main = new MediaPlayer(media5);
            Main.mediaPlayer_main.setAutoPlay(true);
            Main.mediaPlayer_main.play();
            Main.mediaPlayer_main.setVolume(0.4);
            if (Main.music.getId()=="music_on"){
                Main.mediaPlayer_main.setMute(true);
            }
            window.close();
            Main.window.setScene(Main.mainmenu);
            Main.window.setFullScreen(true);
        });
        menu.setPrefSize(291, 86);
        menu.getStyleClass().add("Menu");

        //Create imageviews for all image elements
        Image menu_image = new Image(Gameover.class.getResourceAsStream("never.gif"));
        ImageView menu_view = new ImageView(menu_image);
        Image image = new Image(Gameover.class.getResourceAsStream("gameover.png"));
        ImageView image_view = new ImageView(image);

        //Set coordinates for buttons
        menu_view.setLayoutX(420);
        menu_view.setLayoutY(220);
        menu.setLayoutY(600);
        menu.setLayoutX(680);
        retry.setLayoutX(360);
        retry.setLayoutY(600);

        //Final group that contain all buttons
        Group final_menu = new Group();
        final_menu.getChildren().addAll(image_view,menu_view,menu,retry);
        Scene scene = new Scene(final_menu, 1366, 768);
        window.initStyle(StageStyle.UNDECORATED);

        //Set style from css file
        scene.getStylesheets().addAll(Gameover.class.getResource("gameover.css").toString());
        window.setScene(scene);
        window.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        window.setResizable(false);
        window.showAndWait();
    }
}
