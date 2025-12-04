package blackjack.modele.joueur;

import cartes.Paquet;
import cartes.Carte;
import blackjack.modele.ReglesBlackjack;

/**
 * Représente un joueur de blackjack (humain ou IA).
 * Gère le nom, la main et les opérations de base.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public abstract class Joueur {
    protected String nom;
    protected Paquet main;

    /**
     * Crée un joueur avec un nom et une main vide.
     *
     * @param nom le nom du joueur
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.main = new Paquet();
    }

    /**
     * Retourne le nom du joueur.
     *
     * @return le nom
     */
    public String getNom() { return nom; }

    /**
     * Retourne la main du joueur.
     *
     * @return le paquet représentant la main
     */
    public Paquet getMain() { return main; }

    /**
     * Ajoute une carte dans la main du joueur.
     *
     * @param c la carte à ajouter
     */
    public void ajouterCarte(Carte c) {
        main.ajouter(c);
    }

    /**
     * Vide complètement la main du joueur.
     */
    public void viderMain() {
        while (!main.estVide()) {
            main.retirer();
        }
    }

    /**
     * Calcule le score de la main du joueur.
     *
     * @return le score de la main
     */
    public int getScore() {
        return ReglesBlackjack.calculerScore(main);
    }

    /**
     * Indique si le joueur a dépassé 21.
     *
     * @return true si le joueur est bust
     */
    public boolean estBust() {
        return this.getScore() > 21;
    }

    /**
     * Indique si la main du joueur est un blackjack.
     *
     * @return true si la main vaut 21 avec deux cartes
     */
    public boolean estBlackjack() {
        return ReglesBlackjack.estBlackjack(main);
    }

    /**
     * Indique si le joueur veut tirer une carte.
     *
     * @param carteVisibleCroupier valeur de la carte visible du croupier
     * @return true pour tirer, false pour rester
     */
    public abstract boolean veutTirer(String carteVisibleCroupier);
}
