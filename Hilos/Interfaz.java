import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Interfaz extends JFrame implements ActionListener{

  JButton jb;
  JTextField jt;
  JTextArea jl;

  public Interfaz(){
      jb=new JButton("Enter");
      jt=new JTextField (40);
      jl=new JTextArea("");

      JPanel jp=new JPanel();
      jp.add(jb);jp.add(jt);jp.add(jl);

      getContentPane().add("Center", jp);
      setSize(350, 350);
      setVisible(true);

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jb.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e){
      Ticker t=new Ticker(jt.getText());
      jl.setText(""+t.Tick());
  }

  public static void main(String args[]){
    Interfaz i=new Interfaz();
    Interfaz i1=new Interfaz();
  }
}
