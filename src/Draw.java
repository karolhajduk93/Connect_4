import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Draw extends JComponent {

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;


        /*Game.circles[0].set(0, 1);
        Game.circles[6].set(0, 1);*/
        for(int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                g2.draw( new Ellipse2D.Double(5 + (50*j), 5 + (50*i), 40, 40));
                if(Game.circles[j].get(i) == 1) { // red
                    g2.setColor(Color.red);
                    g2.draw( new Ellipse2D.Double(5 + (50*j), 5 + (50*i), 40, 40));
                    g2.fill(new Ellipse2D.Double(5 + (50*j), 5 + (50*i), 40, 40));
                    g2.setColor(Color.black);
                }
                else if(Game.circles[j].get(i) == 2) { // blue
                    g2.setColor(Color.blue);
                    g2.draw( new Ellipse2D.Double(5 + (50*j), 5 + (50*i), 40, 40));
                    g2.fill(new Ellipse2D.Double(5 + (50*j), 5 + (50*i), 40, 40));
                    g2.setColor(Color.black);
                }
            }
        }

        if (Player.tour) {
            g2.drawString("Red turns", 150, 310);
        }
        else
            g2.drawString("Blue turns", 150, 310);
    }
}
