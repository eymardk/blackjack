package blackjack.modele;

import java.util.ArrayList;
import java.util.List;

import cartes.Paquet;
import cartes.FabriquerPaquet;
import blackjack.modele.joueur.Joueur;
import blackjack.modele.joueur.JoueurHumain;
import blackjack.modele.joueur.JoueurIA;
import blackjack.modele.joueur.JoueurRandom;

public class Partie {

    private Paquet pioche;
    private Joueur croupier;
    private Joueur joueur;
    private boolean partieTerminee = true;

    public Partie() {
        this.joueur = new JoueurHumain("Joueur");
    }

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
    }

    public Paquet getPioche() {
        return pioche;
    }

    public Joueur getCroupier() {
        return croupier;
    }

    public void setCroupier(String with) {
        if (with == "IA") {
            this.croupier =  new JoueurIA("Croupier : IA");
        }
        else {
            this.croupier = new JoueurRandom("Croupier : Random");
        }
    }

    public void setPioche(int size){
        if (size == 32) {
            this.pioche = FabriquerPaquet.creePaquet32();
        }
        else {
            //Plutard Taille variée
            this.pioche = FabriquerPaquet.creePaquet52();
        }
    }

    public Joueur getJoueurs() {
        return joueur;
    }

    public boolean PartieTerminee() {
        return partieTerminee;
    }

    public void setPartieTerminee(boolean terminee) {
        this.partieTerminee = terminee;
    }

    public void jouerTourCroupier() {
        String carteVisible = croupier.getMain().getCarte(0).getValeur();
        while (!croupier.estBust() && croupier.veutTirer(carteVisible)) {
            croupier.ajouterCarte(pioche.retirer());
        }
    }

    public Object[][] getTableauResultats() {
        Object[][] data = new Object[2][3];

        String resultat_croupier;
        String resultat_joueur;

        if (croupier.estBust()) {
            resultat_croupier = "PERDU";
            resultat_joueur = "GAGNÉ";
        } else if (joueur.estBust()) {
            resultat_croupier = "GAGNÉ";
            resultat_joueur = "PERDU";
        } else if (croupier.getScore() > joueur.getScore()) {
            resultat_croupier = "GAGNÉ";
            resultat_joueur = "PERDU";
        } else if (croupier.getScore() < joueur.getScore()) {
            resultat_croupier = "PERDU";
            resultat_joueur = "GAGNÉ";
        } else {
            resultat_croupier = "ÉGALITÉ";
            resultat_joueur = "ÉGALITÉ";
        }

        data[0][0] = croupier.getNom();
        data[0][1] = croupier.getScore();
        data[0][3] = resultat_croupier;

        data[1][0] = joueur.getNom();
        data[1][1] = joueur.getScore();
        data[2][3] = resultat_joueur;

        return data;
    }
}
