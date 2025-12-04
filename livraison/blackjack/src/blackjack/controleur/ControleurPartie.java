package blackjack.controleur;

import blackjack.modele.Partie;
import blackjack.vue.VuePartie;

public class ControleurPartie {
    private final Partie partie;
    private final VuePartie vue;

    public ControleurPartie(Partie partie, VuePartie vue) {
        this.partie = partie;
        this.vue = vue;
        vue.setControleur(this);
    }

    public void nouvellePartie(String typeCroupier, int taillePaquet) {
        partie.initialiserNouvellePartie(typeCroupier, taillePaquet);
        // La vue se met à jour AUTOMATIQUEMENT via Observer
    }

    public void joueurTire() {
        partie.joueurTire();
        // La vue se met à jour AUTOMATIQUEMENT via Observer
    }

    public void joueurReste() {
        partie.jouerTourCroupier();
        // La vue se met à jour AUTOMATIQUEMENT via Observer
    }
}
