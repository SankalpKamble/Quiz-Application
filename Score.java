import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {
    JButton submit,exit;
    Score(String username,int score){
      setBounds(400,150,800,550);
      getContentPane().setBackground(Color.white);
      setLayout(null);
      score=90;
            if(score>=40){
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/celebrate.png"));
          Image i2=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);      //Scaling image (minimizing scale of image)
          ImageIcon i3=new ImageIcon(i2);
          JLabel image=new JLabel(i3);
          image.setBounds(-100,-40,500,600);
          add(image);}

            else{
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/sad.png"));
        Image i2=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);      //Scaling image (minimizing scale of image)
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(-100,-40,500,600);
        add(image);}

         JLabel heading=new JLabel("Thank you "+username+" for playing Mind-Spark.");
            heading.setBounds(300,170,700,30);
            heading.setFont(new Font("open-sans",Font.PLAIN,24));
            add(heading);
        JLabel score_lbl=new JLabel("Your Score is "+score);
        score_lbl.setBounds(400,220,700,30);
        score_lbl.setFont(new Font("open-sans",Font.PLAIN,26));
        add(score_lbl);

         submit=new JButton("Play again");
        submit.setBounds(300,280,170,40);
        submit.setFont(new Font("open-sans",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,254));
        submit.setForeground(Color.white);
        submit.setFocusable(false);
        submit.addActionListener(this);
        submit.setEnabled(true);
        add(submit);

         exit=new JButton("Exit");
        exit.setBounds(500,280,170,40);
        exit.setFont(new Font("open-sans",Font.PLAIN,22));
        exit.setBackground(new Color(30,144,254));
        exit.setForeground(Color.white);
        exit.setFocusable(false);
        exit.addActionListener(this);
        exit.setEnabled(true);
        add(exit);


   setVisible(true);
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
           setVisible(false);
           new Login();}
        else{
            dispose();
        }
     }


    public static void main(String[] args) {
        new Score("User",0);
    }
}
