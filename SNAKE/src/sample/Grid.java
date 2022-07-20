package sample;


import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import sample.Serpente.Parte;
import sample.Serpente.Snake;
import sample.Serpente.Testa;

import java.util.Random;

public class Grid extends GridPane {

    Mela mela;
    Snake snake = new Snake();

    Grid(){
        for(int i=0; i<29; i++){
            for(int j=0; j<14; j++){
                this.add(new QuadGriglia(), i, j);
            }
        }
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
        this.setMinSize(29*50+18, 14*51-2);
        this.setMaxSize(29*50+18, 14*51-2);

        inserisciMela();

        inserisci();
    }

    void inserisci(){
        for(Parte parte: snake){
            this.getChildren().remove(parte);
            this.add(parte, parte.posX, parte.posY);
        }
    }

    void inserisciMela(){
        mela= new Mela();
        this.add(mela, mela.posX, mela.posY);
    }

    void controlloMela() {
            if(snake.testa.posX == mela.posX && snake.testa.posY == mela.posY) {
                snake.aggiungiCoda(snake.get(snake.size()-1));
                inserisci();
                this.getChildren().remove(mela);
                inserisciMela();
            }
        }




    public class Mela extends Parte{

        Random ran= new Random();

        Mela(){
            super();
            this.setFill(Color.RED);
            this.posX= ran.nextInt(29);
            this.posY= ran.nextInt(14);
        }
    }



}





