package converionfngfng;

import java.util.ArrayList;
/**
 *
 * @author ANDRES
 */
public class ConverionFNGFNG {
    
    ArrayList<Character> al;
    //lleva la cuenta de el caracter que estamos evaluando
    int indice;
    String cad;

    public ConverionFNGFNG(String cadena) {
        cad = cadena.replaceAll("\n","");
        al = new ArrayList();
        for (int i = 0; i < cad.length(); i++) {
            al.add(i, cad.charAt(i));
        }
        indice = 0;
    }
    //retorna el simbolo que produce
    int simbolo(){
        do{
            indice++;          
        }while(al.get(indice)!='-');
        return indice-1;       
    }
    //retorna la regla de produccion
    int reglasProduccion(){    
        do{
            indice++;          
        }while(al.get(indice)!='>');
        return indice+1;       
    }
    
     boolean esLetraMayuscula(char c) {
        //arreglo de todos las letras posibles
        char numeros[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
        'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        //bandera para conocer el edo actual
        boolean es_letra = false;
        try {
            //en este ciclo validamos que el caracter en el que estamos
            //sea una letra (a-z)
            int ind = 0;
            do {
                if (numeros[ind] == c) {
                    es_letra = true;
                } else {
                    es_letra = false;
                }
                ind++;
            } while (es_letra == false && ind < 26);

            //si el estado de la bandera quedo en falso, significa que no 
            //es letra.
            return es_letra;
        } catch (NullPointerException e) {
            System.out.println("No valido(esletra).");
            return false;
        }
    }
     
     boolean esLetraNumero(char c) {
        //arreglo de todos las letras posibles
        char numeros[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
        'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
        'z','1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        //bandera para conocer el edo actual
        boolean es_letra = false;
        try {
            //en este ciclo validamos que el caracter en el que estamos
            //sea una letra (a-z)
            int ind = 0;
            do {
                if (numeros[ind] == c) {
                    es_letra = true;
                } else {
                    es_letra = false;
                }
                ind++;
            } while (es_letra == false && ind < 36);

            //si el estado de la bandera quedo en falso, significa que no 
            //es letra.
            return es_letra;
        } catch (NullPointerException e) {
            System.out.println("No valido(esletra).");
            return false;
        }
    }

    
    void FNC(){
        try{
        indice=reglasProduccion();
        
        if(esLetraMayuscula(al.get(indice))==true && esLetraMayuscula(al.get(indice+1))==true){
            //aumentamos dos el indice para que chequemos las siguietes reglas
            try{
               indice=indice+1;
               FNC();
            }catch(IndexOutOfBoundsException e){
            System.out.println("Normalizado.");
        }
        }
        else{
            System.out.println("No valido");
        }
        }catch(IndexOutOfBoundsException ea){
            if(esLetraNumero(al.get(indice))==true){
                FNC();
            }
            else{
                System.out.println("Ño valido(FNC c)");
            }
        }
    }
    
    

    public static void main(String[] args) {
        ConverionFNGFNG a=new ConverionFNGFNG("A->ABA->V");
        
        a.FNC();
    }
}
