package blackjack.modele.joueur;

import cartes.Paquet;
import cartes.Carte;
import blackjack.modele.ReglesBlackjack;

public abstract class Joueur {
    protected String nom;
    protected Paquet main;

    public Joueur(String nom) {
        this.nom = nom;
        this.main = new Paquet();
    }

    public String getNom() { return nom; }

    public Paquet getMain() { return main; }

    public void ajouterCarte(Carte c) {
        main.ajouter(c);
    }

    public void viderMain() {
        while (!main.estVide()) {
            main.retirer();
        }
    }

    public int getScore() {
        return ReglesBlackjack.calculerScore(main);
    }

    public boolean estBust() {
        return this.getScore() > 21;
    }

    public boolean estBlackjack() {
        return ReglesBlackjack.estBlackjack(main);
    }


    public abstract boolean veutTirer(String carteVisibleCroupier);
}
