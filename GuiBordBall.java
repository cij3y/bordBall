import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class GuiBordBall extends JFrame implements ActionListener, KeyListener {

    Timer timer = new Timer(1, this);
    static int ballX = 350;
    static int ballY = 350;


    static String currentPosition;
    static String currentMove;

    public GuiBordBall() {
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setAutoRequestFocus(false);
        setLayout(null);
        setVisible(true);
        setSize(700, 700);
        setResizable(false);
        setTitle("Brett Ball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel field = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.drawLine(100, 100, 600, 100);
                g.drawLine(100, 600, 600, 600);
                g.drawLine(100, 600, 100, 400);
                g.drawLine(100, 100, 100, 300);
                g.drawLine(600, 600, 600, 400);
                g.drawLine(600, 100, 600, 300);
                g.drawLine(100, 400, 50, 400);
                g.drawLine(100, 300, 50, 300);
                g.drawLine(600, 400, 650, 400);
                g.drawLine(600, 300, 650, 300);
                g.drawString("\u26bd", ballX, ballY);
            }
        };

        JLabel legendTennKeyLess = new JLabel(("Machen Sie eine Bewegung: " +
                "y: \u2199 , x: \u2193 , c: \u2198 , a: \u2190 , \n" +
                "d: \u2192 , q: \u2196 , w: \u2191  , e: \u2197 "));

        JLabel legend = new JLabel(("Machen Sie eine Bewegung: " +
                "1: \u2199 , 2: \u2193 , 3: \u2198 , 4: \u2190 , \n" +
                "6: \u2192 ,7: \u2196 , 8: \u2191  , 9: \u2197 "));

        //Containers
        Container gameField = getContentPane();
        gameField.setLayout(new BorderLayout());
        gameField.add(legendTennKeyLess, BorderLayout.NORTH);
        gameField.add(field, BorderLayout.CENTER);
        gameField.add(legend, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Player.winner == 0) {
            System.exit(0);
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        java.util.List<Integer> moveLines = new ArrayList<>();
        if (e.getKeyCode() == KeyEvent.VK_NUMPAD4 || e.getKeyCode() == KeyEvent.VK_A) {
            int oldX = ballX;
            ballX = ballX - 50;
            if(ballX < 100 || ballX > 600 || ballY < 100 || ballY > 600){
                ballX = ballX + 50;
                showMessageDialog(null, "Der Ball darf das Spielfeld nicht verlassen, wählen Sie einen anderen Zug");
            }else {
                currentPosition = String.valueOf(ballX) + String.valueOf(ballY);
                currentMove = String.valueOf(oldX) + String.valueOf(ballY) + String.valueOf(ballX) + String.valueOf(ballY);
                Ball.checkMoves();
                if (Ball.checkMove == 0) {
                    moveLines.add(oldX);
                    moveLines.add(ballY);
                    moveLines.add(ballX);
                    moveLines.add(ballY);
                    JPanel kick = new JPanel() {
                        @Override
                        public void paint(Graphics g) {
                            g.drawLine(moveLines.get(moveLines.size() - 4), moveLines.get(moveLines.size() - 3), moveLines.get(moveLines.size() - 2), moveLines.get(moveLines.size() - 1));
                        }
                    };
                    add(kick);
                    pack();
                    setSize(700, 700);
                    Ball.checkPositions();
                    Ball.addStartPosition();
                    Ball.savePositions.add(String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(oldX) + String.valueOf(ballY) + String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(ballX) + String.valueOf(ballY) + String.valueOf(oldX) + String.valueOf(ballY));
                    Ball.checkMovePossibility();
                } else {
                    ballX = ballX + 50;
                    showMessageDialog(null, "Solche Bewegung wurde bereits gemacht, wählen Sie bitte eine andere");
                }
            }
            Player.checkWinner();
            Player.checkCurrentPlayer();
        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
            int oldX = ballX;
            ballX = ballX + 50;
            if(ballX < 100 || ballX > 600 || ballY < 100 || ballY > 600){
                ballX = ballX - 50;
                showMessageDialog(null, "Der Ball darf das Spielfeld nicht verlassen, wählen Sie einen anderen Zug");
            }else {
                System.out.println("ballX: "+ ballX+" ballY: "+ ballY);
                currentPosition = String.valueOf(ballX) + String.valueOf(ballY);
                currentMove = String.valueOf(oldX) + String.valueOf(ballY) + String.valueOf(ballX) + String.valueOf(ballY);
                Ball.checkMoves();
                if (Ball.checkMove == 0) {
                    moveLines.add(oldX);
                    moveLines.add(ballY);
                    moveLines.add(ballX);
                    moveLines.add(ballY);
                    JPanel kick = new JPanel() {
                        @Override
                        public void paint(Graphics g) {
                            g.drawLine(moveLines.get(moveLines.size() - 4), moveLines.get(moveLines.size() - 3), moveLines.get(moveLines.size() - 2), moveLines.get(moveLines.size() - 1));
                        }
                    };
                    add(kick);
                    pack();
                    setSize(700, 700);
                    Ball.checkPositions();
                    Ball.addStartPosition();
                    Ball.savePositions.add(String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(oldX) + String.valueOf(ballY) + String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(ballX) + String.valueOf(ballY) + String.valueOf(oldX) + String.valueOf(ballY));
                    Ball.checkMovePossibility();
                } else {
                    ballX = ballX - 50;
                    showMessageDialog(null, "Solcher Zug wurde bereits gemacht, wählen Sie bitte einen anderen");
                }
            }
            Player.checkWinner();
            Player.checkCurrentPlayer();
        }

        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
            int oldY = ballY;
            ballY = ballY - 50;
            if(ballX < 100 || ballX > 600 || ballY < 100 || ballY > 600){
                ballY = ballY + 50;
                showMessageDialog(null, "Der Ball darf das Spielfeld nicht verlassen, wählen Sie einen anderen Zug");
            }else {
                System.out.println("ballX: "+ ballX+" ballY: "+ ballY);
                currentPosition = String.valueOf(ballX) + String.valueOf(ballY);
                currentMove = String.valueOf(ballX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY);
                Ball.checkMoves();
                if (Ball.checkMove == 0) {
                    moveLines.add(ballX);
                    moveLines.add(oldY);
                    moveLines.add(ballX);
                    moveLines.add(ballY);
                    JPanel kick = new JPanel() {
                        @Override
                        public void paint(Graphics g) {
                            g.drawLine(moveLines.get(moveLines.size() - 4), moveLines.get(moveLines.size() - 3), moveLines.get(moveLines.size() - 2), moveLines.get(moveLines.size() - 1));
                        }
                    };
                    add(kick);
                    pack();
                    setSize(700, 700);
                    Ball.checkPositions();
                    Ball.addStartPosition();
                    Ball.savePositions.add(String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(ballX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(ballX) + String.valueOf(ballY) + String.valueOf(ballX) + String.valueOf(oldY));
                    Ball.checkMovePossibility();
                } else {
                    ballY = ballY + 50;
                    showMessageDialog(null, "Solche Bewegung wurde bereits gemacht, wählen Sie bitte eine andere");
                }
            }
            Player.checkWinner();
            Player.checkCurrentPlayer();
        }
        if (e.getKeyCode() == KeyEvent.VK_X || e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
            int oldY = ballY;
            ballY = ballY + 50;
            if(ballX < 100 || ballX > 600 || ballY < 100 || ballY > 600){
                ballY = ballY - 50;
                showMessageDialog(null, "Der Ball darf das Spielfeld nicht verlassen, wählen Sie einen anderen Zug");
            }else {
                System.out.println("ballX: "+ ballX+" ballY: "+ ballY);
                currentPosition = String.valueOf(ballX) + String.valueOf(ballY);
                currentMove = String.valueOf(ballX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY);
                Ball.checkMoves();
                if (Ball.checkMove == 0) {
                    moveLines.add(ballX);
                    moveLines.add(oldY);
                    moveLines.add(ballX);
                    moveLines.add(ballY);
                    JPanel kick = new JPanel() {
                        @Override
                        public void paint(Graphics g) {
                            g.drawLine(moveLines.get(moveLines.size() - 4), moveLines.get(moveLines.size() - 3), moveLines.get(moveLines.size() - 2), moveLines.get(moveLines.size() - 1));
                        }
                    };
                    add(kick);
                    pack();
                    setSize(700, 700);
                    Ball.checkPositions();
                    Ball.addStartPosition();
                    Ball.savePositions.add(String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(ballX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(ballX) + String.valueOf(ballY) + String.valueOf(ballX) + String.valueOf(oldY));
                    Ball.checkMovePossibility();
                } else {
                    ballY = ballY - 50;
                    showMessageDialog(null, "Solche Bewegung wurde bereits gemacht, wählen Sie bitte eine andere");
                }
            }
            Player.checkWinner();
            Player.checkCurrentPlayer();
        }
        if (e.getKeyCode() == KeyEvent.VK_Q || e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
            int oldX = ballX;
            int oldY = ballY;
            ballX = ballX - 50;
            ballY = ballY - 50;
            if(ballX < 100 || ballX > 600 || ballY < 100 || ballY > 600){
                ballX = ballX + 50;
                ballY = ballY + 50;
                showMessageDialog(null, "Der Ball darf das Spielfeld nicht verlassen, wählen Sie einen anderen Zug");
            }else {
                System.out.println("ballX: "+ ballX+" ballY: "+ ballY);
                currentPosition = String.valueOf(ballX) + String.valueOf(ballY);
                currentMove = String.valueOf(oldX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY);
                Ball.checkMoves();
                if (Ball.checkMove == 0) {
                    moveLines.add(oldX);
                    moveLines.add(oldY);
                    moveLines.add(ballX);
                    moveLines.add(ballY);
                    JPanel kick = new JPanel() {
                        @Override
                        public void paint(Graphics g) {
                            g.drawLine(moveLines.get(moveLines.size() - 4), moveLines.get(moveLines.size() - 3), moveLines.get(moveLines.size() - 2), moveLines.get(moveLines.size() - 1));
                        }
                    };
                    add(kick);
                    pack();
                    setSize(700, 700);
                    Ball.checkPositions();
                    Ball.addStartPosition();
                    Ball.savePositions.add(String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(oldX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(ballX) + String.valueOf(ballY) + String.valueOf(oldX) + String.valueOf(oldY));
                    Ball.checkMovePossibility();
                } else {
                    ballX = ballX + 50;
                    ballY = ballY + 50;
                    showMessageDialog(null, "Solche Bewegung wurde bereits gemacht, wählen Sie bitte eine andere");
                }
            }
            Player.checkWinner();
            Player.checkCurrentPlayer();
        }
        if (e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
            int oldX = ballX;
            int oldY = ballY;
            ballX = ballX + 50;
            ballY = ballY - 50;
            if(ballX < 100 || ballX > 600 || ballY < 100 || ballY > 600){
                ballX = ballX - 50;
                ballY = ballY + 50;
                showMessageDialog(null, "Der Ball darf das Spielfeld nicht verlassen, wählen Sie einen anderen Zug");
            }else {
                System.out.println("ballX: "+ ballX+" ballY: "+ ballY);
                currentPosition = String.valueOf(ballX) + String.valueOf(ballY);
                currentMove = String.valueOf(oldX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY);
                Ball.checkMoves();
                if (Ball.checkMove == 0) {
                    moveLines.add(oldX);
                    moveLines.add(oldY);
                    moveLines.add(ballX);
                    moveLines.add(ballY);
                    JPanel kick = new JPanel() {
                        @Override
                        public void paint(Graphics g) {
                            g.drawLine(moveLines.get(moveLines.size() - 4), moveLines.get(moveLines.size() - 3), moveLines.get(moveLines.size() - 2), moveLines.get(moveLines.size() - 1));
                        }
                    };
                    add(kick);
                    pack();
                    setSize(700, 700);
                    Ball.checkPositions();
                    Ball.addStartPosition();
                    Ball.savePositions.add(String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(oldX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(ballX) + String.valueOf(ballY) + String.valueOf(oldX) + String.valueOf(oldY));
                    Ball.checkMovePossibility();
                } else {
                    ballX = ballX - 50;
                    ballY = ballY + 50;
                    showMessageDialog(null, "Solche Bewegung wurde bereits gemacht, wählen Sie bitte eine andere");
                }
            }
            Player.checkWinner();
            Player.checkCurrentPlayer();
        }
        if (e.getKeyCode() == KeyEvent.VK_Y || e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
            int oldX = ballX;
            int oldY = ballY;
            ballX = ballX - 50;
            ballY = ballY + 50;
            if(ballX < 100 || ballX > 600 || ballY < 100 || ballY > 600){
                ballX = ballX + 50;
                ballY = ballY - 50;
                showMessageDialog(null, "Der Ball darf das Spielfeld nicht verlassen, wählen Sie einen anderen Zug");
            }else {
                System.out.println("ballX: "+ ballX+" ballY: "+ ballY);
                currentPosition = String.valueOf(ballX) + String.valueOf(ballY);
                currentMove = String.valueOf(oldX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY);
                Ball.checkMoves();
                if (Ball.checkMove == 0) {
                    moveLines.add(oldX);
                    moveLines.add(oldY);
                    moveLines.add(ballX);
                    moveLines.add(ballY);
                    JPanel kick = new JPanel() {
                        @Override
                        public void paint(Graphics g) {
                            g.drawLine(moveLines.get(moveLines.size() - 4), moveLines.get(moveLines.size() - 3), moveLines.get(moveLines.size() - 2), moveLines.get(moveLines.size() - 1));
                        }
                    };
                    add(kick);
                    pack();
                    setSize(700, 700);
                    Ball.checkPositions();
                    Ball.addStartPosition();
                    Ball.savePositions.add(String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(oldX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(ballX) + String.valueOf(ballY) + String.valueOf(oldX) + String.valueOf(oldY));
                    Ball.checkMovePossibility();
                } else {
                    ballX = ballX + 50;
                    ballY = ballY - 50;
                    showMessageDialog(null, "Solche Bewegung wurde bereits gemacht, wählen Sie bitte eine andere");
                }
            }
            Player.checkWinner();
            Player.checkCurrentPlayer();
        }
        if (e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
            int oldX = ballX;
            int oldY = ballY;
            ballX = ballX + 50;
            ballY = ballY + 50;
            if(ballX < 100 || ballX > 600 || ballY < 100 || ballY > 600){
                ballX = ballX - 50;
                ballY = ballY - 50;
                showMessageDialog(null, "Der Ball darf das Spielfeld nicht verlassen, wählen Sie einen anderen Zug");
            }else {
                System.out.println("ballX: "+ ballX+" ballY: "+ ballY);
                currentPosition = String.valueOf(ballX) + String.valueOf(ballY);
                currentMove = String.valueOf(oldX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY);
                Ball.checkMoves();
                if (Ball.checkMove == 0) {
                    moveLines.add(oldX);
                    moveLines.add(oldY);
                    moveLines.add(ballX);
                    moveLines.add(ballY);
                    JPanel kick = new JPanel() {
                        @Override
                        public void paint(Graphics g) {
                            g.drawLine(moveLines.get(moveLines.size() - 4), moveLines.get(moveLines.size() - 3), moveLines.get(moveLines.size() - 2), moveLines.get(moveLines.size() - 1));
                        }
                    };
                    add(kick);
                    pack();
                    setSize(700, 700);
                    Ball.checkPositions();
                    Ball.addStartPosition();
                    Ball.savePositions.add(String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(oldX) + String.valueOf(oldY) + String.valueOf(ballX) + String.valueOf(ballY));
                    Ball.saveMoves.add(String.valueOf(ballX) + String.valueOf(ballY) + String.valueOf(oldX) + String.valueOf(oldY));
                    Ball.checkMovePossibility();
                } else {
                    ballX = ballX - 50;
                    ballY = ballY - 50;
                    showMessageDialog(null, "Solche Bewegung wurde bereits gemacht, wählen Sie bitte eine andere");
                }
            }
            Player.checkWinner();
            Player.checkCurrentPlayer();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}



