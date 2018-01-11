/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.imageio.ImageIO;
import java.io.IOException;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class SSCCE extends JPanel
{
    private JTable tableau;
    
    public SSCCE()
    {
        setLayout( new BorderLayout() );

    DefaultTableModel dm = new DefaultTableModel();
    dm.setDataVector(new Object[][] { {"","","", "","","","","" },
        {"","","", "","","","","" },
        {"","","", "","","","","" },
        {"","","", "","","","","" },
        {"","","", "","","","","" },
        {"","","", "","","","","" }
        }, new Object[] {"","E","A","D","G","B","e","" });
    
    tableau = new JTable(dm);
    tableau.setRowHeight(100);
    tableau.setRowHeight(0,66);
    tableau.setRowHeight(1,18);
    //tableau.setPreferredWitdh(39.7) ;
    tableau.getColumnModel().getColumn(0).setPreferredWidth(83);
    tableau.getColumnModel().getColumn(1).setPreferredWidth(29);
    tableau.getColumnModel().getColumn(2).setPreferredWidth(30);
    tableau.getColumnModel().getColumn(3).setPreferredWidth(30);
    tableau.getColumnModel().getColumn(4).setPreferredWidth(27);
    tableau.getColumnModel().getColumn(5).setPreferredWidth(31);
    tableau.getColumnModel().getColumn(6).setPreferredWidth(29);
   tableau.getColumnModel().getColumn(7).setPreferredWidth(79);
    //Pour faire disparaitre les traits
    //tableau.setShowGrid(false);

    tableau.getColumn("E").setCellRenderer(new ButtonRenderer());
    tableau.getColumn("E").setCellEditor(
        new ButtonEditor(new JCheckBox()));
    
    tableau.getColumn("A").setCellRenderer(new ButtonRenderer());
    tableau.getColumn("A").setCellEditor(
        new ButtonEditor(new JCheckBox()));
    
    tableau.getColumn("D").setCellRenderer(new ButtonRenderer());
    tableau.getColumn("D").setCellEditor(
        new ButtonEditor(new JCheckBox()));
    
    tableau.getColumn("G").setCellRenderer(new ButtonRenderer());
    tableau.getColumn("G").setCellEditor(
        new ButtonEditor(new JCheckBox()));
    
    tableau.getColumn("B").setCellRenderer(new ButtonRenderer());
    tableau.getColumn("B").setCellEditor(
        new ButtonEditor(new JCheckBox()));
    
    tableau.getColumn("e").setCellRenderer(new ButtonRenderer());
    tableau.getColumn("e").setCellEditor(
        new ButtonEditor(new JCheckBox()));

        tableau.setOpaque( false );
        DefaultTableCellRenderer renderer =
            (DefaultTableCellRenderer)tableau.getDefaultRenderer(Object.class);
        renderer.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane( tableau );
        scrollPane.setOpaque( false );
        scrollPane.getViewport().setOpaque( false );

        final ImageIcon icon = new ImageIcon("src/img/guitarNeck.jpg");

        JPanel background = new JPanel( new BorderLayout() )
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);

                g.drawImage(icon.getImage(), 0, 0, 350, 583, this);
                
            }
        };
        background.setPreferredSize(new Dimension(350,590));
        background.add( scrollPane );
        add(background);
    }

    private static void createAndShowGUI()
    {
        JPanel panel = new JPanel();

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.setLocationByPlatform( true );
        frame.setResizable(false);
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}

class ButtonRenderer extends JButton implements TableCellRenderer {
    
    //private ImageIcon im ;

  public ButtonRenderer() {
    setOpaque(false);
    setContentAreaFilled(false);
    setBorderPainted(false);
    
    try {
    Image im = ImageIO.read(getClass().getResource("src/img/point.png"));
    setIcon(new ImageIcon(im));
  } catch (Exception ex) {
    System.out.println(ex);
  }
    
    
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      //System.out.println(row + " et " + column);     
    } else {
      //
    }
  
    return this;
  }
}

class ButtonEditor extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;

  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(false);
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
      System.out.println(row + " et " + column);
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
      //                 
    }
    isPushed = false;
    return new String(label);
  }
}
