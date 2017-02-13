import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Server_i extends JFrame{

  //JButton jb;
  //JTextField jt;
  static JTextArea jl;
  static Server s;

  public Server_i(){
      s=new Server();
      //jb=new JButton("Send");
      //jt=new JTextField (40);
      jl=new JTextArea("");

      JPanel jp=new JPanel();
      /*jp.add(jb);jp.add(jt);*/jp.add(jl);

      getContentPane().add("Center", jp);
      setSize(300, 150);
      setVisible(true);

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public static void main(String args[]){
    Server_i i=new Server_i();

        while(true){
          jl.setText(s.recieveMessage());  
        }

  }
}
