/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class representing a playing card.
 * It encapsulates the rank and suit of the card.
 * Each instance represents a single card in a deck.
 */
public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    /**
     * @return Rank return the rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * @return Suit return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

}
