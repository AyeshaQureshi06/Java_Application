
package Quiz.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame implements ActionListener {
    JButton rules, back, register;
    JTextField fname;
    JPasswordField passwordField;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/QUIZ.png"));
        JLabel image = new JLabel(i1);
        add(image);
        image.setBounds(0, 0, 700, 500);

        JLabel heading = new JLabel("Quizzical Quest");
        heading.setBounds(750, 60, 400, 45);
        add(heading);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(66, 00, 33));

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(800, 150, 350, 30);
        add(name);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        name.setForeground(new Color(66, 00, 33));

        fname = new JTextField();
        fname.setBounds(735, 200, 300, 25);
        fname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(fname);

        JLabel password = new JLabel("Enter Your Password");
        password.setBounds(800, 250, 350, 30);
        add(password);
        password.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        password.setForeground(new Color(66, 00, 33));

        passwordField = new JPasswordField();
        passwordField.setBounds(735, 300, 300, 25);
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(passwordField);

        rules = new JButton("Login");
        rules.setBounds(735, 370, 120, 25);
        rules.setBackground(Color.BLUE);
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(915, 370, 120, 25);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        register = new JButton("Register");
        register.setBounds(825, 420, 120, 25);
        register.setBackground(Color.BLUE);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);

        setSize(1200, 600);
        setLocation(100, 150);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = fname.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            boolean isAuthenticated = false;

            if (!name.isEmpty() && !password.isEmpty() && name.matches("\\S+") && password.matches("\\S+")) {
                try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] credentials = line.split(",");
                        if (credentials[0].equals(name) && credentials[1].equals(password)) {
                            isAuthenticated = true;
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (isAuthenticated) {
                    setVisible(false);
                    new Rules(name);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid name and password.");
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        } else if (ae.getSource() == register) {
            setVisible(false);
            new Register();
        }
    }


    private boolean validateUser(String name, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] user = line.split(",");
                if (user[0].equals(name) && user[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new Login();
    }
}

