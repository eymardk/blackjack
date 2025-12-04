/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.vue;

import blackjack.modele.Partie;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 * Vue des resulatts de la partie
 *
 */
public class ResultatsVue {
    private Partie jeu;
    private PartieGUI vue;
    
    public ResultatsVue(Partie j, PartieGUI vue){
        this.jeu = j;
        this.vue = vue;
        Object[][] res = this.jeu.resultats();
        String[] colonnes = {"Joueur", "Score", "Cartes", "Resultat"};
        
        JTable table = new JTable(res,colonnes);
        table.getColumnModel().getColumn(3);
        JScrollPane scroll = new JScrollPane(table);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);
        
        JButton nvPartie = new JButton("Nouvelle Partie");
        nvPartie.addActionListener(e -> {
            this.vue.getBNewPartie().doClick();
            SwingUtilities.getWindowAncestor(nvPartie).dispose();
        });
        
        JPanel bas = new JPanel();
        bas.add(nvPartie);
        panel.add(bas, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(vue,panel,"Resultats de la partie", JOptionPane.PLAIN_MESSAGE);
        
    }
}
