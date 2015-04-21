import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Date;

public class ArrowHand implements ActionListener {
    public ArrowHand() {
        ClockFrame.getSecondHand().setA(getAngle());
    }
    public void setTime(int h, int m, int s) {
        x=s%60;
        hourx=h%12*5+m/12;
        minx=m%60;
    }
    public void setCurTime() {

        LocalTime lt=LocalTime.now();
        x=lt.getSecond()+1;
        minx=lt.getMinute();
        hourx=lt.getHour()%12*5+minx/12;
    }
    public String getTime() {
        return hourx/5+":"+minx+":"+x;
    }
    @Override
    public void actionPerformed(ActionEvent e) {






        if (x == 60) {
            x = 0;

            minx++;
            if(minx == 12 || minx == 24 || minx == 36 || minx == 48 || minx == 60)
            {hourx++;}

            if(hourx==60) {hourx=0;}
            if (minx == 60) {minx=0;}


        }
            ClockFrame.getSecondHand().setA(getAngle());
            ClockFrame.getSecondHand().setMinangle(getMinAngle());
            ClockFrame.getSecondHand().setHourangle(getHourAngle());
        LocalTime lt2=LocalTime.now();
        System.out.print(lt2.getHour() + ":" + lt2.getMinute() + ":" + lt2.getSecond() + "     ");
        System.out.println(getTime());
        x++;
    }

    private double getAngle() {
        return (x * angle);
    }
    private double getMinAngle() {
        return(minx * angle);
    }
    private double getHourAngle() {
        return(hourx * angle);
    }
    public int getSeconds() {
        return x;
    }
    public int getMinutes() {
        return minx;
    }
    public int getHours() {
        return hourx;
    }
    private int x = 0;
    private int minx=0;
    private int hourx=0;
    private final double angle = 6 * Math.PI / 180;

}
