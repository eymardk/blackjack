package cartes;

public class FabriquerPaquet {

    // Cas particulier : jeu de 52 cartes classique
    public static Paquet creePaquet52() {
        String[] valeurs = {
            "2", "3", "4", "5", "6", "7","8", "9", "10", 
            "Valet", "Dame", "Roi", "AS"
        };

        String[] couleurs = { "Coeur", "Carreau", "Trèfle", "Pique" };

        return creePaquet(valeurs, couleurs);
    }

    // Cas particulier : jeu de 32 cartes classique
    public static Paquet creePaquet32() {
        String[] valeurs = {
            "7", "8", "9", "10", 
            "Valet", "Dame", "Roi" ,"AS"
        };

        String[] couleurs = { "Coeur", "Carreau", "Trèfle", "Pique" };

        return creePaquet(valeurs, couleurs);
    }


    // Cas général : crée un paquet à partir de listes de valeurs et de couleurs
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
