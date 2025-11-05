import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class Gui extends JFrame {
    private JFormattedTextField field1, field2, field3;
    private JButton btnAdd, btnStep, btnReset, btnClose;

    public Gui() {
        super("Bahnhof Verwaltung - Demo GUI");

        initComponents();


    }

    private void initComponents() {
        Verwaltung verwaltung;
        verwaltung = new Verwaltung(10);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout(10, 10));

        // Felder-Panel (3 Zahlenfelder)
        JPanel fields = new JPanel(new GridLayout(3, 2, 5, 5));
        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        field1 = new JFormattedTextField(intFormat);
        field2 = new JFormattedTextField(intFormat);
        field3 = new JFormattedTextField(intFormat);


        field1.setColumns(3);
        field2.setColumns(3);
        field3.setColumns(3);

        field1.setEditable(false);
        field2.setEditable(false);
        field3.setEditable(false);

        fields.add(new JLabel("Zahl 1:"));
        fields.add(field1);
        fields.add(new JLabel("Zahl 2:"));
        fields.add(field2);
        fields.add(new JLabel("Zahl 3:"));
        fields.add(field3);

        // Buttons-Panel (knöpfe machen noch nichts, Close schließt)
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAdd = new JButton("Add");
        btnStep = new JButton("Step");
        btnReset = new JButton("Reset");
        btnClose = new JButton("Close");

        // Keine Logik implementiert - Platzhalter
        btnAdd.addActionListener(e -> {
            // TODO: Implement action
        });
        btnStep.addActionListener(e -> {
            verwaltung.zugHinzufügen("Kartoffeln", verwaltung.gleis1);
        });
        btnReset.addActionListener(e -> {
            // Reset fields to empty
            field1.setValue(null);
            field2.setValue(null);
            field3.setValue(null);
        });
        btnClose.addActionListener(e -> dispose());

        buttons.add(btnAdd);
        buttons.add(btnStep);
        buttons.add(btnReset);
        buttons.add(btnClose);

        main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        main.add(fields, BorderLayout.CENTER);
        main.add(buttons, BorderLayout.SOUTH);

        setContentPane(main);
        pack();
        setLocationRelativeTo(null);
    }

    public static void showGui() {
        SwingUtilities.invokeLater(() -> {
            Gui g = new Gui();
            g.setVisible(true);
        });
    }

    public static void main(String[] args) {
        showGui();
    }
}
