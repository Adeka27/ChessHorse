//Imported classes

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    //Parameters
    public static ArrayList<String> scores;
    public static Stage window;
    public static Scene mainmenu;
    Scene rules;
    public static Scene player;
    public static Scene gameWindow;
    public static ArrayList<Button> plan;
    public static boolean go;
    public static int score_player;
    public static String name_player;
    public static Label statistic;
    public static ArrayList<String> names;
    public static ArrayList<Integer> score;
    public static MediaPlayer mediaPlayer;
    public static MediaPlayer mediaPlayer_main;
    public static boolean play_music;
    public static Button music;

    @Override
    public void start(Stage stage) throws Exception {

        //Settings to play media
        play_music = true;
        Media media4 = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/sad.mp3");
        mediaPlayer_main = new MediaPlayer(media4);
        mediaPlayer_main.play();
        mediaPlayer_main.setVolume(0.1);
        mediaPlayer_main.setAutoPlay(true);

        //Do parameters to null variables
        name_player = "";
        score_player = 0;

        //Create imageview to read gifs
        Image menu_image = new Image(getClass().getResourceAsStream("Projectil.gif"));
        ImageView menu_view = new ImageView(menu_image);
        menu_view.setFitWidth(1366);
        menu_view.setFitHeight(768);
        Image rule_image = new Image(getClass().getResourceAsStream("rules1.gif"));
        ImageView rule_view = new ImageView(rule_image);
        statistic = new Label("");

        //Do parameters in null form
        go = false;
        scores = new ArrayList<>();
        window = stage;
        //Add icon to app
        window.getIcons().add(new Image("icon.png"));
        plan = new ArrayList<>();
        Button add = new Button("");

        //Read file with score and all variables from file to two arraylist with names and score of player
        java.io.File file = new java.io.File("C:/Users/Adilbek/Desktop/feduk.txt");
        Scanner in = new Scanner(file);
        names = new ArrayList<>();
        score = new ArrayList<>();
        while (in.hasNextLine()) {
            String text = in.nextLine();
            String[] parts = text.split("    ");
            score.add(Integer.valueOf(parts[1]));
            names.add(parts[0]);
        }
        in.close();

        //Check every name and score of player and do bubble sort in a file
        for (int index = 0; index < score.size(); index++) {
            //Read reverse numbers
            for (int col = score.size() - 1; col > index; col--) {
                //If first index bigger than second change numbers
                if (score.get(col - 1) < score.get(col)) {
                    int number = score.get(col - 1);
                    String name = names.get(col - 1);
                    String name_last = names.get(col);
                    int number_last = score.get(col);
                    names.remove(col - 1);
                    names.add(col - 1, name_last);
                    names.remove(col);
                    names.add(col, name);
                    score.remove(col - 1);
                    score.add(col - 1, number_last);
                    score.remove(col);
                    score.add(col, number);
                }
            }
        }

        //Rewrite the file in descending order
        PrintWriter fileWriter = new PrintWriter(new FileOutputStream("C:/Users/Adilbek/Desktop/feduk.txt"));
        for (int index = 0; index < names.size(); index++) {
            fileWriter.println(names.get(index) + "    " + score.get(index));
        }
        fileWriter.close();
        Scanner scanner = new Scanner(new FileInputStream("C:/Users/Adilbek/Desktop/feduk.txt"));
        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            scores.add(text);
        }

        //Give a design and action to button
        add.setId("Add");
        add.setMinSize(335, 114);
        add.setOnAction(event -> {

            //Change a song and change scene
            Media media1 = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/gta.mp3");
            mediaPlayer = new MediaPlayer(media1);
            mediaPlayer.play();
            try {
                New_player.display();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //Full screen - on
        window.setFullScreen(true);

        //Create hbox for button place
        HBox all = new HBox();
        all.setAlignment(Pos.BOTTOM_CENTER);
        all.getChildren().addAll(add);

        //Create vbox there will be all player users and scores
        VBox players = new VBox();
        players.setAlignment(Pos.CENTER);

        //Create scrollPane for scrolling through the list of players
        ScrollPane scrollPane = new ScrollPane(players);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setMaxSize(370, 500);
        scrollPane.setFitToWidth(true);

        //Create main VBox there will be all buttons and layouts
        VBox final_scene = new VBox();
        Label spacing = new Label("");
        final_scene.getChildren().addAll(spacing, scrollPane, all);
        final_scene.setSpacing(110);
        final_scene.setAlignment(Pos.TOP_CENTER);
        int counter = 1;

        //Give for all buttons same design and text
        for (int index = 0; index < scores.size(); index++) {
            Button button = new Button(counter + "    " + scores.get(index));
            button.setPrefSize(709, 70);

            //If player complete the game for him we will be add gold button
            if (score.get(index) > 62) {
                button.setId("gold");
            } else {
                button.setId("player");
            }
            counter++;
            plan.add(button);
            players.getChildren().add(button);
        }

        //First scene where you choose a player or create new player
        player = new Scene(final_scene, 1366, 768);
        player.getStylesheets().addAll(getClass().getResource("player.css").toString());
        window.setScene(player);

        //Create button play
        Button play = new Button("");
        play.setPrefSize(291, 86);
        play.getStyleClass().add("Play");

        //Create button recital
        Button recital = new Button("");
        recital.setPrefSize(291, 86);
        recital.getStyleClass().add("Recital");

        //Create button exit
        Button exit = new Button("");
        exit.setPrefSize(291, 86);
        exit.getStyleClass().add("Exit");

        //Create button music that will be off or on music in game
        music = new Button("");
        music.setPrefSize(291, 86);
        music.setId("music_off");
        music.setOnAction(event -> {

            //If music turn on
            if (play_music == true) {
                mediaPlayer_main.setMute(true);
                play_music = false;
                music.setId("music_on");
                //If music turn off
            } else {
                mediaPlayer_main.setMute(false);
                play_music = true;
                music.setId("music_off");
            }
        });

        //Create space between buttons by labels
        Label space_1 = new Label("");
        Label space_2 = new Label("");

        //Create vbox for two buttons
        VBox box = new VBox();
        box.setAlignment(Pos.TOP_CENTER);
        box.setSpacing(32);
        box.getChildren().addAll(play, recital);

        //Create vbox for more space for buttons
        VBox space = new VBox();
        space.setAlignment(Pos.TOP_CENTER);
        space.getChildren().addAll(space_1, box);
        space.setSpacing(240);

        //Final vbox that contains all layouts
        VBox menu = new VBox();
        menu.setAlignment(Pos.BOTTOM_CENTER);
        menu.getChildren().addAll(space_2, exit);
        menu.setSpacing(30);

        //Create a event for all user buttons
        for (int index = 0; index < plan.size(); index++) {
            int count = index;
            plan.get(index).setOnAction(event -> {

                //Create a media when button is pressed
                Media media2 = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/gta.mp3");
                mediaPlayer = new MediaPlayer(media2);
                mediaPlayer.play();

                //If button pressed read information of user and it to two variable name and score
                String[] parts = plan.get(count).getText().split("    ");
                name_player = parts[1];
                score_player = Integer.valueOf(parts[2]);
                statistic.setText(name_player + "\nScore: " + score_player);
                window.setScene(mainmenu);
                window.setFullScreen(true);
            });
        }

        //Create final menu with main buttons
        Group final_menu = new Group();

        //Set the coordinates for all buttons
        menu.setLayoutX(540);
        menu.setLayoutY(460);
        space.setLayoutX(540);
        space.setLayoutY(0);
        statistic.setLayoutY(650);
        statistic.setLayoutX(1100);
        statistic.setId("text");
        music.setLayoutX(540);
        music.setLayoutY(640);
        final_menu.getChildren().addAll(menu_view, space, menu, statistic, music);

        //If play button pressed do action
        play.setOnAction(event -> {

            //Play short media when button is pressed
            Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/gta.mp3");
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            mediaPlayer_main.stop();

            //New song for play mode
            Media media1 = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/relax.mp3");
            mediaPlayer_main = new MediaPlayer(media1);
            mediaPlayer_main.setVolume(0.4);
            mediaPlayer_main.setAutoPlay(true);
            mediaPlayer_main.play();

            //Display chess class main method that contain all of play scene
            try {
                Chess.display();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //Create action to button
        recital.setOnAction(event -> {
            Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/gta.mp3");
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();

            //Set scene rules when button is pressed
            window.setScene(rules);
            window.setFullScreen(true);
        });

        //Create action to button
        exit.setOnAction(event -> {
            Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/gta.mp3");
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();

            //Just exit from a game
            stage.close();
        });

        //Button close of rule scene that just change a scene
        Button close = new Button();
        close.setPrefSize(291, 86);
        close.getStyleClass().add("Close");
        close.setOnAction(event -> {
            Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/gta.mp3");
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();

            //Set new main menu scene
            window.setScene(mainmenu);
            window.setFullScreen(true);
        });

        //Set a coordinates for button
        close.setLayoutY(660);
        close.setLayoutX(530);
        Group rule = new Group();
        rule_view.setFitHeight(768);
        rule_view.setFitWidth(1366);
        rule.getChildren().addAll(rule_view, close);

        rules = new Scene(rule, 1366, 768);

        //Get css resource for scene
        rules.getStylesheets().addAll(getClass().getResource("Rules.css").toString());

        mainmenu = new Scene(final_menu, 1366, 768);

        //Get css resource for scene
        mainmenu.getStylesheets().addAll(getClass().getResource("MainMenu.css").toString());

        //If go boolean is true than change a scene
        if (go) {
            window.setScene(mainmenu);
        }

        window.setResizable(false);
        window.setTitle("ChessHorse Challenge");
        window.setFullScreen(true);

        //Set full screen mode without message
        window.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        window.initStyle(StageStyle.UNDECORATED);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
