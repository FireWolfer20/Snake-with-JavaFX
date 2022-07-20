package sample.Serpente;


import javafx.scene.shape.Rectangle;

public abstract class Parte extends Rectangle {

    public int posX;
    public int posY;
    public int direzione;

    public Parte(){
        this.setHeight(49);
        this.setWidth(49);
    }

}
