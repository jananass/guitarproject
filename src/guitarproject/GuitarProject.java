/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarproject;

/**
 *
 * @author johan stefani et romain ramamonjisoa
 */
public class GuitarProject
{
    
    public GuitarProject()
    {
       GuitarWindow window = new GuitarWindow("Neck Plus Ultra");
       GuitarXML gx = new GuitarXML();
       gx.searchXML();
       
       for (GuitarChord g : gx.chords)
       {
           System.out.println(g.name);
           System.out.println(g.fret);
           System.out.println(g.tuning);
           for (String i : g.strings)
           {
               System.out.println(i);
           }
       }
    }
    
    public static void main(String[] args)
    {
        GuitarProject project = new GuitarProject();
    }
}
