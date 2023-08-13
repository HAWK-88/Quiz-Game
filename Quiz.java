import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener
{
    String questions[][]=new String[10][5];
    String answers[][]=new String[10][2];
    String userAnswers[][]=new String[10][1];
    JRadioButton option1,option2,option3,option4;
    JLabel quesNo,question;
    ButtonGroup groupOptions;
    public static int timer=15;
    public static int ans_given=0;
    public static int count=0;
    JButton next,submit;
    public int score=0;
    String name;

    Quiz(String name)
    {
        this.name=name;
        setVisible(true);                    // TO SET SIZE AND LOCATION OF FRAME
        setSize(1300, 1000);
        setLocation(50, 10);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image1=new JLabel(i2);
        image1.setBounds(0,0,1300,400);
        add(image1);

        quesNo=new JLabel();
        quesNo.setBounds(100, 450, 50, 30);
        add(quesNo);

        question=new JLabel();
        question.setBounds(120, 450, 900, 30);
        question.setFont(new Font("Times New Roman",Font.PLAIN,18));
        add(question);

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
        

         option1=new JRadioButton();
        option1.setBounds(150, 500, 700, 30);
        option1.setFont(new Font("Times New Roman",Font.PLAIN,16));
        option1.setBackground(Color.WHITE); 
        add(option1);

        option2=new JRadioButton();
        option2.setBounds(150, 530, 700, 30);
        option2.setFont(new Font("Times New Roman",Font.PLAIN,16));
        option2.setBackground(Color.WHITE); 
        add(option2);

         option3=new JRadioButton();
        option3.setBounds(150, 560, 700, 30);
        option3.setFont(new Font("Times New Roman",Font.PLAIN,16));
        option3.setBackground(Color.WHITE); 
        add(option3);

         option4=new JRadioButton();
        option4.setBounds(150, 590, 700, 30);
        option4.setFont(new Font("Times New Roman",Font.PLAIN,16));
        option4.setBackground(Color.WHITE); 
        add(option4);

        // To group radio button becuase on clicking we are selecting all options but we shoul select only one of them

     groupOptions=new ButtonGroup();
        groupOptions.add(option1);
        groupOptions.add(option2);
        groupOptions.add(option3);
        groupOptions.add(option4);

        next=new JButton("Next");
        next.setBounds(1000,500,100,30);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.blue);
        next.addActionListener(this);
        add(next);

        submit=new JButton("Submit");
        submit.setBounds(1000,600,100,30);
        submit.setBackground(Color.white);
        submit.setForeground(Color.blue);
        submit.setEnabled(false); // This will make inactive by default
        submit.addActionListener(this);
        add(submit);

        start(count);

        


    }
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==next)
      {
        repaint();
        ans_given=1;
        if(groupOptions.getSelection()==null)
            {
               userAnswers[count][0]="";
            }
            else
             {
                userAnswers[count][0]=groupOptions.getSelection().getActionCommand();
             }

             if(count==8)
             {
                next.setEnabled(false);
                submit.setEnabled(true);
             }

        count++;
        start(count);
      }
      else if(ae.getSource()==submit)
      {
        ans_given=1;
          if(groupOptions.getSelection()==null)
                   {
                     userAnswers[count][0]="";
                   }
          else
                   {
                     userAnswers[count][0]=groupOptions.getSelection().getActionCommand();
                   }

          for(int i=0;i<userAnswers.length;i++)
                 {
                    if(userAnswers[i][0].equals(answers[i][1]))
                    {
                      score =score+1;
                    }
                 }  
         setVisible(false);
         new Score(name,score);
      }
    }

    public void paint(Graphics gr)
    {
        super.paint(gr);

        String time="Time Left "+ timer + " Seconds";
        gr.setColor(Color.RED);
        gr.setFont(new Font("Tahoma",Font.BOLD,22));
        if(timer>0)
        {
        gr.drawString(time, 800,450);
        }
        else
        {
            gr.drawString("Times up!!", 800,450);
        }
        timer--;
        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(ans_given==1)
        {
            ans_given=0;
            timer=15;
        }
        else if(timer<0)
        {
            timer=15;
             if(count==8)
             {
                next.setEnabled(false);
                submit.setEnabled(true);
             }
             if(count==9)
             {
                 if(groupOptions.getSelection()==null)
                   {
                     userAnswers[count][0]="";
                   }
                else
                   {
                     userAnswers[count][0]=groupOptions.getSelection().getActionCommand();
                   }

                 for(int i=0;i<userAnswers.length;i++)
                 {
                    if(userAnswers[i][0].equals(answers[i][1]))
                    {
                      score =score+1;
                    }
                 }  
                 setVisible(false);
                 new Score(name,score);
             }
                else
             {
                if(groupOptions.getSelection()==null)
                {
                   userAnswers[count][0]="";
                }
                else
                {
                   userAnswers[count][0]=groupOptions.getSelection().getActionCommand();
                }
            
             count++;
             start(count);
            }
        }
    }

    public void start(int count)
    {
        quesNo.setText(""+(count+1)+".");
        question.setText(questions[count][0]);
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);
        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);
        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);
        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);

        groupOptions.clearSelection();
    }
   public static void main(String[] args)
    {
      new Quiz("User");
   }    
}

