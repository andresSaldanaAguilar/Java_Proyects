import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Client_i extends JFrame implements ActionListener{

  JButton jb;
  JTextField jt;
  JTextArea jl;
  Client c;

  public Client_i(){
      c=new Client();
      jb=new JButton("Send");
      jt=new JTextField (40);
      jl=new JTextArea("");

      JPanel jp=new JPanel();
      jp.add(jb);jp.add(jt);jp.add(jl);

      getContentPane().add("Center", jp);
      setSize(300, 150);
      setVisible(true);

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jb.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e){
      c.sendMessage(jt.getText());
  }

  public static void main(String args[]){
    Client_i i=new Client_i();
  }
}
