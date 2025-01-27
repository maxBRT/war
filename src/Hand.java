import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Hand {
    private ArrayList mainHand = new ArrayList<>();
    private ArrayList secondHand = new ArrayList<>();

    public ArrayList getMainHand(){
        return mainHand;
    }

    public ArrayList getSecondHand() {
        return secondHand;
    }

    public void Reshuffle(){
        Collections.shuffle(secondHand);
        for(int card = 0; card <= secondHand.size(); card++){
            mainHand.add(secondHand.get(card));
        }
        secondHand.clear();
    }

}
