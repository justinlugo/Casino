/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchoffs;

import casino.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import constants.Constants;

public class ScratchOffs {
    
    private Player player;
    private OneDollar one;
    private FiveDollar five;
    private TenDollar ten;
    private boolean play;
    private Scanner scan;
    
    public ScratchOffs(Player player)
    {
        this.player = player;
        play = true;
        scan = new Scanner(System.in);
    }
    
    public void play()
    {
        int type;
        int quantity;
        int input;
        
        System.out.println("Let's play scratch off tickets!");
        System.out.println("Player's can select from One Dollar, Five Dollar and"
                + " Ten Dollar tickets");
        System.out.println("Prizes are based on the ticket selected");
        
        if (player.getCash() < constants.Constants.ONE_DOL)
        {
            System.out.println("You do not have enough cash to play.");
            play = false;
        }
        
        while (play)
        {
            System.out.println("Which type of scratch off would you like (1 ="
                    + " One Dollar, 5 = Five Dollar, 10 = Ten Dollar)?");
            type = scan.nextInt();
            System.out.println("How many scratch off tickets would you like?");
            quantity = scan.nextInt();
            System.out.println("Getting your scratch offs. . .");
            
            for (int i = 0; i < quantity; ++i)
            {
                switch(type)
                {
                    case constants.Constants.ONE_DOL:
                        player.setCash(player.getCash() - Constants.ONE_DOL);
                        one = new OneDollar(player);
                        break;
                    
                    case constants.Constants.FIVE_DOL:
                        player.setCash(player.getCash() - Constants.FIVE_DOL);
                        five = new FiveDollar(player);
                        break;
                        
                    case constants.Constants.TEN_DOL:
                        player.setCash(player.getCash() - Constants.TEN_DOL);
                        ten = new TenDollar(player);
                        break;
                }
            }
            
            System.out.println("Your current cash balance is: $"
                    + player.getCash());
            
            if (player.getCash() > constants.Constants.ONE_DOL)
            {
                System.out.println("Would you like to play again? (0 = no, 1"
                        + " = yes)");
                input = scan.nextInt();
                
                if (input == 1)
                {
                    play = true;
                }
                else
                {
                    play = false;
                }
            }
            else
            {
                break;
            }
        }
        
        System.out.println("Your current cash balance is: " + player.getCash());
    
    }
    
}
