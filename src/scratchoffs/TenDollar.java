/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchoffs;

import casino.Player;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Glato
 */
class TenDollar {
        
    private char winningBonus;
    ArrayList<Integer> winningNumbers = new ArrayList<Integer>();
    ArrayList<Integer> playerNumbers = new ArrayList<Integer>();
    ArrayList<Double> prizes = new ArrayList<Double>();
    ArrayList<Character> bonus = new ArrayList<Character>();
    private Player player;
    private Random rand;
    
    private static final char[] SYMBOLS = {'$', '%', '&', '#', '@', '!'};  
    private static final int BASE = 60;
    private static final int NUMS = 15;
    private static final int SYM = 4;
    private static final double BONUS = 30.00;
    
    public TenDollar(Player player)
    {
        this.player = player;
        rand = new Random();
        createTicket();
        displayTicket();
        cashTicket();
    }
    
    private void displayTicket()
    {
        System.out.println("Hello world!");
        int count = 0;
        final int BREAK = 5;
        
        System.out.printf("+------------------------------------------+\n"); //42
        
        System.out.printf("| WINNING NUMBERS      ");
        
        for (Integer i : winningNumbers)
        {
           System.out.printf("%5d", i);
        }
        
        System.out.printf("\n|%42s|%42s\n", " ", " ", " ");
        System.out.printf("| YOUR NUMBERS%29s|\n|", " ");
        
        for (int p = 0; p < playerNumbers.size(); ++p)
        {
            count++;
            
            System.out.printf("%8d", playerNumbers.get(p));
            
            if ((count % BREAK) == 0)
            {
                System.out.printf("%2s|\n|", " ");
            }
        }
        
        System.out.printf("%42s|\n", " ");
        System.out.printf("| PRIZES%35s|\n", " ");
        System.out.printf("|%42s|\n|", " ");
        
        count = 0;
        
        for (int p = 0; p < prizes.size(); ++p)
        {
            count++;
            
            System.out.printf("%8.2f", prizes.get(p));
            
            if ((count % BREAK) == 0)
            {
                System.out.printf("%2s|\n|", " ");
            }
        }
        
        System.out.printf("%42s|\n", " ");
        System.out.printf("| SYMBOLS%34s|\n", " ");
        System.out.printf("|%42s|\n|", " ");
        
        for (Character c : bonus)
        {
            System.out.printf("%8c", c);
        }
        
        System.out.printf("%10s|\n+------------------------------------------+\n", " ");
    }
    
    private void cashTicket()
    {
        double cash = 0.0;

        System.out.println("Bonus symbol is " + winningBonus);
        
       
        for (int w = 0; w < winningNumbers.size(); ++w)
        {
            for (int i = 0; i < playerNumbers.size(); ++i)
            {
                if (playerNumbers.get(i) == winningNumbers.get(w))
                {
                    cash += prizes.get(i);
                }
            }
        }
        
        for (int j = 0; j < bonus.size(); ++j)
        {
            if (bonus.get(j) == winningBonus)
            {
                cash += bonus.get(j);
            }
        }
        
        System.out.println("Bonus is worth $" + BONUS);        
        System.out.println("Your scratchoff won you: $" +  (int)cash);
        
        player.setCash(player.getCash() + (int)cash);
        
    }
    
    private void createTicket()
    {
        winningBonus = randomSymbol();
        
        winningNumbers = new ArrayList<>();
        playerNumbers = new ArrayList<>();
        prizes = new ArrayList<>();
        bonus = new ArrayList<>();
        
        for (int i = 0; i < 4; ++i)
        {
            winningNumbers.add(randomNumber());
        }
        for (int i = 0; i < 15; ++i)
        {
            playerNumbers.add(randomNumber());
            prizes.add(randomPrize());
        }
        for (int i = 0; i < 4; ++i)
        {
            bonus.add(randomSymbol());
        }
    }
    private int randomNumber()
    {
        int ran;
        ran = rand.nextInt(BASE) + 1;
        return ran;
    }
    
    private double randomPrize()
    {
        double ran;
        ran = rand.nextInt(BASE) + 1;
        return ran;
    }
    
    private char randomSymbol()
    {
        int num;
        char symbol = ' ';
        
        num = rand.nextInt(SYMBOLS.length);
        
        switch(num)
        {
            case 0:
                symbol = SYMBOLS[0];
                break;
                
            case 1:
                symbol = SYMBOLS[1];
                break;
                
            case 2:
                symbol = SYMBOLS[2];
                break;
                
            case 3:
                symbol = SYMBOLS[3];
                break;            
            
            case 4:
                symbol = SYMBOLS[4];
                break;            
            
            case 5:
                symbol = SYMBOLS[5];
                break;                
        }
        
        return symbol;
    }            
}
