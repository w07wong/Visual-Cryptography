import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
/**
 * @author William Wong
 * @version 1.0.0
 */
public class DrawerComponent extends JComponent
{
    FirstImageComponent fi = new FirstImageComponent();
    SecondImageComponent si = new SecondImageComponent();

    static Color[] colors;
    public static ArrayList<Integer> pattern = new ArrayList<>();

    public void getColor(Color[] c) //recieves colors used to draw the first layer
    {
        colors = c;
    }

    public void paintComponent(Graphics g)
    {
        try{
            Graphics2D g2 = (Graphics2D) g;

            File file= new File("flower2.png"); //imports a file
            BufferedImage image = ImageIO.read(file);  //creates an image object

            int width = image.getWidth(); //sets parameters for generating layers
            int height = image.getHeight();

            fi.getGraphics(g2, width, height,colors); //sends information along with a Graphics2D object to the fi class
            fi.drawFirst(); //runs drawing instructions
            si.getGraphics(g2,image);
            si.drawSecond();
        }catch (Exception e)
        {
        }
    }
}