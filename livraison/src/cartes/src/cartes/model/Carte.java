/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartes.model;

/**
 *
 * @author lebasni231
 */
public class Carte {
    private String valeur;
    private String couleur;

    public Carte(String val, String coul){
        this.valeur = val;
        this.couleur = coul;
    }
    
    @Override
    public String toString(){
        return this.valeur + this.couleur + "\n";
    }
    
}
