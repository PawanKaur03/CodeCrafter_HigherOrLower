package ca.sheridancollege.project;

/**
 * An enum having choices for card names with values
 *
 * @author Pawanpreet Kaur
 * @author Vanshika Vanshika Feb 2024
 */
public enum Rank {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12),
    KING(13);

    private final int value;

    /**
     * Constructor for Rank enum.
     *
     * @param value the numeric value associated with the rank
     */
    Rank(int value) {
        this.value = value;
    }

    /**
     * Get the numeric value associated with the rank.
     *
     * @return the numeric value of the rank
     */
    public int getValue() {
        return value;
    }
}
