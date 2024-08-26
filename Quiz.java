import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
  //Global Declarations
  JButton submit,next_btn,life_line;
    String questions[][]=new String[10][5];  //10 rows-questiions and 5 (1=question+4=options)
    String answers[][]=new String[10][2];  //correct answers of all 10 questions
  String user_answer[][]=new String[10][1];     // to store answers  given by users
  public int count=0;
    JLabel que_no,que;
    JRadioButton opt1,opt2,opt3,opt4;
    public static int timer=15;   //reverse countdown
    public static int is_ans_given=0;          //whether user has selected one of four option for respective question
  public static int score=0;           //to measure score of user
  String username;
  ButtonGroup grp_opt;          //for grouping options of question

      Quiz(String username) {
        this.username=username;
        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        //top image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/quiz.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1440,392);

        //lables
          //1.Question no label
           que_no=new JLabel();
          que_no.setBounds(100,450,50,30);
          que_no.setFont(new Font("open-sans",Font.PLAIN,24));

          //2.Question label
          que=new JLabel();
          que.setBounds(150,450,900,30);
          que.setFont(new Font("open-sans",Font.PLAIN,24));

          //questions 2d array
          questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
          questions[0][1] = "JVM";
          questions[0][2] = "JDB";
          questions[0][3] = "JDK";
          questions[0][4] = "JRE";

          questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
          questions[1][1] = "int";
          questions[1][2] = "Object";
          questions[1][3] = "long";
          questions[1][4] = "void";

          questions[2][0] = "Which package contains the Random class?";
          questions[2][1] = "java.util package";
          questions[2][2] = "java.lang package";
          questions[2][3] = "java.awt package";
          questions[2][4] = "java.io package";

          questions[3][0] = "An interface with no fields or methods is known as?";
          questions[3][1] = "Runnable Interface";
          questions[3][2] = "Abstract Interface";
          questions[3][3] = "Marker Interface";
          questions[3][4] = "CharSequence Interface";

          questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
          questions[4][1] = "Stack";
          questions[4][2] = "String memory";
          questions[4][3] = "Random storage space";
          questions[4][4] = "Heap memory";

          questions[5][0] = "Which of the following is a marker interface?";
          questions[5][1] = "Runnable interface";
          questions[5][2] = "Remote interface";
          questions[5][3] = "Readable interface";
          questions[5][4] = "Result interface";

          questions[6][0] = "Which keyword is used for accessing the features of a package?";
          questions[6][1] = "import";
          questions[6][2] = "package";
          questions[6][3] = "extends";
          questions[6][4] = "export";

          questions[7][0] = "In java, jar stands for?";
          questions[7][1] = "Java Archive Runner";
          questions[7][2] = "Java Archive";
          questions[7][3] = "Java Application Resource";
          questions[7][4] = "Java Application Runner";

          questions[8][0] = "Which of the following is a mutable class in java?";
          questions[8][1] = "java.lang.StringBuilder";
          questions[8][2] = "java.lang.Short";
          questions[8][3] = "java.lang.Byte";
          questions[8][4] = "java.lang.String";

          questions[9][0] = "Which of the following option leads to the portability and security of Java?";
          questions[9][1] = "Bytecode is executed by JVM";
          questions[9][2] = "The applet makes the Java code secure and portable";
          questions[9][3] = "Use of exception handling";
          questions[9][4] = "Dynamic binding between objects";

          answers[0][1] = "JDB";
          answers[1][1] = "int";
          answers[2][1] = "java.util package";
          answers[3][1] = "Marker Interface";
          answers[4][1] = "Heap memory";
          answers[5][1] = "Remote interface";
          answers[6][1] = "import";
          answers[7][1] = "Java Archive";
          answers[8][1] = "java.lang.StringBuilder";
          answers[9][1] = "Bytecode is executed by JVM";


          //radio button
//          1.option 1
          opt1=new JRadioButton();
          opt1.setBounds(170,520,700,30);
          opt1.setBackground(Color.white);
          opt1.setFont(new Font("open-sans",Font.PLAIN,20));
          opt1.setFocusable(false);

//          2.option 2
          opt2=new JRadioButton();
          opt2.setBounds(170,570,700,30);
          opt2.setBackground(Color.white);
          opt2.setFont(new Font("open-sans",Font.PLAIN,20));
          opt2.setFocusable(false);

//          3.option 3
          opt3=new JRadioButton();
          opt3.setBounds(170,620,700,30);
          opt3.setBackground(Color.white);
          opt3.setFont(new Font("open-sans",Font.PLAIN,20));
          opt3.setFocusable(false);

//          4.option 4
          opt4=new JRadioButton();
          opt4.setBounds(170,670,700,30);
          opt4.setBackground(Color.white);
          opt4.setFont(new Font("open-sans",Font.PLAIN,20));
          opt4.setFocusable(false);

         //now we can click every radio button (or select every button) to use only one radio group radio buttons as follows
        grp_opt=new ButtonGroup();
          grp_opt.add(opt1);
          grp_opt.add(opt2);
          grp_opt.add(opt3);
          grp_opt.add(opt4);

          //button
          //1.Next que button
           next_btn=new JButton("Next");
          next_btn.setBounds(1100,500,200,40);
          next_btn.setFocusable(false);
          next_btn.setFont(new Font("opne-sans",Font.PLAIN,22));
          next_btn.setBackground(new Color(30,144,255));
          next_btn.setForeground(Color.white);
          next_btn.addActionListener(this);

          //2.Life line button
           life_line=new JButton("50-50 Life-Line");
          life_line.setBounds(1100,580,200,40);
          life_line.setFocusable(false);
          life_line.setFont(new Font("opne-sans",Font.PLAIN,22));
          life_line.setBackground(new Color(30,144,255));
          life_line.setForeground(Color.white);
        life_line.addActionListener(this);

          //2.Life line button
          submit=new JButton("Submit");
          submit.setBounds(1100,660,200,40);
          submit.setFocusable(false);
          submit.setFont(new Font("opne-sans",Font.PLAIN,22));
          submit.setBackground(new Color(30,144,255));
          submit.setForeground(Color.white);
          submit.setEnabled(false);      //disabling submit button
          submit.addActionListener(this);


        start(count);  //game start function call



          add(image);
          add(que_no);
          add(que);
          add(opt1);
          add(opt2);
          add(opt3);
          add(opt4);
          add(next_btn);
          add(life_line);
          add(submit);
       setVisible(true);
      }


      //button functionalities(next,lifeline,submit)
      public void actionPerformed(ActionEvent e){  //(45:00)
        //when user clicks on next button
           if(e.getSource()==next_btn){
             repaint();
             //after clicking next button set all options visible and enable
             opt1.setEnabled(true);
             opt2.setEnabled(true);
             opt3.setEnabled(true);
             opt4.setEnabled(true);


             //user has
             is_ans_given=1;         //user has seelcted option and clicked next btn
             if(grp_opt.getSelection()==null){              // if user hasn't choosen any answer or option store empty value in string user_answer
               user_answer[count][0]="";
             }
             else{                 //if user has chosen one of option out of 4
               user_answer[count][0]=grp_opt.getSelection().getActionCommand();   // by grp_opt=we get all 4 options, getSelction=we get user selected option , getActionCommand()=we get value of option selected by user
             }
             if(count==8){             //enabling submit button at 10th question and disabling next_btn
               next_btn.setEnabled(false);
               submit.setEnabled(true);
             }
             count++;     // to see new question
             start(count);       // to display next question with their options
           }

           // when user clicks on life_line
           else if(e.getSource()==life_line){
             if (count==2||count==4||count==6||count==8||count==9){
               opt2.setEnabled(false);
               opt3.setEnabled(false);
             }else{
               opt1.setEnabled(false);
               opt4.setEnabled(false);
             }
             life_line.setEnabled(false);     //after using one time it disables
        }

           //when user clicks on submit button
           else{                 //when user clicks on submit button
             is_ans_given=1;

             if(grp_opt.getSelection()==null){              // if user hasn't choosen any answer or option store empty value in string user_answer
               user_answer[count][0]="";
             }
             else{                 //if user has chosen one of option out of 4
               user_answer[count][0]=grp_opt.getSelection().getActionCommand();   // by grp_opt=we get all 4 options, getSelction=we get user selected option , getActionCommand()=we get value of option selected by user
             }


             for (int i=0;i<user_answer.length;i++)
             {
               if(user_answer[i][0].equals(answers[i][1])){
                 score+=10;
               }
               else{
                 score+=0;
                  }
             }
             setVisible(false);
             new Score(username,score);             //after clicking submit button new score frame should open
           }
      }


      //***Function for timer
      public void paint(Graphics g){          //whenever object created paint method get called by default without explicit call
  super.paint(g);
  String time="Time left "+timer+" seconds";    //initially it is 15 (Globally declared)

        if(timer<=5){
          g.setColor(Color.red);
        }
        else{
          g.setColor(Color.green);
        }
  g.setFont(new Font("open-sans",Font.BOLD,25));
  if(timer>0){
    g.drawString(time,1100,500);          //When time ups string disappers
  }else{
    g.drawString("Times Up!!",1150,500);
  }
  timer--;     //time decrement
  try{
    Thread.sleep(1000);                 //To delay timer by 1 sec
    repaint();                          //calling function again and again with decreased timer values

  }
  catch(Exception e){
    e.printStackTrace();
  }

  //If user has given answer or times up before giving answer that time we have to move to next question with timer=15
  if(is_ans_given==1){
    is_ans_given=0;
    timer=15;
  }
  else if(timer<0){
    timer =15;
    //Setting all options visible after using lifeline and going to next question
    opt1.setEnabled(true);
    opt2.setEnabled(true);
    opt3.setEnabled(true);
    opt4.setEnabled(true);


    //if user click or not click next and submit buttons then too he/she will go to next page or test get submitted****************************
    //after giving last questions ans and if user  clicks submit button(51:56)
    if (count==8){
      next_btn.setEnabled(false);
      submit.setEnabled(true);
    }


    if(count==9){     //after giving last questions ans and if user doesn't click submit button(51:56) then too teest should get submited
      if(grp_opt.getSelection()==null){              // if user hasn't choosen any answer or option store empty value in string user_answer
        user_answer[count][0]="";
      }
      else{                 //if user has chosen one of option out of 4
        user_answer[count][0]=grp_opt.getSelection().getActionCommand();   // by grp_opt=we get all 4 options, getSelction=we get user selected option , getActionCommand()=we get value of option selected by user
      }
      //calculating user answers************
      for (int i=0;i<user_answer.length;i++){
        //checking the user_ans mathches with correct answer or not
        if(user_answer[i][0].equals(answers[i][1])){
              score+=10;
        }
        else{
          score+=0;
        }
      }
      setVisible(false);
      //new frame that will show score
      new Score(username,score);       //score frame
    }


    else{         //after giving last questions ans and if user doesn't click next button(51:56) then too next question appears on screen
    if(grp_opt.getSelection()==null){              // if user hasn't choosen any answer or option store empty value in string user_answer
      user_answer[count][0]="";
    }
    else{                 //if user has chosen one of option out of 4
      user_answer[count][0]=grp_opt.getSelection().getActionCommand();   // by grp_opt=we get all 4 options, getSelction=we get user selected option , getActionCommand()=we get value of option selected by user
    }
    count++;     // to see new question
    start(count);       // to display next question with their options
  }
  }
//*********************************************************************************************************************************

      }


      //***Function for question_no and questions and their options
      public void start(int count){
     que_no.setText(""+(count+1)+". ");        //for numbering
          que.setText(questions[count][0]);   //for questions
          opt1.setText(questions[count][1]);  //for options
          opt1.setActionCommand(questions[count][1]);

          opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

          opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

          opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        grp_opt.clearSelection();         // when we select any option and times up then same option of next question also get selected by default to clear this we use clearSelection() method.(40:48)
      }
    public static void main(String[] args) {
        new Quiz("User");
    }
}


//time 24.32
// to create timer I have used Graphics class