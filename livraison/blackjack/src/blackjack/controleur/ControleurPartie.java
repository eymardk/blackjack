package blackjack.controleur;

import blackjack.modele.Partie;
import blackjack.vue.VuePartie;

/**
 * Contrôleur de la partie de blackjack.
 * Fait le lien entre la vue VuePartie et le modèle Partie.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class ControleurPartie {
    private final Partie partie;
    private final VuePartie vue;

    /**
     * Crée un contrôleur de partie et relie la vue au modèle.
     *
     * @param partie le modèle de partie
     * @param vue la vue associée
     */
    public ControleurPartie(Partie partie, VuePartie vue) {
        this.partie = partie;
        this.vue = vue;
        vue.setControleur(this);
    }

    /**
     * Démarre une nouvelle partie.
     *
     * @param typeCroupier "IA" ou "Random"
     * @param taillePaquet 32 ou 52 cartes
     */
    public void nouvellePartie(String typeCroupier, int taillePaquet) {
        partie.initialiserNouvellePartie(typeCroupier, taillePaquet);
        // La vue se met à jour automatiquement via Observer
    }

    /**
     * Action "Tirer" du joueur humain.
     */
    public void joueurTire() {
        partie.joueurTire();
        // La vue se met à jour automatiquement via Observer
    }

    /**
     * Action "Rester" du joueur humain.
     * Lance ensuite le tour du croupier.
     */
    public void joueurReste() {
        partie.jouerTourCroupier();
        // La vue se met à jour automatiquement via Observer
    }
}
