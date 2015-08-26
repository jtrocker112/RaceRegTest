import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class RacerReg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegWin extends Window
{
    private Program program;
    
    private JTextField firstNameField, lastNameField, ageField, raceField, bibNumField;
    private JButton submit, save, reset;
    private JLabel fName, lName, age, race, display, bib;
    
    
    
    //Racer Qualities
    private String fN, lN, r, a, bibNum;
    /**
     * Constructor for objects of class RacerReg
     */
    public RegWin(Program p)

    {
        super("Registrating a new Racer", 10, 10, 500, 500, false);
        //
        program = p;
        
        
        //Qualities
        fN = "UNKNOWN RACER";
        lN = "UNKNOWN RACER";
        a = "UNKNOWN AGE";
        r = "DEFAULT";
        bibNum = "-2";
        
        //Submit Button
        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setBounds(275, 400, 100, 50);
        this.add(submit, 0);
        
        //First Name
        firstNameField = new JTextField(1);
        firstNameField.setBounds(120, 10, 100, 50);
        this.add(firstNameField, 0);
        
        fName = new JLabel("First Name:");
        fName.setBounds(10, 10, 100, 50);
        this.add(fName, 0);
        
        //Last Name
        lastNameField = new JTextField(1);
        lastNameField.setBounds(120, 70, 100, 50);
        this.add(lastNameField, 0);
        
        lName = new JLabel("Last Name:");
        lName.setBounds(10, 70, 100, 50);
        this.add(lName, 0);
        
        //Age
        ageField = new JTextField(1);
        ageField.setBounds(120, 130, 100, 50);
        this.add(ageField, 0);
        
        age = new JLabel("Age:");
        age.setBounds(10, 130, 100, 50);
        this.add(age, 0);
        
        //Bib Number
        bibNumField = new JTextField(1);
        bibNumField.setBounds(120, 190, 100, 50);
        this.add(bibNumField, 0);
        
        bib = new JLabel("Bib Number:");
        bib.setBounds(10, 190, 100, 50);
        this.add(bib, 0);
        
        //Race Type
        raceField = new JTextField(1);
        raceField.setText("DEFAULT");
        raceField.setBounds(120, 250, 100, 50);
        this.add(raceField, 0);
        
        race = new JLabel("Race:");
        race.setBounds(10, 250, 100, 50);
        this.add(race, 0);
        
        //Display
        display = new JLabel("Enter the Racer Information and click Submit.");
        display.setBounds(10, 400, 400, 50);
        this.add(display, 0);
        
        //Save Button
        save = new JButton("Save");
        save.setBounds(350, 200, 100, 100);
        save.addActionListener(this);
        save.setVisible(false);
        this.add(save, 0);
        
        reset = new JButton("Try Again");
        reset.setBounds(350, 300, 100, 100);
        reset.addActionListener(this);
        reset.setVisible(false);
        this.add(reset);
    }
    
    public void reset()
    {
        firstNameField.setText("");
        lastNameField.setText("");
        ageField.setText("");
        raceField.setText("DEFAULT");
        bibNumField.setText("");
        
        firstNameField.setVisible(true);
        lastNameField.setVisible(true);
        ageField.setVisible(true);
        raceField.setVisible(true);
        bibNumField.setVisible(true);
        
        fName.setText("First Name:");
        lName.setText("Last Name:");
        age.setText("Age:");
        race.setText("Race:");
        display.setText("");
        bib.setText("Bib Number");
        
        submit.setVisible(true);
        save.setVisible(false);
        fN = "";
        lN = "";
        r = "DEFAULT";
        a = "UNKNOWN AGE";
        bibNum = "-2";
        display.setText("Enter the Racer Information and click Submit.");
        reset.setVisible(false);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submit)
        {
            fN = firstNameField.getText();
            lN = lastNameField.getText();
            a = ageField.getText();
            r = raceField.getText();
            bibNum = bibNumField.getText();
            submit.setVisible(false);
            save.setVisible(true);
            
            display.setText("Please review the following racer.");
            fName.setText("First Name: " + fN);
            lName.setText("Last Name: " + lN);
            age.setText("Age: " + a);
            race.setText("Race: " + r);
            bib.setText("Bib Number: " + bibNum);
            
            firstNameField.setVisible(false);
            lastNameField.setVisible(false);
            ageField.setVisible(false);
            raceField.setVisible(false);
            bibNumField.setVisible(false);
            
            reset.setVisible(true);
        }
        if(e.getSource() == save)
        {
            this.setVisible(false);
            program.newRacer(fN, lN, a, r, bibNum);
            this.reset();
        }
        if(e.getSource() == reset)
        {
            reset();
        }
    }
}
