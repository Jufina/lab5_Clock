import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class SecondHand extends JPanel {
    public SecondHand() {
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.LIGHT_GRAY);
        g2.fill(new Ellipse2D.Double(x0-100-50/2,y0-100-50/2,radius*2+50,radius*2+50));
        g2.setColor(Color.BLUE);
        g2.draw(new Ellipse2D.Double(x0-100-50/2,y0-100-50/2,radius*2+50,radius*2+50));

        x1 = (int) (x0 + (radius * Math.cos(a)));
        y1 = (int) (y0 + (radius * Math.sin(a)));
        g2.setColor(Color.RED);
        g2.draw(new Line2D.Double(x0, y0, x1, y1));


        x1m = (int) (x0 + (radius * Math.cos(am)));
        y1m = (int) (y0 + (radius * Math.sin(am)));

        g2.setColor(Color.BLACK);
        g2.draw(new Line2D.Double(x0, y0, x1m, y1m));

        x1h = (int) (x0 + ((radius-50) * Math.cos(ah)));
        y1h = (int) (y0 + ((radius-50) * Math.sin(ah)));


        g2.setColor(Color.MAGENTA);
        g2.draw(new Line2D.Double(x0, y0, x1h, y1h));

        g2.setColor(Color.BLACK);
        //Scale
        for(int j=0; j<=60; j++){
            int xsh,ysh, xesh, yesh;
            double angsh;
            int radsh=100;
            if(j%5==0 && j != 0) { //Scale of hours

                angsh= j* 6 * Math.PI / 180-Math.PI/2;
                xsh = (int) (x0 + ((radius-20) * Math.cos(angsh)));
                ysh = (int) (y0 + ((radius-20) * Math.sin(angsh)));
                xesh=(int) (x0+(radsh*Math.cos(angsh)));
                yesh = (int) (y0 + (radsh * Math.sin(angsh)));

                g2.draw(new Line2D.Double(xsh, ysh, xesh, yesh));

            //TEXT
               int px, py;
                px = (int) (x0-5 + ((radius+12) * Math.cos(angsh)));
                py = (int) (y0+5 + ((radius+12) * Math.sin(angsh)));
                g2.setColor(Color.BLACK);
                    Font textBO = new Font("Arial", Font.BOLD | Font.ITALIC, 14);
                    g2.setFont(textBO);
                    String message = j / 5 + "";

                    if(j==60) {
                        message = 12 + "";

                    }
                    g2.drawString(message, px, py);



            }
            else {
                angsh = j * 6 * Math.PI / 180;
                xsh = (int) (x0 + ((radius - 5) * Math.cos(angsh)));
                ysh = (int) (y0 + ((radius - 5) * Math.sin(angsh)));
                xesh = (int) (x0 + (radsh * Math.cos(angsh)));
                yesh = (int) (y0 + (radsh * Math.sin(angsh)));

                g2.draw(new Line2D.Double(xsh, ysh, xesh, yesh));
            }
        }
    }


    private final int x0 = 150;
    private final int y0 = 150;
    private final int radius = 100;


    public void setA(double ang) {
        a = ang-Math.PI/2;
        repaint();
    }
    public void setMinx(int x) {
        x1m=x;

    }
    public void setMinangle(double ang) {
        am=ang-Math.PI/2;
        repaint();
    }
    public void setHourangle(double ang) {
        ah = ang-Math.PI/2;
        repaint();
    }

    public int getMinx() {
        return x1m;
    }




    private static double a;
    private static double am;
    private static double ah;
    private int x1;
    private int y1;
    private int x1m;
    private int y1m;
    private int x1h;
    private int y1h;
}