package sample.Serpente;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import sample.Grid;

import java.util.ArrayList;
import java.util.Random;

public class Snake extends ArrayList<Parte> {

    public Testa testa = new Testa();
    public boolean inVita=true;

    public Snake(){

        super();
        this.add(testa);
        aggiungiCoda(this.get(size()-1));

    }

    public void aggiungiCoda(Parte a){
        switch (a.direzione){
            case 1:
                this.add(new Corpo(a.posX, a.posY+1, a.direzione ));
                break;
            case 2:
                this.add(new Corpo(a.posX-1, a.posY, a.direzione ));
                break;
            case 3:
                this.add(new Corpo(a.posX, a.posY-1, a.direzione ));
                break;
            case 4:
                this.add(new Corpo(a.posX+1, a.posY, a.direzione ));
                break;
        }

    }

    public void muovi(){
        int dirP = 0;
        int dirA = 0;
        for(Parte parte: this){
                switch (parte.direzione){
                    case 1:
                        parte.posY--;
                        break;
                    case 2:
                        parte.posX++;
                        break;
                    case 3:
                        parte.posY++;
                        break;
                    case 4:
                        parte.posX--;
                        break;
                    }
                if(parte instanceof Testa){
                    dirP= parte.direzione;
                } else {
                  dirA = parte.direzione;
                  parte.direzione = dirP;
                  dirP = dirA;
                }

                if(parte.posX < 0){
                    parte.posX = 28;
                }
                if(parte.posX > 28){
                    parte.posX = 0;
                }
                if(parte.posY < 0){
                    parte.posY = 13;
                  }
                if(parte.posY > 13){
                    parte.posY = 0;
                }


        }
        for(Parte a: this){
            if(this.indexOf(a) != 0 && a.posX == testa.posX && a.posY == testa.posY){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("HAI PERSO!");
                alert.show();
                inVita=false;
            }
        }
    }













    class Corpo extends Parte{

        Corpo(int x, int y, int dir){
            super();
            this.setFill(Color.LIGHTGREEN);

            this.posX=x;
            this.posY=y;
            this.direzione=dir;
        }
    }



}
