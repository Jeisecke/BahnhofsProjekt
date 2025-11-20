import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;


public class Gui extends JFrame {
    private JFormattedTextField field1, field2, field3;
    private Verwaltung verwaltung;

    public Gui() {
        super("Bahnhof Verwaltung - Demo GUI");

        this.initComponents();


    }

    private void initComponents() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.verwaltung = new Verwaltung(10);

        final JPanel main = new JPanel(new BorderLayout(10, 10));

        // Felder-Panel
        final JPanel fields = new JPanel(new GridLayout(3, 2, 5, 5));
        final NumberFormat intFormat = NumberFormat.getIntegerInstance();
        this.field1 = new JFormattedTextField(intFormat);
        this.field2 = new JFormattedTextField(intFormat);
        this.field3 = new JFormattedTextField(intFormat);


        this.field1.setColumns(3);
        this.field2.setColumns(3);
        this.field3.setColumns(3);

        this.field1.setEditable(false);
        this.field2.setEditable(false);
        this.field3.setEditable(false);

        fields.add(new JLabel("Gleis 1:"));
        fields.add(this.field1);
        fields.add(new JLabel("Gleis 2:"));
        fields.add(this.field2);
        fields.add(new JLabel("Gleis 3:"));
        fields.add(this.field3);

        final JPanel buttons = getJPanel();

        main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        main.add(fields, BorderLayout.CENTER);
        main.add(buttons, BorderLayout.SOUTH);

        this.setContentPane(main);
        this.pack();
        this.setLocationRelativeTo(null);
        this.anzeigeAktualisieren();
    }

    private JPanel getJPanel() {
        final JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAdd = new JButton("Add");
        JButton btnStep = new JButton("Step");
        JButton btnReset = new JButton("Reset");
        JButton btnPrint = new JButton("Print");
        JButton btnClose = new JButton("Close");

        btnAdd.addActionListener(e -> {
            String[] listeNamen = {"Kartoffeln", "Eisenerz", "Werkzeuge", "Mehl", "Öl", "Kohle", "Elektrotechnik", "Müll", "Holz", "Waren", "Gefahrgut"};
            int ii = verwaltung.random.nextInt(listeNamen.length);
            verwaltung.zugHinzufuegen(listeNamen[ii]+"-"+verwaltung.random.nextInt(50), verwaltung.gleis2);
            this.anzeigeAktualisieren();
        });
        btnStep.addActionListener(e -> {
            this.verwaltung.sortierenZuege();
            this.anzeigeAktualisieren();
        });
        btnReset.addActionListener(e -> {
            // Reset fields to empty
            this.field1.setValue(null);
            this.field2.setValue(null);
            this.field3.setValue(null);
            this.verwaltung = new Verwaltung(0);
        });
        btnPrint.addActionListener(e -> this.verwaltung.printStacks());
        btnClose.addActionListener(e -> System.exit(0));

        buttons.add(btnAdd);
        buttons.add(btnStep);
        buttons.add(btnReset);
        buttons.add(btnPrint);
        buttons.add(btnClose);
        return buttons;
    }

    public void anzeigeAktualisieren(){
        String g1 = null, g2 = null, g3 = null;
        if (null != this.verwaltung.gleis1.top()){
             g1 = String.valueOf(this.verwaltung.gleis1.top().id);
        }
        if (null != this.verwaltung.gleis2.top()){
             g2 = String.valueOf(this.verwaltung.gleis2.top().id);
        }
        if (null != this.verwaltung.gleis3.top()){
             g3 = String.valueOf(this.verwaltung.gleis3.top().id);
        }


        this.field1.setText(g1);
        this.field2.setText(g2);
        this.field3.setText(g3);
    }

    public static void showGui() {
        SwingUtilities.invokeLater(() -> {
            final Gui g = new Gui();
            g.setVisible(true);
        });
    }

    public static void main(final String[] args) {
        Gui.showGui();
    }
}
