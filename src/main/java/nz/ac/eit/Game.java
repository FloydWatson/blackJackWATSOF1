package nz.ac.eit;

public class Game {
    private static int maxValue = 21;
    private Dice dice;


    public Game(){
        dice = new Dice();

    }

    public void hit(Player player){
        player.setHandValue(player.getHandValue() + dice.getRoll());
    }


    public boolean checkBust(Player player){
        return player.getHandValue() > maxValue;
    }

    public void setupGame(Player player, Player dealer){
        for(int i = 0; i < 2; i++){
            hit(player);
            hit(dealer);
        }

    }



}
