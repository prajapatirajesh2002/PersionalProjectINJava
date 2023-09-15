/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bamkmanagementsystem1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
 JButton login,signup,Clear;
 JTextField   CardTextField;
 JPasswordField pinTextField;
    Login() {
        setTitle("AUTOMATED TELLER MACHINE ");
        setLayout(null);
          ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label  =  new JLabel(i3);
        label.setBounds(70, 10, 100,100);
        
        add(label);
 
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD ,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        
        
        JLabel cardno = new JLabel("Card NO : ");
        cardno.setFont(new Font("Raleway",Font.BOLD ,38));
        cardno.setBounds(100,150,400,30);
        add(cardno);
        
        CardTextField  = new JTextField();
        CardTextField.setBounds(300,150,230,30);
        add(CardTextField);
        
        JLabel pin = new JLabel("PIN ");
        pin.setFont(new Font("Raleway",Font.BOLD ,38));
        pin.setBounds(200,220,250,30);
        add(pin);
        
         pinTextField  = new  JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);
        
         login   = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
          Clear   = new JButton("CLEAR");
        Clear.setBounds(430,300,100,30);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);
        add(Clear);
        
        
          signup   = new JButton("SIGN Up");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
        

    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == Clear)
      {
         CardTextField.setText("");
         pinTextField.setText("");
      }
      else if(ae.getSource() == login)
      {
          Conn conn =  new Conn();
          String cardnumber = CardTextField.getText();
          String pinnumber = pinTextField.getText();
          String query = "select*from login where cardnumber = '"+cardnumber+"'and pin = '"+pinnumber+"'";
          
          try{
             ResultSet rs = conn.s.executeQuery(query);
             if(rs.next()){
                 setVisible(false);
                 new Transaction(pinnumber ).setVisible(true);
             }
             else{
                 JOptionPane.showMessageDialog(null, "Incurrect card no and pin");
             }
              
          }
          catch(Exception e){
              System.out.println(e);
          }
      }   
      else if(ae.getSource() == signup){
          setVisible(false);
          
          new SignupOne().setVisible(true);
      }
        
    }

    public static void main(String args[]) {
        new Login();

    }

}
