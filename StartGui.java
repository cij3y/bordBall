import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGui extends JFrame {

    static String player1Name;
    static String player2Name;

      public StartGui(){
        JFrame startWindow = new JFrame();
        startWindow.setSize(700, 100);
        startWindow.setResizable(false);
        startWindow.setTitle("Brett Ball");
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel player1Label = new JLabel();
        player1Label.setText("Wie heißt der erste Spieler? ");

        JTextField name1 = new JTextField(15);

        JLabel player2Label = new JLabel();
        player2Label.setText("Wie heißt der zweite Spieler? ");

        JTextField name2 = new JTextField(15);

        JButton startButton = new JButton("Spiel starten!");
        startButton.setSize(200,50);

        Container startScreen = getContentPane();
        startScreen.setLayout(new FlowLayout());
        startScreen.add(player1Label);
        startScreen.add(name1);
        startScreen.add(player2Label);
        startScreen.add(name2);
        startScreen.add(startButton);
        startWindow.add(startScreen);
        startWindow.setVisible(true);

        startButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            player1Name = name1.getText();
            player2Name = name2.getText();
            //System.out.println(player1Name  +" "+  player2Name);
            Player player1 = new Player();
            Player player2 = new Player();
            startWindow.dispose();
            player1.setName(player1Name);
            player2.setName(player2Name);
            new GuiBordBall();
            Player.checkCurrentPlayer();
          }
        });
    }
}
