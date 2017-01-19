import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame implements ActionListener{

  JButton jb;
  JTextField jt;
  JLabel jl;

  public Interfaz(){
      jb=new JButton("Enter");
      jt=new JTextField (40);
      jl=new JLabel("");

      JPanel jp=new JPanel();
      jp.add(jb);jt.add(jt);jt.add(jl);

      getContentPane().add("Center", jp);
      setSize(350, 350);
      setVisible(true);

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jb.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e){
      Ticker t=new Ticker(jt.getText());
      t.Tick();
  }

  public static void main(String args[]){
    Interfaz i=new Interfaz();
  }
}
