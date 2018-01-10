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
    private SSCCE gneck;
    
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
        create.setActionCommand("menu_quitter");
        create.addActionListener(this);
        
        JMenuItem edit = new JMenuItem("Éditer");
        chords.add(edit);
        edit.setActionCommand("menu_quitter");
        edit.addActionListener(this);
        
        JMenuItem search = new JMenuItem("Rechercher");
        chords.add(search);
        search.setActionCommand("recherche");
        search.addActionListener(this);
        
        chords.add(new JSeparator());
        
        JMenuItem delete = new JMenuItem("Supprimer");
        chords.add(delete);
        delete.setActionCommand("menu_quitter");
        delete.addActionListener(this);
        
        
        
        
        gneck = new SSCCE();
        setContentPane(gneck);
        setVisible(true);
        pack();
         
    }
    
    public void actionPerformed(ActionEvent evenement)
    {
        if(evenement.getActionCommand().equals("menu_quitter"))
            System.out.println("MENU QUITTER");
        else if(evenement.getActionCommand().equals("recherche"))
            System.out.println("Fenetre recherche");   
    }

}