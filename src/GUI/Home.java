package GUI;

import Personen.Arbeiter;
import Personen.Banker;
import Personen.Koenigin;
import Personen.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Home extends CustomeFrame{

    private int widthLeft;
    private int heightLeft;
    private DefaultTableModel tableModel;
    private JTable table;
    private DecimalFormat meinFormat;
    private ArrayList<Person> personList;


    Home(){
        personList = new ArrayList<Person>();
        setTitle("Finanzamt - Home");
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        meinFormat = new DecimalFormat("###,###,##0.00");

        widthLeft = (int)Math.round(super.Frame_width*0.6);
        heightLeft = (int)Math.round(super.Frame_height*0.92);


        JPanel mainPanel = new JPanel(new FlowLayout());
        mainPanel.setBackground(DarkThemeColors.SURFACE_MIXED_100);

        RoundedCornerPanel leftTablePanel = new RoundedCornerPanel(20);
        leftTablePanel.setBackground(DarkThemeColors.SURFACE_MIXED_200);
        leftTablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        tableModel = new DefaultTableModel(new Object[]{"Name", "Beruf", "Einkommen", "Steuer"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(new Dimension((int)Math.round(widthLeft*0.9), (int)Math.round(heightLeft*0.9)));
        table.setBackground(DarkThemeColors.SURFACE_MIXED_300);
        table.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension((int)Math.round(widthLeft*0.9), (int)Math.round(heightLeft*0.9)));
        scrollPane.getViewport().setBackground(DarkThemeColors.SURFACE_MIXED_300);
        leftTablePanel.add(scrollPane);

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





        int widthRight = (int)Math.round(super.Frame_width*0.3);
        int widthFiller = (int)Math.round(super.Frame_width*0.04);
        int widthFiller2 =  (int)Math.round(super.Frame_width*0.02);

        int heightButtons = (int)Math.round(super.Frame_height*0.20);
        int heightRightTable = (int)Math.round(super.Frame_height*0.677);
        int heightFiller3 = (int)Math.round(super.Frame_height*0.03);

        leftTablePanel.setPreferredSize(new Dimension(widthLeft, heightLeft));
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
        add.addActionListener(new ButtonListener());
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
            if (buttonText.equals("ADD")){
                showAddDialog();
            }

        }
    }

    private void showAddDialog() {
        JTextField nameField = new JTextField();
        JComboBox<String> berufComboBox = new JComboBox<>(new String[]{"Arbeiter", "Banker", "Person", "Königin"});
        JTextField einkommenField = new JTextField();

        Object[] message = {
                "Name:", nameField,
                "Beruf:", berufComboBox,
                "Einkommen:", einkommenField
        };

        int option = JOptionPane.showConfirmDialog(
                this,
                message,
                "Neuen Datensatz hinzufügen",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String selectedBeruf = (String) berufComboBox.getSelectedItem();

            // Eingabe für das Einkommen erhalten
            String einkommenInput = einkommenField.getText();

            // Unnötige Zeichen entfernen und Dezimalpunkt setzen
            String cleanedInput = einkommenInput.replace(".", "").replace(",", ".");

            // Versuche, den bereinigten Wert zu einer double-Zahl zu parsen
            double einkommen = 0.0;  // Standardwert, falls das Parsen fehlschlägt
            try {
                einkommen = Double.parseDouble(cleanedInput);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ungültige Eingabe für Einkommen. Bitte geben Sie eine gültige Zahl ein.",
                        "Fehler",
                        JOptionPane.ERROR_MESSAGE
                );
                return;  // Beende die Methode, wenn das Parsen fehlschlägt
            }



            switch(selectedBeruf){
                case "Arbeiter" -> personList.add(new Arbeiter(einkommen, name));
                case "Banker" -> personList.add(new Banker(einkommen, name));
                case "Person" -> personList.add(new Person(einkommen, name));
                case "Königin" -> personList.add(new Koenigin(einkommen, name));
            }

            // Hier kannst du den neuen Datensatz zur Tabelle hinzufügen
            tableModel.addRow(new Object[]{name, selectedBeruf, meinFormat.format(einkommen), personList.get(personList.size() - 1).steuer()});
        }
    }




}
