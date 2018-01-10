/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author johan stefani and romain ramamonjisoa
 */
public class GuitarWindow extends JFrame implements ActionListener
{
    private GuitarNeck gneck;
    
    GuitarWindow(String s)
    {
        super(s);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setResizable(false);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu chords = new JMenu("Accords");
        menuBar.add(chords);
        
        JMenuItem create = new JMenuItem("Créer");
        chords.add(create);
        chords.setActionCommand("menu_quitter");
        chords.addActionListener(this);
        
        JMenuItem edit = new JMenuItem("Éditer");
        chords.add(edit);
        chords.setActionCommand("menu_quitter");
        chords.addActionListener(this);
        
        JMenuItem search = new JMenuItem("Rechercher");
        chords.add(search);
        chords.setActionCommand("menu_quitter");
        chords.addActionListener(this);
        
        chords.add(new JSeparator());
        
        JMenuItem delete = new JMenuItem("Supprimer");
        chords.add(delete);
        chords.setActionCommand("menu_quitter");
        chords.addActionListener(this);
        
        
        gneck = new GuitarNeck("../img/guitarNeck.jpeg");
        setContentPane(gneck);
        setVisible(true);
        pack();
         
    }
    
    public void actionPerformed(ActionEvent evenement)
    {
        if(evenement.getActionCommand().equals("menu_quitter"))
            System.out.println("MENU QUITTER");
    }

}