import java.util.*; //Usato per importare il package contenente la classe Scanner
public class Calcolatrice {
 public static void main(String[] Args)
 {
	 int n1,n2,scelta;
	 float risultato;
	 Scanner intero=new Scanner(System.in);
	 System.out.println("Inserire il primo numero");
	 n1=intero.nextInt();
	 System.out.println("Inserire il secondo numero");
	 n2=intero.nextInt();
	 System.out.println("Inserire 1 per la somma");
	 System.out.println("Inserire 2 per la differenza");
	 System.out.println("Inserire 3 per la moltiplicazione");
	 System.out.println("Inserire 4 per la divisione");
	 scelta=intero.nextInt();
	 if(scelta==1)
	 {
	  risultato=n1+n2;
	  System.out.println(risultato);
	 }
	 else if(scelta==2)
	 {
		 risultato=n1-n2;
		  System.out.println(risultato);
	 }
	 else if(scelta==3)
	 {
		 risultato=n1*n2;
		  System.out.println(risultato);
	 }
	 else if(scelta==4)
	 {
		 risultato=(float)n1/n2;
		  System.out.println(risultato);
	 }
	 else
	 {
		 System.out.println("Errore nell'inserimento");
	 }
 }
}