package prodotto_scalare;

/**
 * @author gubbriaco
 */
public class Main {


    public static void main(String...strings){

        //inizializzo gli array
        int[] a={4,7,1,8,2,1,2,1,3,9,1,4,10,150,65,16}, b={9,3,5,5,2,6,5,9,1,43,11,98,12,32,5,16};

        //controllo se sono della medesima lunghezza n come richiede la traccia
        if(a.length!=b.length)
            throw new RuntimeException("Array di lunghezza diversa.");
        else{

            int N=a.length;
            int M=4;

            //controllo se N è multiplo di M come richiede la traccia
            if(N%M!=0)
                throw new RuntimeException("N non è multiplo di M");
            else{

                //inizializzo un array che conterrà tutti i prodotti calcolati
                ProdottoScalare[] prodotti=new ProdottoScalare[M];

                int porzione = N/M;
                int inizio=0,fine=porzione;

                for(int i=0;i<M;++i){
                    prodotti[i] = new ProdottoScalare(inizio,fine,a,b);
                    prodotti[i].start();

                    inizio=inizio+porzione;
                    fine=fine+porzione;
                }

                //calcolo i risultati dei rispettivi prodotti
                int risultato=0;
                for(int i=0;i<M;++i)
                    risultato = risultato+prodotti[i].getRisultato();


                print(a); System.out.print(" * "); print(b);
                System.out.print(" = " + risultato);

            }//else

        }//else

    }//main


    /**
     *
     * @param array
     */
    private static void print(int[] array){
        System.out.print("[");
        for(int i=0;i<array.length;++i){
            if(i==array.length-1){
                System.out.print(array[i]); System.out.print("]");
            }
            else System.out.print(array[i]+",");
        }
    }

}
