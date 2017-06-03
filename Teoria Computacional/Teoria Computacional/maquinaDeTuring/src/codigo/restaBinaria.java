package codigo;

/**
 *
 * @author ANDRES
 */
public class restaBinaria {
    String sustraendo,minuendo,auxsustraendo,auxminuendo,arreglo1[],arreglo2[]
            ,resultado[],aux1,aux2,resta="";
    int apuntador,acarreo,apres;
    
    public restaBinaria(String auxsustraendo,String auxminuendo){
        this.auxsustraendo=auxsustraendo;
        this.auxminuendo=auxminuendo;
        acarreo=0;
    }
    
    String decodifica(){
        //sacamos el complemento a uno del minuendo
        complementoUno cu=new complementoUno(auxminuendo);
        
        sustraendo="#"+auxsustraendo+"#";
        //encontramos el complemento a uno
        minuendo="#"+cu.decodificar(auxminuendo)+"#";
        arreglo1=new String[sustraendo.length()];
        arreglo2=new String[sustraendo.length()];
        
         if(sustraendo.length()!=minuendo.length()){
            return "Diferente longitud o caracter invalido.";
        }
        else{
        //creamos los arreglos dependiendo quien es mas gramde
        //caso del sustraendo mayor
        for(int i=0;i<sustraendo.length();i++){
                arreglo1[i]=""+sustraendo.charAt(i);
            }
        for(int i=0;i<sustraendo.length();i++){
                arreglo2[i]=""+minuendo.charAt(i);
            }
       
        for(int i=0;i<sustraendo.length();i++){
                System.out.print(arreglo1[i]);

            }
        for(int i=0;i<sustraendo.length();i++){
                System.out.print(arreglo2[i]);
            }
        
        //creamos el arreglo que tiene el resultado, no importa quien 
        //tomemos, todos son del mismo tamaño 
        resultado=new String[sustraendo.length()];
        //recorreremos de izq a derecha
        apuntador=sustraendo.length()-2;
        apres=sustraendo.length()-3;
        e0();  
        System.out.println("Hola");
        return resta;
        }
    }
    
    void e0(){
        aux1=arreglo1[apuntador];
        aux2=arreglo2[apuntador];
       
        //checamos si alguna cadena esta vacia
        if(aux1.equals("#") || aux2.equals("#"))
            System.out.println("Una de las cadenas esta vacia");
            
        else{
            //casos con carry 0
            //caso que sean 0 y 0
            if(aux1.equals("0") && aux2.equals("0") && acarreo==0){
                 resultado[apres]="0";
                 acarreo=0;
                 movIzquierda();
                 e1();
            }
            //caso que sean 1 y 1
            else if(aux1.equals("1") && aux2.equals("1") && acarreo==0){
                resultado[apres]="0";
                acarreo=1;
                movIzquierda();
                 e1();
            }
            //caso que sean 0 y 1
            else if(aux1.equals("0") && aux2.equals("1") && acarreo==0){
                resultado[apres]="1";
                acarreo=0;
                movIzquierda();
                 e1();
            }
            //caso que sean 1 y 0
            else if(aux1.equals("1") && aux2.equals("0") && acarreo==0){
                resultado[apres]="1";
                acarreo=0;
                movIzquierda();
                e1();
            }
            
            
            //casos con carry 1
            //caso que sean 0 y 0
            else if(aux1.equals("0") && aux2.equals("0") && acarreo==1){
                resultado[apres]="1";
                acarreo=0;
                movIzquierda();
                 e1();
            }
            //caso que sean 1 y 1
            else if(aux1.equals("1") && aux2.equals("1") && acarreo==1){
                resultado[apres]="1";
                acarreo=1;
                movIzquierda();
                 e1();
            }
            //caso que sean 0 y 1
            else if(aux1.equals("0") && aux2.equals("1") && acarreo==1){
                resultado[apres]="0";
                acarreo=1;
                movIzquierda();
                 e1();
            }
            //caso que sean 1 y 0
            else if(aux1.equals("1") && aux2.equals("0") && acarreo==1){
                resultado[apres]="0";
                acarreo=1;
                movIzquierda();
                 e1();
            }
            else System.out.println("Caracter invalido (e0)");
        }
    }
    
    void e1(){
        
        aux1=arreglo1[apuntador];
        aux2=arreglo2[apuntador];
       
        //estado final de aceptacion
        if(aux1.equals("#") && aux2.equals("#")){
            String cadena="",cadenafinal;
            
            for(int i=0;i<sustraendo.length()-2;i++){
                cadena=cadena+resultado[i];
            }
            //caso en que acarreo sea uno y debamos sumar un uno
            if(acarreo==1){         
                cadenafinal=sumaBinaria(cadena);
                System.out.println("El resultado es: "+"| "+cadenafinal+" |");
                resta=cadenafinal;
            }
            //caso de acarreo cero, sacamos su complemento
            else{
                complementoUno cu1=new complementoUno(cadena);
                cadenafinal=cu1.decodificar(cadena);
                System.out.println("El resultado es: "+"| "+cadenafinal+" |");
                resta=cadenafinal;
            }
        }
        
        else{
            //casos con carry 0
            //caso que sean 0 y 0
            if(aux1.equals("0") && aux2.equals("0") && acarreo==0){
                 resultado[apres]="0";
                 acarreo=0;
                 movIzquierda();
                 e1();
            }
            //caso que sean 1 y 1
            else if(aux1.equals("1") && aux2.equals("1") && acarreo==0){
                resultado[apres]="0";
                acarreo=1;
                movIzquierda();
                 e1();
            }
            //caso que sean 0 y 1
            else if(aux1.equals("0") && aux2.equals("1") && acarreo==0){
                resultado[apres]="1";
                acarreo=0;
                movIzquierda();
                 e1();
            }
            //caso que sean 1 y 0
            else if(aux1.equals("1") && aux2.equals("0") && acarreo==0){
                resultado[apres]="1";
                acarreo=0;
                movIzquierda();
                e1();
            }

            //casos con carry 1
            //caso que sean 0 y 0
            else if(aux1.equals("0") && aux2.equals("0") && acarreo==1){
                resultado[apres]="1";
                acarreo=0;
                movIzquierda();
                 e1();
            }
            //caso que sean 1 y 1
            else if(aux1.equals("1") && aux2.equals("1") && acarreo==1){
                resultado[apres]="1";
                acarreo=1;
                movIzquierda();
                 e1();
            }
            //caso que sean 0 y 1
            else if(aux1.equals("0") && aux2.equals("1") && acarreo==1){
                resultado[apres]="0";
                acarreo=1;
                movIzquierda();
                 e1();
            }
            //caso que sean 1 y 0
            else if(aux1.equals("1") && aux2.equals("0") && acarreo==1){
                resultado[apres]="0";
                acarreo=1;
                movIzquierda();
                 e1();
            }
            else System.out.println("Caracter invalido (e1)");
        }
    }
    
    void movIzquierda(){
        apuntador--;
        apres--;
    }
    
    void movDerecha(){
        apuntador++;
    }
    
    String sumaBinaria(String cadena1){
        
        
        int indice=cadena1.length()-1;
        int carry=0;
        String res[]=new String[cadena1.length()];
        String aux="";
        do{
        if(indice==cadena1.length()-1){
            if(cadena1.charAt(indice)=='1'){
                res[indice]="0";
                carry=1;
                indice--;
            }
            else{
                res[indice]="1";
                carry=0;
                indice--;
            }
        }
        else{
            
            //casos con carry 0
            if(cadena1.charAt(indice)=='0' && carry==0){
                 res[indice]="0";
                 carry=0;
                 indice--;
            }

            else if(cadena1.charAt(indice)=='1' && carry==0){
                res[indice]="1";
                carry=0;
                indice--;
            }

            //carry 1
            else if(cadena1.charAt(indice)=='0' && carry==1){
                res[indice]="1";
                carry=0;
                indice--;
            }

            else if(cadena1.charAt(indice)=='1' && carry==1){
                res[indice]="1";
                carry=1;
                indice--;
            }
            else System.out.println("Caracter invalido");
        }
        }while(indice>-1);

        for(int j=0;j<cadena1.length();j++){
            aux=aux+res[j];
        }
        return aux;
    }
    /*public static void main(String args[]) {
        restaBinaria l=new restaBinaria("001","000");
        System.out.println(l.decodifica());
    }*/
}
