import java.io.*;
/**
 * Write a description of class SavingData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SavingData
{
    public static void saveText()
    {
        try
        {
            FileWriter fileout = new FileWriter("list.txt");
            BufferedWriter writer = new BufferedWriter(fileout);
            writer.write("cake\r\n");
            writer.write("ice cream\r\n");
            writer.write("soda\r\n");
            writer.write("\n");
            writer.write("First Name" + "\tLast Name" + "\tAge");
            writer.close();
        }catch(IOException ex)
        {
            System.out.println("There was am error written to the file");
            ex.printStackTrace();
        }
    }

    public static void readText()
    {
        try
        {
            FileReader filein = new FileReader("list.txt");
            BufferedReader reader = new BufferedReader(filein);
            String lines = null;
            do{
                lines = reader.readLine();
                if(lines != null)
                    System.out.println(lines);
            }while(lines != null);
            
            reader.close();
        }catch(IOException ex)
        {
            System.out.println("There was a problem reading from the file");
            ex.printStackTrace();
        }
    }
    
    public static void saveData()
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream("information.txt");
            DataOutputStream dataOut = new DataOutputStream(fileOut);
            
            int i = 67;
            double d = 5.6;
            boolean b = true;
            
            System.out.println("Writing " + i);
            dataOut.writeInt(i);
            System.out.println("Writing " + d);
            dataOut.writeDouble(d);
            System.out.println("Writing " + b);
            dataOut.writeBoolean(b);
            
            dataOut.close(); 
        }catch(IOException ex)
        {
            System.out.println("There was a problem saving data to the file");
            ex.printStackTrace();
        }
        
    }
    
    public static void readData()
    {
        try
        {
            FileInputStream filein = new FileInputStream("information.txt");
            DataInputStream datain = new DataInputStream(filein);
            
            int i = datain.readInt();
            double d = datain.readDouble();
            boolean b = datain.readBoolean();
            
            System.out.println("Read " + i);
            System.out.println("Read " + d);
            System.out.println("Read " + b);
            
            datain.close(); 
        }catch(IOException ex)
        {
            System.out.println("There was a problem reading data from the file");
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[]args)
    {
        saveText();
        readText();
        saveData();
        readData();
    }
}
