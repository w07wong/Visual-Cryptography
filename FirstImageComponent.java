import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * @author William Wong
 * @version 1.0.0
 */
public class FirstImageComponent extends JComponent
{
    private static int x = 0;
    private static int y = 0;
    private static int width;
    private static int height;

    static Color[] colors;
    static Random rand = new Random();

    static Graphics2D g2;

    public void getGraphics(Graphics2D g2, int w, int h, Color[] c) //gets g2 object so program can draw pixels
    {
        this.g2 = g2; 
        width = w;
        height = h;
        colors = c;
    }

    public static void drawFirst()
    {
        while(x<width && y < height)
        {
            int randomColor = rand.nextInt(2); //selects either the number 0 or 1 to determine color scheme for group of 4 rectangles
            Rectangle pixel1 = new Rectangle(x,y,1,1); //creates a square of 4 rectangles
            Rectangle pixel2 = new Rectangle(x+1,y,1,1);
            Rectangle pixel3 = new Rectangle(x,y+1,1,1);
            Rectangle pixel4 = new Rectangle(x+1,y+1,1,1);

            g2.draw(pixel1); //draws pixels
            g2.draw(pixel2);
            g2.draw(pixel3);
            g2.draw(pixel4);
            if(randomColor == 0) //if the 1st color scheme is selected the top left and bottom right squares will be filled in with black and the other two, white
            {
                g2.setColor(colors[0]);
                g2.fill(pixel1);
                g2.fill(pixel4);
                g2.setColor(colors[1]);
                g2.fill(pixel2);
                g2.fill(pixel3);
            }

            if(randomColor == 1) //opposite senario if the second color scheme is chosen
            {
                g2.setColor(colors[0]);
                g2.fill(pixel2);
                g2.fill(pixel3);
                g2.setColor(colors[1]);
                g2.fill(pixel1);
                g2.fill(pixel4);
            }
            DrawerComponent.pattern.add(randomColor); //adds the pattern chosen to the pattern arraylist in DrawerComponent
            x += 2; //shifts the x value 2 to the left because groups of 2x2 squares are being drawn

            if(x==width) //if the max x value has been reached, go 2 lines below the current line
            {
                x=0;
                y+=2;
            }
        }
    }
}
