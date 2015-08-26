
/**
 * Write a description of class Runner here.
 * 
 * @author Jackson Porter
 * @version 0.01
 */
public class Racer
{
    private String age;
    private String firstName, lastName;
    private String raceType;
    private String bibNum;

    /**
     * Constructor for objects of class Runner
     */
    public Racer(String a, String n1, String n2, String r, String bN)
    {
        age = a;
        firstName = n1;
        lastName = n2;
        raceType = r;
        bibNum = bN;
    }
    
    public Racer()
    {
        age = "UNKNOWN AGE";
        firstName = "UNKNOWN RACER";
        lastName = "UNKNOWN RACER";
        raceType = "DEFAULT";
        bibNum = "-2";
    }
    
    public void setBibNum(String bN)
    {
        bibNum = bN;
    }
    
    public String getBibNum()
    {
        return bibNum;
    }
    
    public void setAge(String a)
    {
        age = a;
    }
    
    public String getAge()
    {
        return age;
    }
    
    public void setFirstName(String n)
    {
        firstName = n;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String n)
    {
        lastName = n;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setRaceType(String rt)
    {
        raceType = rt;
    }
    
    public String getRaceType()
    {
        return raceType;
    }
}
