/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartes;

import cartes.model.Paquet;
import cartes.vue.PaquetGUI;

/**
 *
 * @author lebasni231
 */
public class MainClass {
    public static void main(String[] args) {
       /* //Carte c1 = new Carte("as","pique");
        Paquet p1 = Paquet.createPaquet32();
        Paquet p2 = Paquet.createPaquet52();
        
        //System.out.print(p1);
        System.out.print(p2);
        */
       Paquet p = Paquet.createPaquet32();
       //System.out.print(p);
       PaquetGUI gui = new PaquetGUI(p);
       //System.out.print("ah");
    }
}
