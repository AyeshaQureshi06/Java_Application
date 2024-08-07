package Quiz.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Register extends JFrame implements ActionListener {
    JButton register, back;
    JTextField fname;
    JPasswordField passwordField;

    Register() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Register");
        heading.setBounds(150, 20, 200, 45);
        add(heading);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(66, 00, 33));

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(50, 100, 300, 30);
        add(name);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        name.setForeground(new Color(66, 00, 33));

        fname = new JTextField();
        fname.setBounds(50, 150, 300, 25);
        fname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(fname);

        JLabel password = new JLabel("Enter Your Password");
        password.setBounds(50, 200, 300, 30);
        add(password);
        password.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        password.setForeground(new Color(66, 00, 33));

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 250, 300, 25);
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(passwordField);

        register = new JButton("Register");
        register.setBounds(50, 300, 120, 25);
        register.setBackground(Color.BLUE);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);

        back = new JButton("Back");
        back.setBounds(230, 300, 120, 25);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(400, 400);
        setLocation(450, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == register) {
            String name = fname.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (!name.isEmpty() && !name.matches("\\d+") && password.matches("\\S+"))  {
                try (FileWriter fw = new FileWriter("users.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println(name + "," + password);
                    JOptionPane.showMessageDialog(this, "Registration Successful");
                    setVisible(false);
                    new Login();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid name and password.");
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }


    public static void main(String[] args) {
        new Register();
    }
}


