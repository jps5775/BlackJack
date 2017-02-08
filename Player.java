/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JoeSema
 */
public class Player {
    
    private String name;
    private Card[] hand = new Card[10];
    private int numCards;
    
    public Player(String aName){
        
        this.name = aName;
        
        //set a player's hand to empty
        this.emptyHand();
    }
    
    /**
     * Resets players hand to have no cards.
     */
    public void emptyHand() {
        
        for(int c = 0; c < hand.length; c++){
            
            this.hand[c] = null;
            
        }
        this.numCards = 0;
        
    }
    
    public boolean addCard(Card aCard){
        
        //print error in case we have max num of cards
        if(this.numCards == 10){
            
            System.err.println(this.name + "'s hand is already has 10 cards.");
            System.exit(1);
        }
        
        this.hand[this.numCards] = aCard;
        this.numCards++;
        
        return (this.getHandSum() <= 21);
    }

    public int getHandSum() {
        int handSum = 0;
        int cardNum;
        int numAces = 0;
        
        for(int c = 0; c < this.numCards; c++){
            
            cardNum = this.hand[c].getMyNumber();
            
            if(cardNum == 1) {
                numAces++;
                handSum += 11;
            }else if(cardNum > 10){
                handSum+=10;
            }else {
                handSum += cardNum;
            }
            
        }
        
        while(handSum > 21 && numAces > 0){
            
            handSum -= 10;
            numAces--;
            
        }
        return handSum;
    }
    
    public void printHand(boolean showFirstCard){
        
        System.out.println(this.name + "'s cards:");
        for(int c = 0; c < this.numCards; c++){
            if(c == 0 && !showFirstCard){
                
                System.out.println("  [hidden]");
                
            }else{
                System.out.printf("  %s\n", this.hand[c].toString());
            }
        
        }
        
    }
    
    
}
