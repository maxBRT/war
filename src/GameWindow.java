import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameWindow {
    private JFrame mainFrame = new JFrame("War");
    private JPanel background = new JPanel();

    private JPanel cpuCardPanel;
    private JPanel playerCardPanel;
    private JPanel playerScorePanel;
    private JPanel cpuScorePanel;
    private JLabel playerScoreLabel;
    private JLabel cpuScoreLabel;

    private int WINDOW_WIDTH = 1240;
    private int WINDOW_HEIGHT = 600;

    public boolean cardOnScreen = false;

    public void InitWindow(){

       //Main Window Settings and Adding Component
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        mainFrame.setVisible(true);
    }

    public void DrawUI(GameManager gameManager){
        //BackGround
        background.setBackground(Color.BLUE);
        background.add(gameManager.playButton);
        mainFrame.add(background, BorderLayout.CENTER);

        cpuScorePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        playerScorePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        cpuScoreLabel = gameManager.getCpuScore();
        playerScoreLabel = gameManager.getPlayerScore();

        cpuScorePanel.add(cpuScoreLabel);
        cpuScorePanel.setPreferredSize(new Dimension(1920, 36));
        cpuScorePanel.setBackground(Color.BLACK);

        playerScorePanel.add(playerScoreLabel);
        playerScorePanel.setPreferredSize(new Dimension(1920, 36));
        playerScorePanel.setBackground(Color.BLACK);

        mainFrame.add(cpuScorePanel, BorderLayout.NORTH);
        mainFrame.add(playerScorePanel, BorderLayout.SOUTH);
    }

    public void DrawCards(Card playerCard, Card cpuCard){
        playerCardPanel = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(playerCard.sprite, 0, 0, null);
            }
        };
        playerCardPanel.setPreferredSize(new Dimension(playerCard.sprite.getWidth() / 2, playerCard.sprite.getHeight() / 2));
        mainFrame.add(playerCardPanel, BorderLayout.EAST);

        cpuCardPanel = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(cpuCard.sprite, 0, 0, null);
            }
        };
        cpuCardPanel.setPreferredSize(new Dimension(cpuCard.sprite.getWidth() / 2, cpuCard.sprite.getHeight() / 2));
        mainFrame.add(cpuCardPanel, BorderLayout.WEST);

        cardOnScreen = true;
    }

    public void RefreshWindow(){
        SwingUtilities.updateComponentTreeUI(mainFrame);
    }

    public void RefreshUI(GameManager gameManager) {
        mainFrame.remove(cpuCardPanel);
        mainFrame.remove(playerCardPanel);
        cardOnScreen = false;
    }
}
