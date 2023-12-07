package GUI;

import Personen.Arbeiter;
import Personen.Banker;
import Personen.Koenigin;
import Personen.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Home extends CustomeFrame implements ComponentListener, WindowStateListener{

    private int widthLeft;
    private int heightLeft;
    private DefaultTableModel tableModel;
    private JTable table;
    private DefaultTableModel tableModelStatistik;
    private JTable tableStatistik;
    private DecimalFormat meinFormat;
    private ArrayList<Person> personList;
    private JScrollPane rightScrollPane;
    private JScrollPane scrollPane;
    private JPanel mainPanel;
    private RoundedCornerPanel leftTablePanel;
    private RoundedCornerPanel rightTablePanelStatistik;
    private RoundedCornerPanel buttons;
    private RoundedCornerPanel rightTablePanel;
    private JPanel right;
    private JPanel filler;
    private JPanel filler2;
    private JPanel filler3;
    private JButton logout;
    private JButton add;
    private JPanel buttonContainer;


    Home(){
        personList = new ArrayList<Person>();
        setTitle("Finanzamt - Home");
        initComponents();
        getContentPane().addComponentListener(this);
        addWindowStateListener(this);
        setVisible(true);
    }

    private void initComponents() {
        int widthRight = (int)Math.round(super.Frame_width*0.3);
        int widthFiller = (int)Math.round(super.Frame_width*0.04);
        int widthFiller2 =  (int)Math.round(super.Frame_width*0.02);

        int heightButtons = (int)Math.round(super.Frame_height*0.20);
        int heightRightTable = (int)Math.round(super.Frame_height*0.677);
        int heightFiller3 = (int)Math.round(super.Frame_height*0.03);

        meinFormat = new DecimalFormat("###,###,##0.00");

        widthLeft = (int)Math.round(super.Frame_width*0.6);
        heightLeft = (int)Math.round(super.Frame_height*0.92);


        mainPanel = new JPanel(new FlowLayout());
        mainPanel.setBackground(DarkThemeColors.SURFACE_MIXED_100);

        leftTablePanel = new RoundedCornerPanel(20);
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

        rightTablePanelStatistik = new RoundedCornerPanel(20);
        rightTablePanelStatistik.setBackground(DarkThemeColors.SURFACE_MIXED_200);
        rightTablePanelStatistik.setForeground(DarkThemeColors.SURFACE_MIXED_200);
        rightTablePanelStatistik.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        tableModelStatistik = new DefaultTableModel(new Object[]{"Daten","Werte"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableStatistik = new JTable(tableModelStatistik);
        tableStatistik.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableStatistik.setPreferredScrollableViewportSize(new Dimension((int)Math.round(widthRight*0.9), (int)Math.round(heightRightTable*1.2)));
        tableStatistik.setBackground(DarkThemeColors.SURFACE_MIXED_300);
        tableStatistik.setForeground(Color.WHITE);

        rightScrollPane = new JScrollPane(tableStatistik);
        rightScrollPane.setPreferredSize(new Dimension((int)Math.round(widthRight*0.9), (int)Math.round(widthRight*1.2)));
        rightScrollPane.getViewport().setBackground(DarkThemeColors.SURFACE_MIXED_300);
        rightTablePanelStatistik.add(rightScrollPane);


        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension((int)Math.round(widthLeft*0.9), (int)Math.round(heightLeft*0.9)));
        scrollPane.getViewport().setBackground(DarkThemeColors.SURFACE_MIXED_300);
        leftTablePanel.add(scrollPane);

        buttons = new RoundedCornerPanel(20);
        buttons.setBackground(DarkThemeColors.SURFACE_MIXED_200);
        rightTablePanel = new RoundedCornerPanel(20);
        rightTablePanel.setBackground(DarkThemeColors.SURFACE_MIXED_200);

        right = new JPanel();
        filler = new JPanel();
        filler2 = new JPanel();
        filler3 = new JPanel();

        filler.setOpaque(false);
        filler2.setOpaque(false);
        filler3.setOpaque(false);
        right.setOpaque(false);

        logout = new RoundedButton("LOGOUT");
        add = new RoundedButton("ADD");
        buttonContainer = new JPanel();
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

        rightTablePanel.add(rightTablePanelStatistik);
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
        JComboBox<String> berufComboBox = new JComboBox<>(new String[]{"Arbeiter", "Banker", "Arbeitslos", "Königin"});
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

            // Eingabe fÃ¼r das Einkommen erhalten
            String einkommenInput = einkommenField.getText();

            // UnnÃ¶tige Zeichen entfernen und Dezimalpunkt setzen
            String cleanedInput = einkommenInput.replace(".", "").replace(",", ".");

            // Versuche, den bereinigten Wert zu einer double-Zahl zu parsen
            double einkommen = 0.0;  // Standardwert, falls das Parsen fehlschlÃ¤gt
            try {
                einkommen = Double.parseDouble(cleanedInput);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ungültige Eingabe für Einkommen. Bitte geben Sie eine gültige Zahl ein.",
                        "Fehler",
                        JOptionPane.ERROR_MESSAGE
                );
                return;  // Beende die Methode, wenn das Parsen fehlschlÃ¤gt
            }



            switch(selectedBeruf){
                case "Arbeiter":  {personList.add(new Arbeiter(einkommen, name)); break;}
                case "Banker": {personList.add(new Banker(einkommen, name)); break;}
                case "Arbeitslos": {personList.add(new Person(einkommen, name)); break;}
                case "Königin": {personList.add(new Koenigin(einkommen, name)); break;}
            }

            // Hier kannst du den neuen Datensatz zur Tabelle hinzufÃ¼gen
            tableModel.addRow(new Object[]{name, selectedBeruf, meinFormat.format(einkommen), meinFormat.format(personList.get(personList.size() - 1).steuer())});

            int nRow = tableModel.getRowCount(), nCol = tableModel.getColumnCount();
            Object[][] tableData = new Object[nCol][nRow];
            for (int i = 0 ; i < nCol ; i++)
                for (int j = 0 ; j < nRow ; j++)
                    tableData[i][j] = tableModel.getValueAt(j,i);

            int anzahlPersonen = 0;
            double gesamtSteuer = 0.0;
            for (Object val : tableData[3]) {
                anzahlPersonen ++;
                gesamtSteuer += Double.parseDouble(val.toString().replace(".","").replace(",","."));
            }

            int anzahlKoeniginnen = 0, anzahlArbeiter = 0, anzahlBanker = 0, anzahlArbeitslose = 0;
            double durchschnittlichesEinkommen = 0.0, durchschnittlichesEinkommen_Koenigin = 0.0, durchschnittlichesEinkommen_Arbeiter = 0.0, durchschnittlichesEinkommen_Banker = 0.0, durchschnittlichesEinkommen_Arbeitlose = 0.0;
            //for (Object val : tableData[2]) {
            for (int i = 0; i < tableData[2].length; i ++) {
                Object Beruf = tableData[1][i];
                Object val = tableData[2][i];
                durchschnittlichesEinkommen += Double.parseDouble(val.toString().replace(".","").replace(",","."));
                switch(Beruf.toString()) {
                    case "Arbeiter": {
                        anzahlArbeiter++;
                        durchschnittlichesEinkommen_Arbeiter += Double.parseDouble(val.toString().replace(".","").replace(",","."));
                        break;
                    }
                    case "Königin": {
                        anzahlKoeniginnen++;
                        durchschnittlichesEinkommen_Koenigin += Double.parseDouble(val.toString().replace(".","").replace(",","."));
                        break;
                    }
                    case "Arbeitslos": {
                        anzahlArbeitslose++;
                        durchschnittlichesEinkommen_Arbeitlose += Double.parseDouble(val.toString().replace(".","").replace(",","."));
                        break;
                    }
                    case "Banker": {
                        anzahlBanker++;
                        durchschnittlichesEinkommen_Banker += Double.parseDouble(val.toString().replace(".","").replace(",","."));
                        break;
                    }
                }
            }

            durchschnittlichesEinkommen /= anzahlPersonen;
            durchschnittlichesEinkommen = Math.round(durchschnittlichesEinkommen * 100) / 100;
            if (anzahlKoeniginnen > 0) {
                durchschnittlichesEinkommen_Koenigin /= anzahlKoeniginnen;
                durchschnittlichesEinkommen_Koenigin = Math.round(durchschnittlichesEinkommen_Koenigin * 100) / 100;
            }
            if (anzahlBanker > 0) {
                durchschnittlichesEinkommen_Banker /= anzahlBanker;
                durchschnittlichesEinkommen_Banker = Math.round(durchschnittlichesEinkommen_Banker * 100) / 100;
            }
            if (anzahlArbeiter > 0) {
                durchschnittlichesEinkommen_Arbeiter /= anzahlArbeiter;
                durchschnittlichesEinkommen_Arbeiter = Math.round(durchschnittlichesEinkommen_Arbeiter * 100) / 100;
            }
            if (anzahlArbeitslose > 0) {
                durchschnittlichesEinkommen_Arbeitlose /= anzahlArbeitslose;
                durchschnittlichesEinkommen_Arbeitlose = Math.round(durchschnittlichesEinkommen_Arbeitlose * 100) / 100;
            }

            if (tableModelStatistik.getRowCount() > 0) {
                for (int i = 1; i <= 12; i++) {
                    tableModelStatistik.removeRow(0);
                }
            }


            tableModelStatistik.addRow(new Object[] {"Anzahl Personen", anzahlPersonen});
            tableModelStatistik.addRow(new Object[] {"Anzahl Königinnen", anzahlKoeniginnen});
            tableModelStatistik.addRow(new Object[] {"→ ⌀ Einkommen", meinFormat.format(durchschnittlichesEinkommen_Koenigin)});
            tableModelStatistik.addRow(new Object[] {"Anzahl Banker", anzahlBanker});
            tableModelStatistik.addRow(new Object[] {"→ ⌀ Einkommen", meinFormat.format(durchschnittlichesEinkommen_Banker)});
            tableModelStatistik.addRow(new Object[] {"Anzahl Arbeiter", anzahlArbeiter});
            tableModelStatistik.addRow(new Object[] {"→ ⌀ Einkommen", meinFormat.format(durchschnittlichesEinkommen_Arbeiter)});
            tableModelStatistik.addRow(new Object[] {"Anzahl Arbeitslose", anzahlArbeitslose});
            tableModelStatistik.addRow(new Object[] {"→ ⌀ Einkommen", meinFormat.format(durchschnittlichesEinkommen_Arbeitlose)});
            tableModelStatistik.addRow(new Object[] {"", ""});
            tableModelStatistik.addRow(new Object[] {"⌀ Einkommen", meinFormat.format(durchschnittlichesEinkommen)});
            tableModelStatistik.addRow(new Object[] {"gesamte Steuern", meinFormat.format(gesamtSteuer)});


        }


    }

    private void resize() {
        double Frame_width = getWidth();
        double Frame_height = getHeight();

        int widthRight = (int)Math.round(Frame_width*0.3);
        int widthFiller = (int)Math.round(Frame_width*0.04);
        int widthFiller2 =  (int)Math.round(Frame_width*0.02);

        int heightButtons = (int)Math.round(Frame_height*0.20);
        int heightRightTable = (int)Math.round(Frame_height*0.677);
        int heightFiller3 = (int)Math.round(Frame_height*0.03);

        widthLeft = (int)Math.round(Frame_width*0.6);
        heightLeft = (int)Math.round(Frame_height*0.92);

        table.setPreferredScrollableViewportSize(new Dimension((int)Math.round(widthLeft*0.9), (int)Math.round(heightLeft*0.9)));
        tableStatistik.setPreferredScrollableViewportSize(new Dimension((int)Math.round(widthRight*0.9), (int)Math.round(heightRightTable*1.2)));

        scrollPane.setPreferredSize(new Dimension((int)Math.round(widthLeft*0.9), (int)Math.round(heightLeft*0.9)));
        rightScrollPane.setPreferredSize(new Dimension((int)Math.round(widthRight*0.9), (int)Math.round(widthRight*1.2)));

        leftTablePanel.setPreferredSize(new Dimension(widthLeft, heightLeft));
        right.setPreferredSize(new Dimension(widthRight, (int)Math.round(Frame_height*0.94)));
        filler.setPreferredSize(new Dimension(widthFiller, (int)Math.round(Frame_height*0.94)));
        filler2.setPreferredSize(new Dimension(widthFiller2, (int)Math.round(Frame_height*0.94)));
        buttons.setPreferredSize(new Dimension(widthRight, heightButtons));
        rightTablePanel.setPreferredSize(new Dimension(widthRight, heightRightTable));
        filler3.setPreferredSize(new Dimension(widthRight, heightFiller3));
        buttonContainer.setPreferredSize(new Dimension((int)Math.round(widthRight*0.7), heightButtons));
    }

    @Override
    public void componentResized(ComponentEvent e) {
        resize();
    }

    @Override
    public void componentMoved(ComponentEvent e) {}
    @Override
    public void componentShown(ComponentEvent e) {}
    @Override
    public void componentHidden(ComponentEvent e) {}

    @Override
    public void windowStateChanged(WindowEvent e) {
        // minimized
        if ((e.getNewState() & Frame.NORMAL) == Frame.NORMAL){
            resize();
        }
        // maximized
        else if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH){
            resize();
        }
    }
}

