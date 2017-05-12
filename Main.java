import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author William Wong
 * @version 1.0.0
 */
public class Main
{
    static Color[] colors1 = {Color.BLACK, Color.WHITE}; //determines the color key for the first layer
    //static Color[] colors2 = {new Color(255,255,255,0), Color.WHITE};
    public static void main(String args[])
    {
        DrawerComponent dc = new DrawerComponent();

        JFrame f = new JFrame("NOTHING"); //new JFrame
        f.setSize(800,800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(null, "Layer Generated"); //had a problem displaying one layer, then laying another on top of it, so the program just outputs both layers at once.
        //         dc.getColor(colors2);
        //         f.add(dc);
        //         f.setVisible(true);
        //         JOptionPane.showMessageDialog(null, "Remove Layer Generated");
        //         f.getContentPane().removeAll();
        //         f.repaint();
        //         JOptionPane.showMessageDialog(null, "Final");
        dc.getColor(colors1);//sends the color array to the DrawerComponent class
        f.add(dc);//add the drawing component to the frame
        f.setVisible(true);
    }   
}
