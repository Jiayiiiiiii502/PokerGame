package comp1721.cwk2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Representation of a standard suits.
 *
 * <p>Provided for use in COMP1721 Coursework 2.</p>
 *
 * @author Jiayi Xie
 */


public class Deck extends CardCollection{

    protected List<Card> deck;

    /**
     * Create a Deck object
     */
    public Deck(){
        deck = new LinkedList<>();
        for(Card.Suit suit:Card.Suit.values()){
            for (Card.Rank rank:Card.Rank.values()){
                Card card=new Card(rank,suit);
                deck.add(card);
            }
        }
    }

    /**
     * Show the size of a deck
     *
     * @return Return an integer which represents the size of a deck
     */
    public int size(){//bego
        return deck.size();
    }


    /**
     * Judge whether the deck is empty or not
     *
     * @return Return an integer which represents the size of a deck
     */
    public boolean isEmpty(){
        if(deck.size()==0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * Judge whether a specific card is in the deck or not
     *
     * @param card represents the specific card which will be compared with the deck
     * @return Return an integer which represents the size of a deck
     */
    public boolean contains(Card card){
        for(int i=0;i<deck.size();i++){
            System.out.println(deck.get(i));
            if(deck.get(i).equals(card)){
                return true;
            }
        }
        return false;
    }

    /**
     * Delete all cards in the deck
     *
     * @throws CardException if the deck is empty
     */
    public void discard(){
        if(deck.size()==0){
            throw new CardException("Invalid!\n");
        }
        else{
            deck.clear();
        }
    }

    /**
     * Delete the first card in the deck and return it
     *
     * @return Return the first card
     * @throws CardException if the deck is empty
     */
    public Card deal(){
        if(deck.size()==0){
            throw new CardException("Invalid!\n");
        }
        else{
            Card answer = deck.get(0);
            deck.remove(0);
            return answer;
        }
    }

    /**
     * Randomly scramble the deck by using API in Collections
     *
     */
    public void shuffle(){//bego
        Collections.shuffle(deck);
    }

    /**
     * Add a specific card into the deck
     *
     * @param card that meant to be added into deck
     */
    public void add(Card card){
        deck.add(card);
    }

}
