import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener
{
    String name;
    JButton back,start;
    Rules(String name)
    {
        this.name=name;
        getContentPane().setBackground(Color.black); //PANE IS USED TO GET FULL FRAME AND IT IS INSIDE AWT PACKAGE
       setLayout(null);

       setVisible(true);                    // TO SET SIZE AND LOCATION OF FRAME
       setSize(800, 650);
       setLocation(350, 100);

       JLabel heading=new JLabel("Welcome"+" "+name);
       heading.setBounds(50,20,700,28);
       heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
       heading.setForeground(Color.WHITE);
       add(heading);

      JLabel heading2=new JLabel("Carefully go through Instructions");
       heading2.setBounds(50,60,700,30);
       heading2.setFont(new Font("Times New Roman", Font.BOLD, 28));
       heading2.setForeground(Color.WHITE);
       add(heading2);

       JLabel rules=new JLabel();
       rules.setBounds(20,90,700,350);
       rules.setFont(new Font("Times New Roman", Font.BOLD, 14));
       rules.setForeground(Color.WHITE);
       rules.setText(
        "<html>"+ 
       "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
       "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
       "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
       "4. Crying is allowed but please do so quietly." + "<br><br>" +
       "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
       "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
       "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
       "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
   "<html>");

   add(rules);

       back=new JButton("Back");
       back.setBounds(250,500, 100,30);
       back.setForeground(Color.white);
       back.setBackground(Color.BLUE);
       back.addActionListener(this); // added to enable click event 
       add(back);

       start=new JButton("Start");
       start.setBounds(400,500, 100,30);
       start.setForeground(Color.white);
       start.setBackground(Color.BLUE);
       start.addActionListener(this);
       add(start);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==start)
        {
            setVisible(false);
          new Quiz(name);
        }
        else
        {
           setVisible(false);
           new Login();
        }
    }
    public static void main(String[] args) 
    {
        new Rules("User");
    }
}
