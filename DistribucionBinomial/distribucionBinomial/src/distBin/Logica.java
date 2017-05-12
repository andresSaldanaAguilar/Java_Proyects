package distBin;

/**
 * @author ANDRES
 */
public class Logica {

    double p, n, x;

    public Logica(double n, double x, double p) {
        this.n = n;
        this.x = x;
        this.p = p;
    }

    double factorial(double num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
    
    double Binomial(double n, double x, double p){
        double resultado;
        resultado=(factorial(n)/(factorial(x)*factorial(n-x)))*(Math.pow(p,x))*(Math.pow(1-p,n-x));
        return resultado;
    }
    
    double Sumatoria(){
        double aux=0,total=0;
        do{
            total=total+Binomial(n,aux,p);
            aux++;            
        }while(aux<=x);
        return total;
    }

    public static void main(String args[]) {
        Logica l=new Logica(5,4,0.20);
        System.out.print(l.Sumatoria());
    }
}
