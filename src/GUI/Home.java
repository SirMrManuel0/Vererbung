package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends CustomeFrame{

    Home(){
        setTitle("Finanzamt - Home");
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new FlowLayout());
        mainPanel.setBackground(DarkThemeColors.SURFACE_MIXED_100);

        RoundedCornerPanel leftTablePanel = new RoundedCornerPanel(20);
        leftTablePanel.setBackground(DarkThemeColors.SURFACE_MIXED_200);

        RoundedCornerPanel buttons = new RoundedCornerPanel(20);
        buttons.setBackground(DarkThemeColors.SURFACE_MIXED_200);
        RoundedCornerPanel rightTablePanel = new RoundedCornerPanel(20);
        rightTablePanel.setBackground(DarkThemeColors.SURFACE_MIXED_200);

        JPanel right = new JPanel();
        JPanel filler = new JPanel();
        JPanel filler2 = new JPanel();
        JPanel filler3 = new JPanel();

        filler.setOpaque(false);
        filler2.setOpaque(false);
        filler3.setOpaque(false);
        right.setOpaque(false);

        JButton logout = new RoundedButton("LOGOUT");
        JButton add = new RoundedButton("ADD");
        JPanel buttonContainer = new JPanel();
        buttonContainer.setOpaque(false);
        buttonContainer.setLayout(new GridLayout(2,1));
        buttonContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        logout.setBackground(DarkThemeColors.PRIMARY_500);
        add.setBackground(DarkThemeColors.PRIMARY_500);
        logout.setForeground(Color.WHITE);
        add.setForeground(Color.WHITE);

        logout.setFocusable(false);
        add.setFocusable(false);
        logout.setBorderPainted(false);
        add.setBorderPainted(false);



        int widthLeft = (int)Math.round(super.Frame_width*0.6);
        int widthRight = (int)Math.round(super.Frame_width*0.3);
        int widthFiller = (int)Math.round(super.Frame_width*0.04);
        int widthFiller2 =  (int)Math.round(super.Frame_width*0.02);

        int heightButtons = (int)Math.round(super.Frame_height*0.20);
        int heightRightTable = (int)Math.round(super.Frame_height*0.677);
        int heightFiller3 = (int)Math.round(super.Frame_height*0.03);

        leftTablePanel.setPreferredSize(new Dimension(widthLeft, (int)Math.round(super.Frame_height*0.92)));
        right.setPreferredSize(new Dimension(widthRight, (int)Math.round(super.Frame_height*0.94)));
        filler.setPreferredSize(new Dimension(widthFiller, (int)Math.round(super.Frame_height*0.94)));
        filler2.setPreferredSize(new Dimension(widthFiller2, (int)Math.round(super.Frame_height*0.94)));
        buttons.setPreferredSize(new Dimension(widthRight, heightButtons));
        rightTablePanel.setPreferredSize(new Dimension(widthRight, heightRightTable));
        filler3.setPreferredSize(new Dimension(widthRight, heightFiller3));
        buttonContainer.setPreferredSize(new Dimension((int)Math.round(widthRight*0.7), heightButtons));


        buttonContainer.add(logout);
        buttonContainer.add(add);
        buttons.add(buttonContainer);

        right.add(buttons);
        right.add(filler3);
        right.add(rightTablePanel);

        mainPanel.add(leftTablePanel);
        mainPanel.add(filler);
        mainPanel.add(right);
        mainPanel.add(filler2);

        // Add the main panel to the frame
        add(mainPanel);

        logout.addActionListener(new ButtonListener());
    }

    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            if (buttonText.equals("LOGOUT")){
                dispose();
                Index in = new Index();
            }

        }
    }

}
