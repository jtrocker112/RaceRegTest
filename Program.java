import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;
/**
 * Write a description of class Program here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Program
{
    private MainWindow mainWindow;
    private RegWin regWin;

    private ArrayList<Racer> racers;
    private int currentRacer;
    private List<RaceTime> times;
    private List<Integer> bibNums;
    private Timer timer;
    private bibWin bibWin;
    //private RegistrationSave fileIO;
    
    /**
     * Constructor for objects of class Program
     */
    public Program()
   {
        mainWindow = new MainWindow(this);
        regWin = new RegWin(this);
        //timerWindow = new TimerWindow();
        timer = new Timer(this);
        
        racers = new ArrayList<Racer>();
        currentRacer = 0;
        times = new ArrayList<RaceTime>();
        bibNums = new ArrayList<Integer>();
        
        bibWin = new bibWin(this);
        //fileIO = new RegistrationSave();
    }

    public void registerRacer()
    {
        JOptionPane.showMessageDialog(null, "This feature is not currently available.", "DEVELOPMENT ERROR", JOptionPane.INFORMATION_MESSAGE);
        regWin.setVisible(true);
    }
    
    public void newRacer(String fName, String lName, String age, String race, String bibNum)
    {
        Racer tempRacer = new Racer();
        tempRacer.setFirstName(fName);
        tempRacer.setLastName(lName);
        tempRacer.setAge(age);
        tempRacer.setRaceType(race);
        tempRacer.setBibNum(bibNum);
        racers.add(tempRacer);
        //System.out.println(fName + " " + lName + " " + age + " " + race);
    }
    
    public ArrayList getRacers()
    {
        return racers;
    }
    
    public void saveRacers()
    {
        System.out.println("ATTEMPTING SAVE!");
        try
        {
            File registration = new File("Registration.csv");
            FileWriter fileout = new FileWriter(registration);
            BufferedWriter writer = new BufferedWriter(fileout);
            
            writer.write("Last Name,");
            writer.write("First Name,");
            writer.write("Bib Number,");
            writer.write("Age,");
            writer.write("Race,\r");
            
            for(int i = 0; i < racers.size(); i ++)
            {
                writer.write(racers.get(i).getLastName() + ",");
                writer.write(racers.get(i).getFirstName() + ",");
                writer.write(racers.get(i).getBibNum() + ",");
                writer.write(racers.get(i).getAge() + ",");
                writer.write(racers.get(i).getRaceType() + ",\r");
            }
            writer.close();
        }
        catch(IOException ex)
        {
            System.out.println("There was an error - PROGRAM CRASH!");
            ex.printStackTrace();
        }
    }
    
//     public void importRacers(File importation)
//     {
//         
//         
//     }

    public void compile()
    {
            System.out.println("CHECK!");
            racers.clear();
            System.out.println("CHECK!");
            times.clear();
            bibNums.clear();
            compileResults();
//             try
//             {
//                 FileReader fileinReg = new FileReader("Registration.csv");
//                 BufferedReader reader = new BufferedReader(fileinReg);
//                 String lines = "";
//                 //Check Java API to see how string is blank - if size = 0 for null. 
//                 lines = reader.readLine();
//                 
//                 do{
//                     lines = reader.readLine();
//                     int i = lines.indexOf(",");
//                     String lastName = lines.substring(0, i);
//                     int k = lines.indexOf(",", i+1);
//                     String firstName = lines.substring(i+1, k);
//                     i = lines.indexOf(",", k+1);
//                     String bibNum = lines.substring(k+1, i);
//                     k = lines.indexOf(",", i+1);
//                     String age = lines.substring(i+1, k);
//                     i = lines.indexOf(",", k+1);
//                     String raceType = lines.substring(k, i);
//                     Racer tempRacer = new Racer(age, firstName, lastName, raceType, bibNum);
//                     racers.add(tempRacer);
//                     System.out.println(tempRacer.get
//                     System.out.println("CHECK!");
//                 }while(lines != null);
//                 reader.close();
//                 
//             }catch(IOException ex)
//             {
//                 System.out.println("There was a problem reading from the file");
//                 ex.printStackTrace();
//             }
//             
//             System.out.println("CHECK! 2");
//             //Import Times
//             try
//             {
//                 FileReader fileinTime = new FileReader("Times.csv");
//                 BufferedReader readerTime = new BufferedReader(fileinTime);
//                 String timeLine = null;
//                 timeLine = readerTime.readLine();
//                 do{
//                     timeLine = readerTime.readLine();
//                     int l = timeLine.indexOf(",");
//                     String bibNum = timeLine.substring(0, l);
//                     int m = timeLine.indexOf(",", l+1);
//                     String time = timeLine.substring(l+1, m);
//                     
//                     RaceTime tempTime = new RaceTime(time);
//                     times.add(tempTime);
//                     
//                     if(bibNum.equals("Bandit"))
//                         bibNums.add(-2);
//                     else
//                     {
//                         int tempInt = Integer.parseInt(bibNum);
//                         bibNums.add(tempInt);
//                     }
//                 }while(timeLine != null);
//                 readerTime.close();
//             }catch(IOException ex)
//             {
//                 System.out.println("There was a problem reading from the file");
//                 ex.printStackTrace();
//             }
//             
//             System.out.println("CHECK! 3");
//             //Race Sort
//             try
//         {
//             FileWriter fileout = new FileWriter("Results.csv");
//             BufferedWriter writer = new BufferedWriter(fileout);
//             
//             writer.write("Last Name,");
//             writer.write("First Name,");
//             writer.write("Age,");
//             writer.write("Race,");
//             writer.write("Bib Number,");
//             writer.write("Time\r");
//             
//             for(int j = 0; j < times.size(); j++)
//             {
//                 for(int i = 0; i < racers.size(); i++)
//                 {
//                     if(bibNums.get(j) == -2)
//                     {
//                         writer.write("Bandit,Bandit,N/A,DEFAULT,Bandit,");
//                         //Need to convert time.
//                         writer.write(times.get(j) + ",\r");
//                     }
//                     else if(bibNums.get(j) == Integer.parseInt(racers.get(i).getBibNum()))
//                     {
//                         writer.write(racers.get(i).getLastName() + ",");
//                         writer.write(racers.get(i).getFirstName() + ",");
//                         writer.write(racers.get(i).getAge() + ",");
//                         writer.write(racers.get(i).getRaceType() + ",");
//                         writer.write(racers.get(i).getBibNum() + ",");
//                         //Need to convert time.
//                         writer.write(times.get(j) + ",\r");
//                         
//                     }
//                     else
//                         System.out.println("There was an error.");
//                 }
//             }
//             writer.close();
//         }
//         catch(IOException ex)
//         {
//             System.out.println("There was an error - PROGRAM CRASH!");
//             ex.printStackTrace();
//         }
    }
    
    public void compileResults()
    {
//         String lines = null;
//         try
//         {
//             FileReader fileReadReg = new FileReader("Registration.csv");
//             BufferedReader readerReg = new BufferedReader(fileinReg);
//             lines = reader.readLine();
//             System.out.println("TEST PRINTOUT READ 1: " + lines);
//             
//             do{
//                     lines = reader.readLine();
//                     System.out.println("TEST PRINTOUT READ 2: " + lines);
//                     int i = lines.indexOf(",");
//                     String lastName = lines.substring(0, i);
//                     int k = lines.indexOf(",", i+1);
//                     String firstName = lines.substring(i+1, k);
//                     i = lines.indexOf(",", k+1);
//                     String bibNum = lines.substring(k+1, i);
//                     k = lines.indexOf(",", i+1);
//                     String age = lines.substring(i+1, k);
//                     i = lines.indexOf(",", k+1);
//                     String raceType = lines.substring(k, i);
//                     Racer tempRacer = new Racer(age, firstName, lastName, raceType, bibNum);
//                     racers.add(tempRacer);
//                     System.out.println(tempRacer.get
//                     System.out.println("CHECK!");
//             }while(lines != null);
//         }
//         catch(IOException ex)
//         {
//             System.out.println("There was an error while reading/writing the file.");
//             ex.printStackTrace();
//         }
    }
    
    public void launchTimer()
    {
        JOptionPane.showMessageDialog(null, "This feature is simple. Simply push the 'Lap' button when a racer comes across the line. Make sure someone is keeping track on the the Racer's bib number. If you have a bandit runner - record where they crossed as well.", "Using Timer", JOptionPane.INFORMATION_MESSAGE);
        timer.setToVisible();
    }
    
    public void timerComplete()
    {
        mainWindow.timerComplete();
    }
    
    public void bibEntry()
    {
        bibWin.setVisible(true);
    }
    
    public void saveTimes()
    {
        try
        {
            FileWriter fileout = new FileWriter("Times.csv");
            BufferedWriter writer = new BufferedWriter(fileout);
            
            writer.write("Bib Number,");
            writer.write("Time\r");

            
            for(int i = 0; i < times.size(); i ++)
            {
                if(bibNums.get(i) == 0)
                {
                    writer.write("Bandit,");
                }
                else
                    writer.write(bibNums.get(i)+ ",");
                writer.write(times.get(i).getDoubleTime() + "\r");
            }
            writer.close();
        }
        catch(IOException ex)
        {
            System.out.println("There was an error - PROGRAM CRASH!");
            ex.printStackTrace();
        }
        bibWin.setVisible(false);
        //timerWin.reset();
    }
    
    public void addTimes(List<RaceTime> t)
    {
        times = t;
    }
    
    public void addBibs(List<Integer> i)
    {
        bibNums = i;
    }
}
