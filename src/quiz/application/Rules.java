
package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Salman
 */
public class Rules extends JFrame implements ActionListener{
    
    String name;
    JButton start, back;
    
     Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Welcome " + name + " to Code Quiz");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. The app will have a total of 10 questions, each with 4 answer choices." + "<br><br>" +
                "2. For each correct answer, users will earn 10 points." + "<br><br>" +
                "3. Users will have 15 seconds to answer each question." + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. The questions will be on a variety of programming and computer science topics, such as data structures, algorithms, programming languages, and many more." + "<br><br>" +
                "6. Users can retake the quiz as many times as they like." + "<br><br>" +
                "7. The app will keep track of the user's scores and progress over time." + "<br><br>" +
                "8. Users can use the 50-50 lifeline button to remove two incorrect answer choices from a question once during the quiz." + "<br><br>" +
            "<html>"
        );
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
     
        public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }
         
    public static void main(String[] args){
        new Rules("Userx30n");
    }
}
