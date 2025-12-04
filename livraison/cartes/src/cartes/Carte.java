package cartes;

import javax.swing.*;
import java.net.URL;

/**
 * Représente une carte à jouer avec une valeur et une couleur.
 * Permet aussi de récupérer une icône graphique associée.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class Carte {
    private String valeur;
    private String couleur;

    /**
     * Crée une nouvelle carte.
     *
     * @param valeur la valeur de la carte (2..10, Valet, Dame, Roi, AS, etc.)
     * @param couleur la couleur de la carte (Coeur, Carreau, Trèfle, Pique, etc.)
     */
    public Carte(String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    /**
     * Retourne la valeur de la carte.
     *
     * @return la valeur
     */
    public String getValeur() {
        return valeur;
    }

    /**
     * Retourne la couleur de la carte.
     *
     * @return la couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Retourne une représentation texte de la carte.
     *
     * @return chaîne de la forme "valeur de couleur"
     */
    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }

    /**
     * Retourne l'icône associée à la carte.
     *
     * @param face true pour la carte visible, false pour le dos
     * @return l'icône chargée, ou null si l'image est introuvable
     */
    public Icon getIcon(boolean face) {
        String nomFichier;

        if (face) {
            String v = valeur;
            String c = couleur;
            nomFichier = v + "_" + c + ".png";
        } else {
            nomFichier = "Dos.png";
        }

        String chemin = "/cartes_icon/" + nomFichier;
        URL url = Carte.class.getResource(chemin);
        if (url == null) {
            System.err.println("Image non trouvée: " + chemin);
            return null;
        }
        return new ImageIcon(url);
    }
}
