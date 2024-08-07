package Quiz.Application;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    JButton start , back;
    String username;
    Rules(String username){
        this.username = username;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel heading  = new JLabel("Welcome " + username + " to Quizzical Quest");
        heading.setBounds(30,20,700,30);
        add(heading);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
        heading.setForeground( Color.BLUE);


        JLabel rules = new JLabel();
        rules.setBounds(20,90,700,350);
        add(rules);
        rules.setFont(new Font("Tahoma",Font.PLAIN,16));
       rules.setText(
               "<html>"+
                       "1. Focus on answering the questions, avoid distractions." + "<br><br>" +
                       "2. Stay concentrated on your screen, as others might also be figuring out the answers." + "<br><br>" +
                       "3. All questions are mandatory, so give each one your best shot." + "<br><br>" +
                       "4. It's okay to feel stressed, but try to stay calm." + "<br><br>" +
                       "5. Use your knowledge wisely to answer the questions." + "<br><br>" +
                       "6. Don't worry if others are progressing faster; focus on your own performance." + "<br><br>" +
                       "7. Get ready for a challenging experience." + "<br><br>" +
                       "8. May your knowledge be vast, good luck!" + "<br><br>"+
                       "<html>"
       );


        back = new JButton("Back");
        back.setBounds(250,500,100,30);
        back.setBackground(Color.BLUE);
        back.setForeground( Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400,500,100,30);
        start.setBackground(Color.BLUE);
        start.setForeground( Color.WHITE);
        start.addActionListener(this);
        add(start);




        setSize(800,600);
        setLocation(350,100);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == start){
            setVisible(false); //current frame ko close kar k new object banyen ge
            //new Rules(name);
            new Quiz(username);

        }
        else{
            setVisible(false); //for hidding the frame
            new Login();
        }
    }


    public static void main(String[] args) {
        new Rules("User");
    }
}
