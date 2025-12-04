package blackjack.modele;

import cartes.model.Paquet;

/**
 * Classe abstraite représentant un joueur.
 * Pattern Template Method.
 * @author lebasni231
 */
public abstract class Joueur {
    private Paquet p;
    private String name;
    
    /**
     * Construit un joueur.
     * @param n le nom
     */
    public Joueur(String n){
        this.name = n;
        this.p = new Paquet();
    }
    
    public String getName(){
        return this.name;
    }
    
    public Paquet getPaquet(){
        return this.p;
    }
    
    /**
     * Réinitialise la main du joueur.
     */
    public void newHand(){
        this.p.vide();
    }
    
    /**
     * Pioche une carte.
     * @param p le paquet source
     */
    public abstract void drawCard(Paquet p);
    
    /**
     * Exécute le tour du joueur.
     * @param p la pioche
     * @param adv l'adversaire
     */
    public abstract void tour(Paquet p, Joueur adv);
}
