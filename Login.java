import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;

import java.awt.*;

public class Login extends JFrame implements ActionListener
{
    JButton Quit,instructions;
    JTextField tf1;

    Login()
    {
       
       getContentPane().setBackground(Color.black); //PANE IS USED TO GET FULL FRAME AND IT IS INSIDE AWT PACKAGE
       setLayout(null); // by this we tell that I will create my own layout 
       //To use image which is inside file directory we will use ImageIcon class
       
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons//quiz.jpg"));

       //To put this image which is received inside i1 we will use JLabel
       JLabel image = new JLabel(i1);
       image.setBounds(0,0, 500, 500); // here I'm creating my own layout
       add(image);

       // To write heading or text on frame we will use JLabel class

       JLabel heading=new JLabel("Debug Your Mind");
       heading.setBounds(600,40,300,45);
       heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 34));
       heading.setForeground(Color.BLUE);
       add(heading);

        JLabel name=new JLabel("Enter Your Name");
       name.setBounds(600,150,300,20);
       name.setFont(new Font("Times New Roman", Font.BOLD, 18));
       name.setForeground(Color.white);
       add(name);

       // To build button we will use JButton

       instructions=new JButton("Instructions");
       instructions.setBounds(600,270, 120,25);
       instructions.setForeground(Color.white);
       instructions.setBackground(Color.BLUE);
       instructions.addActionListener(this);
       add(instructions);

       Quit=new JButton("Quit");
       Quit.setBounds(790,270, 120,25);
       Quit.setForeground(Color.white);
       Quit.setBackground(Color.BLUE);
       Quit.addActionListener(this); // added to enable click event 
       add(Quit);

       // To build text field we will use JTextField

        tf1=new JTextField();
       tf1.setBounds(600,200,300,25);
       tf1.setFont(new Font("Times New Roman",Font.BOLD,14));
       add(tf1);

       setVisible(true);                    // TO SET SIZE AND LOCATION OF FRAME
       setSize(1000, 500);
       setLocation(200, 150);
        
      
       
    }   
     public void actionPerformed(ActionEvent e) // for click event on button
     { 
          if(e.getSource()==instructions)
          {
                setVisible(false); // This line will set the visibility of current frame to be false
                String name=tf1.getText();
                new Rules(name);      // This line will open new class Rules
          }
          else if(e.getSource()==Quit)
          {
            setVisible(false);
          }
     }


        
    public static void main(String[] args) 
    {
          new Login(); 

        
        

        
    }
}    