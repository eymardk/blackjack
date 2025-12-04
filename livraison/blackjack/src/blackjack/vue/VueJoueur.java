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

    public void afficher(Joueur joueur, boolean montrerToutesLesCartes) {
        if (montrerToutesLesCartes == true) {
            labelNomScore.setText(joueur.getNom() + " (" + joueur.getScore() + ")");
        }
        else {
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

    // garder aussi ta méthode simple pour le joueur
    public void afficher(Joueur joueur) {
        afficher(joueur, true);
    }

}
