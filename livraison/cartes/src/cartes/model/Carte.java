package cartes.model;

/**
 * Représente une carte à jouer.
 * @author lebasni231
 */
public class Carte {
    private String valeur;
    private String couleur;

    /**
     * Construit une carte.
     * @param val la valeur
     * @param coul la couleur
     */
    public Carte(String val, String coul){
        this.valeur = val;
        this.couleur = coul;
    }
    
    public String getVal(){
        return this.valeur;
    }
    
    public String getCouleur(){
        return this.couleur;
    }
    
    @Override
    public String toString(){
        return this.valeur + this.couleur;
    }
}
