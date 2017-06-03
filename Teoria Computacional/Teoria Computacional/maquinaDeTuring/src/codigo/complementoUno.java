package codigo;
/**
 * @author ANDRES
 */

public class complementoUno {
    
    String cadenaAux,cadena,complemento,aux,arreglo[];
    int apuntador;
    
    public complementoUno(String cadenaAux){
        this.cadenaAux=cadenaAux;
        apuntador=1;
        complemento="";
        
    }
    
    String decodificar(String cadenaAux){
        cadena="#"+cadenaAux+"#";
        arreglo=new String[cadena.length()];
        for(int i=0;i<cadena.length();i++){
            arreglo[i]=""+cadena.charAt(i);
        }
        e0();
        return complemento;
    }
    
    void e0(){
        aux=arreglo[apuntador];
            if(aux.equals("0")){
                arreglo[apuntador]="1";
                movDer();
                e1();
            }
            else if(aux.equals("1")){
                arreglo[apuntador]="0";
                movDer();
                e1();
            }
            else if(aux.equals("#")){
                movIzq();
                System.out.println("Cadena Vacia");
            }
            else rechazar(aux);
    }
    
    void e1(){
        aux=arreglo[apuntador];
            if(aux.equals("0")){
                arreglo[apuntador]="1";
                movDer();
                e1();
            }
            else if(aux.equals("1")){
                arreglo[apuntador]="0";
                movDer();
                e1();
            }
            else if(aux.equals("#")){
                movIzq();
                e2();
                
            }
            else rechazar(aux);
    }
    
    void e2(){
        aux=arreglo[apuntador];
            if(aux.equals("0")){
                arreglo[apuntador]="0";
                movIzq();
                e2();
            }
            else if(aux.equals("1")){
                arreglo[apuntador]="1";
                movIzq();
                e2();
            }
            else if(aux.equals("#")){
                movDer();
                e3();
            }
            else rechazar(aux);
    }
    
    void e3(){
        for(int i=1;i<cadena.length()-1;i++){
            complemento=complemento+arreglo[i];
        }
        System.out.println("El complemento es: "+complemento);
    }
  
    void movIzq(){
        apuntador--;
    }
    
    void movDer(){
        apuntador++;
    }
    
    void rechazar(String aux){
        System.out.println("Caracater invalido: "+aux);
    }
    
    
}
