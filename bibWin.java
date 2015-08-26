import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * Write a description of class bibWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bibWin extends Window
{
    private JButton save, reset, erase, exit;
    private EzImage bibPic;
    private int counter;
    
    private Program program;
    
    private List<Integer> bibNums;
    
    private JTextField [] field;
    private JLabel [] numbers;
    
    /**
     * Constructor for objects of class bibWin
     */
    public bibWin(Program p)
    {
        super("Bib Number Entry", 0, 0, 700, 700, false);
        counter = 0;
        program = p;
        
        bibNums = new ArrayList<Integer>();
        
        exit = new JButton("Save and Exit");
        exit.setBounds(400, 550, 200, 100);
        exit.addActionListener(this);
        this.add(exit, 0);
        
        
        save = new JButton("Add Bibs");
        save.setBounds(0, 550, 200, 100);
        save.addActionListener(this);
        this.add(save, 0);
        
        
        reset = new JButton("Reset ALL");
        reset.setBounds(300, 550, 100, 100);
        reset.addActionListener(this);
        this.add(reset, 0);
       
        
        erase = new JButton("Erase Entry");
        erase.setBounds(200, 550, 100, 100);
        erase.addActionListener(this);
        this.add(erase, 0);
        
        
        field = new JTextField[10];
        int space = 50;
        for(int i = 0; i < 10; i ++)
        {
            field[i] = new JTextField();
            field[i].setBounds(100, space, 100, 50);
            space += 50;
            //field[i].setText("N/A");
            this.add(field[i], 0);
            
            field[i].setVisible(false);
        }
        
        numbers = new JLabel[10];
        space = 50;
        for(int i = 0; i < 10; i ++)
        {
            numbers[i] = new JLabel();
            numbers[i].setBounds(35, space, 100, 50);
            space += 50;
            numbers[i].setText("Racer #" + (i+1) + ":");
            this.add(numbers[i], 0);
            
            numbers[i].setVisible(false);
        }
        
        bibPic = new EzImage(300, 200, 300, 300, "number.PNG");
        this.add(bibPic, 0);
        
        
        counter = 0;
        
        for(int i = 0; i < 10; i ++)
        {
            field[i].setVisible(true);
            numbers[i].setVisible(true);
        }
        
        JOptionPane.showMessageDialog(null, "Enter the first 10 racers, then click Add Racers", "Instructions", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Once you have finished, click 'Save and Exit'", "Instructions", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "If you need to insert a blank entry type -1.", "Instructions", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "If you need to insert a bandit racer type 0.", "Instructions", JOptionPane.INFORMATION_MESSAGE);

        
        
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == save)
        {
            addBibsToList();
        }
        if(e.getSource() == erase)
        {
            eraseEntry();
        }
        if(e.getSource() == exit)
        {
            program.addBibs(bibNums);
            program.saveTimes();
        }
    }
    
    public void addBibsToList()
    {
        //Add functionality to catch String with letters - or character Strings here.
            
            counter += 10;
            for(int i = 0; i < 10; i++)
            {
                String tempString = field[i].getText();
                //System.out.println("TEST!");
                if(tempString.length() == 0)
                {
                    boolean retry = true;
                    do{
                        String messageReturn = JOptionPane.showInputDialog(null, "Woops! You didn't type an entry for Racer #" + (counter - 10 + i ) + ". Is this correct? Type '1' for yes and '2' for no.", "Confirm", JOptionPane.QUESTION_MESSAGE);
                        if(messageReturn.equals("1"))
                        {
                            JOptionPane.showMessageDialog(null, "Okay. This racer will be declared as a bandit runner.", "Adding a Racer", JOptionPane.PLAIN_MESSAGE);
                            bibNums.add(0);
                            retry = false;
                        }
                        else if(messageReturn.equals("2"))
                        {
                            String input = JOptionPane.showInputDialog(null, "Enter the bib number now:", "Adding a Racer", JOptionPane.INFORMATION_MESSAGE);
                            bibNums.add(Integer.parseInt(input));
                            retry = false;
                        }
//                         else if(messageReturn.equals("3"))
//                         {
//                             JOptionPane.showMessageDialog(null, "Bib Entry has now been reset. Please try again.", "Adding a Racer", JOptionPane.PLAIN_MESSAGE);
//                             retry = false;
//                         }
                        else{
                            JOptionPane.showMessageDialog(null, "You have made an error. Please try again. If you continue to have this problem, type '3' in the box to start Bib Number Entry over.", "Error", JOptionPane.WARNING_MESSAGE);
                            retry = true;
                        }
                    }
                    while(retry);
                    
                }
                else if(tempString.equals("0"))
                {
                    bibNums.add(0);
                }
                else
                    bibNums.add(Integer.parseInt(tempString));
                
                field[i].setText("");
                              
                numbers[i].setText("Racer #" + (counter + i + 1) + ":");
            }
            JOptionPane.showMessageDialog(null, "Enter the next 10 racers.", "Instructions", JOptionPane.INFORMATION_MESSAGE);
            
    }
    
    
    public void eraseEntry()
    {
        String tempString = JOptionPane.showInputDialog(null, "This function can help you fix an error. Type '1' if you need to erase ONE SINGLE ENTRY. Type '2' if you need to erase multiple entries.", "Erase", JOptionPane.ERROR_MESSAGE);
            if(tempString.equals("1"))
            {
                String tempString1 = JOptionPane.showInputDialog(null, "Type in the Racer # you want to erase.", "Erase", JOptionPane.ERROR_MESSAGE);
                String answerString = JOptionPane.showInputDialog(null, "Type 1 to replace the entry, Type 2 to insert as a bandit runner.", "Erase", JOptionPane.ERROR_MESSAGE);
                if(answerString.equals("1"))
                {
                    String tempString2 = JOptionPane.showInputDialog(null, "Type in the bib number you want to replace Racer #" + tempString1 + ".", "Erase", JOptionPane.ERROR_MESSAGE);
                    int tempInt1 = Integer.parseInt(tempString1);
                    int tempInt2 = Integer.parseInt(tempString2);
                    bibNums.set(tempInt1, tempInt2);
                    JOptionPane.showMessageDialog(null, "Your command is complete.", "Racer Erased.", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(answerString.equals("2"))
                {
                    int tempInt3 = Integer.parseInt(tempString1);
                    bibNums.set(tempInt3, -1); 
                }
                else
                    JOptionPane.showMessageDialog(null, "There was an error. Try again.", "Erase", JOptionPane.ERROR_MESSAGE);
            }
            else if(tempString.equals("2"))
            {
                String tempString3 = "";
                String tempString4 = "";
                
                
                    tempString3 = JOptionPane.showInputDialog(null, "This function will delete all entries past a given number. Enter the Racer # from which you want to erase all entries following.", "Erase", JOptionPane.ERROR_MESSAGE);
                    tempString4 = JOptionPane.showInputDialog(null, "You are about to delete all entries past Racer #" + tempString3 + ". Type 1 to continue. Type 2 to cancel.", "Erase", JOptionPane.ERROR_MESSAGE);
                    if(tempString4.equals("1"))
                    {
                        int tempInt4 = Integer.parseInt(tempString3);
                        for(int i = (tempInt4 + 1); i < bibNums.size(); i ++)
                        {
                           bibNums.remove(i);
                        }
                        JOptionPane.showMessageDialog(null, "You will now be taken back to the entry screen.", "Erase", JOptionPane.INFORMATION_MESSAGE);
                        
                        
                        counter = tempInt4 - (tempInt4 % 10);
                        for(int i = 0; i < 10; i ++)
                        {
                            numbers[i].setText("Racer #" + (counter + i + 1) + ":");
                        }
                        int counter2 = 0;
                        for(int k = counter; k < tempInt4; k++)
                        {
                            field[counter2].setText("" + bibNums.get(k));
                            counter2 += 1;
                        }
                        //CHECK ME!!!!!!!!!!
                        //bibNums.trimToSize();
                        counter -= 10;
                    }
                    else if(tempString4.equals("2"))
                    {
                        JOptionPane.showMessageDialog(null, "Command Canceled.", "Erase", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "There was an error. Try again.", "Erase", JOptionPane.ERROR_MESSAGE);
                
            }
            else
                JOptionPane.showMessageDialog(null, "There was an error. Try again.", "Erase", JOptionPane.ERROR_MESSAGE);
    }
    
    //This code is old code used when bibWin and timerWin were in one class together. It was also the predessor to the current GUI bib entry interface. 
    
//     public void addTimes()
//     {
//         //JOptionPane.showMessageDialog(null, "Ready? Type in each bib number IN ORDER and hit enter. If there was no bib number, please type 'bandit' and hit enter." + times.size(), "Bib Entry", JOptionPane.INFORMATION_MESSAGE);
// 
//         this.setVisible(false);
// 
//         for(int i = 0; i < times.size(); i ++)
//         {
//            String tempString = JOptionPane.showInputDialog(null, "Enter Bib Number: ", "Bib Entry", JOptionPane.INFORMATION_MESSAGE);
//            tempString.toLowerCase();
//            if(tempString.equals("bandit"))
//            {
//                tempString = "-1";
//            }
//            int toReturn = Integer.parseInt(tempString);
//            bibNums.add(toReturn);
//         }
//         //System.out.println(bibNums.toString());
//         this.setVisible(true);
//         bibs.setVisible(false);
//         exit.setVisible(true);
//     }
    
}
