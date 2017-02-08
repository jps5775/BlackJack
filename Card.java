

/**
 * An implementation of a card type.
 * 
 * @author JoeSema
 */
public class Card {
    /**
     * Two Data Types:
     * Primitive: int, short, long, String, boolean, float, double, and char
     * 'Compound/other': objects, lists, arrays etc. 
     * 
     */
    private Suit mySuit; // Object data type is Suit object
    private int myNumber;
    
    /**
     * @param aSuit        the suit of the card
     * @param aNumber      the number of the card
     */
    
    
    public Card(Suit aSuit, int aNumber){
        
        this.mySuit = aSuit;
        
        if(aNumber >= 1 && aNumber <= 13){
            
            this.myNumber = aNumber;
            
        } else {
            
            System.err.println(aNumber + " is not a valid card number.");
            System.exit(1);
            
        }
        
        
    }
    
    
    public int getMyNumber(){
        
        return myNumber;
        
    }
    
    @Override
    public String toString(){
        
        String numStr = "Error";
        
        
        switch(this.myNumber){
            
            case 2:
                numStr = "Two";
                break;
                
            case 3:
                numStr = "There";
                break;
            
            case 4:
                numStr = "Four";
                break;
                
            case 5:
                numStr = "Five";
                break;
                
            case 6:
                numStr = "Six";
                break;
                
            case 7:
                numStr = "Seven";
                break;
                
            case 8:
                numStr = "Eight";
                break;
                
            case 9:
                numStr = "Nine";
                break;
                
            case 10:
                numStr = "Ten";
                break;
                
            case 11:
                numStr = "Jack";
                break;
                
            case 12:
                numStr = "Queen";
                break;
                
            case 13:
                numStr = "King";
                break;
                
            case 1:
                numStr = "Ace";
                break;
        
        }
        
        return numStr + " of " + mySuit.toString();
        
    }
    
    
}
