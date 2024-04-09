// StartGame.java
package ca.sheridancollege.project;
import javax.swing.JOptionPane;

public class StartGame {
    public static void main(String[] args) {
        String playerName1 = JOptionPane.showInputDialog(null, "Enter the name for Player 1:");
        HumanPlayer player1 = new HumanPlayer(playerName1);

        String playerName2 = JOptionPane.showInputDialog(null, "Enter the name for Player 2:");
        HumanPlayer player2 = new HumanPlayer(playerName2);
        GameController gameController = new GameController(player1, player2);
        gameController.play();
    }
}
 