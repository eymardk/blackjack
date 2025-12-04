/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.modele;

//import blackjack.controleur.AbstractModeleEcoutable;
import cartes.model.Paquet;
import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.TimeUnit;

/**
 * Deroulement d'un partie de blackjack
 * 
 */
public class Partie {
    //private Joueur currJ;
    private Joueur j1;
    private Joueur j2;
    private Paquet pioche;
    private int sizeP;
    private boolean tour1 = true;
    
    public Partie(Joueur j1, Joueur j2, Paquet p){
        this.pioche = p;
        this.sizeP = this.pioche.getPaquet().size();
        this.j1 = j1;
        this.j2 = j2;
    }
    
    public Joueur getJ1(){
        return this.j1;
    }
    
    public Joueur getJ2(){
        return this.j2;
    }
    
    public Paquet getPioche(){
        return this.pioche;
    }
    
    public void restart(){
        this.j1.newHand();
        this.j2.newHand();
        
        if(this.sizeP == 52){
            this.pioche.reset(52);
        }
        else{
            this.pioche.reset(32);
        }
    }
    
    public void init(){
        this.pioche.melangerPaquet();
        
        for(int i = 0; i < 2; i++){
            j1.getPaquet().ajoutDessous(this.pioche.tiragePremiere());
            j2.getPaquet().ajoutDessous(this.pioche.tiragePremiere());
        }
        System.out.print("NEW");
    }
    
    public boolean isOver(){
        if((BlackJack.estBLackJack(this.j1.getPaquet())|| BlackJack.estBLackJack(this.j2.getPaquet())) && this.tour1){
            return true;
        }
        if(BlackJack.supperieur(this.j1.getPaquet()) || BlackJack.supperieur(this.j2.getPaquet())){
            return true;
        }
        if(this.pioche.getPaquet().size() < 2){
            return true;
        }
        return false;
    } 
    
    public Object[][] resultats(){
        Object[][] res = new Object[2][4];
        
        ArrayList<Integer> scores = new ArrayList<>();
        List<String> resultats = new ArrayList<>();
        int max = 0;
        

        scores.add(this.j1.getPaquet().getSum());
            
        if(BlackJack.supperieur(this.j1.getPaquet())){
            resultats.add("PERDU");
        }
        else {
            resultats.add("GAGNE");
            if(this.j1.getPaquet().getSum() > max){
                max = this.j1.getPaquet().getSum();
            }
        }
        
        scores.add(this.j2.getPaquet().getSum());
            
        if(BlackJack.supperieur(this.j2.getPaquet())){
            resultats.add("PERDU");
        }
        else {
            resultats.add("GAGNE");
            if(this.j2.getPaquet().getSum() > max){
                max = this.j2.getPaquet().getSum();
            }
        }
        
        for(int i = 0; i < scores.size(); i++){
            if(resultats.get(i).equals("GAGNE") && scores.get(i) != max){
                resultats.set(i, "PERDU");
            }
            
        }
        
        res[0][0] = this.j1.getName();
        res[0][1] = scores.get(0);
        res[0][2] = this.j1.getPaquet().toString();
        res[0][3] = resultats.get(0);
        
        res[1][0] = this.j2.getName();
        res[1][1] = scores.get(1);
        res[1][2] = this.j2.getPaquet().toString();
        res[1][3] = resultats.get(1);
        return res;
    }
    
}
