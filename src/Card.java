import javax.imageio.*;
import java.awt.image.BufferedImage;

public class Card {
    private int value;
    private String suit;
    BufferedImage sprite;

    public Card(int value, String suit,BufferedImage sprite){
        this.value = value;
        this.suit = suit;
        this.sprite = sprite;
    }

    public int getValue() {
        return value;
    }
}
