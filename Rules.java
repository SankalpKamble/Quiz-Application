import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {
    JButton start_btn,back_btn;
    String username;
    Rules(String user_name){
        this.username=user_name;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading=new JLabel("Welcome "+user_name+" to the Mind-Spark Quiz");
        heading.setBounds(50,20,700,30);
        heading.setFont(new Font("sans-serif",Font.BOLD,28));
        heading.setForeground(new Color(30,144,254));
        //Rule list
        JLabel rules=new JLabel();
        rules.setBounds(40,90,700,350);
        rules.setFont(new Font("open-sans",Font.PLAIN,16));
        rules.setText(
                "<html>"+
                       "1. No Googling or looking up answers online."+"<br><br>"+
                       "2. Complete the quiz within the specified time."+"<br><br>"+
                "3.Answer independently, no talking or collaboration."+"<br><br>"+
        "4.Answer honestly, no copying from others."+"<br><br>"+
                        "5.There is 50-50 life-line provided to user"+"<br><br>"+
                "6.Follow any specific instructions provided."+"<br><br>"+
                        "7.Ensure your device meets any specified technical requirements for the quiz."+"<br><br>"+
                        "8.Participants are not allowed to take screenshots or share quiz questions."+"<br><br>"+
                        "<html>"
        );

        //buttons
        //1.Next button
        start_btn=new JButton("START");
        start_btn.setBounds(200,450,100,45);
        start_btn.setFocusable(false);
        start_btn.setBackground(new Color(30,144,254));
        start_btn.setForeground(Color.white);
//        start_btn.setBorderPainted(false);        //button border
        start_btn.addActionListener(this);

        //2.Back button
        back_btn=new JButton("BACK");
        back_btn.setBounds(450,450,100,45);
        back_btn.setBackground(new Color(30,144,254));
        back_btn.setForeground(Color.white);
        back_btn.setFocusable(false);
        back_btn.setBorderPainted(true);
        //button functionality
        back_btn.addActionListener(this);


        add(heading);
        add(rules);
        add(start_btn);
        add(back_btn);
        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==start_btn){
            setVisible(false);
            new Quiz(username);
           setVisible(false);
        } else if (e.getSource()==back_btn) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
      new Rules("User");
    }
}
