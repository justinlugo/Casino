/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import casino.Player;
import constants.Constants;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Glato
 */
public class SlotsUi extends JPanel{
    
    private CasinoUi casinoUi;
    private Player player;
    private JLabel data;
    private JLabel bet;
    private JButton spin;
    private JPanel headerPanel;
    private JPanel slotsPanel;
    private ArrayList<ImageIcon> images;
    private Random rand;
    private ArrayList<Integer> spinNums;
    
    public SlotsUi(Player player, CasinoUi casinoUi)
    {
        this.player = player;
        this.casinoUi = casinoUi;
        rand = new Random();
        initImages();
        initComponents();
    }
    
    public void initComponents()
    {
        headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(3, 1));
        headerPanel.setBorder(BorderFactory.createTitledBorder(""));
        
        data = new JLabel("Welcome to Knights Casino Slots!");
        bet = new JLabel("The bet is $" + Constants.BET);
        
        spin = new JButton("SPIN");
        spin.addActionListener(new SpinListener());
        
        headerPanel.add(data);
        headerPanel.add(bet);
        headerPanel.add(spin);
        
        slotsPanel = new JPanel();
        slotsPanel.setLayout(new GridLayout(1, 3));
        slotsPanel.setBorder(BorderFactory.createTitledBorder("Your spin:"));
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(headerPanel);
        this.add(slotsPanel);
    }
    
    public void initImages()
    {
        images = new ArrayList();
        
        images.add(createImageIcon("../images/slots/Banana.png", "Banana"));
        images.add(createImageIcon("../images/slots/Bar.png", "Bar"));
        images.add(createImageIcon("../images/slots/Bell.png", "Bell"));
        images.add(createImageIcon("../images/slots/Cherry.png", "Cherry"));
        images.add(createImageIcon("../images/slots/Clover.png", "Clover"));
        images.add(createImageIcon("../images/slots/Coin.png", "Coin"));
        images.add(createImageIcon("../images/slots/Diamond.png", "Diamond"));
        images.add(createImageIcon("../images/slots/Gold.png", "Gold"));
        images.add(createImageIcon("../images/slots/Money.png", "Money"));
        images.add(createImageIcon("../images/slots/Plum.png", "Plum"));
        images.add(createImageIcon("../images/slots/Seven.png", "Seven"));
        images.add(createImageIcon("../images/slots/Watermelon.png", "Watermelon"));
    }

    public ImageIcon createImageIcon(String path, String description)
    {
       java.net.URL imgURL = getClass().getResource(path);
       
       ImageIcon imageIcon;
       
       if (imgURL != null)
       {
           imageIcon = new ImageIcon(imgURL, description);
           imageIcon.setDescription(description);
           imageIcon = imageResize(imageIcon);
           return imageIcon;
       }
       
       else
       {
           System.err.println("Couldn't find file: " + path);
           return null;
       }
       
    }
    
    public ImageIcon imageResize(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
    
    private class SpinListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            spin();
            results();
        }
    }
    
    public void spin()
    {
        int num;
        
        player.setCash(player.getCash() - Constants.BET);
        casinoUi.updatePlayerUi();
        
        spinNums = new ArrayList();
        slotsPanel.removeAll();
        
        JLabel one = new JLabel();
        num = rand.nextInt(images.size());
        ImageIcon imageOne = images.get(num);
        one.setIcon(imageOne);
        spinNums.add(num);
        
        JLabel two = new JLabel();
        num = rand.nextInt(images.size());
        ImageIcon imageTwo = images.get(num);
        two.setIcon(imageTwo);
        spinNums.add(num);
        
        JLabel three = new JLabel();
        num = rand.nextInt(images.size());
        ImageIcon imageThree = images.get(num);
        three.setIcon(imageThree);
        spinNums.add(num);
        
        slotsPanel.add(one);
        slotsPanel.add(two);
        slotsPanel.add(three);

        slotsPanel.revalidate();
        slotsPanel.repaint();
    }
    
    public void results()
    {
        if(spinNums.get(0) == spinNums.get(1) && spinNums.get(1) == spinNums.get(2))
        {
            JOptionPane.showMessageDialog(null, "Three symbols matched, you won $50!");
            player.setCash(player.getCash() + Constants.TRIPLE_PAYOUT);
        }
        
        else if (spinNums.get(0) == spinNums.get(1) || spinNums.get(0) == spinNums.get(2) || spinNums.get(1) == spinNums.get(2))
        {
            JOptionPane.showMessageDialog(null, "Two symbols matched, you won $5!");
            player.setCash(player.getCash() + Constants.PAIR_PAYOUT);
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "No symbols matched.");
        }
        
        casinoUi.updatePlayerUi();
            
    }

}
