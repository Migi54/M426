import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Random;

public class passwortkarte {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Alphabet Raster");
        int zeilenAnzahl = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die Anzahl der Zeilen ein:"));
        // Spaltenüberschriften festlegen (A bis Z)
        String[] columns = new String[27];
        columns[0] = "";
        for (int i = 1; i < 27; i++) {
            columns[i] = Character.toString((char) ('A' + i - 1));
        }

        // Daten für das Raster vorbereiten
        Object[][] data = new Object[zeilenAnzahl][27];
        for (int i = 0; i < zeilenAnzahl; i++) {
            data[i][0] = i + 1; // Nummerierung der ersten Spalte
            for (int j = 1; j < 27; j++) { // Schleife von 1 bis 27
                int rand = new Random().nextInt(4); // Zufallszahl zwischen 0 und 3 generieren
                switch (rand) {
                    case 0:
                        // Kleinbuchstaben (ASCII 97-122)
                        data[i][j] = Character.toString((char) (new Random().nextInt(26) + 97));
                        break;
                    case 1:
                        // Grossbuchstaben (ASCII 65-90)
                        data[i][j] = Character.toString((char) (new Random().nextInt(26) + 65));
                        break;
                    case 2:
                        // Ziffern (ASCII 48-57)
                        data[i][j] = Character.toString((char) (new Random().nextInt(10) + 48));
                        break;
                    case 3:
                        // Sonderzeichen (ASCII 33-47, 58-64, 91-96, 123-126)
                        int[] ranges = {33, 47, 58, 64, 91, 96, 123, 126};
                        int rangeIndex = new Random().nextInt(ranges.length / 2); // Zufälligen Bereich auswählen
                        int startRange = ranges[rangeIndex * 2];
                        int endRange = ranges[rangeIndex * 2 + 1];
                        data[i][j] = Character.toString((char) (new Random().nextInt(endRange - startRange + 1) + startRange));
                        break;
                }
            }
        }

        // Tabelle erstellen und Daten einfügen
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

         // Verschieben von Spalten deaktivieren
        table.getTableHeader().setReorderingAllowed(false);

        // Tabelle in einem Scrollpane platzieren
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Eingabefelder hinzufügen
        JPanel inputPanel = new JPanel(new GridLayout());
        inputPanel.add(new JLabel("Website:"));
        inputPanel.add(new JTextField());
        inputPanel.add(new JLabel("Startpunkt:"));
        inputPanel.add(new JTextField());
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
