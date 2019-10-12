package nz.ac.eit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void createDice() {
        Dice dice = new Dice();
        assertNotNull(dice);
    }

    @Test
    public void createPlayer() {
        Player player = new Player();
        assertNotNull(player);
    }

    @Test
    public void createGame() {
        Game game = new Game();
        assertNotNull(game);
    }


    @Test
    public void checkDiceRoll() {
        Dice dice = new Dice();
        System.out.println("Roll should return a number between and including 1 and 6. number returned is: " + dice.getRoll());
    }

    @Test
    public void testGameSetup() {
        Player player = new Player();
        Player dealer = new Player();
        Game game = new Game();
        game.setupGame(player, dealer);
        int high = 12;
        int low = 2;

        System.out.println("Player score should be greater then 1 and less than => 12. player score is: " + player.getHandValue());
        System.out.println("Dealer score should be greater then 1 and less than => 12. dealer score is: " + dealer.getHandValue());
        assertTrue("Error, Player score is too high", high >= player.getHandValue());
        assertTrue("Error, Player score is too low",  low  <= player.getHandValue());
        assertTrue("Error, Dealer score is too high", high >= dealer.getHandValue());
        assertTrue("Error, Dealer score is too low",  low  <= dealer.getHandValue());
    }

    @Test
    public void testHit() {
        Player player = new Player();
        Game game = new Game();
        int oldScore = player.getHandValue();
        game.hit(player);
        int newScore = player.getHandValue();

        System.out.println("Player score should be greater then 0 and less than => 6. player score is: " + player.getHandValue());
        assertNotEquals(oldScore, newScore);
    }

    @Test
    public void testBustEdgeCase21() {
        Player player = new Player();
        Game game = new Game();
        player.setHandValue(21);

        System.out.println("Player with score: " + player.getHandValue() + " should not be considered bust. should return false. player is bust?:" + game.checkBust(player));
    }

    @Test
    public void testBustEdgeCase22() {
        Player player = new Player();
        Game game = new Game();
        player.setHandValue(22);

        System.out.println("Player with score: " + player.getHandValue() + " should be considered bust. should return true. player is bust?:" + game.checkBust(player));
    }
}
