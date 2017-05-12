import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;
/**
 * @author William Wong
 * @version 1.0.0
 */
public class SecondImageComponent extends JComponent
{
    private static int x = 0;
    private static int y = 0;
    private static int pattern1Index = 0;
    private static int pattern2Index = 0;
    private static int patternIndex = 0;
    static Random rand = new Random();
    private static int pattern;

    static Color[] colors = {Color.BLACK, new Color(255,255,255,0)};

    static Graphics2D g2;
    static BufferedImage image;

    public void getGraphics(Graphics2D g2, BufferedImage image)
    {
        this.g2 = g2; 
        this.image = image;
    }

    public static void drawSecond()
    {
        while(x<image.getWidth() && y<image.getHeight())
        {
            int pixelColor = image.getRGB(x,y); // Get pixel color by x and y position 

            pattern = DrawerComponent.pattern.get(patternIndex);
            patternIndex++;

            if(pixelColor == -16777216 && pattern == 0) //if the pixel color is black, and the 1st color scheme is being used, then fill the opposite squares with black.
            { //filling the opposite squares black will make the whole 2x2 square completely black, putting emphasis on that square
                Rectangle pixel1 = new Rectangle(x,y,1,1);
                Rectangle pixel2 = new Rectangle(x+1,y,1,1);
                Rectangle pixel3 = new Rectangle(x,y+1,1,1);
                Rectangle pixel4 = new Rectangle(x+1,y+1,1,1);
                g2.setColor(colors[0]);
                g2.fill(pixel2);
                g2.fill(pixel3);
                g2.setColor(colors[1]);
                g2.fill(pixel1);
                g2.fill(pixel4);

            } else if(pixelColor == -16777216 && pattern == 1) //if the 2nd color scheme is being used, fill the opposite squares black
            {
                Rectangle pixel1 = new Rectangle(x,y,1,1);
                Rectangle pixel2 = new Rectangle(x+1,y,1,1);
                Rectangle pixel3 = new Rectangle(x,y+1,1,1);
                Rectangle pixel4 = new Rectangle(x+1,y+1,1,1);

                g2.draw(pixel1);
                g2.draw(pixel2);
                g2.draw(pixel3);
                g2.draw(pixel4);
                g2.setColor(colors[0]);
                g2.fill(pixel1);
                g2.fill(pixel4);
                g2.setColor(colors[1]);
                g2.fill(pixel2);
                g2.fill(pixel3);

            } else { //otherwise, just generate a random 2x2 square
                int randomColor = rand.nextInt(2);
                Rectangle pixel1 = new Rectangle(x,y,1,1);
                Rectangle pixel2 = new Rectangle(x+1,y,1,1);
                Rectangle pixel3 = new Rectangle(x,y+1,1,1);
                Rectangle pixel4 = new Rectangle(x+1,y+1,1,1);

                g2.draw(pixel1);
                g2.draw(pixel2);
                g2.draw(pixel3);
                g2.draw(pixel4);
                if(randomColor == 0)
                {
                    g2.setColor(colors[0]);
                    g2.fill(pixel1);
                    g2.fill(pixel4);
                    g2.setColor(colors[1]);
                    g2.fill(pixel2);
                    g2.fill(pixel3);
                }

                if(randomColor == 1)
                {
                    g2.setColor(colors[0]);
                    g2.fill(pixel2);
                    g2.fill(pixel3);
                    g2.setColor(colors[1]);
                    g2.fill(pixel1);
                    g2.fill(pixel4);
                }
            }
            x+=2;
            if(x==image.getWidth())
            {
                x=0;
                y+=2;
            }
        }
    }
}

