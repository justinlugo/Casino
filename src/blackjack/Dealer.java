/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import constants.Constants;
import java.util.Iterator;

/**
 *
 * @author Glato
 */
public class Dealer implements IDealer{

    private ArrayList<Card> hand;
    private int score;
    
    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getScore() {
        score = 0;
        for (Card card : hand)
        {
            //System.out.println(card.toString());
            score += card.getValue();
        }
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int hitOrStand(){
        if(score <= Constants.DEALER_HIT)
        {
            return Constants.HIT;
        }
        else
        {
            return Constants.DEALER_STAND;
        }
    }
    
    @Override
    public Card deal(Deck deck){
        Card card = new Card();
        Iterator<Card> c = deck.getDeck().iterator();
        
        if (c.hasNext())
        {
            card = c.next();
        }
        
        deck.getDeck().remove(card);
        return card;
    }
    
    /*
    public Dealer()
    {
        hand = new ArrayList();
    }
*/
}
