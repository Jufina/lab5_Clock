import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Julia on 20.04.2015.
 */
public class Main {
    static ArrowHand arrowSec;
    public static int h,s,m;
    public static void main(String[] args) {

        ClockFrame frame = new ClockFrame();



        arrowSec = new ArrowHand();

        arrowSec.setCurTime();
        Timer timer = new Timer(1000, arrowSec );
        timer.start();

        frame.setVisible(true);
        //arrowSec.setTime(12,48,60);


    }



}
