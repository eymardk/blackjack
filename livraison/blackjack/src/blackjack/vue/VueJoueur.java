package blackjack.vue;

import blackjack.modele.joueur.Joueur;
import cartes.Carte;

import javax.swing.*;
import java.awt.*;

public class VueJoueur extends JPanel {

    private final JLabel labelNomScore;
    private final JPanel panelCartes;

    public VueJoueur() {
        setLayout(new BorderLayout());
        labelNomScore = new JLabel();
        panelCartes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(labelNomScore, BorderLayout.NORTH);
        add(panelCartes, BorderLayout.CENTER);
    }

    // Met à jour l’affichage pour un joueur donné
    public void afficher(Joueur joueur) {
        labelNomScore.setText(joueur.getNom() + " (" + joueur.getScore() + ")");

        panelCartes.removeAll();
        var main = joueur.getMain();
        for (int i = 0; i < main.getTaille(); i++) {
            Carte c = main.getCarte(i);
            Icon icon = c.getIcon(true);
            panelCartes.add(new JLabel(icon));
        }

        panelCartes.revalidate();
        panelCartes.repaint();
    }
}
