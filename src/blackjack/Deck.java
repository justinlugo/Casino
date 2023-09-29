/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

import constants.Constants;
import constants.Constants.Face;
import constants.Constants.Suit;
import java.util.ArrayList;
import java.util.List;

public class Deck {
    private Set<Card> deck;
    
    public Set<Card> getDeck() 
    {
        return deck;
    }

    public void setDeck(Set<Card> deck) 
    {
        this.deck = deck;
    }
    public Deck()
    {
        //System.out.println("Generating the deck of card");
        generateDeck();
        //System.out.println();
        
        //System.out.println("Displaying the deck of cards");
        //displayDeck();
        //System.out.println();        
        
        //System.out.println("Shuffling the deck of cards");
        shuffleDeck();
        //System.out.println();
        
        //System.out.println("Displaying the deck of cards");
        //displayDeck();
        //System.out.println();        
    }
    
    private void generateDeck()
    {
        deck = new HashSet<Card>(Constants.NUM_CARDS);
        
        for (Face face : Face.values())
        {
            for (Suit suit : Suit.values())
            {
                Card card = new Card();
                card.setFace(face);
                card.setSuit(suit);
                
                if (suit == Suit.HEARTS || card.getSuit() == suit.DIAMONDS)
                {
                    card.setColor(Constants.Color.RED);
                }
                else
                    card.setColor(Constants.Color.BLACK);
                
                if(!deck.contains(card))
                    deck.add(card);
            }
        }
        
    }
    
    private void displayDeck()
    {
        System.out.println("Your hand is:");
        
        for(Card card : deck)
        {
            System.out.println(card.getFace() + " of " + card.getSuit() + " is color " + card.getColor());
        }
        
    }
    private void shuffleDeck()
    {
        List<Card> cardList = new ArrayList<Card>(deck);
        Collections.shuffle(cardList);
        deck = new HashSet<Card>(cardList);
    }


    
}
