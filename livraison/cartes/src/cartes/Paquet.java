package cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Représente un paquet de cartes.
 * Permet d'ajouter, retirer et mélanger les cartes.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class Paquet {
    private List<Carte> cartes;

    /**
     * Crée un paquet vide.
     */
    public Paquet() {
        this.cartes = new ArrayList<>();
    }

    /**
     * Ajoute une carte au paquet.
     *
     * @param c la carte à ajouter (ignorée si null)
     */
    public void ajouter(Carte c) {
        if (c != null) {
            cartes.add(c);
        }
    }

    /**
     * Retire la dernière carte du paquet.
     *
     * @return la carte retirée, ou null si le paquet est vide
     */
    public Carte retirer() {
        if (cartes.isEmpty()) {
            return null;
        }
        return cartes.remove(cartes.size() - 1);
    }

    /**
     * Retire une carte au hasard dans le paquet.
     *
     * @return la carte retirée, ou null si le paquet est vide
     */
    public Carte retirerAleatoire() {
        if (cartes.isEmpty()) {
            return null;
        }
        Random r = new Random();
        int index = r.nextInt(cartes.size());
        return cartes.remove(index);
    }

    /**
     * Mélange les cartes du paquet.
     */
    public void melanger() {
        Collections.shuffle(cartes);
    }

    /**
     * Retourne le nombre de cartes dans le paquet.
     *
     * @return la taille du paquet
     */
    public int getTaille() {
        return cartes.size();
    }

    /**
     * Indique si le paquet est vide.
     *
     * @return true si le paquet ne contient aucune carte
     */
    public boolean estVide() {
        return cartes.isEmpty();
    }

    /**
     * Retourne la carte à un index donné sans la retirer.
     *
     * @param index position de la carte
     * @return la carte, ou null si l'index est invalide
     */
    public Carte getCarte(int index) {
        if (index < 0 || index >= cartes.size()) {
            return null;
        }
        return cartes.get(index);
    }

    /**
     * Retourne une représentation texte du paquet.
     *
     * @return une chaîne listant les cartes
     */
    @Override
    public String toString() {
        String resultat = "";
        for (Carte c : cartes) {
            resultat += c.toString() + "\n";
        }
        return resultat;
    }
}
