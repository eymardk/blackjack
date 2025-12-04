package blackjack.vue;

import blackjack.modele.ModeleEcouteur;
import blackjack.modele.Partie;
import cartes.Carte;
import cartes.Paquet;

import javax.swing.*;
import java.awt.*;

/**
 * Vue graphique de la pioche.
 * Affiche les cartes du paquet face cachée, superposées.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class VuePaquetPioche extends JPanel implements ModeleEcouteur {

    private final Paquet pioche;

    /**
     * Crée une vue pour la pioche et s'abonne au modèle.
     *
     * @param pioche le paquet représentant la pioche
     * @param partie la partie observée
     */
    public VuePaquetPioche(Paquet pioche, Partie partie) {
        this.pioche = pioche;
        partie.ajouterEcouteur(this);

        setPreferredSize(new Dimension(200, 300));
        setBorder(BorderFactory.createTitledBorder("Pioche"));
    }

    /**
     * Appelé quand le modèle change.
     *
     * @param source le modèle modifié
     */
    @Override
    public void modeleMisAJour(Object source) {
        repaint();
    }

    /**
     * Dessine la pile de cartes face cachée.
     *
     * @param g le contexte graphique
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int nbCartes = pioche.getTaille();
        if (nbCartes == 0) {
            g.drawString("Pioche vide", 10, 30);
            return;
        }

        int maxAffichees = nbCartes;
        int decalage = 5;

        for (int i = 0; i < maxAffichees; i++) {
            Carte c = pioche.getCarte(i % pioche.getTaille());
            Icon dos = c.getIcon(false); // face cachée

            int x = 10 + i * decalage;
            int y = 25 + i + 2;

            dos.paintIcon(this, g, x, y);
        }
    }
}
