import javax.swing.*;
import java.awt.*;


/**
 * Created by Julia on 20.04.2015.
 */
public class ClockFrame extends JFrame {
    public ClockFrame() {
        setTitle("Clock");
        setSize(700,700);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        add(mainPanel);


        secondHand = new SecondHand();
        mainPanel.add(secondHand);




    }


    public static SecondHand getSecondHand() {
        return secondHand;
    }

    private static SecondHand secondHand;

}