package Quiz.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Quiz extends JFrame implements ActionListener {
  String questions[][] = new String[10][5];
  String answers[][] = new String[10][5];
  String Useranswers[][] = new String[10][1];
  JLabel qno, question;
  ButtonGroup groupoptions;
  JRadioButton opt1, opt2, opt3, opt4;
  JButton next, lifeline, submit;
  public static int timer = 15;
  public static int ans_given = 0;
  public static int count = 0;
  public static int score = 0;
  String username;

  public Quiz(String username) {
    this.username = username;
    setBounds(50, 0, 1440, 850); // Set appropriate size and position for the window
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    try {
      // Load and resize the image
      BufferedImage originalImage = ImageIO.read(ClassLoader.getSystemResource("icons/quiz1.jpg"));
      Image resizedImage = originalImage.getScaledInstance(1390, 392, Image.SCALE_SMOOTH);
      ImageIcon i1 = new ImageIcon(resizedImage);
      JLabel image = new JLabel(i1);
      image.setBounds(0, 0, 1390, 392); // Adjusted image size
      add(image);
    } catch (IOException e) {
      e.printStackTrace();
    }

    qno = new JLabel();
    qno.setBounds(100, 450, 50, 30);
    qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
    add(qno);

    question = new JLabel();
    question.setBounds(150, 450, 900, 30);
    question.setFont(new Font("Tahoma", Font.PLAIN, 24));
    add(question);

    // Initialize questions and answers
    questions[0][0] = "What is the output of the following code?" +
            " print(type(3.14))";
    questions[0][1] = "<class 'int'>";
    questions[0][2] = "<class 'decimal'>";
    questions[0][3] = "<class 'double'>";
    questions[0][4] = "<class 'float'>";

    questions[1][0] = "Which of the following is not a valid variable name in Python?";
    questions[1][1] = "my_variable";
    questions[1][2] = "2nd_variable";
    questions[1][3] = "variable2";
    questions[1][4] = "_variable";

    questions[2][0] = "What does the following list comprehension produce?" +
            "[x**2 for x in range(4)]";
    questions[2][1] = "[0, 1, 2, 3]";
    questions[2][2] = "[1, 4, 9, 16]";
    questions[2][3] = "[0, 1, 4, 9]";
    questions[2][4] = "[0, 1, 4, 9, 16]";

    questions[3][0] = "Which of the following functions can be used to get the length of a list in Python?";
    questions[3][1] = "size()";
    questions[3][2] = "len()";
    questions[3][3] = "length()";
    questions[3][4] = "count()";

    questions[4][0] = "What will be the output of the following code?"+
                    "x = [1, 2, 3]\n" +
                    "x.append([4, 5])\n" +
                    "print(len(x))";
    questions[4][1] = "3";
    questions[4][2] = "4";
    questions[4][3] = "5";
    questions[4][4] = "6";

    questions[5][0] = "How do you create a dictionary in Python?";
    questions[5][1] = "dict = {}";
    questions[5][2] = "dict = []";
    questions[5][3] = "dict = ()";
    questions[5][4] = "dict = ''";

    questions[6][0] = "What is the output of the following code?" +
            "def func(a, b=2, c=3):\n" +
            "    return a + b + c\n" +
            "print(func(1, c=5))";
    questions[6][1] = "6";
    questions[6][2] = "8";
    questions[6][3] = "10";
    questions[6][4] = "9";

    questions[7][0] = "Which of the following statements is true about Python's garbage collection?";
    questions[7][1] = "Python uses a mark-and-sweep garbage collection strategy.\n";
    questions[7][2] = "Python does not have a garbage collector.\n";
    questions[7][3] = "Python's garbage collection can be manually controlled using the gc module.\n";
    questions[7][4] = " Python relies solely on reference counting for garbage collection.\n" +
            "\n";

    questions[8][0] = "What will be the output of the following code?" +
            "my_tuple = (1, 2, 3)\n" +
            "my_tuple[1] = 4\n" +
            "print(my_tuple)";
    questions[8][1] = "(1, 2, 3)";
    questions[8][2] = "(1, 4, 3)";
    questions[8][3] = "TypeError: 'tuple' object does not support item assignment";
    questions[8][4] = "None of the above";

    questions[9][0] = "Which method is used to convert a string to lowercase in Python?";
    questions[9][1] = "lowercase()";
    questions[9][2] = "tolower()";
    questions[9][3] = "lower()";
    questions[9][4] = "casefold()";

// Set the answers
    answers[0][1] = "<class 'float'>";
    answers[1][1] = "2nd_variable";
    answers[2][1] = "[0, 1, 4, 9]";
    answers[3][1] = "len()";
    answers[4][1] = "4";
    answers[5][1] = "dict = {}";
    answers[6][1] = "8";
    answers[7][1] = " Python's garbage collection can be manually controlled using the gc module.";
    answers[8][1] = "TypeError: 'tuple' object does not support item assignment";
    answers[9][1] = "lower()";


    opt1 = new JRadioButton();
    opt1.setBounds(170, 520, 700, 30);
    opt1.setBackground(Color.WHITE);
    opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
    add(opt1);

    opt2 = new JRadioButton();
    opt2.setBounds(170, 560, 700, 30);
    opt2.setBackground(Color.WHITE);
    opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
    add(opt2);

    opt3 = new JRadioButton();
    opt3.setBounds(170, 600, 700, 30);
    opt3.setBackground(Color.WHITE);
    opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
    add(opt3);

    opt4 = new JRadioButton();
    opt4.setBounds(170, 640, 700, 30);
    opt4.setBackground(Color.WHITE);
    opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
    add(opt4);

    groupoptions = new ButtonGroup();
    groupoptions.add(opt1);
    groupoptions.add(opt2);
    groupoptions.add(opt3);
    groupoptions.add(opt4);

    next = new JButton("Next");
    next.setBounds(1100, 500, 200, 40);
    next.setFont(new Font("Tahoma", Font.PLAIN, 22));
    next.setBackground(new Color(30, 144, 255));
    next.setForeground(Color.WHITE);
    next.addActionListener(this);
    add(next);

    lifeline = new JButton("50-50 Lifeline");
    lifeline.setBounds(1100, 550, 200, 40);
    lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
    lifeline.setBackground(new Color(30, 144, 255));
    lifeline.setForeground(Color.WHITE);
    lifeline.addActionListener(this);
    add(lifeline);

    submit = new JButton("Submit");
    submit.setBounds(1100, 600, 200, 40);
    submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
    submit.setBackground(new Color(30, 144, 255));
    submit.setForeground(Color.WHITE);
    submit.addActionListener(this);
    submit.setEnabled(false);
    add(submit);

    start(count);

    setVisible(true);

    // Start the timer thread
    new Thread(() -> {
      while (true) {
        try {
          Thread.sleep(1000);
          if (ans_given == 0) {
            timer--;
            repaint();
          }
          if (timer < 0) {
            timer = 15;
            if (ans_given == 0) {
              Useranswers[count][0] = "";
              count++;
              start(count);
            }
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
      if (groupoptions.getSelection() == null) {
        JOptionPane.showMessageDialog(this, "Please select an answer.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }
      repaint();
      opt1.setEnabled(true);
      opt2.setEnabled(true);
      opt3.setEnabled(true);
      opt4.setEnabled(true);
      ans_given = 1;
      if (groupoptions.getSelection() == null) {
        Useranswers[count][0] = "";
      } else {
        Useranswers[count][0] = groupoptions.getSelection().getActionCommand();
      }

      if (count == 8) {
        next.setEnabled(false);
        submit.setEnabled(true);
      }

      count++;
      start(count);
    } else if (ae.getSource() == lifeline) {
      if (count % 2 == 0) {
        opt2.setEnabled(false);
        opt3.setEnabled(false);
      } else {
        opt1.setEnabled(false);
        opt4.setEnabled(false);
      }
      lifeline.setEnabled(false);
    } else if (ae.getSource() == submit) {
      ans_given = 1;
      if (groupoptions.getSelection() == null) {
        Useranswers[count][0] = "";
      } else {
        Useranswers[count][0] = groupoptions.getSelection().getActionCommand();
      }
      for (int i = 0; i < Useranswers.length; i++) {
        if (Useranswers[i][0].equals(answers[i][1])) {
          score += 10;
        }
      }
      this.setVisible(false);
      new Score(username, score);
    }
  }

  public void paint(Graphics g) {
    super.paint(g);
    String time = "Time left - " + timer + " seconds";
    g.setColor(Color.RED);
    g.setFont(new Font("Tahoma", Font.BOLD, 25));
    if (timer > 0) {
      g.drawString(time, 1100, 450);
    } else {
      g.drawString("Times up!!", 1100, 450);
    }
  }

  public void start(int count) {
    qno.setText("" + (count + 1) + ". ");
    question.setText(questions[count][0]);
    opt1.setText(questions[count][1]);
    opt1.setActionCommand(questions[count][1]);

    opt2.setText(questions[count][2]);
    opt2.setActionCommand(questions[count][2]);

    opt3.setText(questions[count][3]);
    opt3.setActionCommand(questions[count][3]);

    opt4.setText(questions[count][4]);
    opt4.setActionCommand(questions[count][4]);

    groupoptions.clearSelection();
  }

  public static void main(String[] args) {
    new Quiz("User");
  }
}
