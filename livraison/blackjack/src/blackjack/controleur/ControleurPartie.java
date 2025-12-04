package blackjack.controleur;

import blackjack.modele.Partie;
import blackjack.vue.ResultatCellRenderer;
import blackjack.vue.VuePartie;

import javax.swing.*;
import java.awt.BorderLayout;

public class ControleurPartie {

    private final Partie partie;
    private final VuePartie vue;

    public ControleurPartie(Partie partie, VuePartie vue) {
        this.partie = partie;
        this.vue = vue;

        initListeners();
        rafraichirVue();
        majBoutons();
    }

    private void initListeners() {

        // Nouvelle partie : (re)lance une manche, bots jouent d’abord
        vue.getBoutonNouvellePartie().addActionListener(e -> {
            partie.initialiserNouvellePartie();
            partie.jouerTourBots();
            partie.setPartieTerminee(false);
            rafraichirVue();
            majBoutons();
        });

        // Tirer : l’humain prend une carte
        vue.getBoutonTirer().addActionListener(e -> {
            var humain = partie.getPremierJoueurHumain();
            if (humain != null && !humain.estBust() && !partie.isPartieTerminee()) {
                humain.ajouterCarte(partie.getPioche().retirer());

                if (humain.estBust()) {
                    // Humain bust → croupier joue, puis fin de manche
                    partie.jouerTourCroupier();
                    partie.setPartieTerminee(true);
                    rafraichirVue();
                    majBoutons();
                    afficherPopupResultats();
                    return;
                }

                rafraichirVue();
                majBoutons();
            }
        });

        // Rester : l’humain arrête de tirer, croupier joue
        vue.getBoutonRester().addActionListener(e -> {
            if (!partie.isPartieTerminee()) {
                partie.jouerTourCroupier();
                partie.setPartieTerminee(true);
                rafraichirVue();
                majBoutons();
                afficherPopupResultats();
            }
        });
    }

    private void rafraichirVue() {
        vue.afficherPartie(partie);
    }

    // Active/désactive les boutons selon l’état de la manche
    private void majBoutons() {
        boolean terminee = partie.isPartieTerminee();
        vue.getBoutonNouvellePartie().setEnabled(terminee);
        vue.getBoutonTirer().setEnabled(!terminee);
        vue.getBoutonRester().setEnabled(!terminee);
    }

    // Popup de fin de manche avec tableau de scores
    private void afficherPopupResultats() {
        Object[][] data = partie.getTableauResultats();
        String[] colonnes = { "Joueur", "Score", "Cartes", "Résultat" };

        JTable table = new JTable(data, colonnes);
        table.getColumnModel().getColumn(3)
             .setCellRenderer(new ResultatCellRenderer());

        JScrollPane scroll = new JScrollPane(table);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);

        JButton btnNouvelle = new JButton("Nouvelle partie");
        btnNouvelle.addActionListener(e -> {
            vue.getBoutonNouvellePartie().doClick();
            SwingUtilities.getWindowAncestor(btnNouvelle).dispose();
        });

        JPanel bas = new JPanel();
        bas.add(btnNouvelle);
        panel.add(bas, BorderLayout.SOUTH);

        JOptionPane.showMessageDialog(
                vue, panel, "Résultats de la partie",
                JOptionPane.PLAIN_MESSAGE);
    }
}
