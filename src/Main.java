import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        GameWindow window = new GameWindow();
        window.InitWindow();

        Deck deck = new Deck();
        Hand playerHand = new Hand();
        Hand cpuHand = new Hand();

        deck.InitDeck();
        deck.Deal(playerHand.getMainHand(), cpuHand.getMainHand());

        gameManager.InitScores(playerHand, cpuHand);

        window.DrawUI(gameManager);
        window.RefreshWindow();

        gameManager.playButton.addActionListener(actionEvent -> {
            Card playerCard = (Card) playerHand.getMainHand().getFirst();
            Card cpuCard = (Card) cpuHand.getMainHand().getFirst();
            window.DrawCards(playerCard, cpuCard);
            window.RefreshWindow();
            gameManager.CompareCards(playerHand.getMainHand(), cpuHand.getMainHand(), window);
            gameManager.UpdateScores(playerHand, cpuHand);
        });

        window.ClearButton.addActionListener(actionEvent -> {
            window.RefreshUI(gameManager);
            window.RefreshWindow();
        });
    }
}
