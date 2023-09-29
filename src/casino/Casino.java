/* Justin Lugo
 * Whiting
 * COP 3330, Fall 2020
 */
package casino;

import java.util.Scanner;
import blackjack.BlackJack;
import slots.Slots;
import constants.Constants;
import scratchoffs.ScratchOffs;
import userInterface.CasinoUi;


/**
 *
 * 
 */
public class Casino {


    
    private static BlackJack blackJack;
    private static Slots slots;
    private static Player player;
    private static ScratchOffs scratchoffs;
    private static Scanner scan;
    private static CasinoUi ui;
       
    public static void main(String[] args) {
        int game = 0;
        scan = new Scanner(System.in);
        setPlayer(new Player());
        
        ui = new CasinoUi(new Casino());
        
        /*
        game = displayMenu();
        switch(game){
            case Constants.BLACK_JACK:
                System.out.println("Let's play Black Jack!");
                blackJack = new BlackJack(player);
                blackJack.play();
                break;
            case Constants.SCRATCH:
                System.out.println("Let's play scratchoffs!");
                scratchoffs = new ScratchOffs(player);
                scratchoffs.play();
                break;
            case Constants.SLOTS:
                System.out.println("Let's play the slot machines!");
                slots = new Slots(player);
                slots.play();   
                break;
            default:
                System.out.println("Invalid game selection, try again.");
        }
        */
        
    }
    
    private static int displayMenu(){
        int select;
        
        do
        {
            System.out.println("Welcome to Knights Casino!");
            System.out.println("");
            System.out.println("Select the game to play");
            System.out.println("1. Black Jack");
            System.out.println("2. Scratch Off Tickets");
            System.out.println("3. Slot Machines");
            System.out.println("Enter the number of your choice:");
            select = scan.nextInt();
        } while(select < Constants.BLACK_JACK || select > Constants.SLOTS);
        
        return select;
    }
    
    public static BlackJack getBlackJack() {
        return blackJack;
    }

    public static void setBlackJack(BlackJack aBlackJack) {
        blackJack = aBlackJack;
    }

    public static Slots getSlots() {
        return slots;
    }

    public static void setSlots(Slots aSlots) {
        slots = aSlots;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player aPlayer) {
        player = aPlayer;
    }

    public static ScratchOffs getScratchoffs() {
        return scratchoffs;
    }

    public static void setScratchoffs(ScratchOffs aScratchoffs) {
        scratchoffs = aScratchoffs;
    }
}
