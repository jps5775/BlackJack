
import java.util.Random;
        
/**
 *
 * @author JoeSema
 */
public class Deck {
    
    /**
     * The array of cards in the deck, where the top card is in the first index.
     */
    
    private Card[] myCards;
    
    /**
     * The number of cards currently in the deck.
     */
    
    private int numCards;
    
    /**
     * call the other constructor, when defining one deck without shuffling
     * this deck constructor is overloaded
     * 52 cards and no shuffle
     */
    
    public Deck(){
        
        this(1,false);
        
    }
    
    public Deck(int numDecks, boolean shuffle){
        
        this.numCards = numDecks * 52;
        this.myCards = new Card[this.numCards];
        
        //init card index
        int c = 0;
        
        //for each deck
        for(int d = 0; d < numDecks; d++){
            
            //for each suit
            for(int s = 0; s < 4; s++){
                
                //for each number
                for(int n = 1; n <= 13; n++){
                    
                    this.myCards[c] = new Card(Suit.values()[s], n);
                    c++;
                    
                }
                
            }
            
        }
        
        //shuffle deck, if necessary
        if (shuffle){
            
            this.shuffle();
            
        }
        
    }
    
    public void shuffle(){
        
        //init random number generator
        Random rng = new Random();
        
        //temp card
        Card temp;
        
        int j;
        for(int i = 0; i < this.numCards; i++){
            
            //random number from 0-52
            j = rng.nextInt(this.numCards);
            
            //do swap
            temp = this.myCards[i];
            this.myCards[i] = this.myCards[j];
            this.myCards[j] = temp;
            
        }
    }
    
    /**
     * Deal next card on top of deck
     * 
     * @return      top Card object/reference type 
     */
    public Card dealNextCard(){
        //get the top card
        
        Card top = this.myCards[0];
        
        //shift all subsequent cards to the left by one index
        for(int c = 1; c < this.numCards; c++){
            
            this.myCards[c-1] = this.myCards[c];
            
        }
        
        this.myCards[this.numCards-1] = null;
        
        //decrement the number of cards in our deck
        this.numCards--;
            
        return top;
    }
    
    /**
     * prints out the top cards of the deck
     * @param numToPrint    the num of cards from the top of the deck to print
     */
    public void printDeck(int numToPrint){
        
        for(int c = 0; c < numToPrint; c++){
            System.out.printf("% 3d/%d %s\n", c+1, this.numCards, 
                    this.myCards[c].toString());
            
        }
        
        System.out.printf("\t[%d others]\n", this.numCards - numToPrint);
        
        
    }
}
