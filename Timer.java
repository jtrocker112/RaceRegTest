import java.util.*;
import java.io.*;
/**
 * Welcome to the Timer class! 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer
{
    private long startTime, endTime;
    
    private List<RaceTime> times;
    private Program program;
    
    private timerWin window;
    
    /**
     * Constructor for objects of class Timer
     */
    public Timer(Program p)
    {
        program = p;
       
        window = new timerWin(this);
        
        startTime = 0;
        endTime = 0;
        times = new ArrayList<RaceTime>();
    }
    
    public void setStartTime(long st)
    {
        startTime = st;
        //System.out.println(startTime);
    }
    
    public long getStartTime()
    {
       return startTime; 
    }
    
    public void setEndTime(long et)
    {
        endTime = et;
    }
    
    public void startTimer()
    {
        setStartTime(System.currentTimeMillis());
    }
    
    public void lap()
    {
        long tempLong = System.currentTimeMillis();
        long currentRacerLong = tempLong - startTime;
        RaceTime tempTime = new RaceTime(currentRacerLong);
        //System.out.println("LAP: " + currentRacerLong);
        times.add(tempTime);
    }
    
    public void stopTimer()
    {
        setEndTime(System.currentTimeMillis());
    
        for(int i = 0; i < times.size(); i++)
        {
            String currentRacer = times.get(i).getDoubleTime();
            //System.out.println(currentRacer);
        }
        program.addTimes(times);
        program.timerComplete();
    }
    
    
     
    
    public void setToVisible()
    {
        window.setToVisible();
    }
}
