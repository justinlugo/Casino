/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import constants.Constants.Color;
import constants.Constants.Face;
import constants.Constants.Suit;

public class Card {
    
    public Face face;
    public Suit suit;
    public Color color;
    
    public int value;
    
    public Face getFace()
    {
        return face;
    }
    
    public void setFace(Face face)
    {
        this.face = face;
    }
    
    public Suit getSuit()
    {
        return suit;
    }
    
    public void setSuit(Suit suit)
    {
        this.suit = suit;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void setColor(Color color)
    {
        this.color = color;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
    
    public int hashCode()
    {
        int hashcode = 0;
        return hashcode;
    }
    
    public boolean equals(Object obj)
    {
        if (obj instanceof Card)
        {
            Card card = (Card) obj;
            
            return (card.face.equals(this.face) && card.suit.equals(this.suit)
                    && card.color.equals(this.color));
        }
        else
            return false;
    }
    
    public int getValue() 
    {
        value = 0;
        
        if (face == Face.TWO)
        {
            value = 2;
        }
        else if (face == Face.THREE)
        {
            value = 3;
        }
        else if (face == Face.FOUR)
        {
            value = 4;
        }
        else if (face == Face.FIVE)
        {
            value = 5;
        }
        else if (face == Face.SIX)
        {
            value = 6;
        }
        else if (face == Face.SEVEN)
        {
            value = 7;
        }
        else if (face == Face.EIGHT)
        {
            value = 8;
        }        
        else if (face == Face.NINE)
        {
            value = 9;
        }
        else if (face == Face.TEN || face == Face.JACK || face == Face.QUEEN ||
                face == Face.KING)
        {
            value = 10;
        }
        else if (face == Face.ACE)
        {
            value = 11;
        }       
        
        return value;
    }
    
    @Override
    public String toString()
    {
        String card = "";
        card = face + " " + suit;
        return card;
    }
    
}
