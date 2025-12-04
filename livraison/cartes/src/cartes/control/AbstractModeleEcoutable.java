/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartes.control;

import java.util.ArrayList;

/**
 * 
 * 
 */
public abstract class AbstractModeleEcoutable {
    private ArrayList<EcouteurModele> ecouteurs = new ArrayList<>();
    
    public void ajoutEcouteur(EcouteurModele e){
        ecouteurs.add(e);
    }
    
    public void removeEcouteur(EcouteurModele e){
        ecouteurs.remove(e);
    }
    
    public void fireChange(){
        for(EcouteurModele e : ecouteurs){
            e.modeleMisAJour(this);
        }
    }
}
