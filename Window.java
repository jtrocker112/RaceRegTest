import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of interface Window here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Window extends JFrame implements ActionListener
{
    public Window(String s, int x, int y, int w, int l, boolean v)
    {
        super(s);
        this.setBounds(x, y, w, l);
        this.setLayout(null);
        this.setVisible(v);
    }
}
