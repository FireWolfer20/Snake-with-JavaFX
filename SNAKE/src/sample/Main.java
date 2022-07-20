package sample;
import javafx.application.Platform;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    Label punteggio = new Label("Punteggio: 0");
    Random ran= new Random();
    Grid grid= new Grid();
    int pun=0;

    public void start(Stage primaryStage) throws Exception{

        BorderPane bp= new BorderPane();
        bp.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));




        bp.setTop(punteggio);
        punteggio.setFont(new Font(30));
        BorderPane.setAlignment(punteggio, Pos.CENTER);
        bp.setCenter(grid);
        BorderPane.setAlignment(grid, Pos.CENTER);
        bp.setPadding(new Insets(0, 10, 20, 10));

        Thread game = new Thread(() -> {
            while(grid.snake.inVita){
                Platform.runLater(() -> {grid.snake.muovi();
                                        grid.controlloMela();
                                        grid.inserisci();
                                        pun+=10;
                                        punteggio.setText("Punteggio: "+pun);});
                try {
                    Thread.sleep(150  );
                } catch (Exception ex) {
                }
            }
        });

        game.start();

        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(bp, 100, 100);
        primaryStage.setScene(scene);
        scene.setOnKeyPressed(new SnakeHandler());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    class SnakeHandler implements EventHandler<KeyEvent>{

        public void handle(KeyEvent keyEvent) {
            switch (keyEvent.getCode()){
                case A:
                case LEFT:
                    if(grid.snake.testa.direzione != 2) {
                        grid.snake.testa.direzione = 4;}
                    break;
                case S:
                case DOWN:
                    if(grid.snake.testa.direzione != 1) {
                        grid.snake.testa.direzione = 3;}
                    break;
                case D:
                case RIGHT:
                    if(grid.snake.testa.direzione != 4) {
                        grid.snake.testa.direzione = 2;}
                    break;
                case W:
                case UP:
                    if(grid.snake.testa.direzione != 3) {
                        grid.snake.testa.direzione = 1;}
                    break;
                case P:
                    grid.snake.aggiungiCoda(grid.snake.get(grid.snake.size()-1));
                    break;
            }
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
