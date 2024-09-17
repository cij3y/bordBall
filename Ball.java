import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

public class Ball {

    static int checkMove;

    static int positionChecked;

    static List<String> savePositions = new ArrayList<>();

    static List<String> saveMoves = new ArrayList<>();

    static void addStartPosition(){
        if(savePositions.isEmpty()){
            savePositions.add("350350");
        }
    }

    static void checkPositions() {

        String position = GuiBordBall.currentPosition;
        positionChecked = 0 ;
        for (int i = 0; i < savePositions.size(); i++) {
            if (position.equals(savePositions.get(i))) {
                positionChecked++;
                break;
            }
        }
    }

    static void checkMoves() {

        checkMove = 0;
        String move = GuiBordBall.currentMove;
        for (int i = 0; i < saveMoves.size(); i++) {
            if (move.equals(saveMoves.get(i))) {
                checkMove++;
                break;
            }
        }
    }

        static void checkMovePossibility () {
            int kontrolInt = 0;
            //E4
            if (GuiBordBall.ballX == 600 && GuiBordBall.ballY == 600) {
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition1 = Integer.parseInt(GuiBordBall.currentPosition) - 50;

                    if (savePositionInt == possiblePosition1) {
                        kontrolInt++;
                        break;
                    }
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition2 = Integer.parseInt(GuiBordBall.currentPosition) - 50;

                    if (savePositionInt == possiblePosition2) {
                        kontrolInt++;
                        break;
                    }
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition3 = Integer.parseInt(GuiBordBall.currentPosition) - 50;

                    if (savePositionInt == possiblePosition3) {
                        kontrolInt++;
                        break;
                }
                    System.out.println("kontrol: " + kontrolInt);
                }
                if (kontrolInt == 3) {
                    showMessageDialog(null, "Keine Bewegung mehr möglich, beenden Sie das Program");
                }
                //E3
            }else if (GuiBordBall.ballX == 100 && GuiBordBall.ballY == 600) {
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition1 = Integer.parseInt(GuiBordBall.currentPosition) - 50;

                    if (savePositionInt == possiblePosition1) {
                        kontrolInt++;
                        break;
                    }
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition2 = Integer.parseInt(GuiBordBall.currentPosition) + 50000 - 50;

                    if (savePositionInt == possiblePosition2) {
                        kontrolInt++;
                        break;
                    }
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition3 = Integer.parseInt(GuiBordBall.currentPosition) + 500000;

                    if (savePositionInt == possiblePosition3) {
                        kontrolInt++;
                        break;
                    }
                }
                if (kontrolInt == 3) {
                    showMessageDialog(null, "Keine Bewegung mehr möglich, beenden Sie das Program");
                }
                //E2
            }else if (GuiBordBall.ballX == 600 && GuiBordBall.ballY == 100) {
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition1 = Integer.parseInt(GuiBordBall.currentPosition) - 50000;

                    if (savePositionInt == possiblePosition1) {
                        kontrolInt++;
                        break;
                    }
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition2 = Integer.parseInt(GuiBordBall.currentPosition) + 50;

                    if (savePositionInt == possiblePosition2) {
                        kontrolInt++;
                        break;
                    }
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition3 = Integer.parseInt(GuiBordBall.currentPosition) - 50000 + 50;

                    if (savePositionInt == possiblePosition3) {
                        kontrolInt++;
                        break;
                    }
                }
                System.out.println("kontrol: " + kontrolInt);
                System.out.println("positionlist: " + savePositions);
                if (kontrolInt == 3) {
                    showMessageDialog(null, "Keine Bewegung mehr möglich, beenden Sie das Program");
                }
                //E1
            }else if (GuiBordBall.ballX == 100 && GuiBordBall.ballY == 100) {
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition1 = Integer.parseInt(GuiBordBall.currentPosition) + 50;

                    if (savePositionInt == possiblePosition1) {
                        kontrolInt++;
                        break;
                    }
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition2 = Integer.parseInt(GuiBordBall.currentPosition) + 50000;

                    if (savePositionInt == possiblePosition2) {
                        kontrolInt++;
                        break;
                    }
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition3 = Integer.parseInt(GuiBordBall.currentPosition) + 50050;

                    if (savePositionInt == possiblePosition3) {
                        kontrolInt++;
                        break;
                    }
                }
                if (kontrolInt == 3) {
                    showMessageDialog(null, "Keine Bewegung mehr möglich, beenden Sie das Program");
                }
                //A
            }else if (GuiBordBall.ballX == 100 && GuiBordBall.ballY < 100) {
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition1 = Integer.parseInt(GuiBordBall.currentPosition) - 50;

                    if (savePositionInt == possiblePosition1) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition2 = Integer.parseInt(GuiBordBall.currentPosition) + 50000 - 50;

                    if (savePositionInt == possiblePosition2) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition3 = Integer.parseInt(GuiBordBall.currentPosition) + 50000;

                    if (savePositionInt == possiblePosition3) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition4 = Integer.parseInt(GuiBordBall.currentPosition) + 50050;

                    if (savePositionInt == possiblePosition4) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition5 = Integer.parseInt(GuiBordBall.currentPosition) + 50;

                    if (savePositionInt == possiblePosition5) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                if (kontrolInt == 5) {
                    showMessageDialog(null, "Keine Bewegung mehr möglich, beenden Sie das Program");
                }
                //B
            }else if (GuiBordBall.ballY == 100 && GuiBordBall.ballX < 100) {
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition1 = Integer.parseInt(GuiBordBall.currentPosition) + 50000;

                    if (savePositionInt == possiblePosition1) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition2 = Integer.parseInt(GuiBordBall.currentPosition) + 50000 - 50;

                    if (savePositionInt == possiblePosition2) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition3 = Integer.parseInt(GuiBordBall.currentPosition) - 50;

                    if (savePositionInt == possiblePosition3) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition4 = Integer.parseInt(GuiBordBall.currentPosition) - 50050;

                    if (savePositionInt == possiblePosition4) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition5 = Integer.parseInt(GuiBordBall.currentPosition) - 50000;

                    if (savePositionInt == possiblePosition5) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                if (kontrolInt == 5) {
                    showMessageDialog(null, "Keine Bewegung mehr möglich, beenden Sie das Program");
                }
                //C
            }else if (GuiBordBall.ballX == 600 && GuiBordBall.ballY < 100) {
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition1 = Integer.parseInt(GuiBordBall.currentPosition) - 50;

                    if (savePositionInt == possiblePosition1) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition2 = Integer.parseInt(GuiBordBall.currentPosition) - 50050;

                    if (savePositionInt == possiblePosition2) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition3 = Integer.parseInt(GuiBordBall.currentPosition) - 50000;

                    if (savePositionInt == possiblePosition3) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition4 = Integer.parseInt(GuiBordBall.currentPosition) - 50050 + 50;

                    if (savePositionInt == possiblePosition4) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition5 = Integer.parseInt(GuiBordBall.currentPosition) + 50;

                    if (savePositionInt == possiblePosition5) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                if (kontrolInt == 5) {
                    showMessageDialog(null, "Keine Bewegung mehr möglich, beenden Sie das Program");
                }
                //D
            }else if (GuiBordBall.ballY == 600 && GuiBordBall.ballX < 100) {
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition1 = Integer.parseInt(GuiBordBall.currentPosition) + 50000;

                    if (savePositionInt == possiblePosition1) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition2 = Integer.parseInt(GuiBordBall.currentPosition) + 50000 - 50;

                    if (savePositionInt == possiblePosition2) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition3 = Integer.parseInt(GuiBordBall.currentPosition) - 50;

                    if (savePositionInt == possiblePosition3) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition4 = Integer.parseInt(GuiBordBall.currentPosition) - 50050;

                    if (savePositionInt == possiblePosition4) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition5 = Integer.parseInt(GuiBordBall.currentPosition) - 50000;

                    if (savePositionInt == possiblePosition5) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                if (kontrolInt == 5) {
                    showMessageDialog(null, "Keine Bewegung mehr möglich, beenden Sie das Program");
                }
                //F
            }else if (GuiBordBall.ballX > 100 && GuiBordBall.ballY > 100) {
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition1 = Integer.parseInt(GuiBordBall.currentPosition) - 50;

                    if (savePositionInt == possiblePosition1) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition2 = Integer.parseInt(GuiBordBall.currentPosition) + 50000 - 50;

                    if (savePositionInt == possiblePosition2) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition3 = Integer.parseInt(GuiBordBall.currentPosition) + 50000;

                    if (savePositionInt == possiblePosition3) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition4 = Integer.parseInt(GuiBordBall.currentPosition) + 50050;

                    if (savePositionInt == possiblePosition4) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition5 = Integer.parseInt(GuiBordBall.currentPosition) + 50;

                    if (savePositionInt == possiblePosition5) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition6 = Integer.parseInt(GuiBordBall.currentPosition) - 50050;

                    if (savePositionInt == possiblePosition6) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition7 = Integer.parseInt(GuiBordBall.currentPosition) - 50000;

                    if (savePositionInt == possiblePosition7) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                for (int i = 0; i < savePositions.size(); i++) {
                    int savePositionInt = Integer.parseInt(savePositions.get(i));
                    int possiblePosition8 = Integer.parseInt(GuiBordBall.currentPosition) - 50000 +50;

                    if (savePositionInt == possiblePosition8) {
                        kontrolInt++;
                        break;
                    }
                    System.out.println("kontrol: " + kontrolInt);
                }
                if (kontrolInt == 8) {
                    showMessageDialog(null, "Keine Bewegung mehr möglich, beenden Sie das Program");
                }
            }
        }
    }



