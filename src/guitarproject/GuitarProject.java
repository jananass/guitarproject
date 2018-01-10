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

    /**
     * @param args the command line arguments
     */
    
    public GuitarProject()
    {
       GuitarWindow window = new GuitarWindow("Neck Plus Ultra");
    }
    
    public static void main(String[] args)
    {
        GuitarProject project = new GuitarProject();
    }
}
