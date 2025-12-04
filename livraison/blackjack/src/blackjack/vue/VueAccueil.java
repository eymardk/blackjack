package blackjack.vue;

import blackjack.controleur.ControleurAccueil;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Vue d'accueil : choix du paquet et de la difficulté.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class VueAccueil extends JFrame {

    private final ControleurAccueil accueilControleur;

    private JPanel panelPrincipal;
    private JPanel panelChoixPaquet;
    private JPanel panelChoixIa;

    private JButton boutonPaquet32;
    private JButton boutonPaquet52;

    private JButton boutonIaFacile;
    private JButton boutonIaMedium;

    private JButton boutonLancerPartie;

    /**
     * Crée la fenêtre d'accueil et initialise les boutons.
     *
     * @param accueilControleur le contrôleur associé
     */
    public VueAccueil(ControleurAccueil accueilControleur){
        this.accueilControleur = accueilControleur;

        setTitle("BlackJack - Accueil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        panelPrincipal = new JPanel(new GridLayout(3,1));

        // Choix taille paquet
        panelChoixPaquet = new JPanel(new GridLayout(1,2));

        boutonPaquet32 = new JButton("Paquet 32");
        boutonPaquet32.addActionListener(e -> choisirTaillePaquet(32));

        boutonPaquet52 = new JButton("Paquet 52");
        boutonPaquet52.addActionListener(e -> choisirTaillePaquet(52));

        panelChoixPaquet.add(boutonPaquet32);
        panelChoixPaquet.add(boutonPaquet52);

        // Choix difficulté IA
        panelChoixIa = new JPanel(new GridLayout(1,2));

        boutonIaFacile = new JButton("Croupier facile");
        boutonIaFacile.addActionListener(e -> choisirDifficulte("Random"));

        boutonIaMedium = new JButton("Croupier medium");
        boutonIaMedium.addActionListener(e -> choisirDifficulte("IA"));

        boutonIaFacile.setEnabled(false);
        boutonIaMedium.setEnabled(false);

        panelChoixIa.add(boutonIaFacile);
        panelChoixIa.add(boutonIaMedium);

        // Bouton lancer
        boutonLancerPartie = new JButton("Lancer Partie");
        boutonLancerPartie.addActionListener(e -> lancerPartie());
        boutonLancerPartie.setEnabled(false);

        panelPrincipal.add(panelChoixPaquet);
        panelPrincipal.add(panelChoixIa);
        panelPrincipal.add(boutonLancerPartie);

        add(panelPrincipal, BorderLayout.CENTER);
        setSize(800,500);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Gère le choix de la taille du paquet.
     *
     * @param taille taille du paquet (32 ou 52)
     */
    private void choisirTaillePaquet(int taille){
        boutonPaquet32.setEnabled(false);
        boutonPaquet52.setEnabled(false);

        boutonIaFacile.setEnabled(true);
        boutonIaMedium.setEnabled(true);

        accueilControleur.setTaillePaquet(taille);
    }

    /**
     * Gère le choix de la difficulté du croupier.
     *
     * @param difficulte "Random" ou "IA"
     */
    private void choisirDifficulte(String difficulte){
        boutonIaFacile.setEnabled(false);
        boutonIaMedium.setEnabled(false);

        boutonLancerPartie.setEnabled(true);

        accueilControleur.setDifficulte(difficulte);
    }

    /**
     * Ferme l'accueil et démarre la partie.
     */
    private void lancerPartie(){
        dispose();
        accueilControleur.start();
    }
}
