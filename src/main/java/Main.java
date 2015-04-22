import javax.swing.*;
import java.time.LocalTime;


public class Main {
    /**
     * @value arrowSec 
     */
    static ArrowHand arrowSec;
    public static void main(String[] args) {

        ClockFrame frame = new ClockFrame();



        arrowSec = new ArrowHand();
        //arrowSec.setTime(17, 0, 0);
        arrowSec.setCurTime();
        frame.setVisible(true);
        Timer timer = new Timer(1000, arrowSec );
        timer.start();





    }



}
