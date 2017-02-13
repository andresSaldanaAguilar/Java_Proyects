import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{
  static ServerSocket ss;
  static Socket s;
  static ObjectInputStream din;
  ObjectOutputStream dout;
  String msg;
  
  public Server(){
      try {
          ss=new ServerSocket(1234);
          s=new Socket();
          s=ss.accept();
          din=new ObjectInputStream(s.getInputStream());
      } catch (IOException ex) {
          Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public void sendMessage(String message){
    try{
      dout=new ObjectOutputStream(s.getOutputStream());
      dout.writeObject(message);
      dout.close();
    }catch (Exception e) {};
  }

  public String recieveMessage(){

    try{
      msg=(String)din.readObject();
      System.out.println(msg);
      //din.close();

    }catch(Exception e){}

          return msg;

  }

}
