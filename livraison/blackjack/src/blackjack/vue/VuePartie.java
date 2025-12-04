package blackjack.vue;

import blackjack.modele.Partie;
import blackjack.modele.ModeleEcouteur;
import blackjack.controleur.ControleurPartie;

import javax.swing.*;
import java.awt.*;

public class VuePartie extends JFrame implements ModeleEcouteur {

    private final Partie partie;
    private ControleurPartie controleur;

    private final VueJoueur vueJoueur;
    private final VueJoueur vueCroupier;
    private final VuePaquetPioche vuePioche;
    private final JButton boutonTirer;
    private final JButton boutonRester;
    private final JButton boutonNouvellePartie;
    private final JButton boutonAccueil;

    public VuePartie(Partie partie) {
        this.partie = partie;
        partie.ajouterEcouteur(this);

        setTitle("Blackjack");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // HAUT : Pioche
        vuePioche = new VuePaquetPioche(partie.getPioche(), partie);
        add(vuePioche, BorderLayout.NORTH);

        // Centre : 2 VueJoueur
        JPanel panelCentre = new JPanel(new GridLayout(2, 1));

        vueJoueur = new VueJoueur();
        vueCroupier = new VueJoueur();

        panelCentre.add(vueCroupier);
        panelCentre.add(vueJoueur);

        add(panelCentre, BorderLayout.CENTER);

        // Bas : boutons
        JPanel panelBas = new JPanel();
        boutonTirer = new JButton("Tirer");
        boutonRester = new JButton("Rester");
        boutonNouvellePartie = new JButton("Nouvelle partie");
        boutonAccueil = new JButton("Accueil");

        panelBas.add(boutonTirer);
        panelBas.add(boutonRester);
        panelBas.add(boutonNouvellePartie);
        panelBas.add(boutonAccueil);
        add(panelBas, BorderLayout.SOUTH);

        // Callbacks → contrôleur
        boutonNouvellePartie.addActionListener(e -> {
            if (controleur != null)
                controleur.nouvellePartie("IA", 52);
        });

        boutonTirer.addActionListener(e -> {
            if (controleur != null)
                controleur.joueurTire();
        });

        boutonRester.addActionListener(e -> {
            if (controleur != null)
                controleur.joueurReste();
        });

        boutonAccueil.addActionListener(e -> {
            dispose();
            new blackjack.controleur.ControleurAccueil();
        });

        pack();
        setLocationRelativeTo(null);
        setSize(800, 900);
        setVisible(true);
    }

    @Override
    public void modeleMisAJour(Object source) {
        if (source == partie) {
            mettreAJourAffichage();
            if (partie.isPartieTerminee()) {
                afficherResultatTableau();
            }
        }
    }

    private void mettreAJourAffichage() {
        vueJoueur.afficher(partie.getJoueur());

        if (!partie.isPartieTerminee()) {
            vueCroupier.afficher(partie.getCroupier(), false);
        } else {
            vueCroupier.afficher(partie.getCroupier(), true);
        }

        boolean terminee = partie.isPartieTerminee();
        boutonTirer.setEnabled(!terminee);
        boutonRester.setEnabled(!terminee);

        // désactiver Nouvelle partie + Accueil quand une partie est en cours
        boutonNouvellePartie.setEnabled(terminee);
        boutonAccueil.setEnabled(terminee);
    }

    private void afficherResultatTableau() {
        Object[][] data = partie.getTableauResultats();
        String[] colonnes = { "Joueur", "Score", "Résultat" };

        JTable table = new JTable(data, colonnes);
        table.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(
                this,
                scrollPane,
                "Résultat de la partie",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void setControleur(ControleurPartie controleur) {
        this.controleur = controleur;
    }
}
