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
        cad = cadena.replaceAll("\n", "");
        al = new ArrayList();
        for (int i = 0; i < cad.length(); i++) {
            al.add(i, cad.charAt(i));
        }
        indice = 0;
    }
    
    void ImprimeOriginal(){
        for(int i=0;i<al.size();i++){
                try{
                if(al.get(i+1)=='-' && i!=0){
                System.out.print("\n");
                System.out.print(al.get(i));}
                else System.out.print(al.get(i));
                }catch(IndexOutOfBoundsException ae){
                    System.out.print(al.get(i));
                }               
            }
    }

    //retorna el simbolo que produce
    int simbolo() {
        do {
            indice++;
        } while (al.get(indice) != '-');
        return indice - 1;
    }
    
    int encuentraSimbolo(){
        int aux=indice;
        do {
            aux--;
        } while (al.get(aux) != '-');
        return aux - 1;
    }

    //retorna la regla de produccion
    int reglasProduccion() {
        do {
            indice++;
        } while (al.get(indice) != '>' && al.get(indice) != '|');
        return indice + 1;
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
            'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
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

    void FNC() {
        try {
            indice = reglasProduccion();
            System.out.println(al.get(indice) + " encontrada.");
            //si es de la forma A->AA
            if (esLetraMayuscula(al.get(indice)) == true && esLetraMayuscula(al.get(indice + 1)) == true) {
                //aumentamos dos el indice para que chequemos las siguietes reglas
                try {
                    indice = indice + 2;
                    System.out.println(al.get(indice) + " mayuscula encontrada.");

                    if (al.get(indice + 1) == '-') {
                        FNC();
                    } else if (al.get(indice) == '|') {
                        indice--;
                        FNC();
                    } else {
                        System.out.println("No valido (2.a)");
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Normalizado. (2.a)");
                }
            } //si es de la forma A->a
            else if (esLetraNumero(al.get(indice)) == true) {
                try {
                    //aqui validamos de que realmente despues d eun no terminal no
                    //haya otro simbolo              
                    System.out.println(al.get(indice) + " minuscula encontrada."); //nose que pets
                    indice++;

                    try {
                        if (al.get(indice + 1) == '-') {
                            FNC();
                        }
                    } catch (IndexOutOfBoundsException e) {
                    }
                    try {
                        if (al.get(indice) == '|') {
                            indice--;
                            FNC();
                        }
                    } catch (IndexOutOfBoundsException e) {
                    }
                    System.out.println(al.get(indice)); //nose que pets
                    System.out.println("No valido (1.a)");

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Normalizado. (1.b)");
                }
            } else {
                System.out.println("No valido (1.b)");
            }
        } catch (IndexOutOfBoundsException ea) {
            if (esLetraNumero(al.get(indice)) == true) {
                FNC();
            } else {
                System.out.println("No valido(1.c)");
            }
        }
    }

    ArrayList<Character> coincidencia() {     
        //guarda temporalmente el simbolo
        char simbolo;
        //guarda temporalmente la regla de produccion
        char rp;
        //contador para cada ciclo
        int indiceProduccion = 0;
        //contador principal        
        int aux=0;
        try{
        do{
            indice=indiceProduccion;
        
            //encuentra simbolos terminales
            do {
                rp = al.get(reglasProduccion());
            } while (esLetraNumero(rp) == false && indice < al.size());
            
            //simbolo que produce la regla
            simbolo = al.get(encuentraSimbolo());
            //guardamos el indice de donde se encontraron rp y simbolo
            int indiceSimbolo=encuentraSimbolo();
            indiceProduccion=indice;
            
            //System.out.println(simbolo + " " + " " + rp);
            //esta parte reemplaza los simbolos que producen estas constantes
            indice = 0;
            do{
                if (al.get(indice) == simbolo && indice != indiceSimbolo &&
                    al.get(indice-1) == '>' || al.get(indice) == simbolo &&
                    indice != indiceSimbolo && al.get(indice-1) == '|'){
                    
                    al.set(indice, rp);
                    indice++;
                } else {
                    indice++;
                }
            } while (indice < al.size());
            aux++;
        }while(aux<al.size());
        
        //imprime la conversion 
        }catch(IndexOutOfBoundsException e){
            
            for(int i=0;i<al.size();i++){
                try{
                if(al.get(i+1)=='-' && i!=0){
                System.out.print("\n");
                System.out.print(al.get(i));}
                else System.out.print(al.get(i));
                }catch(IndexOutOfBoundsException ae){
                    System.out.print(al.get(i));
                }              
            }
        }
        
        return al;
    
        }
    

    /*public static void main(String[] args) {
        ConverionFNGFNG a = new ConverionFNGFNG("S->AC\nM->BD|BN\nN->x\nA->z\nB->y\nC->MA\nD->MB");
        a.ImprimeOriginal();
        a.coincidencia();
    }*/
}
