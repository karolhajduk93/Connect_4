import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Draw extends JComponent {

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        ArrayList<Integer>[] circles = new ArrayList[6];

        for(int i = 0; i < 6; i++) {
            circles[i] = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                g2.draw( new Ellipse2D.Double(5 + (50*j), 5 + (50*i), 40, 40));
                circles[i].add(0);
            }
        }
        //

        g2.drawString("Red turns", 150,310);

    }
}
