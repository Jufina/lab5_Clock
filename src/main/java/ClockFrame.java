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


        secondHand = new ArrowPanel();
        mainPanel.add(secondHand);




    }


    public static ArrowPanel getArrowPanel() {
        return secondHand;
    }

    private static ArrowPanel secondHand;

}