import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException; 

public class GUI extends JFrame implements ActionListener {
    static JMenuBar menuBar = new JMenuBar();;
 
    static JMenu menu = new JMenu("Menu");
    
    static JMenuItem m1 = new JMenuItem("Show Date+Time");
    static JMenuItem m2 = new JMenuItem("Write Textbox to log");
    static JMenuItem m3 = new JMenuItem("Change Background Color");
    static JMenuItem m4 = new JMenuItem("Quit");

    static JTextField textField = new JTextField(15);

    public void init() {
        // adding items to menu
        m1.setFont(new Font("Verdana", Font.PLAIN, 15));
        m1.addActionListener(this);
        menu.add(m1);
        m2.setFont(new Font("Verdana", Font.PLAIN, 15));
        m2.addActionListener(this);
        menu.add(m2);
        m3.setFont(new Font("Verdana", Font.PLAIN, 15));
        m3.addActionListener(this);
        menu.add(m3);
        m4.setFont(new Font("Verdana", Font.PLAIN, 15));
        m4.addActionListener(this);
        menu.add(m4);

        menu.setFont(new Font("Verdana", Font.PLAIN, 20));
 
        // add menu to menu bar
        menuBar.add(menu);
 
        // add menubar to frame
        this.setJMenuBar(menuBar);

        textField.setFont(new Font("Verdana", Font.PLAIN, 30));
        textField.addActionListener(this);

        this.add(textField);
 
        // set the size of the frame
        this.setSize(800, 400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Creating GUI object
        GUI GUI = new GUI();
        GUI.init();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.m1) {
            Date d = new Date(); 
            this.textField.setText("Date: " + d); 
        } else if (e.getSource() == this.m2) {
            File log = new File("log.txt");
            try {
                FileWriter writer = new FileWriter("log.txt");
                String textString = this.textField.getText();
                writer.write(textString);
                writer.close();
              } catch (IOException error) {
                System.out.println("Error");
              }

        } else if (e.getSource() == this.m3) {
            Random rand = new Random();
            Double r = rand.nextDouble();
            Double g = rand.nextDouble();
            Double b = rand.nextDouble();
            Color green = new Color.hsb(r, g, b);
        } else if (e.getSource() == this.m4) {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } if (e.getSource() == this.textField) {
            System.out.print("Text entered");
        }
    }

}