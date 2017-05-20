/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete1;

import java.util.ArrayList;

/**
 *
 * @author ANDRES
 */
public class logicaAutomata {
    ArrayList<Character> pila;
    int indiceCadena;
    String cadena,mensajefinal;
    
    public logicaAutomata(String cadena){
        indiceCadena= 0;
        this.cadena=cadena+" ";
        pila = new ArrayList();
        /*agregamos el simbolo de fondo de la pila*/
        pila.add('Z');
        mensajefinal="";
    }
    
    char topePila(){
        return pila.get(pila.size()-1);
    }
    
    int topePilaInt(){
        return pila.size()-1;
    }
    
    String muestraMensaje(){
        return mensajefinal;
    }
    
    void q0(){

        /*primer caso del automata*/
        if(topePila()=='Z' && cadena.charAt(indiceCadena)=='0'){
            pila.add('A');
            /*si truena es que no es valida, ya que no puede haber solo unos*/
            try{
            indiceCadena++;
            System.out.println(topePila()+"0.1");
            System.out.println(cadena.charAt(indiceCadena));
            }catch(IndexOutOfBoundsException e){
                System.out.println("No valido (caracteres no validos o ceros de mas.(q0))");
                mensajefinal="Cadena invalida.1";
            }
                /*caso de recursividad*/
                if(topePila()=='A' && cadena.charAt(indiceCadena)=='0'){
                    q0();
                    mensajefinal="Estado:q0, Zo 0|Zo A\n"+mensajefinal;
                }
                /*caso pasamos al sig. edo quitando un A de la pila*/
                else if(topePila()=='A' && cadena.charAt(indiceCadena)=='1'){
                    q0();
                    mensajefinal="Estado:q0, Zo 0|Zo A\n"+mensajefinal;
                }
                /*no entra en ningun caso y no es valido.*/
                else{
                    System.out.println("No valido (caracteres no validos.(q0))");
                    mensajefinal="Cadena invalida.2";
                }
                
        }
        /*segundo caso del automata*/
        else if(topePila()=='A' && cadena.charAt(indiceCadena)=='0'){
            pila.add('A');
            /*si truena es que no es valida, ya que no puede haber solo unos*/
            try{
            indiceCadena++;
            System.out.println(topePila()+"0.2");
            System.out.println(cadena.charAt(indiceCadena));
            }catch(IndexOutOfBoundsException e){
                System.out.println("Cadena invalida.(q0)");
                mensajefinal="Cadena invalida.3";
            }
                /*caso recursividad*/
                if(topePila()=='A' && cadena.charAt(indiceCadena)=='0'){
                    q0();
                    mensajefinal="Estado:qo, A 0|A A\n"+mensajefinal;
                }
                /*caso pasamos al sig. edo eliminando el tope*/
                else if(topePila()=='A' && cadena.charAt(indiceCadena)=='1'){    
                    q0();
                    mensajefinal="Estado:qo, A 0|A A\n"+mensajefinal;
                }
                /*no entra en ningun caso y no es valido.*/
                else {
                    System.out.println("No valido (caracteres no validos.(q0))");
                    mensajefinal= "Cadena invalida.4";
                }
        }
        /*3er caso*/
        else if(topePila()=='A' && cadena.charAt(indiceCadena)=='1'){
                pila.remove(topePilaInt());
                try{
                    indiceCadena++;
                    System.out.println(topePila()+"0.3");
                    System.out.println(cadena.charAt(indiceCadena));
                }catch(IndexOutOfBoundsException e){
                System.out.println("Cadena invalida.(q0.3)");
                mensajefinal="Cadena invalida.5";
                }
                q1();
                mensajefinal="Estado:q0, A 1|e\n"+mensajefinal;
        }
        /*no hay ningun caso valido*/
        else{ 
            System.out.println("Estado invalido (caracteres no validos.(q0))");
            mensajefinal="Cadena invalida.6";
        }
    }
    
    void q1(){
        /*primer caso y unico*/
        
        if(topePila()=='A' && cadena.charAt(indiceCadena)=='1'){
            pila.remove(topePilaInt());
            /*si truena es que no es valida, ya que no puede haber solo unos*/
            try{
            indiceCadena++;
            System.out.println(topePila()+"1.1");
            System.out.println(cadena.charAt(indiceCadena));
            }catch(Exception e){
                System.out.println("No valido (caracteres no validos o ceros de mas(q1).)");
                mensajefinal="Cadena invalida.7";
            }
                /*caso de recursividad*/
                if(topePila()=='A' && cadena.charAt(indiceCadena)=='1'){
                    q1();
                    mensajefinal="Estado:q1, A 1|e\n"+mensajefinal;
                }
                /*caso del estado final*/
                else if(topePila()=='Z' && cadena.charAt(indiceCadena)==' '){
                    q1();
                    mensajefinal="Estado:q1, A 1|e\n"+mensajefinal;
                }
                /*no entra en ningun caso y no es valido.*/
                else{
                    System.out.println("No valido (caracteres no validos(q1)..)");
                    mensajefinal="Cadena invalida.8";
                }
        }
        
        else if(topePila()=='Z' && cadena.charAt(indiceCadena)==' '){
           pila.remove(topePilaInt());

                    /*si la pila esta vacia significa que terminamos*/ 
                    if(pila.isEmpty()==true){
                        System.out.println("Cadena valida (edo final.)");
                        mensajefinal="Estado:q1, Zo e|e\nCadena Valida.\n"+mensajefinal;
                    }else{
                        System.out.println("pila no vacia.");
                        mensajefinal="Cadena invalida.9";
                    }
        }
        
        /*no hay ningun caso valido*/
        else{
            System.out.println("Estado invalido (caracteres no validos.(q1))");
            mensajefinal="Cadena invalida.";
        }
    }
    
    
    
    /*public static void main(String args[]){
        logicaAutomata ap=new logicaAutomata("01");
        ap.q0();
    }*/
}
