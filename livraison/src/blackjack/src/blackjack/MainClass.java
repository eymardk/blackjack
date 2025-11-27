/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import cartes.model.Paquet;
import cartes.vue.PaquetGUI;

/**
 * Verif utilisation class Carte as lib
 * @author lebasni231
 */
public class MainClass {
   /**
   * C'est juste un main
     * @param args
   */
    public static void main(String[] args) {
        //Paquet p1 = Paquet.createPaquet32();
        //System.out.print(p1);
        Paquet p = Paquet.createPaquet32();
        PaquetGUI gui = new PaquetGUI(p);
    }
}


