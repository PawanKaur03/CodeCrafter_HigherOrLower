package ca.sheridancollege.project;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GameController {
    private final HumanPlayer player1;
    private final HumanPlayer player2;
    private int roundsWonByPlayer1;
    private int roundsWonByPlayer2;
    private final Scanner scanner;

    public GameController(HumanPlayer p1, HumanPlayer p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.roundsWonByPlayer1 = 0;
        this.roundsWonByPlayer2 = 0;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        
        int roundsToPlay = 5; // Default rounds to play

        // Main Path
        for (int round = 1; round <= roundsToPlay; round++) {
            System.out.println(" *---------------------------------------------------*");
            System.out.println(" *                      Round " + round + "                      *");
            System.out.println(" *---------------------------------------------------*");
            playRound();
        }

        // Alternate Path: Tiebreaker Round
        if (roundsWonByPlayer1 == roundsWonByPlayer2) {
            playTiebreakerRound();
        }

        // Declare the winner after all rounds (including tiebreaker)
        declareWinner();
    }

    private void playRound() {
        
        List<Card> deck = createDeck();

        Card currentCard = deck.remove(deck.size() - 1);
        System.out.println("\nCard: " + currentCard.getRank() + " of " +
                currentCard.getSuit() + "\n");

        System.out.println(player1.play());
        String guessP1 = scanner.nextLine().toLowerCase();
        System.out.println(player2.play());
        String guessP2 = scanner.nextLine().toLowerCase();

        Card nextCard = deck.remove(deck.size() - 1);
        System.out.println("\nNext card is: " + nextCard.getRank() + " of " +
                nextCard.getSuit() + "\n");

        String result = compareCards(currentCard, nextCard);

        if (result.equals(guessP1) && result.equals(guessP2)) {
            System.out.println("Correct! indeed, card is " + result + " ,you both wins this round.\n");
            roundsWonByPlayer1++;
            roundsWonByPlayer2++;
        } else if (result.equals(guessP1)) {
            System.out.println("Correct! " + player1.getName() + " card is indeed "+ guessP1 + ". You win this round.\n");
            roundsWonByPlayer1++;
        } else if (result.equals(guessP2)) {
            System.out.println("Correct! " + player2.getName() + " card is indeed "+ guessP2 + ". You win this round.\n");
            roundsWonByPlayer2++;
        } else {
            System.out
                    .println("Incorrect! drawn card is " + result + " as compared to previous card. You both loss this round.\n");
        }
    }

    private void playTiebreakerRound() {

        JOptionPane.showMessageDialog(null, "You both have " + roundsWonByPlayer1 + " correct guesses!\nLet's play 3 Tiebreaker Rounds", "Tiebreaker Round", JOptionPane.INFORMATION_MESSAGE);
        
        for (int currentRound = 1; currentRound < 4; currentRound++) {
            System.out.println(" *-------------------------------------------------------------------*");
            System.out.println(" *                        Tie Breaker Round " + currentRound + "                        *");
            System.out.println(" *-------------------------------------------------------------------*");
            playRound();
        } 
    }

    public void declareWinner() {
        System.out.println("*********************************************************************************************************************************************\n");
        if (roundsWonByPlayer1 > roundsWonByPlayer2) {
            System.out.println("\t\t\t\tCongratulations! " + player1.getName() + " is the overall winner, with "
                    + roundsWonByPlayer1 + " correct guesses! " + player2.getName() + ", you lost at "
                    + (roundsWonByPlayer1 - roundsWonByPlayer2) + " guesses");
        } else if (roundsWonByPlayer1 < roundsWonByPlayer2) {
            System.out.println("\t\t\t\tCongratulations! " + player2.getName() + " is the overall winner, with "
                    + roundsWonByPlayer2 + " correct guesses! " + player1.getName() + ", you lost at "
                    + (roundsWonByPlayer2 - roundsWonByPlayer1) + " guesses");
        } else {
            System.out.println("\t\t\t\tIt's a tie! The game is drawn, you both have " + roundsWonByPlayer1
                    + " correct guesses!");
        }
        System.out.println("\n*********************************************************************************************************************************************");

    }

    private List<Card> createDeck() {
        GroupOfCards groupOfCards = new GroupOfCards(52);
        return groupOfCards.getCards();
    }

    private static String compareCards(Card card1, Card card2) {
        int rank1 = card1.getRank().getValue();
        int rank2 = card2.getRank().getValue();

        if (rank1 < rank2) {
            return "higher";
        } else if (rank1 > rank2) {
            return "lower";
        } else {
            return "equal";
        }
    }
}
