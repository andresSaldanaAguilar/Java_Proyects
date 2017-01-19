public class Ticker implements Runnable{

  String cadena;
  Thread t;
  int limite,n;



  public Ticker(String cadena){

    //logica
    this.cadena=cadena;
    t=new Thread(this);
    limite=cadena.length();
    n=0;
  }

  public void Tick(){
      System.out.println("Original: "+cadena);
      t.start();
  }

  public void run(){

    char[] aCaracteres = cadena.toCharArray();
    int j= aCaracteres.length-1;
    System.out.print("Ticker: ");

     while(n != limite){
      for(int i=0;i<cadena.length();i++){
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
