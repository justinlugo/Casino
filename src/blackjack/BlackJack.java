/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import casino.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import constants.Constants;

/**
 *
 *
 */
public class BlackJack {

    private Player player;
    private boolean play;
    private Deck deck;
    private static Scanner scan;
    private Dealer dealer;
    private Card card;
    
    //private ArrayList<Card> deck = new ArrayList();
    //private HashMap<Card> hashDeck = new HashMap();
    
    public BlackJack(Player player)
    {
        this.player = player;
        scan = new Scanner(System.in);
        play = true;
        deck = new Deck();
        dealer = new Dealer();
        card = new Card();
    }
    
    public void play()
    {
        System.out.println();
        
        displayRules();
        
        if (player.getCash() < Constants.BJ_BET)
        {
            System.out.println("You are out of cash, you cannot play.");
            play = false;
        }
        
        while (play)
        {
            System.out.println("Player's cash: $" + player.getCash());
            
            if (player.getCash() < Constants.BJ_BET)
            {
                System.out.println("You are out of cash, you cannot play.");
                play = false;
            }
            
            player.setCash(player.getCash() - Constants.BJ_BET);
            
            System.out.println("");
            System.out.println("Dealing...");
            player.setHand(new ArrayList());
            player.setScore(Constants.ZERO);
            player.setBusted(false);
            dealer.setHand(new ArrayList());
            dealer.setScore(Constants.ZERO);
            

            
            for (int i = 0; i < 2; ++i)
            {
                card = dealer.deal(deck);
                player.getHand().add(card);
                //System.out.println(card.toString());
            }
            System.out.println("Player's score: " + player.getScore());
            
            for (int c = 0; c < 2; ++c)
            {
                card = dealer.deal(deck);
                dealer.getHand().add(card);
                //System.out.println(card.toString());
            }
            System.out.println("Dealer's score: " + dealer.getScore());
            
            while (player.hitOrStand() == Constants.HIT)
            {
                card = dealer.deal(deck);
                player.getHand().add(card);
                System.out.println("Player's score: " + player.getScore());
                
                if (player.getScore() > Constants.BUST)
                {
                    System.out.println("You have bust!");
                    player.setBusted(true);
                    break;
                }
            }
            
            if (player.getBusted() == true)
            {
                play = player.playAgain();
                continue;
            }
            
            else
            {
                System.out.println("Dealer's score: " + dealer.getScore());
                
                while (dealer.hitOrStand() == Constants.HIT)
                {
                    card = dealer.deal(deck);
                    dealer.getHand().add(card);
                    System.out.println("Dealer's score: " + dealer.getScore());
                    
                    if (dealer.getScore() > Constants.BUST)
                    {
                        System.out.println("Dealer busted!");
                        break;
                    }
                }
            }
            
            results();
            play = player.playAgain();
            
        }
        
        System.out.println();
    }
    
    private void displayRules()
    {
        System.out.println("Dealer must HIT if their score is 16 or less");
        System.out.println("Dealer must STAND if their score is 17 or higher");
        System.out.println("If the player wins the hand, they recieve $20");
        System.out.println("If the dealer wins the hand, the $10 bet is lost");
        System.out.println("If it is a PUSH, the player keeps their $10 bet");
        System.out.println("");
    }
    
    private void results()
    {
        System.out.println("Player's score: " + player.getScore());
        System.out.println("Dealer's score: " + dealer.getScore());
        
        if (dealer.getScore() > 21)
        {
            System.out.println("The dealer has busted, you have won $10!");
            player.setCash(player.getCash() + 10);
        }
        else if (dealer.getScore() == player.getScore())
        {
            System.out.println("It was a push and you have won $10!");
            player.setCash(player.getCash() + 10);
        }
        else if (player.getScore() > dealer.getScore())
        {
            System.out.println("You have won $20!");
            player.setCash(player.getCash() + 10);
        }
        else
        {
            System.out.println("The dealer has won the hand!");
        }
    }
    
    
}
