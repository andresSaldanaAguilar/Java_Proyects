import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame implements ActionListener{

  JButton jb;
  JTextField jt;
  JTextArea jl;


  public Interfaz(){
      jb=new JButton("Send");
      jt=new JTextField (70);
      jl=new JTextArea("");

      JPanel jp=new JPanel();
      jp.add(jb);jp.add(jt);jp.add(jl);

      getContentPane().add("Center", jp);
      setSize(800, 150);
      setVisible(true);
      jb.addActionListener(this);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public void actionPerformed( ActionEvent ae){
      pali p=new pali(jt.getText());
      if(p.es_palindromo()==false){
        jl.setText("Es palindromo :D");
      }
      else{
        jl.setText("No es palindromo :(");
      }
      jt.setText("");
  }

  public static void main(String args[]){
      Interfaz i=new Interfaz();

  }
}
