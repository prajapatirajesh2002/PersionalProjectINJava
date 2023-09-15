/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bamkmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    public MiniStatement(String pinnumber) {

        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel("Indian Bank");
        setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel("Indian Bank");
        setBounds(20, 300, 500, 30);
        add(balance);

        try {

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin ='" + pinnumber + "'");

            while (rs.next()) {
                card.setText("Card Number " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX " + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // hit by bank table
        try {
            int bal = 0;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select *from  bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + " &nbsp&nbsp&nbsp&nbsp&nbsp" + rs.getString("type") + " &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));

                }
                else{
                      bal -=Integer.parseInt(rs.getString("amount"));
                  }


            }
            balance.setText("Your current account balance is Rs "+bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        mini.setBounds(20, 140, 400, 200);

        setTitle("Mini Statement ");
        setSize(600, 500);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new MiniStatement("");

    }

}
