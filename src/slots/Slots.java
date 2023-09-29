/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slots;

import casino.Player;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Slots {
    private static Scanner scan;
    private Random rand;
    private char[] spins;
    private boolean play;
    private Player player;
    private static final char[] SYMBOLS = {'$', '%', '&', '@', '!'};
    
    
    public Slots(Player player)
    {
        this.player = player;
        rand = new Random();
        spins = new char[3];
        play = true;
        
    }
    
    public void play()
    {
        scan = new Scanner(System.in);
        System.out.println("Your cash balance is $" + player.getCash());
        System.out.println("The bet is $5");
        System.out.println("Match two symbols to win $5");
        System.out.println("Match all three symbols to win $50");
        if (player.getCash() < 5)
        {
            System.out.println("You don't have enough money to play.");
            play = false;
        }
     
        while (play)
        {
            player.setCash(player.getCash() - 5);
            System.out.println("Spinning . . .");
            
            for(int s = 0; s < spins.length; s++)
            {
                spins[s] = randomSymbol();
                System.out.print(spins[s] + " ");
            }
            
            System.out.println("");
            if((spins[0] == spins[1]) && (spins[1] == spins[2]))
            {
                System.out.println("Jackpot! You won $50!");
                player.setCash(player.getCash() + 50);
            }
            else if(spins[0] == spins[1] || spins[1] == spins[2] || spins[0] == spins[2])
            {
                System.out.println("Two symbols matched, you won $5!");
                player.setCash(player.getCash() + 5);  
            }
            else
            {
                System.out.println("No matches!");
            }
            
            System.out.println("Cash balance: $" + player.getCash());
            
            if(player.getCash() >= 5)
            {
              System.out.println("Would you like to play again? (Yes = 1, No = 0)");
              
              int input = scan.nextInt();
              
              if (input == 1)
                play = true;
              else
                play = false;   
            }
            else
                break;
        }
    }
    
    private char randomSymbol()
    {
        int num = rand.nextInt(SYMBOLS.length);
        char symbol = ' ';
        
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
