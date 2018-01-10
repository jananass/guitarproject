/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarproject;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author johan stefani et romain ramamonjisoa
 */
public class GuitarNeck extends JPanel
{
    private Image img;
    
    public GuitarNeck(String file)
    {
        try
        {
            img = ImageIO.read(new File("K:\\home_etu-\\s16005598\\je danse la java\\GuitarProject\\src\\img\\guitarNeck.jpg"));
            setPreferredSize(new Dimension(300,300));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(img, 0, 0, null);
    }
}
