import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class TimerWindow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class timerWin extends Window
{
    private Timer timer;
    private JButton start, lap, end;
      
    /**
     * Constructor for objects of class TimerWindow
     */
    public timerWin(Timer t)
    {
        super("Timer", 500, 500, 500, 500, false);
        timer = t;
        
        
        start = new JButton("Start Race");
        start.setBounds(0, 0, 500, 50);
        start.addActionListener(this);
        this.add(start, 0);
        
        lap = new JButton("Lap (Racer Pass)");
        lap.setBounds(0, 50, 500, 50);
        lap.addActionListener(this);
        lap.setVisible(false);
        this.add(lap, 0);
        
        end = new JButton("Stop Race");
        end.setBounds(0, 100, 500, 50);
        end.addActionListener(this);
        end.setVisible(false);
        this.add(end, 0);
        
        //recordBibNumbers();
    }
    
    public void reset()
    {
        start.setVisible(true);
        lap.setVisible(false);
        end.setVisible(false);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == start)
        {
            timer.startTimer();
            start.setVisible(false);
            lap.setVisible(true);
            end.setVisible(true);
        }
        if(e.getSource() == lap)
        {
            timer.lap();
        }
        if(e.getSource() == end)
        {
            timer.stopTimer();     
            
            this.reset();
            this.setVisible(false);
        }
    }
    
    public void setToVisible()
    {
        this.setVisible(true);
    }
    
}
