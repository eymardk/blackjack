package blackjack.modele;

import java.util.ArrayList;
import java.util.List;

import cartes.Paquet;
import cartes.FabriqueCartes;
import blackjack.modele.joueur.Joueur;
import blackjack.modele.joueur.JoueurHumain;
import blackjack.modele.joueur.JoueurIA;

public class Partie {

    private Paquet pioche;
    private Joueur croupier;
    private List<Joueur> joueurs;
    // Au démarrage, aucune manche en cours → true pour activer "Nouvelle partie"
    private boolean partieTerminee = true;

    public Partie() {
        joueurs = new ArrayList<>();
        croupier = new JoueurIA("Croupier");
    }

    public void ajouterJoueur(Joueur j) {
        joueurs.add(j);
    }

    // Nouvelle manche : pioche, mélange, vider mains, distribuer 2 cartes à tous
    public void initialiserNouvellePartie() {
        pioche = FabriqueCartes.creerJeu52Cartes();
        pioche.melanger();

        croupier.viderMain();
        for (Joueur j : joueurs) {
            j.viderMain();
        }

        for (int i = 0; i < 2; i++) {
            for (Joueur j : joueurs) {
                j.ajouterCarte(pioche.retirer());
            }
            croupier.ajouterCarte(pioche.retirer());
        }

        partieTerminee = false;
    }

    public Paquet getPioche() { return pioche; }
    public Joueur getCroupier() { return croupier; }
    public List<Joueur> getJoueurs() { return joueurs; }

    public boolean isPartieTerminee() { return partieTerminee; }
    public void setPartieTerminee(boolean terminee) { this.partieTerminee = terminee; }

    // Premier joueur humain (s’il existe)
    public Joueur getPremierJoueurHumain() {
        for (Joueur j : joueurs) {
            if (j instanceof JoueurHumain) return j;
        }
        return null;
    }

    // Tous les bots jouent automatiquement (l’humain est ignoré)
    public void jouerTourBots() {
        String carteVisibleCroupier = croupier.getMain().getCarte(0).getValeur();

        for (Joueur j : joueurs) {
            if (j instanceof JoueurHumain) continue;

            while (!j.estBust() && j.veutTirer(carteVisibleCroupier)) {
                j.ajouterCarte(pioche.retirer());
            }
        }
    }

    // Croupier joue en dernier
    public void jouerTourCroupier() {
        String carteVisible = croupier.getMain().getCarte(0).getValeur();
        while (!croupier.estBust() && croupier.veutTirer(carteVisible)) {
            croupier.ajouterCarte(pioche.retirer());
        }
    }

    // Données utilisées par le tableau de résultats
    public Object[][] getTableauResultats() {
        Object[][] data = new Object[joueurs.size()][4];

        int scoreC = ReglesBlackjack.calculerScore(croupier.getMain());
        boolean bustC = ReglesBlackjack.aDepasse(croupier.getMain());

        for (int i = 0; i < joueurs.size(); i++) {
            Joueur j = joueurs.get(i);
            int scoreJ = ReglesBlackjack.calculerScore(j.getMain());
            boolean bustJ = ReglesBlackjack.aDepasse(j.getMain());

            String resultat;
            if (bustJ) {
                resultat = "PERDU";
            } else if (bustC) {
                resultat = "GAGNÉ";
            } else if (scoreJ > scoreC) {
                resultat = "GAGNÉ";
            } else if (scoreJ < scoreC) {
                resultat = "PERDU";
            } else {
                resultat = "ÉGALITÉ";
            }

            data[i][0] = j.getNom();
            data[i][1] = scoreJ;
            data[i][2] = j.getMain().toString();
            data[i][3] = resultat;
        }
        return data;
    }
}
