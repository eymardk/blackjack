package blackjack.modele;

import cartes.model.Paquet;

/**
 * Gère le déroulement d'une partie de blackjack entre deux joueurs.
 * 
 * @author lebasni231
 */
public class Partie {
    private Joueur j1;
    private Joueur j2;
    private Paquet pioche;
    private int sizeP;
    private boolean j1Fini;
    private boolean j2Fini;
    
    /**
     * Construit une nouvelle partie.
     * @param j1 le premier joueur
     * @param j2 le second joueur
     * @param p la pioche
     */
    public Partie(Joueur j1, Joueur j2, Paquet p){
        this.pioche = p;
        this.sizeP = this.pioche.getPaquet().size();
        this.j1 = j1;
        this.j2 = j2;
        this.j1Fini = false;
        this.j2Fini = false;
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
    
    public boolean isJ1Fini(){
        return this.j1Fini;
    }
    
    public boolean isJ2Fini(){
        return this.j2Fini;
    }
    
    /**
     * Réinitialise la partie pour une nouvelle manche.
     */
    public void restart(){
        this.j1.newHand();
        this.j2.newHand();
        this.j1Fini = false;
        this.j2Fini = false;
        
        if(this.sizeP == 52){
            this.pioche.reset(52);
        }
        else{
            this.pioche.reset(32);
        }
    }
    
    /**
     * Initialise la partie : mélange et distribue 2 cartes à chaque joueur.
     */
    public void init(){
        this.pioche.melangerPaquet();
        
        for(int i = 0; i < 2; i++){
            j1.getPaquet().ajoutDessous(this.pioche.tiragePremiere());
            j2.getPaquet().ajoutDessous(this.pioche.tiragePremiere());
        }
        
        if(BlackJack.estBLackJack(this.j1.getPaquet())){
            this.j1Fini = true;
        }
        if(BlackJack.estBLackJack(this.j2.getPaquet())){
            this.j2Fini = true;
        }
    }
    
    /**
     * Fait jouer un tour au joueur 1.
     */
    public void tourJ1(){
        if(!this.j1Fini && !BlackJack.supperieur(this.j1.getPaquet())){
            this.j1.tour(this.pioche, this.j2);
            
            if(BlackJack.supperieur(this.j1.getPaquet())){
                this.j1Fini = true;
            }
        }
    }
    
    /**
     * Fait jouer un tour au joueur 2.
     */
    public void tourJ2(){
        if(!this.j2Fini && !BlackJack.supperieur(this.j2.getPaquet())){
            this.j2.tour(this.pioche, this.j1);
            
            if(BlackJack.supperieur(this.j2.getPaquet())){
                this.j2Fini = true;
            }
        }
    }
    
    /**
     * Marque le joueur 1 comme ayant terminé.
     */
    public void j1Reste(){
        this.j1Fini = true;
    }
    
    /**
     * Marque le joueur 2 comme ayant terminé.
     */
    public void j2Reste(){
        this.j2Fini = true;
    }
    
    /**
     * Vérifie si la partie est terminée.
     * @return true si terminée, false sinon
     */
    public boolean isOver(){
        if(this.j1Fini && this.j2Fini){
            return true;
        }
        
        if(this.pioche.getPaquet().size() < 2){
            return true;
        }
        
        return false;
    }
    
    /**
     * Calcule les résultats de la partie.
     * @return tableau [2][4] contenant nom, score, main, résultat
     */
    public Object[][] resultats(){
        Object[][] res = new Object[2][4];
        
        int scoreJ1 = this.j1.getPaquet().getSum();
        int scoreJ2 = this.j2.getPaquet().getSum();
        
        boolean j1Bust = BlackJack.supperieur(this.j1.getPaquet());
        boolean j2Bust = BlackJack.supperieur(this.j2.getPaquet());
        
        boolean j1BJ = BlackJack.estBLackJack(this.j1.getPaquet());
        boolean j2BJ = BlackJack.estBLackJack(this.j2.getPaquet());
        
        String resultatJ1;
        String resultatJ2;
        
        if(j1BJ && j2BJ){
            resultatJ1 = "EGALITE (BlackJack)";
            resultatJ2 = "EGALITE (BlackJack)";
        }
        else if(j1BJ){
            resultatJ1 = "GAGNE (BlackJack)";
            resultatJ2 = "PERDU";
        }
        else if(j2BJ){
            resultatJ1 = "PERDU";
            resultatJ2 = "GAGNE (BlackJack)";
        }
        else if(j1Bust && j2Bust){
            resultatJ1 = "PERDU (>21)";
            resultatJ2 = "PERDU (>21)";
        }
        else if(j1Bust){
            resultatJ1 = "PERDU (>21)";
            resultatJ2 = "GAGNE";
        }
        else if(j2Bust){
            resultatJ1 = "GAGNE";
            resultatJ2 = "PERDU (>21)";
        }
        else if(scoreJ1 > scoreJ2){
            resultatJ1 = "GAGNE (" + scoreJ1 + ")";
            resultatJ2 = "PERDU (" + scoreJ2 + ")";
        }
        else if(scoreJ2 > scoreJ1){
            resultatJ1 = "PERDU (" + scoreJ1 + ")";
            resultatJ2 = "GAGNE (" + scoreJ2 + ")";
        }
        else {
            resultatJ1 = "EGALITE (" + scoreJ1 + ")";
            resultatJ2 = "EGALITE (" + scoreJ2 + ")";
        }
        
        res[0][0] = this.j1.getName();
        res[0][1] = scoreJ1;
        res[0][2] = this.j1.getPaquet().toString();
        res[0][3] = resultatJ1;
        
        res[1][0] = this.j2.getName();
        res[1][1] = scoreJ2;
        res[1][2] = this.j2.getPaquet().toString();
        res[1][3] = resultatJ2;
        
        return res;
    }
}
