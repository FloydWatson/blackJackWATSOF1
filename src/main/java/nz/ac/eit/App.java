package nz.ac.eit;

import java.util.Scanner;


public class App 
{
    static boolean playerTurn = true;
    static boolean dealerTurn = false;
    static boolean gameRunning = true;

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        Player dealer = new Player();

        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        String userInput = "";




        System.out.println("Blackjack Game");
        game.setupGame(player, dealer);
        System.out.println("Player must try get highest value without going over 21. in case of a draw the Dealer wins");
        System.out.println("player starting score: " + player.getHandValue());


        while(gameRunning){
            while(playerTurn){
                System.out.println("would you like to hit or stand");
                userInput = sc.nextLine();
                switch(userInput){
                    case "hit":
                        game.hit(player);
                        if(!game.checkBust(player)){
                            System.out.println("congratulations. new score is: "+player.getHandValue());
                        } else {
                            System.out.println("You went bust with a score of : " + player.getHandValue());
                            System.out.println("House wins. thank you for playing. goodbye");
                            endGame();

                        }
                        break;
                    case "stand":
                        System.out.println("Player stands on score of: " + player.getHandValue());
                        playerTurn = false;
                        dealerTurn = true;

                    default:
                        System.out.println("invalid input. please try again");
                        break;
                }
            }
            while(dealerTurn){
                System.out.println("Dealer starting score: " + dealer.getHandValue());
                while(dealer.getHandValue() < player.getHandValue()){
                    System.out.println("Dealer hits");
                    game.hit(dealer);
                    System.out.println("Dealer new score: " + dealer.getHandValue());
                    sleepApp();

                    if(game.checkBust(dealer)){
                        System.out.println("Dealer has gone bust. Congratulations you won!");
                        System.out.println("Thank you for playing");
                        sleepApp();
                        endGame();
                    }
                    sleepApp();
                }

                System.out.println("Dealer has stood and won");
                System.out.println("Dealer score: " + dealer.getHandValue());
                System.out.println("Player score: " + player.getHandValue());
                System.out.println("Thank you for playing");
                endGame();
            }
        }

    }


    public static void sleepApp(){
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void endGame(){
        dealerTurn = false;
        gameRunning = false;
        playerTurn = false;
    }



}
