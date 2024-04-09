/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods
 * given.
 *
 * @author Pawanpreet Kaur
 * @author Vanshika Vanshika Feb 2024
 */
public abstract class Game {

    private final String name;//the title of the game
    private ArrayList<Player> players;// the players of the game

    public Game(String name) {  // Constructor for Game class
        this.name = name;
        this.players = new ArrayList<>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Compares two cards and determines if the first card is higher, lower, or
     * equal to the second card.
     *
     * @param card1 the first card
     * @param card2 the second card
     * @return a string indicating whether the second card is higher, lower, or equal
     *         to the first card
     */
    public static String compareCards(Card card1, Card card2) {
        int rank1 = card1.getRank().getValue();
        int rank2 = card2.getRank().getValue();

        if (rank1 < rank2) {
            return "higher";
        } else if (rank1 > rank2) {
            return "lower";
        }else {
            return "equal";
        }
    }


    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

}//end class
