package comp1721.cwk2;

import java.util.*;


/**
 * Representation of the actual card gaming.
 *
 * <p>Provided for use in COMP1721 Coursework 2.</p>
 *
 * @author Jiayi Xie
 */
public class PokerHand extends CardCollection{

    protected List<Card> hand;
    /**
     * Creates a hand object
     */
    public PokerHand(){
        hand=new LinkedList<>();
    }


    /**
     * Creates a Card object.
     *
     * <p>A constructor with a String parameter that specifies the cards that should be added to the hand, using
     *     two-character abbreviations for the cards.</p>
     *
     * @param cards String representation of a card
     * @throws CardException if there might be duplicated card or too many cards added in
     */
    public PokerHand(String cards){
        hand=new LinkedList<>();
        String[] input=cards.split(" ");
        if(input.length>5){
            throw new CardException("Too much cards!\n");
        }
        for(int i=0;i<input.length;i++){
            if(hand.contains(new Card(input[i]))){
                throw new CardException("Duplicated!\n");
            }
            else{
                hand.add(new Card(input[i]));
            }
        }
    }


    /**
     * Creates a Card object.
     *
     * <p>overriding the default version, which returns a string in which cards are shown
     *     in two-character form, separated by spaces—e.g., "2D JC 7H"</p>
     *
     *  @return String which can be represented in two ways
     */
    @Override
    public String toString() {


        StringBuilder builder=new StringBuilder();

        for(int i=0;i< hand.size();i++){
            builder.append(hand.get(i).toString());
            if(i<hand.size()-1){
                builder.append(" ");
            }
        }
        return builder.toString();
    }


    /**
     * Show the size of the hand
     *
     * @return Return an integer which represents the size of a hand
     */
    public int size(){
        return hand.size();
    }


    /**
     * Delete all cards in the hand
     *
     * @throws CardException if the hand is empty
     */
    public void discard(){
        if(hand.size()==0){
            throw new CardException("Invalid!");
        }
        else{
            hand.clear();
        }
    }



    /**
     * Delete all cards in the hand and return to the deck
     *
     *<P>empties the hand of cards and returns each of them
     *   to the specified deck.</P>
     *
     * @throws CardException if the deck is empty
     */
    public Deck discardTo(Deck deck){
        if(hand.size()==0){
            throw new CardException("Invalid!\n");
        }
        else{
            for(int i=0;i<hand.size();i++){
                deck.add(hand.get(i));
            }
            hand.clear();
        }
        return deck;
    }

    /**
     * Judge whether this hand is pair or not
     *
     * @throws CardException if the there is not 5 cards in the hand
     */
    public boolean isPair(){
        if(hand.size()!=5){
            return false;
        }
        List<Character> ranks=new ArrayList<>();
        for(int i=0;i<hand.size();i++){
            ranks.add(hand.get(i).getRank().getSymbol());
        }

        Map<Character,Integer> map =new HashMap<>();
        for(Character rank:ranks){
            Integer count=map.get(rank);
            map.put(rank, count == null ? 1 : count + 1);
        }
        int max=0;
        int num=0;
        for(Integer value:map.values()){
            if(value>max){
                max=value;
                num=1;
            }
            else if(value==max){
                num++;
            }
            else{
                continue;
            }
        }
        if(max==2 &&num==1){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * Judge whether this hand is two pairs or not
     *
     * @throws CardException if the there is not 5 cards in the hand
     */
    public boolean isTwoPairs(){
        if(hand.size()!=5){
            return false;
        }
        List<Character> ranks=new ArrayList<>();
        for(int i=0;i<hand.size();i++){
            ranks.add(hand.get(i).getRank().getSymbol());
        }

        Map<Character,Integer> map =new HashMap<>();
        for(Character rank:ranks){
            Integer count=map.get(rank);
            map.put(rank, count == null ? 1 : count + 1);
        }

        int max=0;
        int num=0;
        for(Integer value:map.values()){
            if(value>max){
                max=value;
                num=1;
            }
            else if(value==max){
                num++;
            }
            else{
                continue;
            }
        }
        if(max==2 &&num==2){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * Judge whether this hand is three pairs or not
     *
     * @throws CardException if the there is not 5 cards in the hand
     */
    public boolean isThreeOfAKind(){
        if(hand.size()!=5){
            return false;
        }
        List<Character> ranks=new ArrayList<>();
        for(int i=0;i<hand.size();i++){
            ranks.add(hand.get(i).getRank().getSymbol());
        }

        Map<Character,Integer> map =new HashMap<>();
        for(Character rank:ranks){
            Integer count=map.get(rank);
            map.put(rank, count == null ? 1 : count + 1);
        }

        int max=0;
        int num=0;
        if(map.containsValue(3) &&map.containsValue(2)){
            return false;
        }
        else{
            for(Integer value:map.values()){
                if(value>max){
                    max=value;
                    num=1;
                }
                else if(value==max){
                    num++;
                }
                else{
                    continue;
                }
            }
            if(max==3){
                return true;
            }
            else{
                return false;
            }
        }
    }


    /**
     * Judge whether this hand is four cards of a kind or not
     *
     * @throws CardException if the there is not 5 cards in the hand
     */
    public boolean isFourOfAKind(){
        if(hand.size()!=5){
            return false;
        }
        List<Character> ranks=new ArrayList<>();
        for(int i=0;i<hand.size();i++){
            ranks.add(hand.get(i).getRank().getSymbol());
        }

        Map<Character,Integer> map =new HashMap<>();
        for(Character rank:ranks){
            Integer count=map.get(rank);
            map.put(rank, count == null ? 1 : count + 1);
        }

        if(map.containsValue(4)){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * Judge whether this hand is full house or not
     *
     * @throws CardException if the there is not 5 cards in the hand
     */
    public boolean  isFullHouse(){
        if(hand.size()!=5){
            return false;
        }
        List<Character> ranks=new ArrayList<>();
        for(int i=0;i<hand.size();i++){
            ranks.add(hand.get(i).getRank().getSymbol());
        }

        Map<Character,Integer> map =new HashMap<>();
        for(Character rank:ranks){
            Integer count=map.get(rank);
            map.put(rank, count == null ? 1 : count + 1);
        }

        if(map.containsValue(3) &&map.containsValue(2)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Judge whether this hand is flush or not
     *
     * @throws CardException if the there is not 5 cards in the hand
     */
    public boolean  isFlush(){
        if(hand.size()!=5){
            return false;
        }
        List<Character> suits=new ArrayList<>();
        for(int i=0;i<hand.size();i++){
            suits.add(hand.get(i).getSuit().getSymbol());
        }
        int num=1;
        for(int j=1;j<suits.size();j++){
            if(suits.get(0).equals(suits.get(j))){
                num++;
            }
        }
        if(num==5){
            return true;
        }
        else return false;
    }


    /**
     * Judge whether this hand is straight or not
     *
     * @throws CardException if the there is not 5 cards in the hand
     */
    public boolean  isStraight(){
        if(hand.size()!=5){
            return false;
        }


        List<Integer> temp=new ArrayList<>();
        for(int j=0;j<hand.size();j++){
            if(hand.get(j).getRank().getSymbol()=='J'){
                temp.add(11);
            }
            else if(hand.get(j).getRank().getSymbol()=='Q'){
                temp.add(12);
            }
            else if(hand.get(j).getRank().getSymbol()=='K'){
                temp.add(13);
            }
            else{
                temp.add(hand.get(j).value());
            }
        }

        Collections.sort(temp);

        if((temp.get(temp.size()-1)-temp.get(0)==4)){
            return true;
        }
        else if(temp.get(4)==13 && temp.get(3)==12 && temp.get(2)==11 &&temp.get(1)==10 && temp.get(0)==1){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * Add a specific card in the hand
     *
     * @param card which will be added in to hand
     * @throws CardException if the hand is not containing 5 cards
     */
    public void add(Card card){
        for(int i=0;i<hand.size();i++){
            if(hand.contains(card)){
                throw new CardException("Invalid!\n");
            }
        }
        hand.add(card);
        if(hand.size()>5){
            throw new CardException("Invalid!\n");
        }
    }

}