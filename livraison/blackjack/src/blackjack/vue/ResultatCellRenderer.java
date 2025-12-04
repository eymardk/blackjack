package blackjack.vue;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

// Colore la colonne "Résultat" du tableau (GAGNÉ / PERDU / ÉGALITÉ)
public class ResultatCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        String texte = value != null ? value.toString() : "";

        if (texte.startsWith("GAGN")) {
            c.setForeground(Color.GREEN.darker());
        } else if (texte.startsWith("PERDU")) {
            c.setForeground(Color.RED);
        } else if (texte.startsWith("ÉGAL") || texte.startsWith("EGAL")) {
            c.setForeground(Color.ORANGE.darker());
        } else {
            c.setForeground(Color.BLACK);
        }

        return c;
    }
}
