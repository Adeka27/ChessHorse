//Imported classes
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.ArrayList;

//Chess class that contain main method that display a game scene
public class Chess {

    //Parameters
    public static ArrayList<Button> previous;
    public static int counter;
    public static int rnd_cell;
    public static ArrayList<Button> buttons;
    public static int score;
    public static Label score_player;
    public static Label score_score;
    public static Label new_record;
    public static Button music;
    public static void display() throws Exception {

        //Set for all parameters null variable
        Random rnd = new Random();
        previous = new ArrayList<>();
        counter = -1;
        boolean even = true;

        //Loop that will regenerate random number between 10 and 88 that have a sum of coord is even
        while (even) {
            rnd_cell = rnd.nextInt(78) + 11;
            String coord = String.valueOf(rnd_cell);
            int first = Integer.parseInt(String.valueOf(coord.charAt(0)));
            int second = Integer.parseInt(String.valueOf(coord.charAt(1)));
            if ((first + second) % 2 == 0 && (first * 10 + second) % 10 != 0 && second != 9) {
                even = false;
            }
        }

        //Generate cell buttons with text
        buttons = new ArrayList<>();
        Button u18 = new Button("11");
        buttons.add(u18);
        Button u17 = new Button("12");
        buttons.add(u17);
        Button u16 = new Button("13");
        buttons.add(u16);
        Button u15 = new Button("14");
        buttons.add(u15);
        Button u14 = new Button("15");
        buttons.add(u14);
        Button u13 = new Button("16");
        buttons.add(u13);
        Button u12 = new Button("17");
        buttons.add(u12);
        Button u11 = new Button("18");
        buttons.add(u11);
        //
        Button u28 = new Button("21");
        buttons.add(u28);
        Button u27 = new Button("22");
        buttons.add(u27);
        Button u26 = new Button("23");
        buttons.add(u26);
        Button u25 = new Button("24");
        buttons.add(u25);
        Button u24 = new Button("25");
        buttons.add(u24);
        Button u23 = new Button("26");
        buttons.add(u23);
        Button u22 = new Button("27");
        buttons.add(u22);
        Button u21 = new Button("28");
        buttons.add(u21);
        //
        Button u38 = new Button("31");
        buttons.add(u38);
        Button u37 = new Button("32");
        buttons.add(u37);
        Button u36 = new Button("33");
        buttons.add(u36);
        Button u35 = new Button("34");
        buttons.add(u35);
        Button u34 = new Button("35");
        buttons.add(u34);
        Button u33 = new Button("36");
        buttons.add(u33);
        Button u32 = new Button("37");
        buttons.add(u32);
        Button u31 = new Button("38");
        buttons.add(u31);
        //
        Button u48 = new Button("41");
        buttons.add(u48);
        Button u47 = new Button("42");
        buttons.add(u47);
        Button u46 = new Button("43");
        buttons.add(u46);
        Button u45 = new Button("44");
        buttons.add(u45);
        Button u44 = new Button("45");
        buttons.add(u44);
        Button u43 = new Button("46");
        buttons.add(u43);
        Button u42 = new Button("47");
        buttons.add(u42);
        Button u41 = new Button("48");
        buttons.add(u41);
        //
        Button u58 = new Button("51");
        buttons.add(u58);
        Button u57 = new Button("52");
        buttons.add(u57);
        Button u56 = new Button("53");
        buttons.add(u56);
        Button u55 = new Button("54");
        buttons.add(u55);
        Button u54 = new Button("55");
        buttons.add(u54);
        Button u53 = new Button("56");
        buttons.add(u53);
        Button u52 = new Button("57");
        buttons.add(u52);
        Button u51 = new Button("58");
        buttons.add(u51);
        //
        Button u68 = new Button("61");
        buttons.add(u68);
        Button u67 = new Button("62");
        buttons.add(u67);
        Button u66 = new Button("63");
        buttons.add(u66);
        Button u65 = new Button("64");
        buttons.add(u65);
        Button u64 = new Button("65");
        buttons.add(u64);
        Button u63 = new Button("66");
        buttons.add(u63);
        Button u62 = new Button("67");
        buttons.add(u62);
        Button u61 = new Button("68");
        buttons.add(u61);
        //
        Button u78 = new Button("71");
        buttons.add(u78);
        Button u77 = new Button("72");
        buttons.add(u77);
        Button u76 = new Button("73");
        buttons.add(u76);
        Button u75 = new Button("74");
        buttons.add(u75);
        Button u74 = new Button("75");
        buttons.add(u74);
        Button u73 = new Button("76");
        buttons.add(u73);
        Button u72 = new Button("77");
        buttons.add(u72);
        Button u71 = new Button("78");
        buttons.add(u71);
        //
        Button u88 = new Button("81");
        buttons.add(u88);
        Button u87 = new Button("82");
        buttons.add(u87);
        Button u86 = new Button("83");
        buttons.add(u86);
        Button u85 = new Button("84");
        buttons.add(u85);
        Button u84 = new Button("85");
        buttons.add(u84);
        Button u83 = new Button("86");
        buttons.add(u83);
        Button u82 = new Button("87");
        buttons.add(u82);
        Button u81 = new Button("88");
        buttons.add(u81);

        //Create a grid pane that connect all cell buttons
        GridPane table = new GridPane();
        table.setAlignment(Pos.CENTER);

        //Set for all buttons one id
        for (int index = 0; index < buttons.size(); index++) {
            buttons.get(index).setPrefSize(80, 81);
            buttons.get(index).getStyleClass().add("Cell");
        }
        table.add(u11, 0, 0);
        table.add(u12, 0, 1);
        table.add(u13, 0, 2);
        table.add(u14, 0, 3);
        table.add(u15, 0, 4);
        table.add(u16, 0, 5);
        table.add(u17, 0, 6);
        table.add(u18, 0, 7);
        //
        table.add(u21, 1, 0);
        table.add(u22, 1, 1);
        table.add(u23, 1, 2);
        table.add(u24, 1, 3);
        table.add(u25, 1, 4);
        table.add(u26, 1, 5);
        table.add(u27, 1, 6);
        table.add(u28, 1, 7);
        table.add(u31, 2, 0);
        table.add(u32, 2, 1);
        table.add(u33, 2, 2);
        table.add(u34, 2, 3);
        table.add(u35, 2, 4);
        table.add(u36, 2, 5);
        table.add(u37, 2, 6);
        table.add(u38, 2, 7);
        table.add(u41, 3, 0);
        table.add(u42, 3, 1);
        table.add(u43, 3, 2);
        table.add(u44, 3, 3);
        table.add(u45, 3, 4);
        table.add(u46, 3, 5);
        table.add(u47, 3, 6);
        table.add(u48, 3, 7);
        table.add(u51, 4, 0);
        table.add(u52, 4, 1);
        table.add(u53, 4, 2);
        table.add(u54, 4, 3);
        table.add(u55, 4, 4);
        table.add(u56, 4, 5);
        table.add(u57, 4, 6);
        table.add(u58, 4, 7);
        table.add(u61, 5, 0);
        table.add(u62, 5, 1);
        table.add(u63, 5, 2);
        table.add(u64, 5, 3);
        table.add(u65, 5, 4);
        table.add(u66, 5, 5);
        table.add(u67, 5, 6);
        table.add(u68, 5, 7);
        table.add(u71, 6, 0);
        table.add(u72, 6, 1);
        table.add(u73, 6, 2);
        table.add(u74, 6, 3);
        table.add(u75, 6, 4);
        table.add(u76, 6, 5);
        table.add(u77, 6, 6);
        table.add(u78, 6, 7);
        table.add(u81, 7, 0);
        table.add(u82, 7, 1);
        table.add(u83, 7, 2);
        table.add(u84, 7, 3);
        table.add(u85, 7, 4);
        table.add(u86, 7, 5);
        table.add(u87, 7, 6);
        table.add(u88, 7, 7);

        //Loop that give a horse cell for a cell button with random id
        for (int index = 0; index < buttons.size(); index++) {
            String random = String.valueOf(rnd_cell);
            if (buttons.get(index).getText().equals(random)) {
                buttons.get(index).getStyleClass().add("Horse");
                previous.add(buttons.get(index));
                counter++;
            }
        }
        doYouKnowTheWay();

        //Retry button
        Button random = new Button("");
        random.setPrefSize(291, 86);
        random.getStyleClass().add("Retry");
        random.setOnAction(event -> {

            //Make a sound than button is pressed
            Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/gta.mp3");
            Main.mediaPlayer = new MediaPlayer(media);
            Main.mediaPlayer.play();

            //Clear all variables
            previous.clear();
            counter = 0;
            score=0;
            score_score.setText(String.valueOf(score));
            new_record.setText("");

            //Return initial values ​​for all buttons
            for (int index = 0; index < buttons.size(); index++) {
                buttons.get(index).getStyleClass().add("Cell");
                buttons.get(index).getStyleClass().remove("Horse");
                buttons.get(index).getStyleClass().remove("TrueWay");
                buttons.get(index).setVisible(true);
                String rnd_num = String.valueOf(rnd_cell);
                if (buttons.get(index).getText().equals(rnd_num)) {
                    buttons.get(index).getStyleClass().add("Horse");
                    previous.add(buttons.get(index));
                }
            }
            doYouKnowTheWay();
        });


        //Give a methods for all cell buttons
        u11.setOnAction(event -> {
            doOperation(u11);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u12.setOnAction(event -> {
            doOperation(u12);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u13.setOnAction(event -> {
            doOperation(u13);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u13.setOnAction(event -> {
            doOperation(u13);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u14.setOnAction(event -> {
            doOperation(u14);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u15.setOnAction(event -> {
            doOperation(u15);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u16.setOnAction(event -> {
            doOperation(u16);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u17.setOnAction(event -> {
            doOperation(u17);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u18.setOnAction(event -> {
            doOperation(u18);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u21.setOnAction(event -> {
            doOperation(u21);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u22.setOnAction(event -> {
            doOperation(u22);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u23.setOnAction(event -> {
            doOperation(u23);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u24.setOnAction(event -> {
            doOperation(u24);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u25.setOnAction(event -> {
            doOperation(u25);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u26.setOnAction(event -> {
            doOperation(u26);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u27.setOnAction(event -> {
            doOperation(u27);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u28.setOnAction(event -> {
            doOperation(u28);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u31.setOnAction(event -> {
            doOperation(u31);
            checkComplete(); checkGameOver();
            doYouKnowTheWay();
        });
        u32.setOnAction(event -> {
            doOperation(u32);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u33.setOnAction(event -> {
            doOperation(u33);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u34.setOnAction(event -> {
            doOperation(u34);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u35.setOnAction(event -> {
            doOperation(u35);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u36.setOnAction(event -> {
            doOperation(u36);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u37.setOnAction(event -> {
            doOperation(u37);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u38.setOnAction(event -> {
            doOperation(u38);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u41.setOnAction(event -> {
            doOperation(u41);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u42.setOnAction(event -> {
            doOperation(u42);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u43.setOnAction(event -> {
            doOperation(u43);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u44.setOnAction(event -> {
            doOperation(u44);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u45.setOnAction(event -> {
            doOperation(u45);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u46.setOnAction(event -> {
            doOperation(u46);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u47.setOnAction(event -> {
            doOperation(u47);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u48.setOnAction(event -> {
            doOperation(u48);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u51.setOnAction(event -> {
            doOperation(u51);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u52.setOnAction(event -> {
            doOperation(u52);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u53.setOnAction(event -> {
            doOperation(u53);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u54.setOnAction(event -> {
            doOperation(u54);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u55.setOnAction(event -> {
            doOperation(u55);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u56.setOnAction(event -> {
            doOperation(u56);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u57.setOnAction(event -> {
            doOperation(u57);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u58.setOnAction(event -> {
            doOperation(u58);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u61.setOnAction(event -> {
            doOperation(u61);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u62.setOnAction(event -> {
            doOperation(u62);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u63.setOnAction(event -> {
            doOperation(u63);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u64.setOnAction(event -> {
            doOperation(u64);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u65.setOnAction(event -> {
            doOperation(u65);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u66.setOnAction(event -> {
            doOperation(u66);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u67.setOnAction(event -> {
            doOperation(u67);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u68.setOnAction(event -> {
            doOperation(u68);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u71.setOnAction(event -> {
            doOperation(u71);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u72.setOnAction(event -> {
            doOperation(u72);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u73.setOnAction(event -> {
            doOperation(u73);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u74.setOnAction(event -> {
            doOperation(u74);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u75.setOnAction(event -> {
            doOperation(u75);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u76.setOnAction(event -> {
            doOperation(u76);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u77.setOnAction(event -> {
            doOperation(u77);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u78.setOnAction(event -> {
            doOperation(u78);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u81.setOnAction(event -> {
            doOperation(u81);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u82.setOnAction(event -> {
            doOperation(u82);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u83.setOnAction(event -> {
            doOperation(u83);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u84.setOnAction(event -> {
            doOperation(u84);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u85.setOnAction(event -> {
            doOperation(u85);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u86.setOnAction(event -> {
            doOperation(u86);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u87.setOnAction(event -> {
            doOperation(u87);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });
        u88.setOnAction(event -> {
            doOperation(u88);
            checkComplete();
            checkGameOver();
            doYouKnowTheWay();
        });

        //Create image view with gif root
        ImageView play_view = new ImageView(new Image(Chess.class.getResourceAsStream("gamer.png")));

        //Set a null variable for label
        score_player = new Label("Score:");
        score_score = new Label("0");
        score_player.setId("sc");

        //Set a coordinate for all layouts
        score_score.setLayoutX(1190);
        score_score.setLayoutY(140);
        score_score.setId("sc");
        new_record = new Label("");
        new_record.setId("sc");
        new_record.setLayoutX(1070);
        new_record.setLayoutY(220);
        score_player.setLayoutX(1136);
        score_player.setLayoutY(56);
        table.setLayoutX(200);
        table.setLayoutY(40);
        random.setLayoutX(1060);
        random.setLayoutY(400);

        //Button music that turn on or turn off music in game
        music = new Button("");
        music.setPrefSize(291, 86);
        music.setId("music_off");
        music.setOnAction(event -> {
            //If music is on than he turn off
            if (music.getId()=="music_off") {
                Main.mediaPlayer_main.setMute(true);
                music.setId("music_on");
            }
            //If music is off than he turn on
            else {
                Main.mediaPlayer_main.setMute(false);
                music.setId("music_off");
            }
        });
        music.setLayoutX(1060);
        music.setLayoutY(500);
        Button menu = new Button();
        menu.setPrefSize(291, 86);
        menu.setId("menu");
        menu.setLayoutX(1060);
        menu.setLayoutY(650);

        //Set action for menu button
        menu.setOnAction(event -> {

            //Play song when button is pressed
            //Clear score variable
            score=0;
            Main.mediaPlayer_main.stop();
            Media media4 = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/sad.mp3");
            Main.mediaPlayer_main = new MediaPlayer(media4);
            Main.mediaPlayer_main.setCycleCount(100);
            Main.mediaPlayer_main.play();
            Main.mediaPlayer_main.setVolume(0.4);

            //If music is mute than don't play song
            if (Main.music.getId()=="music_on"){
                Main.mediaPlayer_main.setMute(true);
            }
            Main.window.setScene(Main.mainmenu);
            Main.window.setFullScreen(true);
        });
        Group final_table = new Group();
        final_table.getChildren().addAll(play_view,table, random,score_player,score_score, new_record,music,menu);


       Main.gameWindow = new Scene(final_table, 1366, 768);

       //Give for game scene css resources
       Main.gameWindow.getStylesheets().addAll(Chess.class.getResource("Play.css").toString());
       Main.window.setScene(Main.gameWindow);
       Main.window.setFullScreen(true);
    }


    //Method that do change of horse cell
    public static void doOperation(Button operation) {

        //If there is a such button in array list
        if (checkCell(operation)) ;
        else {

            //Takes the coordinates of the pressed button and the past and divides them in parts
            int first_ccord_prev = Integer.parseInt(String.valueOf(previous.get(counter).getText().charAt(0)));
            int second_ccord_prev = Integer.parseInt(String.valueOf(previous.get(counter).getText().charAt(1)));
            String test = operation.getText();
            int first_coord = Integer.parseInt(String.valueOf(test.charAt(0)));
            int second_coord = Integer.parseInt(String.valueOf(test.charAt(1)));

            //If the coordinates coincide when adding or subtracting, then the horse can move there and do it for 8 times
            if (first_ccord_prev + 2 > 0 && first_ccord_prev + 2 < 9 && first_ccord_prev + 2 == first_coord) {
                if (second_ccord_prev + 1 > 0 && second_ccord_prev + 1 < 9 && second_ccord_prev + 1 == second_coord) {

                    //Play a song when button is pressed
                    Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/beat.mp3");
                    Main.mediaPlayer = new MediaPlayer(media);
                    Main.mediaPlayer.play();

                    //Add this button for array list
                    previous.add(operation);

                    //Do set visible false for previous button
                    previous.get(counter).setVisible(false);
                    operation.getStyleClass().add("Horse");
                    score++;

                    //If score more than 10 do new coordinates for label
                    if (score>=10){
                        score_score.setLayoutX(1185);
                    }

                    //Set new score
                    score_score.setText(String.valueOf(score));

                    //If score more than previous than recond give a message about new record
                    if (Main.score_player<score){
                        if (Main.score_player!=0){
                            new_record.setText("NEW RECORD");
                        }

                        //Write a new score
                        Main.score_player=score;
                        Main.statistic.setText(Main.name_player + "\nScore: " + Main.score_player);

                        //Reload a new score of a player
                        for (int index = 0; index < Main.names.size(); index++) {
                            if (Main.names.get(index).equals(Main.name_player)){
                                Main.score.remove(index);
                                Main.score.add(index,score);
                            }
                        }

                        //Method that rewrite a file with new score
                        reload();
                    }
                    counter++;
                }
                if (second_ccord_prev - 1 > 0 && second_ccord_prev - 1 < 9 && second_ccord_prev - 1 == second_coord) {
                    Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/beat.mp3");
                    Main.mediaPlayer = new MediaPlayer(media);
                    Main.mediaPlayer.play();
                    previous.add(operation);
                    previous.get(counter).setVisible(false);
                    operation.getStyleClass().add("Horse");
                    score++;
                    if (score>=10){
                        score_score.setLayoutX(1185);
                    }
                    score_score.setText(String.valueOf(score));
                    if (Main.score_player<score){
                        if (Main.score_player!=0){
                            new_record.setText("NEW RECORD");
                        }
                        Main.score_player=score;
                        Main.statistic.setText(Main.name_player + "\nScore: " + Main.score_player);
                        for (int index = 0; index < Main.names.size(); index++) {
                            if (Main.names.get(index).equals(Main.name_player)){
                                Main.score.remove(index);
                                Main.score.add(index,score);
                            }
                        }
                        reload();
                    }
                    counter++;
                }
            } else {
                if (first_ccord_prev - 2 > 0 && first_ccord_prev - 2 < 9 && first_ccord_prev - 2 == first_coord) {
                    if (second_ccord_prev + 1 > 0 && second_ccord_prev + 1 < 9 && second_ccord_prev + 1 == second_coord) {
                        Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/beat.mp3");
                        Main.mediaPlayer = new MediaPlayer(media);
                        Main.mediaPlayer.play();
                        previous.add(operation);
                        previous.get(counter).setVisible(false);
                        operation.getStyleClass().add("Horse");
                        score++;
                        if (score>=10){
                            score_score.setLayoutX(1185);
                        }
                        score_score.setText(String.valueOf(score));
                        if (Main.score_player<score){
                            if (Main.score_player!=0){
                                new_record.setText("NEW RECORD");
                            }
                            Main.score_player=score;
                            Main.statistic.setText(Main.name_player + "\nScore: " + Main.score_player);
                            for (int index = 0; index < Main.names.size(); index++) {
                                if (Main.names.get(index).equals(Main.name_player)){
                                    Main.score.remove(index);
                                    Main.score.add(index,score);
                                }
                            }
                            reload();
                        }
                        counter++;
                    }
                    if (second_ccord_prev - 1 > 0 && second_ccord_prev - 1 < 9 && second_ccord_prev - 1 == second_coord) {
                        Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/beat.mp3");
                        Main.mediaPlayer = new MediaPlayer(media);
                        Main.mediaPlayer.play();
                        previous.add(operation);
                        previous.get(counter).setVisible(false);
                        operation.getStyleClass().add("Horse");
                        score++;
                        if (score>=10){
                            score_score.setLayoutX(1185);
                        }
                        score_score.setText(String.valueOf(score));
                        if (Main.score_player<score){
                            if (Main.score_player!=0){
                                new_record.setText("NEW RECORD");
                            }
                            Main.score_player=score;
                            Main.statistic.setText(Main.name_player + "\nScore: " + Main.score_player);
                            for (int index = 0; index < Main.names.size(); index++) {
                                if (Main.names.get(index).equals(Main.name_player)){
                                    Main.score.remove(index);
                                    Main.score.add(index,score);
                                }
                            }
                            reload();
                        }
                        counter++;
                    }
                } else {
                    if (second_ccord_prev + 2 > 0 && second_ccord_prev + 2 < 9 && second_ccord_prev + 2 == second_coord) {
                        if (first_ccord_prev + 1 > 0 && first_ccord_prev + 1 < 9 && first_ccord_prev + 1 == first_coord) {
                            Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/beat.mp3");
                            Main.mediaPlayer = new MediaPlayer(media);
                            Main.mediaPlayer.play();
                            previous.add(operation);
                            previous.get(counter).setVisible(false);
                            operation.getStyleClass().add("Horse");
                            score++;
                            if (score>=10){
                                score_score.setLayoutX(1185);
                            }
                            score_score.setText(String.valueOf(score));
                            if (Main.score_player<score){
                                if (Main.score_player!=0){
                                    new_record.setText("NEW RECORD");
                                }
                                Main.score_player=score;
                                Main.statistic.setText(Main.name_player + "\nScore: " + Main.score_player);
                                for (int index = 0; index < Main.names.size(); index++) {
                                    if (Main.names.get(index).equals(Main.name_player)){
                                        Main.score.remove(index);
                                        Main.score.add(index,score);
                                    }
                                }
                                reload();
                            }
                            counter++;
                        }
                        if (first_ccord_prev - 1 > 0 && first_ccord_prev - 1 < 9 && first_ccord_prev - 1 == first_coord) {
                            Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/beat.mp3");
                            Main.mediaPlayer = new MediaPlayer(media);
                            Main.mediaPlayer.play();
                            previous.add(operation);
                            previous.get(counter).setVisible(false);
                            operation.getStyleClass().add("Horse");
                            score++;
                            if (score>=10){
                                score_score.setLayoutX(1185);
                            }
                            score_score.setText(String.valueOf(score));
                            if (Main.score_player<score){
                                if (Main.score_player!=0){
                                    new_record.setText("NEW RECORD");
                                }
                                Main.score_player=score;
                                Main.statistic.setText(Main.name_player + "\nScore: " + Main.score_player);
                                for (int index = 0; index < Main.names.size(); index++) {
                                    if (Main.names.get(index).equals(Main.name_player)){
                                        Main.score.remove(index);
                                        Main.score.add(index,score);
                                    }
                                }
                                reload();
                            }
                            counter++;
                        }
                    } else {
                        if (second_ccord_prev - 2 > 0 && second_ccord_prev - 2 < 9 && second_ccord_prev - 2 == second_coord) {
                            if (first_ccord_prev + 1 > 0 && first_ccord_prev + 1 < 9 && first_ccord_prev + 1 == first_coord) {
                                Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/beat.mp3");
                                Main.mediaPlayer = new MediaPlayer(media);
                                Main.mediaPlayer.play();
                                previous.add(operation);
                                previous.get(counter).setVisible(false);
                                operation.getStyleClass().add("Horse");
                                score++;
                                if (score>=10){
                                    score_score.setLayoutX(1185);
                                }
                                score_score.setText(String.valueOf(score));
                                if (Main.score_player<score){
                                    if (Main.score_player!=0){
                                        new_record.setText("NEW RECORD");
                                    }
                                    Main.score_player=score;
                                    Main.statistic.setText(Main.name_player + "\nScore: " + Main.score_player);
                                    for (int index = 0; index < Main.names.size(); index++) {
                                        if (Main.names.get(index).equals(Main.name_player)){
                                            Main.score.remove(index);
                                            Main.score.add(index,score);
                                        }
                                    }
                                    reload();
                                }
                                counter++;
                            }
                            if (first_ccord_prev - 1 > 0 && first_ccord_prev - 1 < 9 && first_ccord_prev - 1 == first_coord) {
                                Media media = new Media("file:///C:/Users/Adilbek/IdeaProjects/Project_1/src/sample/beat.mp3");
                                Main.mediaPlayer = new MediaPlayer(media);
                                Main.mediaPlayer.play();
                                previous.add(operation);
                                previous.get(counter).setVisible(false);
                                operation.getStyleClass().add("Horse");
                                score++;
                                if (score>=10){
                                    score_score.setLayoutX(1185);
                                }
                                score_score.setText(String.valueOf(score));
                                if (Main.score_player<score){
                                    if (Main.score_player!=0){
                                        new_record.setText("NEW RECORD");
                                    }
                                    Main.score_player=score;
                                    Main.statistic.setText(Main.name_player + "\nScore: " + Main.score_player);
                                    for (int index = 0; index < Main.names.size(); index++) {
                                        if (Main.names.get(index).equals(Main.name_player)){
                                            Main.score.remove(index);
                                            Main.score.add(index,score);
                                        }
                                    }
                                    reload();
                                }
                                counter++;
                            }
                        }
                    }
                }
            }
        }
    }

    //Check a buttons
    public static boolean checkCell(Button check) {

        //If pressed button in array list of previous cell buttons than return true
        for (int index = 0; index < previous.size(); index++) {
            if (previous.get(index).getText() == check.getText()) {
                return true;
            }
        }
        return false;
    }

    public static void checkGameOver() {

        //If score 63 than game is completed
        if (score == 63);
        else {

            //Take the coordinates of the pressed button and check for a further path
            int first_ccord_prev = Integer.parseInt(String.valueOf(previous.get(counter).getText().charAt(0)));
            int second_ccord_prev = Integer.parseInt(String.valueOf(previous.get(counter).getText().charAt(1)));
            ArrayList<Boolean> checking = new ArrayList<>();
            String number_first = "";
            String number_second = "";
            String number_third = "";
            String number_fourth = "";
            String number_fiveth = "";
            String number_sixth = "";
            String number_seventh = "";
            String number_eighth = "";

            //Records for this button all possible moves more accurately coordinates in text
            if (second_ccord_prev - 2 > 0 && second_ccord_prev - 2 < 9) {
                if (first_ccord_prev + 1 > 0 && first_ccord_prev + 1 < 9) {
                    number_first = String.valueOf(first_ccord_prev + 1) + String.valueOf(second_ccord_prev - 2);

                    //If the parameters do not match the machine, add a lie to the collection
                } else checking.add(false);

                if (first_ccord_prev - 1 > 0 && first_ccord_prev - 1 < 9) {
                    number_second = String.valueOf(first_ccord_prev - 1) + String.valueOf(second_ccord_prev - 2);
                } else checking.add(false);

                //If the parameters do not match the machine, add a lie to the collection
            } else {
                checking.add(false);
                checking.add(false);
            }

            if (second_ccord_prev + 2 > 0 && second_ccord_prev + 2 < 9) {
                if (first_ccord_prev + 1 > 0 && first_ccord_prev + 1 < 9) {
                    number_third = String.valueOf(first_ccord_prev + 1) + String.valueOf(second_ccord_prev + 2);
                } else checking.add(false);

                if (first_ccord_prev - 1 > 0 && first_ccord_prev - 1 < 9) {
                    number_fourth = String.valueOf(first_ccord_prev - 1) + String.valueOf(second_ccord_prev + 2);
                } else checking.add(false);

            } else {
                checking.add(false);
                checking.add(false);
            }

            if (first_ccord_prev - 2 > 0 && first_ccord_prev - 2 < 9) {
                if (second_ccord_prev + 1 > 0 && second_ccord_prev + 1 < 9) {
                    number_fiveth = String.valueOf(first_ccord_prev - 2) + String.valueOf(second_ccord_prev + 1);
                } else checking.add(false);

                if (second_ccord_prev - 1 > 0 && second_ccord_prev - 1 < 9) {
                    number_sixth = String.valueOf(first_ccord_prev - 2) + String.valueOf(second_ccord_prev - 1);
                } else checking.add(false);

            } else {
                checking.add(false);
                checking.add(false);
            }

            if (first_ccord_prev + 2 > 0 && first_ccord_prev + 2 < 9) {
                if (second_ccord_prev + 1 > 0 && second_ccord_prev + 1 < 9) {
                    number_seventh = String.valueOf(first_ccord_prev + 2) + String.valueOf(second_ccord_prev + 1);
                } else checking.add(false);

                if (second_ccord_prev - 1 > 0 && second_ccord_prev - 1 < 9) {
                    number_eighth = String.valueOf(first_ccord_prev + 2) + String.valueOf(second_ccord_prev - 1);
                } else checking.add(false);

            } else {
                checking.add(false);
                checking.add(false);
            }

            /*
            Does a loop that checks for
            these coordinates in the collection
            of past buttons if they are all there
            is a notification of a loss
            */
            for (int index = 0; index < previous.size(); index++) {
                if (previous.get(index).getText().equals(number_first))
                    checking.add(false);
                if (previous.get(index).getText().equals(number_second))
                    checking.add(false);
                if (previous.get(index).getText().equals(number_third))
                    checking.add(false);
                if (previous.get(index).getText().equals(number_fourth))
                    checking.add(false);
                if (previous.get(index).getText().equals(number_fiveth))
                    checking.add(false);
                if (previous.get(index).getText().equals(number_sixth))
                    checking.add(false);
                if (previous.get(index).getText().equals(number_seventh))
                    checking.add(false);
                if (previous.get(index).getText().equals(number_eighth))
                    checking.add(false);
            }

            //If collection of booleans is full than display a game over scene
            if (checking.size() == 8) {
                Gameover.display();
            }
        }
    }

    //Method that show the way for horse button
    public static void doYouKnowTheWay (){

        //Removes past indexes with prompts
        for (int index = 0; index < buttons.size(); index++) {
            buttons.get(index).getStyleClass().remove("TrueWay");
        }
/*Writes coordinates in parts
and makes special additions
and decrements to find a hint
if the button's path is contained
in the collection of past buttons
that does not show otherwise
gives this button
a special index that changes
the color when hovering*/

        int first_ccord_prev = Integer.parseInt(String.valueOf(previous.get(counter).getText().charAt(0)));
        int second_ccord_prev = Integer.parseInt(String.valueOf(previous.get(counter).getText().charAt(1)));
        String number_first = "";
        String number_second = "";
        String number_third = "";
        String number_fourth = "";
        String number_fiveth = "";
        String number_sixth = "";
        String number_seventh = "";
        String number_eighth = "";
        if (second_ccord_prev - 2 > 0 && second_ccord_prev - 2 < 9) {
            if (first_ccord_prev + 1 > 0 && first_ccord_prev + 1 < 9) {
                number_first = String.valueOf(first_ccord_prev+1) + String.valueOf(second_ccord_prev-2);
            }

            if (first_ccord_prev - 1 > 0 && first_ccord_prev - 1 < 9) {
                number_second = String.valueOf(first_ccord_prev-1) + String.valueOf(second_ccord_prev-2);
            }

        }
        if (second_ccord_prev + 2 > 0 && second_ccord_prev + 2 < 9) {
            if (first_ccord_prev + 1 > 0 && first_ccord_prev + 1 < 9) {
                number_third = String.valueOf(first_ccord_prev+1) + String.valueOf(second_ccord_prev+2);
            }

            if (first_ccord_prev - 1 > 0 && first_ccord_prev - 1 < 9) {
                number_fourth = String.valueOf(first_ccord_prev-1) + String.valueOf(second_ccord_prev+2);
            }

        }

        if (first_ccord_prev - 2 > 0 && first_ccord_prev - 2 < 9) {
            if (second_ccord_prev + 1 > 0 && second_ccord_prev + 1 < 9) {
                number_fiveth = String.valueOf(first_ccord_prev - 2) + String.valueOf(second_ccord_prev + 1);
            }

            if (second_ccord_prev - 1 > 0 && second_ccord_prev - 1 < 9) {
                number_sixth = String.valueOf(first_ccord_prev - 2) + String.valueOf(second_ccord_prev - 1);
            }

        }

        if (first_ccord_prev + 2 > 0 && first_ccord_prev + 2 < 9) {
            if (second_ccord_prev + 1 > 0 && second_ccord_prev + 1 < 9) {
                number_seventh = String.valueOf(first_ccord_prev + 2) + String.valueOf(second_ccord_prev + 1);
            }

            if (second_ccord_prev - 1 > 0 && second_ccord_prev - 1 < 9) {
                number_eighth = String.valueOf(first_ccord_prev + 2) + String.valueOf(second_ccord_prev - 1);
            }

        }

        //Give a special id for this buttons
        for (int index = 0; index < buttons.size(); index++) {
            if (!checkCell(buttons.get(index)) && buttons.get(index).getText().equals(number_first)){
                    buttons.get(index).getStyleClass().add("TrueWay");}
            if (!checkCell(buttons.get(index)) && buttons.get(index).getText().equals(number_second)){
                buttons.get(index).getStyleClass().add("TrueWay");
            }
            if (!checkCell(buttons.get(index)) && buttons.get(index).getText().equals(number_third)){
                buttons.get(index).getStyleClass().add("TrueWay");
            }
            if (!checkCell(buttons.get(index)) && buttons.get(index).getText().equals(number_fourth)){
                buttons.get(index).getStyleClass().add("TrueWay");
            }
            if (!checkCell(buttons.get(index)) && buttons.get(index).getText().equals(number_fiveth)){
                buttons.get(index).getStyleClass().add("TrueWay");
            }
            if (!checkCell(buttons.get(index)) && buttons.get(index).getText().equals(number_sixth)){
                buttons.get(index).getStyleClass().add("TrueWay");
            }
            if (!checkCell(buttons.get(index)) && buttons.get(index).getText().equals(number_seventh)){
                buttons.get(index).getStyleClass().add("TrueWay");
            }
            if (!checkCell(buttons.get(index)) && buttons.get(index).getText().equals(number_eighth)){
                buttons.get(index).getStyleClass().add("TrueWay");
            }
        }
    }

    //Method that reload a information about players
    public static void reload (){

        //Create a writer that write to file a new information from two collections
        PrintWriter fileWriter = null;
        try {
            fileWriter = new PrintWriter(new FileOutputStream("C:/Users/Adilbek/Desktop/feduk.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int index = 0; index < Main.score.size(); index++) {
            fileWriter.println(Main.names.get(index) + "    " + Main.score.get(index));
        }
        fileWriter.close();
    }

    //Method that checks complete the game a player or not
    public static void checkComplete( ){

        //If score of player is more than 62 than display a special scene of complete class
        if (score > 62){
            Complete.display();
        }

    }
    }

