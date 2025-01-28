import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameManager {
        JButton playButton = new JButton("PLAY");
        private JLabel playerScore;
        private JLabel cpuScore;
        private boolean atWar = false;
        private ArrayList warStack = new ArrayList();

        public void CompareCards(ArrayList playerHand, ArrayList cpuHand, GameWindow window){
        atWar = true;
        Card playerCard = (Card) playerHand.getFirst();
        Card cpuCard = (Card) cpuHand.getFirst();

        if(playerCard.getValue() > cpuCard.getValue()){
            atWar = false;
            playerHand.removeFirst();
            cpuHand.removeFirst();
            playerHand.addLast(cpuCard);
            playerHand.addLast(playerCard);
        }
        if(playerCard.getValue() < cpuCard.getValue()){
            atWar = false;
            playerHand.removeFirst();
            cpuHand.removeFirst();
            cpuHand.addLast(playerCard);
            cpuHand.addLast(cpuCard);
        }

        if(playerCard.getValue() == cpuCard.getValue()){
            atWar = true;
            warStack.add(playerCard);
            playerHand.removeFirst();
            warStack.add(cpuCard);
            cpuHand.removeFirst();
            while(atWar){
                playerCard = (Card) playerHand.getFirst();
                cpuCard = (Card) cpuHand.getFirst();

               /* window.RefreshUI(this);
                window.DrawCards(playerCard, cpuCard);
                window.RefreshWindow(); */

                if(playerCard.getValue() > cpuCard.getValue()){
                    atWar = false;
                    warStack.add(cpuCard);
                    warStack.add(playerCard);
                    playerHand.removeFirst();
                    cpuHand.removeFirst();
                    for(int card = 0; card < warStack.size(); card++){
                        playerHand.addLast(warStack.get(card));
                    }
                    warStack.clear();
                    }
                    if(playerCard.getValue() < cpuCard.getValue()){
                        atWar = false;
                        warStack.add(playerCard);
                        warStack.add(cpuCard);
                        playerHand.removeFirst();
                        cpuHand.removeFirst();
                        for(int card = 0; card < warStack.size(); card++){
                            cpuHand.addLast(warStack.get(card));
                        }
                        warStack.clear();
                    }
                    if (playerCard.getValue() == cpuCard.getValue()){
                        warStack.add(playerCard);
                        warStack.add(cpuCard);
                        playerHand.removeFirst();
                        cpuHand.removeFirst();
                    }
            }
        }
    }

    public void InitScores(Hand playerHand, Hand cpuHand){
        cpuScore = new JLabel("CPU Current Cards:" + Integer.toString(cpuHand.getMainHand().size() + cpuHand.getSecondHand().size()));
        cpuScore.setFont(new Font("Arial", Font.BOLD, 24));
        cpuScore.setForeground(Color.WHITE);
        playerScore = new JLabel("Player Current Cards:" + Integer.toString(playerHand.getMainHand().size() + playerHand.getSecondHand().size()));
        playerScore.setFont(new Font("Arial", Font.BOLD, 24));
        playerScore.setForeground(Color.WHITE);
    }
    public JLabel getPlayerScore(){
        return playerScore;
    }

    public JLabel getCpuScore(){
        return cpuScore;
    }

    public void UpdateScores(Hand playerHand, Hand cpuHand){
        cpuScore.setText("CPU Current Cards:" + Integer.toString(cpuHand.getMainHand().size() + cpuHand.getSecondHand().size()));
        playerScore.setText("Player Current Cards:" + Integer.toString(playerHand.getMainHand().size() + playerHand.getSecondHand().size()));
    }

}
