import javax.swing.*;
import java.awt.*;


/**
 * Created by Julia on 20.04.2015.
 */
public class ClockFrame extends JFrame {
    /**
     * Class constructor.
     */
    public ClockFrame() {
        setTitle("Clock");
        setSize(700,700);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        add(mainPanel);


        arrPan = new ArrowPanel();
        mainPanel.add(arrPan);
    }

    /**
     * Getting panel with drawing arrows.
     * @return panel of frame
     */
    public static ArrowPanel getArrowPanel() {
        return arrPan;
    }

    private static ArrowPanel arrPan;

}