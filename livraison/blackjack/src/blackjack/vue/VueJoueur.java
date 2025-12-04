package blackjack.vue;

import blackjack.modele.joueur.Joueur;
import cartes.Carte;

import javax.swing.*;
import java.awt.*;

/**
 * Vue graphique d'un joueur.
 * Affiche son nom, son score et ses cartes sous forme d'icônes.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class VueJoueur extends JPanel {

    private final JLabel labelNomScore;
    private final JPanel panelCartes;

    /**
     * Crée le panneau d'affichage d'un joueur.
     */
    public VueJoueur() {
        setLayout(new BorderLayout());
        labelNomScore = new JLabel();
        panelCartes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(labelNomScore, BorderLayout.NORTH);
        add(panelCartes, BorderLayout.CENTER);
    }

    /**
     * Affiche les cartes d'un joueur.
     *
     * @param joueur le joueur à afficher
     * @param montrerToutesLesCartes true pour tout afficher,
     *                               false pour une seule carte visible
     */
    public void afficher(Joueur joueur, boolean montrerToutesLesCartes) {
        if (montrerToutesLesCartes) {
            labelNomScore.setText(joueur.getNom() + " (" + joueur.getScore() + ")");
        } else {
            labelNomScore.setText(joueur.getNom());
        }

        panelCartes.removeAll();
        var main = joueur.getMain();

        for (int i = 0; i < main.getTaille(); i++) {
            Carte c = main.getCarte(i);
            boolean visible = montrerToutesLesCartes || i == 0; // seule la première visible
            Icon icon = c.getIcon(visible);
            panelCartes.add(new JLabel(icon));
        }

        panelCartes.revalidate();
        panelCartes.repaint();
    }

    /**
     * Affiche toutes les cartes d'un joueur.
     *
     * @param joueur le joueur à afficher
     */
    public void afficher(Joueur joueur) {
        afficher(joueur, true);
    }
}
