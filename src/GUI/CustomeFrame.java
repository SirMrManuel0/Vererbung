package GUI;

import java.awt.*;
import javax.swing.*;

public class CustomeFrame extends JFrame{

    protected Font font;
    protected int Frame_width;
    protected int Frame_height;

    public CustomeFrame(){
        font = new Font("SansSerif", Font.PLAIN, 20);

        // Ermitteln der Bildschirmgröße
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        Frame_height = (int)Math.round(screenHeight / 1.5);
        Frame_width = (int)Math.round(screenWidth / 1.5);

        // GUI.GUI-Fenster-Einstellungen
        setTitle("Finanzamt");
        setSize(new Dimension(Frame_width, Frame_height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        getContentPane().setBackground(DarkThemeColors.SURFACE_MIXED_100);
    }
}
