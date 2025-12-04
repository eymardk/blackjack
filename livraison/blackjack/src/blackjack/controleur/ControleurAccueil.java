package blackjack.controleur;

import blackjack.modele.Partie;
import blackjack.vue.VueAccueil;
import blackjack.vue.VuePartie;

import javax.swing.SwingUtilities;

/**
 * Contrôleur de l'écran d'accueil.
 */
public class ControleurAccueil {

    private int taillePaquet = 52;
    // "f" = facile (Random), "m" = medium (IA)
    private String difficulte = "IA";

    public ControleurAccueil() {
        SwingUtilities.invokeLater(() -> new VueAccueil(this));
    }

    public void setTaillePaquet(int taille) {
        this.taillePaquet = taille;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public void start() {
        Partie partie = new Partie();
        String typeCroupier = difficulte.equals("IA") ? "IA" : "Random";

        partie.initialiserNouvellePartie(typeCroupier, taillePaquet);

        VuePartie vue = new VuePartie(partie);
        ControleurPartie controleur = new ControleurPartie(partie, vue);
        controleur.nouvellePartie(typeCroupier, taillePaquet);
        vue.setControleur(controleur);
        
    }
}
