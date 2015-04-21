import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class ArrowHand implements ActionListener {
    public ArrowHand() {
        ClockFrame.getArrowPanel().setASecond(getSecondAngle());
        ClockFrame.getArrowPanel().setAMinute(getMinAngle());
        ClockFrame.getArrowPanel().setAHour(getHourAngle());
    }
    public void setTime(int h, int m, int s) {
        sec =s%60;
        hour =h%12*5+m/12;
        min =m%60;
        ClockFrame.getArrowPanel().setASecond(getSecondAngle());
        ClockFrame.getArrowPanel().setAMinute(getMinAngle());
        ClockFrame.getArrowPanel().setAHour(getHourAngle());
    }
    public void setCurTime() {

        LocalTime lt=LocalTime.now();
        sec =lt.getSecond()+1;
        min =lt.getMinute();
        hour =lt.getHour()%12*5+ min /12;
        ClockFrame.getArrowPanel().setASecond(getSecondAngle());
        ClockFrame.getArrowPanel().setAMinute(getMinAngle());
        ClockFrame.getArrowPanel().setAHour(getHourAngle());
    }
    public String getTime() {
        if(hour == 0){
            return 12+":"+ min +":"+ sec;
        }
        else
        {
            return hour / 5 + ":" + min + ":" + sec;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        LocalTime lctcur=LocalTime.now();
        int h=lctcur.getHour()%12;
        int m=lctcur.getMinute();
        int s=lctcur.getSecond();

        System.out.println(h+":"+m+":"+s+"     "+getTime());


        ClockFrame.getArrowPanel().setASecond(getSecondAngle());
        ClockFrame.getArrowPanel().setAMinute(getMinAngle());
        ClockFrame.getArrowPanel().setAHour(getHourAngle());
        sec++;
        if (sec >= 60) {
            sec = 0;

            min++;
            if(min == 12 || min == 24 || min == 36 || min == 48 || min == 60)
            {
                hour++;}

            if(hour >=60) {
                hour =0;}
            if (min >= 60) {
                min =0;}


        }

    }

    private double getSecondAngle() {
        return (sec * angle);
    }
    private double getMinAngle() {
        return(min * angle);
    }
    private double getHourAngle() {
        return(hour * angle);
    }
    public int getSeconds() {
        return sec;
    }
    public int getMinutes() {
        return min;
    }
    public int getHours() {
        if(hour == 0)
        {return 12;}
            else
        {return hour;}
    }
    private int sec = 0;
    private int min =0;
    private int hour =0;
    private final double angle = 6 * Math.PI / 180;

}
