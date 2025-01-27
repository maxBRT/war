import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameManager {
        JButton playButton = new JButton("PLAY");
        private JLabel playerScore;
        private JLabel cpuScore;

    public void CompareCards(ArrayList playerHand, ArrayList cpuHand){
        Card playerCard = (Card) playerHand.getFirst();
        Card cpuCard = (Card) cpuHand.getFirst();

        if(playerCard.getValue() > cpuCard.getValue()){
            playerHand.addLast(cpuCard);
            playerHand.addLast(playerCard);
            playerHand.removeFirst();
            cpuHand.removeFirst();
        }
        if(playerCard.getValue() < cpuCard.getValue()){
            cpuHand.addLast(playerCard);
            cpuHand.addLast(cpuCard);
            playerHand.removeFirst();
            cpuHand.removeFirst();
        }
    }
    public void InitScores(Hand playerHand, Hand cpuHand){
        cpuScore = new JLabel("CPU Current Cards:" + Integer.toString(cpuHand.getMainHand().size() + cpuHand.getSecondHand().size()));
        cpuScore.setFont(new Font("Arial", Font.BOLD, 24));
        cpuScore.setForeground(Color.WHITE);
        playerScore = new JLabel("CPU Current Cards:" + Integer.toString(playerHand.getMainHand().size() + playerHand.getSecondHand().size()));
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
        playerScore.setText("CPU Current Cards:" + Integer.toString(playerHand.getMainHand().size() + playerHand.getSecondHand().size()));
    }

}
