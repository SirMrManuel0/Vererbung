package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index extends CustomeFrame{

    private JTextField idField;
    private JPasswordField passwordField;


    public Index(){
        initComponents();
        setVisible(true);
    }
    protected void initComponents() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        mainPanel.setBackground(DarkThemeColors.SURFACE_MIXED_100);



        RoundedCornerPanel middleSide = new RoundedCornerPanel(20);
        middleSide.setLayout(new GridLayout(5,1, 10, 10));
        middleWidget(middleSide);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        mainPanel.add(middleSide, gbc);

        add(mainPanel);
    }

    private void middleWidget(JPanel middlePanel) {
        // Create widgets for the login screen
        JLabel label = new JLabel("LOGIN");
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        // Set placeholder text for input fields
        emailField.setToolTipText("Enter your ID");
        passwordField.setToolTipText("Enter your password");

        label.setFont(super.font);
        emailField.setFont(super.font);
        passwordField.setFont(super.font);
        loginButton.setFont(super.font);

        label.setForeground(Color.WHITE);
        emailField.setForeground(Color.WHITE);
        passwordField.setForeground(Color.WHITE);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(DarkThemeColors.PRIMARY_500);
        emailField.setBackground(DarkThemeColors.SURFACE_MIXED_500);
        passwordField.setBackground(DarkThemeColors.SURFACE_MIXED_500);

        passwordField.setBorder(null);
        emailField.setBorder(null);

        middlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        middlePanel.setPreferredSize(new Dimension((int)super.Frame_width/3, (int)super.Frame_height/3));


        // Add widgets to the middle-side layout
        middlePanel.add(label);
        middlePanel.add(emailField);
        middlePanel.add(passwordField);
        middlePanel.add(loginButton);

        middlePanel.setBackground(DarkThemeColors.SURFACE_MIXED_200);

        loginButton.addActionListener(new ButtonListener());
    }



    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            dispose();
            Home home = new Home();
        }
    }


}
