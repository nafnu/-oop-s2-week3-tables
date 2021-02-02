package com.jetbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserLogin extends JFrame {

    private JPanel contentPane;
    private JButton btnNewButton;
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        // write your code here
        System.out.println("This is user login");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Login Label
        JLabel lblNewLabel = new JLabel("Login");

        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);

        //Username Label
        JLabel lblUsername = new JLabel("Username");

        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);

        textField = new JTextField( );
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        textField.setBounds(480, 170, 193, 52);
        textField.setColumns(1);
        contentPane.add(textField);

        //Password Label
        JLabel lblPassword = new JLabel("Password");

        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField( );
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 31));
        passwordField.setBounds(480, 286, 193, 52);
        passwordField.setColumns(1);
        contentPane.add(passwordField);

        //Button
        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 73);
        contentPane.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                System.out.println("Button is pressed: " +userName +":  "+password);

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/titanicmanifest",  "Nat", "m+S0sh1@tp/6");

                    PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement("select name, password from student where name=? and password = ? ");

                    preparedStatement.setString(1, userName);
                    preparedStatement.setString(2, password);


//here sonoo is database name, root is username and password

                    ResultSet rs = preparedStatement.executeQuery();
                    if (rs.next()) {
                        System.out.println("Logging IN");
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    } else {
                        System.out.println("Not allowed to login");
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }


                } catch (Exception ex) {
                    System.out.println(ex);
                } finally {

                }
            }
        });

    }
}
