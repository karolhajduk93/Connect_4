import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game extends JFrame {

    public static int WIDTH = 360 , HEIGHT = 350;
    int[] boundaries = {50, 100, 150, 200, 250, 300, 350};
    public static void main(String[] args) {
        new Game();
    }

    public Game(){
        this.setTitle("Connect 4");
        this.setSize(WIDTH, HEIGHT); //7 on 6
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                System.out.println(column);
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
}
