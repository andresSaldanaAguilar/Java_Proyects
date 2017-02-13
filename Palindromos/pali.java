import java.util.*;
import java.util.Arrays;
import java.lang.*;

public class pali{
String cadena;

public pali(String cadena){
  this.cadena=cadena;
}

public boolean es_palindromo(){
  int fin=(cadena.length())-1;
  int inicio=0;
  boolean Errorc=false;

  while ((inicio<fin) && (!Errorc)){

  	if (cadena.charAt(inicio)==cadena.charAt(fin)){
  		inicio++;
  		fin--;
  	} else {
  		Errorc = true;
  	}
  }

  if (Errorc==false){
	System.out.println(cadena + " es un PALINDROMO");
  return false;
  }
  else{
	System.out.println(cadena + " NO es un palindromo");
  return true;
}
}
}
