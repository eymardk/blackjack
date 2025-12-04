package cartes;

public class MainClass {
    public static void main(String[] args) {
        Paquet p52 = FabriquerPaquet.creePaquet52();
        System.out.println("Jeu 52 : " + p52.getTaille());
        System.out.println(p52);

        Paquet p32 = FabriquerPaquet.creePaquet32();
        System.out.println("Jeu 32 : " + p32.getTaille());
        System.out.println(p32);
    }
}
