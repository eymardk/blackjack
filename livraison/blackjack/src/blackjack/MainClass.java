package blackjack;

import blackjack.controleur.ControleurAccueil;

/**
 * Point d'entrée de l'application Blackjack.
 * Crée le contrôleur de l'écran d'accueil.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class MainClass {

    /**
     * Méthode principale de l'application.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        new ControleurAccueil();
    }
}
