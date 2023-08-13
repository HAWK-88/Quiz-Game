import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener
{
    Score(String name,int score)
    {
        setBounds(600, 150, 750,550);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2=i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,200,300,250);
        add(image);

        JLabel heading=new JLabel("Thank You For Playing");
        heading.setBounds(100, 20, 500, 20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(heading);

        JLabel score2=new JLabel("Your Score is "+score);
        score2.setBounds(380, 200, 300, 30);
        score2.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(score2);

        JButton submit=new JButton("Play Again");
        submit.setBounds(400,270,120,30);
        submit.setBackground(Color.CYAN);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
      setVisible(false);
      new Login();
    }
    public static void main(String[] args)
     {
         new Score("User",0);    
    }
}

