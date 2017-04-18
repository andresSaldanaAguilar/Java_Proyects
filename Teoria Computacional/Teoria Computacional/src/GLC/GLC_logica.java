package GLC;
import java.util.ArrayList;

public class GLC_logica {

    ArrayList<Character> al;
    //lleva la cuenta de el caracter que estamos evaluando
    int indice;
    String cad;

    public GLC_logica(String cad) {
        this.cad = cad;
        al = new ArrayList();
        for (int i = 0; i < cad.length(); i++) {
            al.add(i, cad.charAt(i));
        }
        indice = 0;
    }

    boolean esNumero(char num) {

        //arreglo de todos los posibles numeros
        char numeros[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        //bandera para conocer el edo actual
        boolean es_numero = true;
        try {
            //en este ciclo validamos que el caracter en el que estamos
            //sea un numero (0-9)
            int ind = 0;
            do {
                if (numeros[ind] == num) {
                    es_numero = true;
                } else {
                    es_numero = false;
                }
                ind++;
            } while (es_numero == false && ind < 10);

            //si el estado de la bandera quedo en falso, significa que no 
            //es numero, de lo contrario lo afirmamos que es numero.
            if (es_numero == false) {
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException e) {
            System.out.println("No valido(num).");
            return false;
        }
    }

    boolean pBalance() {

        //bandera para conocer el edo actual
        int balance = 0;

        try {
            //en este ciclo recorremos cada caracter de la cadena
            for (int i = 0; i < al.size(); i++) {
                char aux = al.get(i);
                if (aux == '(') {
                    balance++;
                }
                if (aux == ')') {
                    balance--;
                } else {
                    balance = balance + 0;
                }
            }
            if (balance == 0) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            System.out.println("No valido(balance).");
            return false;

        }
    }

    void LLC_1() {
        try {
            //caso donde encontramos un parentesis
            if (al.get(indice) == '(') {
                if (pBalance() == true) {
                    indice++;
                    LLC_2();
                } else {
                    System.out.println("Cadena invalida, parentesis sin balance (1).");
                }
            } //demas casos, pasamos al siguiente edo, no aumentamos indice por ser
            //opcional
            else {
                LLC_2();
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println(al.get(indice)); //igual ño se que hace XD pero sirve
            System.out.println("No valido (1).");          
        }
    }

    void LLC_2() {
        try {
            //caso cuando hay parentesis que contienen el numero
            if (al.get(indice) == '(') {
                if (pBalance() == true) {
                    indice++;
                    LLC_3();
                } else {
                    System.out.println("Cadena invalida, parentesis sin balance (2).");
                }
            } //si no hay parentesis, pasamos al sig. edo, sin aumentar indice
            else {
                LLC_3();
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("No valido(2). ");           
        }
    }

    void LLC_3() {
        //checamos por parentesis perdidos
        if(pBalance() == true){
        //checamos que el caracter sea un digito
        if (esNumero(al.get(indice)) == true) {
            //el try es para que, si ya no hay mas despues del numero, no nos
            //marque error ya que si es valida
            try {
                indice++;
                //si encontramos un parentesis despues, aumentamos dos el  indice
                //de otra forma solo lo aumentamos una
                if (al.get(indice) == ')') {
                    indice++;
                    LLC_4();
                } else {
                    LLC_4();
                }
            } catch (IndexOutOfBoundsException ie) {
                //System.out.println(al.get(indice)); don't know wtf
                System.out.println("Cadena valida (3).");
            }
        } //o no hay digito o no es un digito.
        else {
            LLC_4();
        }
        }else System.out.println("Cadena invalida, parentesis sin balance (3 ini).");
        
    }

    void LLC_4() {
        //checamos si hay un operando
        if (al.get(indice) == '*' || al.get(indice) == '-' || al.get(indice) == '+') {
            try{
                indice++;
                char aux=al.get(indice); //nose porque pero esto hace que funcione .-.
                LLC_5();
            }catch (IndexOutOfBoundsException ie) {
            System.out.println("Cadena invalida, no hay numero consecuente (4).");
        }
            
        }
        else {
            System.out.println("Cadena invalida, no hay operando (4).");
        }
    }

    void LLC_5() {
        //checamos por parentesis perdidos
        try {
            if(pBalance() == true){
            //caso cuando hay parentesis que contienen el numero
            if (al.get(indice) == '(') {
                if (pBalance() == true) {
                    indice++;
                    LLC_6();
                } else {
                    System.out.println("Cadena invalida, parentesis sin balance (5).");
                }
            } //si no hay parentesis, pasamos al sig. edo, sin aumentar indice
            else {
                LLC_6();
            }
        }
            else System.out.println("Cadena invalida, parentesis sin balance (5 ini).");
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("Cadena valida (5).");
        }
    }

    void LLC_6() {

        //checamos que el caracter sea un digito
        if (esNumero(al.get(indice)) == true) {
            //el try es para que, si ya no hay mas despues del numero, no nos
            //marque error ya que si es valida
            try {
                indice++;
                //si encontramos un parentesis despues, aumentamos dos el  indice
                //de otra forma solo lo aumentamos una
                if (al.get(indice) == ')') {
                    //buscamos si hay otro parentesis mas
                    try {
                        indice++;
                        if (al.get(indice) == ')') {
                            try {
                                indice++;
                                LLC_1();
                            } catch (IndexOutOfBoundsException ie) {
                                System.out.println(al.get(indice));
                                System.out.println("Cadena valida (6.1).");
                            }
                        }
                        //si no hay y no nos mando error, se repite todo
                        else{
                                LLC_1();
                        }
                    } catch (IndexOutOfBoundsException ie) {
                        System.out.println(al.get(indice));
                        System.out.println("Cadena valida (6.2).");
                    }
                }
                //si no hay parentesis ni error, repetimos todo tambien
                else {
                    LLC_1();
                }
            }
            //si ya no hay nada termino el programa
            catch (IndexOutOfBoundsException ie){
                System.out.println("Cadena valida (6.3).");
            }
        } //o no hay digito o no es un digito.
        
        else {
            System.out.println("Cadena invalida, hay caracteres que no son numeros o no hay numeros (6).");
        }
    }

}
