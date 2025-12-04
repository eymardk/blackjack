package cartes;

/**
 * Classe de test simple pour la librairie cartes.
 * Crée et affiche un paquet de 52 cartes puis un paquet de 32 cartes.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class MainClass {

    /**
     * Point d'entrée de l'application de test.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        Paquet p52 = FabriquerPaquet.creePaquet52();
        System.out.println("Jeu 52 : " + p52.getTaille());
        System.out.println(p52);

        Paquet p32 = FabriquerPaquet.creePaquet32();
        System.out.println("Jeu 32 : " + p32.getTaille());
        System.out.println(p32);
    }
}
