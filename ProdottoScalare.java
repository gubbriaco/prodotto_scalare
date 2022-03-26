package prodotto_scalare;

import java.util.Arrays;

/**
 * @author gubbriaco
 */
public class ProdottoScalare extends Thread {

    private final int inizio, fine;
    private int[] a, b;
    private int risultato;

    public ProdottoScalare(int inizio, int fine, int[] a, int[] b){
        this.inizio=inizio;
        this.fine=fine;
        this.a= Arrays.copyOf(a,a.length);
        this.b=Arrays.copyOf(b,b.length);
        risultato=0;
    }


    @Override public void run(){

        for(int i=inizio;i<fine;++i)
            risultato = risultato + a[i]*b[i];

    }


    public int getRisultato(){

        try{
            this.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Il risultato del " + this.getName() + " è " + risultato);

        return risultato;

    }

}
