import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import java.util.*;

public class GUI extends JFrame{

    private Font font;
    private int width;
    private int heigth;
    private final Color FOREGROUND_COLOR;
    private final Color BACKGROUND_COLOR;


    public GUI(){
        font = new Font("SansSerif", Font.PLAIN, 20);

        // Ermitteln der Bildschirmgröße
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        heigth = (int)Math.round(screenHeight / 1.7);
        width = (int)Math.round(screenHeight / 1.8);
        FOREGROUND_COLOR = Color.WHITE;
        BACKGROUND_COLOR = Color.BLACK;

        // GUI-Fenster-Einstellungen
        setTitle("Finanzamt - Login");
        setSize(new Dimension(width, heigth));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);

        // Initialisieren der GUI-Komponenten
        initComponents();

        setLocationRelativeTo(null);
    }



    public void show(){
        setVisible(true);
    }
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Heared you!");
        }
    }
}
