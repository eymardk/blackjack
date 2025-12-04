package blackjack;

import blackjack.modele.Partie;
import blackjack.modele.joueur.*;
import blackjack.vue.VuePartie;
import blackjack.controleur.ControleurPartie;

import javax.swing.SwingUtilities;

// Point d'entrée de l'application Blackjack (GUI)
public class MainClass {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Modèle : partie avec un croupier IA
            Partie partie = new Partie();
            partie.ajouterJoueur(new JoueurHumain("Humain"));
            partie.ajouterJoueur(new JoueurIA("Bot IA"));
            partie.ajouterJoueur(new JoueurRandom("Bot Random"));

            // Vue graphique
            VuePartie vue = new VuePartie();

            // Contrôleur qui relie modèle et vue
            new ControleurPartie(partie, vue);

            // Affiche la fenêtre
            vue.setVisible(true);
        });
    }
}
