/*Crea un programma per la gestione di un controcorrente gestito dalla classe CC.
Il programma deve essere in grado di effettuare versamenti, prelievi, di restituire il saldo e di effettuare la lista dei primi 5 prelievi.

1)	Versamento
2)	Prelievo
3)	Saldo
4)  Lista primi 5 prelievi (per chi riesce a lavorare con gli array)
5)	Uscita*/
import java.util.Scanner;
public class Cc {

	public  static int versamento(int saldo,int ammontare){
		saldo=saldo+ammontare;
		return saldo;
		
	}
	
	public static int prelievo(int saldo,int ammontare,int array[],int conta){
	
		conta=conta-1;
		if(conta<=4) 
		array[conta]=ammontare;	
		saldo=saldo-ammontare;
		return saldo;
	}
	
	public static void stampaSaldo(int saldo)
	{
		System.out.println("Saldo disponibile: "+saldo);
	}
	
	public static void stampaPrimiPrelievi(int array[])
	{
		int i;
		for(i=0;i<array.length;i++)
			System.out.println(array[i]);
	}
	public static void main(String[] args) {
		int saldo=0,scelta,ammontare,conta=0,array[]=new int[5];
		array[0]=0;
		array[1]=0;
		array[2]=0;
		array[3]=0;
		array[4]=0;
		Scanner inserimento=new Scanner(System.in);
		do {
			System.out.println("Inserire 1 per versare soldi sul conto");
			System.out.println("Inserire 2 per prelevare soldi dal conto");
			System.out.println("Inserire 3 per stampare il saldo");
			System.out.println("Inserire 4 per visualizzare i primi 5 prelivi");
			System.out.println("Inserire 5 per terminare il programma");
			scelta=inserimento.nextInt();
			switch(scelta) {
			case 1:
				System.out.println("Inserire l'ammontare del versamento");
				ammontare=inserimento.nextInt();
				saldo=versamento(saldo,ammontare);
				break;
			case 2:
				if(saldo!=0) {
					System.out.println("Inserire l'ammontare del prelievo");
					ammontare=inserimento.nextInt();
					if(saldo-ammontare>=0) {
						conta++;
				saldo=prelievo(saldo,ammontare,array,conta);
					}else {
						System.out.println("Saldo non sufficiente al prelievo");
					stampaSaldo(saldo);
					}
				}else
					System.out.println("Non sono presenti soldi sul conto");
				break;
			case 3:
				stampaSaldo(saldo);
				break;
			case 4:
				stampaPrimiPrelievi(array);
				break;
			}
		}while(scelta!=5);
		
	}

}