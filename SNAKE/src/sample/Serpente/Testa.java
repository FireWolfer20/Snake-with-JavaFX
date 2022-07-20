package sample.Serpente;

import javafx.scene.paint.Color;

import java.util.Random;

public class Testa extends Parte{

    Random ran= new Random();

    Testa(){
        super();
        this.setFill(Color.DARKGREEN);

        this.posX = ran.nextInt(27)+1;
        this.posY = ran.nextInt(12)+1;
        this.direzione = ran.nextInt(4)+1;
    }


}