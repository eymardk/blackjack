package blackjack.modele;

import cartes.Paquet;
import cartes.FabriquerPaquet;
import blackjack.modele.joueur.Joueur;
import blackjack.modele.joueur.JoueurHumain;
import blackjack.modele.joueur.JoueurIA;
import blackjack.modele.joueur.JoueurRandom;

/**
 * Gère une partie de Blackjack entre un joueur humain et un croupier (IA).
 */
public class Partie extends ModeleObservable {

    private Paquet pioche;
    private Joueur croupier;
    private Joueur joueur;
    private boolean partieTerminee = true;

    public Partie() {
        this.joueur = new JoueurHumain("Joueur");
    }

    /**
     * Initialise une nouvelle partie.
     * 
     * @param with "IA" pour JoueurIA, autre pour JoueurRandom
     * @param size 32 ou 52 pour la taille du paquet
     */
    public void initialiserNouvellePartie(String with, int size) {
        this.setCroupier(with);
        this.setPioche(size);

        pioche.melanger();

        croupier.viderMain();
        joueur.viderMain();

        for (int i = 0; i < 2; i++) {
            joueur.ajouterCarte(pioche.retirer());
            croupier.ajouterCarte(pioche.retirer());
        }

        partieTerminee = false;
        fireChange(); // <-- nouveau
    }

    public Paquet getPioche() {
        return pioche;
    }

    public Joueur getCroupier() {
        return croupier;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setCroupier(String with) {
        if ("IA".equals(with)) {
            this.croupier = new JoueurIA("Croupier (IA)");
        } else {
            this.croupier = new JoueurRandom("Croupier (Random)");
        }
    }

    public void setPioche(int size) {
        if (size == 32) {
            this.pioche = FabriquerPaquet.creePaquet32();
        } else {
            this.pioche = FabriquerPaquet.creePaquet52();
        }
    }

    public boolean isPartieTerminee() {
        return partieTerminee;
    }

    public void setPartieTerminee(boolean terminee) {
        this.partieTerminee = terminee;
        fireChange();
    }

    /**
     * Tour du joueur : il tire une carte.
     * Retourne true si la partie doit s'arrêter (bust ou blackjack).
     */
    public boolean joueurTire() {
        if (partieTerminee || pioche.estVide())
            return true;

        joueur.ajouterCarte(pioche.retirer());

        if (joueur.estBust() || joueur.estBlackjack()) {
            partieTerminee = true;
        }

        fireChange();
        return partieTerminee;
    }

    /**
     * Tour complet du croupier : il joue jusqu'à s'arrêter.
     */
    public void jouerTourCroupier() {
        if (partieTerminee)
            return;

        String carteVisible = croupier.getMain().getCarte(0).getValeur();

        while (!croupier.estBust() && croupier.veutTirer(carteVisible) && !pioche.estVide()) {
            croupier.ajouterCarte(pioche.retirer());
        }

        partieTerminee = true;
        fireChange(); 
    }

    /**
     * Renvoie un tableau 2x3 pour l'affichage des résultats :
     * [ligne][colonne] = [0: nom, 1: score, 2: résultat]
     */
    public Object[][] getTableauResultats() {
        Object[][] data = new Object[2][3];

        String resultatCroupier;
        String resultatJoueur;

        if (croupier.estBust() && joueur.estBust()) {
            resultatCroupier = "PERDU (>21)";
            resultatJoueur = "PERDU (>21)";
        } else if (croupier.estBust()) {
            resultatCroupier = "PERDU (>21)";
            resultatJoueur = "GAGNÉ";
        } else if (joueur.estBust()) {
            resultatCroupier = "GAGNÉ";
            resultatJoueur = "PERDU (>21)";
        } else if (croupier.getScore() > joueur.getScore()) {
            resultatCroupier = "GAGNÉ";
            resultatJoueur = "PERDU";
        } else if (croupier.getScore() < joueur.getScore()) {
            resultatCroupier = "PERDU";
            resultatJoueur = "GAGNÉ";
        } else {
            resultatCroupier = "ÉGALITÉ";
            resultatJoueur = "ÉGALITÉ";
        }

        // ligne 0 : croupier
        data[0][0] = croupier.getNom();
        data[0][1] = croupier.getScore();
        data[0][2] = resultatCroupier;

        // ligne 1 : joueur
        data[1][0] = joueur.getNom();
        data[1][1] = joueur.getScore();
        data[1][2] = resultatJoueur;

        return data;
    }
}
