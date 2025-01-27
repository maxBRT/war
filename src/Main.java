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

        gameManager.playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                window.DrawCards((Card) playerHand.getMainHand().getFirst(), (Card) cpuHand.getMainHand().getFirst());
                window.RefreshWindow();
                gameManager.CompareCards(playerHand.getMainHand(), cpuHand.getMainHand());
                gameManager.UpdateScores(playerHand, cpuHand);
            }
        });

        window.ClearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                window.RefreshUI(gameManager);
                window.RefreshWindow();
            }
        });
    }
}
