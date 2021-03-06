import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;

public class Game extends JFrame {

    static int WIDTH = 360 , HEIGHT = 350;
    static ArrayList<Integer>[] circles = new ArrayList[7];
    public static void main(String[] args) {
        new Game();
    }


    public Game(){
        this.setTitle("Connect 4");
        this.setSize(WIDTH, HEIGHT); //7 on 6
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating board of empty circles
        for(int i = 0; i < 7; i++) {
            circles[i] = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                circles[i].add(0);
            }
        }
        Player player1 = new Player();
        Player player2 = new Player();

        Draw draw = new Draw();
        this.add(draw);


        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                int column = -1;
                int yPressed = e.getX() - 3;
                for (int j = 0; j < 7; j++) {
                    if(yPressed >= (5 + 50 * j) && yPressed <= (45 + 50 * j)){
                        column = j;
                    }
                }
                if(Player.tour && column != -1){
                    player1.move(column);
                    repaint();
                    Player.winCondition();
                    repaint();
                }
                else if(!Player.tour && column != -1){
                    player2.move(column);
                    repaint();
                    Player.winCondition();
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.setVisible(true);
    }

    public static void setDefault(){
        for(int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                circles[i].set(j, 0);
            }
        }
        Player.tour = true;
        Player.moveNumber = 0;
        Player.counterBlue = 0;
        Player.counterRed = 0;
    }
}
