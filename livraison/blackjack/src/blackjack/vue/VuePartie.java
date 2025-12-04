package blackjack.vue;

import blackjack.modele.Partie;
import cartes.Carte;

import javax.swing.*;
import java.awt.*;

public class VuePartie extends JFrame {

    private final JPanel panelCroupier;
    private final JPanel panelJoueurs;
    private final JButton boutonNouvellePartie;
    private final JButton boutonTirer;
    private final JButton boutonRester;

    public VuePartie() {
        super("Blackjack");

        panelCroupier = new JPanel(new FlowLayout());
        panelJoueurs = new JPanel();
        panelJoueurs.setLayout(new BoxLayout(panelJoueurs, BoxLayout.Y_AXIS));

        boutonNouvellePartie = new JButton("Nouvelle partie");
        boutonTirer = new JButton("Tirer");
        boutonRester = new JButton("Rester");

        JPanel panelBoutons = new JPanel();
        panelBoutons.add(boutonNouvellePartie);
        panelBoutons.add(boutonTirer);
        panelBoutons.add(boutonRester);

        JPanel panelCentre = new JPanel(new BorderLayout());
        panelCentre.add(new JLabel("Croupier"), BorderLayout.NORTH);
        panelCentre.add(panelCroupier, BorderLayout.CENTER);
        panelCentre.add(new JScrollPane(panelJoueurs), BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panelCentre, BorderLayout.CENTER);
        this.getContentPane().add(panelBoutons, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
    }

    // Rafraîchit l’affichage complet à partir de l’état de la partie
    public void afficherPartie(Partie partie) {
        panelCroupier.removeAll();
        panelJoueurs.removeAll();

        // Croupier : 1 carte visible si partie en cours, tout visible si fin
        var mainC = partie.getCroupier().getMain();
        boolean terminee = partie.isPartieTerminee();

        for (int i = 0; i < mainC.getTaille(); i++) {
            Carte c = mainC.getCarte(i);
            Icon icon;
            if (!terminee && i > 0) {
                icon = c.getIcon(false); // dos
            } else {
                icon = c.getIcon(true);  // face
            }
            panelCroupier.add(new JLabel(icon));
        }

        // Joueurs
        for (var j : partie.getJoueurs()) {
            VueJoueur vueJ = new VueJoueur();
            vueJ.afficher(j);
            panelJoueurs.add(vueJ);
        }

        panelCroupier.revalidate();
        panelCroupier.repaint();
        panelJoueurs.revalidate();
        panelJoueurs.repaint();
        pack();
    }

    public JButton getBoutonNouvellePartie() { return boutonNouvellePartie; }
    public JButton getBoutonTirer() { return boutonTirer; }
    public JButton getBoutonRester() { return boutonRester; }
}
