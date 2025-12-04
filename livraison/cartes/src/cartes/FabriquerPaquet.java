package cartes;

/**
 * Fabrique des paquets de cartes.
 * Fournit des méthodes pour créer des paquets 52, 32 cartes ou personnalisés.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class FabriquerPaquet {

    /**
     * Crée un paquet de 52 cartes classique.
     *
     * @return un paquet de 52 cartes
     */
    public static Paquet creePaquet52() {
        String[] valeurs = {
            "2", "3", "4", "5", "6", "7","8", "9", "10",
            "Valet", "Dame", "Roi", "AS"
        };

        String[] couleurs = { "Coeur", "Carreau", "Trèfle", "Pique" };

        return creePaquet(valeurs, couleurs);
    }

    /**
     * Crée un paquet de 32 cartes classique.
     *
     * @return un paquet de 32 cartes
     */
    public static Paquet creePaquet32() {
        String[] valeurs = {
            "7", "8", "9", "10",
            "Valet", "Dame", "Roi" ,"AS"
        };

        String[] couleurs = { "Coeur", "Carreau", "Trèfle", "Pique" };

        return creePaquet(valeurs, couleurs);
    }

    /**
     * Crée un paquet à partir de listes de valeurs et de couleurs.
     *
     * @param valeurs les valeurs possibles des cartes
     * @param couleurs les couleurs possibles des cartes
     * @return un paquet contenant toutes les combinaisons valeur/couleur
     */
    public static Paquet creePaquet(String[] valeurs, String[] couleurs) {
        Paquet paquet = new Paquet();

        for (String couleur : couleurs) {
            for (String valeur : valeurs) {
                paquet.ajouter(new Carte(valeur, couleur));
            }
        }

        return paquet;
    }
}
