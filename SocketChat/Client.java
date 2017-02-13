import java.io.*;
import java.net.*;

public class Client{
  static Socket s;
  ObjectInputStream din;
  static ObjectOutputStream dout;
  
  public Client(){
      try{
      s=new Socket("127.0.0.1",1234);
      dout=new ObjectOutputStream(s.getOutputStream());
    }catch (Exception e) {};
  }

  public void sendMessage(String message){
    try{


      dout.writeObject(message);
      //dout.close();
    }catch (Exception e) {};
  }


}
