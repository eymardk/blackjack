package blackjack.vue;

import blackjack.modele.ModeleEcouteur;
import blackjack.modele.Partie;
import cartes.Carte;
import cartes.Paquet;

import javax.swing.*;
import java.awt.*;

public class VuePaquetPioche extends JPanel implements ModeleEcouteur {

    private final Paquet pioche;

    public VuePaquetPioche(Paquet pioche, Partie partie) {
        this.pioche = pioche;
        partie.ajouterEcouteur(this);

        setPreferredSize(new Dimension(200, 300));
        setBorder(BorderFactory.createTitledBorder("Pioche"));
    }

    @Override
    public void modeleMisAJour(Object source) {
        repaint();
    }

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
