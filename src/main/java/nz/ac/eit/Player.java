package nz.ac.eit;
import java.util.Scanner;

public class Player {

    private int handValue = 0;
    private String username= "";

    public Player(){}

    public int getHandValue(){
        return handValue;
    }

    public void setHandValue(int value){
        handValue = value;
    }

    public String getUsername() {return username;}

    public void setUsername(String playername){ username = playername;}


}
