/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import casino.Player;
import casino.Casino;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Glato
 */
public class PlayerUi extends JPanel {


    
    private Player player;
    private JLabel cashLabel;
    private JLabel cashBalance;

    public PlayerUi(Player player) {
        this.player = player;
        initComponents();
    }
    
    public void initComponents()
    {
        String name = JOptionPane.showInputDialog(null, "Enter the player's name: ");
        player.setName(name);
        
        String cash = JOptionPane.showInputDialog(null, "Enter cash to play: ");
        player.setCash(Integer.parseInt(cash));
        
        this.setPreferredSize(new Dimension(100, 500));
        this.setBorder(BorderFactory.createTitledBorder(player.getName()));
        
        cashLabel = new JLabel("Cash Balance: $");
        cashLabel.setPreferredSize(new Dimension(100, 100));
        
        cashBalance = new JLabel(Integer.toString(player.getCash()));
        cashBalance.setPreferredSize(new Dimension(100, 100));
        
        this.add(cashLabel);
        this.add(cashBalance);
    }
    
        
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public JLabel getCashLabel() {
        return cashLabel;
    }

    public void setCashLabel(JLabel cashLabel) {
        this.cashLabel = cashLabel;
    }

    public JLabel getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(JLabel cashBalance) {
        this.cashBalance = cashBalance;
    }
}
