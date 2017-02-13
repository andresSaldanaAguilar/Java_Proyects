import java.util.*;

public class Ticker implements Runnable{

  String cadena;
  Thread t;
  int limite,n;
  ArrayList <Character> al;
  //Interfaz


  public Ticker(String cadena){

    //logica
    al=new ArrayList <Character> ();
    this.cadena=cadena;
    t=new Thread(this);
    limite=cadena.length();
    n=0;
  }

  public ArrayList Tick(){
      System.out.println("Original: "+cadena);
      t.start();
      return al;
  }

  public void run(){

    char[] aCaracteres = cadena.toCharArray();
    int j= aCaracteres.length-1;
    System.out.print("Ticker: ");

     while(n != limite){
      for(int i=0;i<cadena.length();i++){
          al.add(aCaracteres [j-i]);
          System.out.print(aCaracteres [j-i]);
          try {
              Thread.sleep(200);
          } catch (Exception e) {
              return;
          }n++;
      }
    }
  }
}
