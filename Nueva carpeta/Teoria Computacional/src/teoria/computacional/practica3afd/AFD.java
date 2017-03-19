package teoria.computacional.practica3afd;

import java.util.ArrayList;

public class AFD {

    ArrayList<Character> al;
    //lleva la cuenta de el caracter que estamos evaluando
    int indice;
    String cad;

    public AFD(String num) {
        cad = num;
        al = new ArrayList();
        for (int i = 0; i < cad.length(); i++) {
            al.add(i, cad.charAt(i));
        }
        indice = 0;
    }

    void q0() {
        try {
            char c = al.get(indice);
            if (c == '0') {
                indice++;
                System.out.println("q0 -> q1 : 0");
                q1();

            } else if (c == '1') {
                indice++;
                System.out.println("q0 -> q1 : 1");
                q1();
            } else {
                System.out.println("Caracter No valido(q0)");
            }
        } catch (NullPointerException e) {
            System.out.println("No valido.(q0)" + indice);
        }
    }

    void q1() {
        try {
            try {
                char ca = al.get(indice);

                if (ca == '1') {
                    indice++;
                    System.out.println("q1 -> q1 : 1");
                    q1();
                } else if (ca == '0') {
                    q2();
                } else {
                    System.out.println("Caracter No valido.(q1)");
                }
            //la excepcion de boundaries es para cuando el programa termina en uno
            } catch (NullPointerException e) {
                System.out.println("No valido.(Estado actual: q1)");
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("No valido. (Estado actual: q1)");
        }
    }

    void q2() {
        try {
            try {
                char car = al.get(indice);
                System.out.println("q1 -> q2 : 0");
                indice++;
                
                //en esta parte nos aseguramos de que si encontramos un cero,
                //no pueda haber mas ceros despues de el estado final
                try {
                    char c = al.get(indice);
                    System.out.println("No valido,(En estado final)");
                } catch (IndexOutOfBoundsException ie) {
                    System.out.println("Valido. (En estado final)");
                }

                //tenemos que poner nuestras sentencias en un try catch para
                //cachar expeciones de tamali y de nulidades
            } catch (NullPointerException e) {
                System.out.println("No Valido. (q2)");
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("No valido.. (q2)");
        }

    }
}
