//Imported classes
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

//Class that contain scene that will play when player win a game
public class Complete {
    public static void display(){

        //Change a song if it's muted don't play them
        Main.mediaPlayer_main.stop();
        Media media4 = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/champion.mp3");
        Main.mediaPlayer_main = new MediaPlayer(media4);
        Main.mediaPlayer_main.setAutoPlay(true);
        Main.mediaPlayer_main.setVolume(0.4);
        if (Chess.music.getId()=="music_on"){
            Main.mediaPlayer_main.setMute(true);
        }

        //Create a new stage
        Stage window = new Stage();
        //Add icon to app
        window.getIcons().add(new Image("icon.png"));
        window.setFullScreen(true);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Notification");
        Button menu = new Button();

        //Button menu will be change a song and clear all variables
        menu.setOnAction(event -> {
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
        menu.setId("menu");

        //Create imageviews that will be a root and some gifs in scene
        Image menu_image = new Image(Gameover.class.getResourceAsStream("guy.gif"));
        ImageView menu_view = new ImageView(menu_image);
        Image image = new Image(Gameover.class.getResourceAsStream("200.gif"));
        ImageView image_view = new ImageView(image);

        //Set coordinates for buttons and images
        menu_view.setLayoutX(420);
        menu_view.setLayoutY(290);
        menu.setLayoutY(640);
        menu.setLayoutX(510);

        //Group that contain all buttons and images
        Group final_menu = new Group();
        final_menu.getChildren().addAll(image_view,menu_view,menu);
        Scene scene = new Scene(final_menu, 1366, 768);
        window.initStyle(StageStyle.UNDECORATED);

        //Set a design from a css file to scene
        scene.getStylesheets().addAll(Gameover.class.getResource("win.css").toString());
        window.setScene(scene);
        window.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        window.setResizable(false);
        window.showAndWait();
    }
}
