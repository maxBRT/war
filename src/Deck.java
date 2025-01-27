import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {
    private ArrayList deckArr = new ArrayList<>();

    public void InitDeck() {
        for (int i = 1; i <= 4; i++) {
            String suit = null;
            if (i == 1) suit = "Clovers";
            if (i == 2) suit = "Hearts";
            if (i == 3) suit = "Pikes";
            if (i == 4) suit = "Tiles";
            for (int value = 2; value <= 14; value++) {
                BufferedImage sprite;
                try {
                    sprite = ImageIO.read(new File("cards_textures/" + suit + "_" + Integer.toString(value) + ".png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Card newCard = new Card(value, suit, sprite);
                this.deckArr.add(newCard);
            }
        }
    }

    public void Deal(ArrayList playerHand, ArrayList cpuHand){
        Collections.shuffle(deckArr);
        for(int card = 0; card < deckArr.size(); card++){
            if(card < deckArr.size() / 2){
                playerHand.add(deckArr.get(card));
            }
            if(card >= deckArr.size() / 2){
                cpuHand.add(deckArr.get(card));
            }
        }
        deckArr.clear();
    }
}