package blackjack.controleur;

import blackjack.modele.Partie;
import blackjack.vue.VueAccueil;
import blackjack.vue.VuePartie;

import javax.swing.SwingUtilities;

/**
 * Contrôleur de l'écran d'accueil.
 * Prépare la configuration de la partie avant de la lancer.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class ControleurAccueil {

    private int taillePaquet = 52;
    // "Random" = facile, "IA" = medium
    private String difficulte = "IA";

    /**
     * Crée le contrôleur et affiche la vue d'accueil.
     */
    public ControleurAccueil() {
        SwingUtilities.invokeLater(() -> new VueAccueil(this));
    }

    /**
     * Définit la taille du paquet choisi.
     *
     * @param taille 32 ou 52
     */
    public void setTaillePaquet(int taille) {
        this.taillePaquet = taille;
    }

    /**
     * Définit la difficulté choisie.
     *
     * @param difficulte "Random" ou "IA"
     */
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    /**
     * Lance la partie avec les paramètres choisis.
     */
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
