import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class MainProgram here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWindow extends Window
{
    private EzImage logo;
    private JButton newRacer, importRacers, endReg, exit, timer, bibs;
    private Window racerRegistration;
    private Program program;
    //final JFileChooser fc;
    /**
     * Constructor for objects of class MainProgram
     */
    public MainWindow(Program p)
    {
        super("RaceReg", 10, 10, 500, 500, true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        program = p;
        //fc = new JFileChooser();
        
        //Logo
        logo = new EzImage(100, 10, 250, 75, "Images/logo.PNG");
        this.add(logo, 0);
        
        //New Racer Button
        newRacer = new JButton("New Racer");
        newRacer.addActionListener(this);
        newRacer.setBounds(30, 100, 150, 50);
        this.add(newRacer, 0);
        this.repaint();
        
        //End Registration
        endReg = new JButton("Complete Registration");
        endReg.addActionListener(this);
        endReg.setBounds(30, 220, 150, 50);
        this.add(endReg, 0);
        this.repaint();
        
        //Import Button
        importRacers = new JButton("Import Racers");
        importRacers.addActionListener(this);
        importRacers.setBounds(30, 160, 150, 50);
        this.add(importRacers, 0);
        this.repaint();
        
        //Exit Button
        exit = new JButton("EXIT");
        exit.addActionListener(this);
        exit.setBounds(400, 10, 75, 50);
        this.add(exit, 0);
        this.repaint();
        
        //Timer Launch
        timer = new JButton("Launch Timer");
        timer.addActionListener(this);
        timer.setBounds(200, 200, 200, 100);
        this.add(timer, 0);
        timer.setVisible(true);
        this.repaint();
        
        //bibs Times
        bibs = new JButton("Bib Number Entry");
        bibs.addActionListener(this);
        bibs.setBounds(200, 400, 200, 50);
        this.add(bibs, 0);
        bibs.setVisible(false);
        this.repaint();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == newRacer)
        {
            program.registerRacer();
        }
        if(e.getSource() == exit)
        {
            System.exit(0);
        }
        if(e.getSource() == endReg)
        {
            JOptionPane.showMessageDialog(null, "ALL ADDED RACERS WILL BE SAVED TO A .CSV FILE IN THE PROGRAM FOLDER.", "Registration Complete", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "This feature is not currently available. CHECK FILE FOLDER", "DEVELOPMENT ERROR", JOptionPane.INFORMATION_MESSAGE);
            endReg.setVisible(false);
            newRacer.setVisible(false);
            //importRacers.setVisible(false);
            program.saveRacers();
        }
        if(e.getSource() == importRacers)
        {
            //JOptionPane.showMessageDialog(null, "Select your .csv file template now.", "Racers Import", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "This feature is not yet availible. Please enter all racers using the 'New Racer' button.", "Racers Import", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == timer)
        {
            program.launchTimer();
        }
//         if(e.getSource() == fc)
//         {
//             //program.importRacers();
//         }
        if(e.getSource() == bibs)
        {
            program.bibEntry();
        }
    }
   
    public void timerComplete()
    {
        timer.setVisible(false);
        bibs.setVisible(true);
    }
}
