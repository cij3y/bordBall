import static javax.swing.JOptionPane.showMessageDialog;

public class Player {

    String name;

    static int winner = 1;
    static int currentPlayer;
    static int turn = 1;

    public void setName(String name) {
        this.name = name;
    }

    static void checkWinner(){

        if(GuiBordBall.currentPosition.equals("600300")){
            showMessageDialog(null,"Player " + StartGui.player1Name + " hat gewonnen");
            winner = 0;
        }else if(GuiBordBall.currentPosition.equals("600350")){
            showMessageDialog(null,"Player " + StartGui.player1Name + " hat gewonnen");
            winner = 0;
        }else if(GuiBordBall.currentPosition.equals("600400")){
            showMessageDialog(null,"Player " + StartGui.player1Name + " hat gewonnen");
            winner = 0;
        }else if(GuiBordBall.currentPosition.equals("100300")){
            showMessageDialog(null,"Player " + StartGui.player2Name + " hat gewonnen");
            winner = 0;
        }else if(GuiBordBall.currentPosition.equals("100350")){
            showMessageDialog(null,"Player " + StartGui.player2Name + " hat gewonnen");
            winner = 0;
        }else if(GuiBordBall.currentPosition.equals("100400")){
            showMessageDialog(null,"Player " + StartGui.player2Name + " hat gewonnen");
            winner = 0;
        }
    }

    static void checkCurrentPlayer(){
        if(Ball.positionChecked == 0){
            turn++;
        }
        turn = turn % 2;
        if(turn == 0) {
            showMessageDialog(null, "" + StartGui.player1Name + " ist am Ball -->");
            currentPlayer = 1;
        }else{
            showMessageDialog(null, "" + StartGui.player2Name + " ist am Ball <--");
        }
    }
}
