import javax.swing.*;                                  //swing package comes from extended package of java so "javax"
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Login extends JFrame implements ActionListener{
    JButton next_btn,back_btn;
    JTextField user_field;
    Login(){
        setLayout(null);                                //don't want to use existed layouts null means I want to create my own layout
        getContentPane().setBackground(Color.white);

        //settting login image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/login.jpeg"));
        JLabel login_img=new JLabel(i1);
        login_img.setBounds(0,-10,600,500);

        //heading
        JLabel heading=new JLabel("Mind-Spark");
        heading.setBounds(780,60,300,45);
        heading.setFont(new Font("open-sans",Font.BOLD,50));
        heading.setForeground(new Color(30,144,254));


        //user name label
        JLabel user_name=new JLabel("Enter Your Name ");
        user_name.setBounds(760,150,300,45);
        user_name.setFont(new Font("open-sans",Font.BOLD,20));
        user_name.setForeground(new Color(	128, 0, 128));


        //input field
        user_field=new JTextField();
        user_field.setBounds(760,220,300,45);
        user_field.setFont(new Font("open-sans",Font.BOLD,20));

        //buttons
        //1.Next button
        next_btn=new JButton("NEXT");
        next_btn.setBounds(760,300,100,45);
        next_btn.setBackground(new Color(30,144,254));
        next_btn.setForeground(Color.white);
        next_btn.setFocusable(false);
        next_btn.setBorderPainted(true);        //button border
        next_btn.addActionListener(this);
        //2.Back button
       back_btn=new JButton("BACK");
        back_btn.setBounds(960,300,100,45);
        back_btn.setBackground(new Color(30,144,254));
        back_btn.setForeground(Color.white);
        back_btn.setFocusable(false);
        back_btn.setBorderPainted(true);
        //button functionality
        back_btn.addActionListener(this);

        //adding components to frame
        add(login_img);
        add(heading);
        add(user_field);
        add(user_name);
        add(next_btn);
        add(back_btn);

        setSize(1200,500);
        setLocation(150,150);
        setVisible(true);      //by default false

    }
      public void actionPerformed(ActionEvent e){
//        actionEventListener contains abstarct and unimplemented methods , so its we need to override them so this function is created
          if(e.getSource()==next_btn){
              String name=user_field.getText();
           new Rules(name);
//           dispose();
              setVisible(false);
          }
          else if(e.getSource()==back_btn){
              setVisible(false);

          }
      }
    public static void main(String[] args) {
        new Login();
    }
}
