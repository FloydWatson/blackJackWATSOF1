package nz.ac.eit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

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

        System.out.println("Player score should be greater then 1 and less than => 12. player score is: " + player.getHandValue());
        System.out.println("Dealer score should be greater then 1 and less than => 12. dealer score is: " + dealer.getHandValue());
    }

    @Test
    public void testHit() {
        Player player = new Player();
        Game game = new Game();
        game.hit(player);

        System.out.println("Player score should be greater then 0 and less than => 6. player score is: " + player.getHandValue());
    }

    @Test
    public void testBustEdgeCase21() {
        Player player = new Player();
        Game game = new Game();
        player.setHandValue(21);

        System.out.println("Player with score: " + player.getHandValue() + " should not be considered bust. should return true. player is bust?:" + game.checkBust(player));
    }

    @Test
    public void testBustEdgeCase22() {
        Player player = new Player();
        Game game = new Game();
        player.setHandValue(22);

        System.out.println("Player with score: " + player.getHandValue() + " should be considered bust. should return false. player is bust?:" + game.checkBust(player));
    }
}
