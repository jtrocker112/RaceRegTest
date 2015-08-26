
/**
 * Write a description of class RaceTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RaceTime
{
    private long longTime;
    private double doubleTime;
    private String raceTime;
    
    /**
     * Constructor for objects of class RaceTime
     */
    public RaceTime(long lT)
    {
        longTime = lT;
        longTime /= 1000;
        doubleTime = (double) lT;
        doubleTime /= 1000;
    }
    
    public RaceTime(String raceT)
    {
        raceTime = raceT;
        String seconds, minutes;
        
        
        int l = raceTime.indexOf(":");
        String minS = raceTime.substring(0, l);
        String timeS = raceTime.substring(l+1, raceTime.length());
        
        double minD = Double.parseDouble(minS);
        double timeD = Double.parseDouble(timeS);
        
        minD *= 60;
        minD += timeD;
        doubleTime = minD;
        longTime = (long) minD;
    }
    
    public long getLongTime()
    {
        return longTime;
    }
   
    public String getDoubleTime()
    {
        double seconds = doubleTime % 60;
        double minutes = doubleTime - seconds;
        minutes = minutes / 60;
        int intMin = (int) minutes;
        seconds *= 100;
        seconds = Math.rint(seconds);
        seconds = seconds / 100;
        if(doubleTime < 60.0)
        {
            return 0 + ":" + seconds;
        }
        if(doubleTime > 60.0)
        {
            return intMin + ":" + seconds;
        }
        return "THERE WAS AN ERROR. PLEASE NOTIFY DEVELOPMENT.";
    }
}
