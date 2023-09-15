/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bamkmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit, back;
    JTextField amount;
String pinnumber;
    public Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        //Image i2 = i1.getImage().getScaledInstance(, 900,900,Image.SCALE_DEFAULT);
        Image i2 = i1.getImage().getScaledInstance(900, 690, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 690);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 250, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Ralway", Font.BOLD, 22));
        amount.setBounds(170, 290, 320, 25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 370, 150, 25);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355, 395, 150, 25);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 690);
        setLocation(300, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"please Enter the amount you want to deposit ");
                
            }
            else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+ date+"','Deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+"Deposited Successfully");
                
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                
                }
                catch(Exception e){
                 System.out.println(e);   
                }
            }
            

        } else if (ae.getSource() == back) {
             setVisible(false);
             new Transaction(pinnumber).setVisible(true);
        }

    }

    public static void main(String args[]) {
        new Deposit("");
    }

}
