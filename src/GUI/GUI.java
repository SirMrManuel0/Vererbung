package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import java.util.*;

public class GUI extends JFrame{

    protected Font font;
    protected int width;
    protected int heigth;

    public GUI(){
        font = new Font("SansSerif", Font.PLAIN, 20);

        // Ermitteln der Bildschirmgröße
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        heigth = (int)Math.round(screenHeight / 1.5);
        width = (int)Math.round(screenWidth / 1.5);

        // GUI.GUI-Fenster-Einstellungen
        setTitle("Finanzamt");
        setSize(new Dimension(width, heigth));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(DarkThemeColors.SURFACE_MIXED_100);

        // Initialisieren der GUI.GUI-Komponenten
        initComponents();

        setLocationRelativeTo(null);
    }


    protected void initComponents(){

    }
    public void display(){
        setVisible(true);
    }
    protected class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Heared you!");
        }
    }
}
