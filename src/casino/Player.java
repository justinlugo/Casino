/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import blackjack.Card;
import constants.Constants;
import java.util.ArrayList;
import java.util.Scanner;
import constants.Constants.Face;

/**
 *
 * 
 */
public class Player implements IPlayer
{

    private String name;
    private int cash;
    private Scanner scan;
    private ArrayList<Card> hand;
    private int score;
    private boolean busted;
    private boolean play;
    
    
    
    
    public Player() {
        /*
        scan = new Scanner(System.in);
        String player;
        int money;
        
        
        System.out.println("Enter name");
        player = scan.nextLine();
        
        System.out.println("You need at least $10 to play");
        System.out.println("Enter cash");
        money = scan.nextInt();
        
        setName(player);
        setCash(money);
        hand = new ArrayList();
        */
    }
    
    public boolean getBusted()
    {
        return busted;
    }
    
    public boolean setBusted(boolean word)
    {
        this.busted = word;
        return word;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cash
     */
    public int getCash() {
        return cash;
    }

    /**
     * @param cash the cash to set
     */
    public void setCash(int cash) {
        this.cash = cash;
    }
    
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
    
    
    
    public boolean playAgain() {
        int choice;
        System.out.println("Would you like to play again? (Enter 0 for no"
                + " or 1 for yes)");
        choice = scan.nextInt();
        if (choice == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int hitOrStand() {
        int choice;
        System.out.println("Would you like to hit or stand? (Enter 0 for"
                + " stand or 1 for a hit)");
        choice = scan.nextInt();
        //System.out.println("Player's choice: " + choice);
        if (choice == Constants.HIT)
        {
            return Constants.HIT;
        }
        else
        {
            return Constants.STAND;
        }
    } 
}
