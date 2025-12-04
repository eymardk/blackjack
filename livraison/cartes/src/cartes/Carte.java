package cartes;

import javax.swing.*;
import java.net.URL;

public class Carte {
    private String valeur;
    private String couleur;

    public Carte(String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public String getValeur() {
        return valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }

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
