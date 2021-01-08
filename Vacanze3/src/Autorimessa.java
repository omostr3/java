/*
 Progettare una classe Autorimessa che rappresenta un�autorimessa per automobili. Gli attributi
che caratterizzano tale classe sono:
� il numero posti disponibili;
� il nome dell�autorimessa;
� un arraylist che conterr� le targhe delle auto parcheggiate.
La classe deve avere un costruttore parametrico che inizializza il numero di posti disponibili ed il
nome autorimessa e crea un arraylist vuoto.
Devono inoltre essere presenti i metodi che consentono di:
� parcheggiare un�auto (attenzione verificare che ci siano posti liberi e, dopo ogni
parcheggio, decrementare il numero di posti disponibili) passando la targa come
parametro;
� ritirare un�auto (incrementando il numero di posti disponibili) passando la targa come
parametro; se la targa non esiste nell�arraylist dare opportuno messaggio;
� stampare il numero di posti ancora liberi.
Suggerimento: memorizzare il numero totale di posti dell�autorimessa in una costante.
Variante: verificare che le auto che vengono parcheggiate abbiano numeri di targa differenti.
Testare tutti i metodi scritti su un oggetto di tipo Autorimessa.
 */
import java.util.*;
public class Autorimessa {
 private int posti;
 private String nome;
 private ArrayList <String> targhe;
 private final int pmax=10;
    public Autorimessa() {
    	this.posti=0;
    	this.nome="";
    	this.targhe=new ArrayList<String>();
    	}
    
    public void setPosti(int posti) {
    	this.posti=posti;
    }
    public void setNome(String nome) {
    	this.nome=nome;
    }
    
    public boolean aggiungiAuto(String targa) {
    	boolean controllo;
    	if(this.posti+1<=this.pmax) {
    	if(this.targhe.isEmpty()==true) {
    		this.targhe.add(targa);
    		this.posti+=1;
    		return true;
    	}
    	else {
    		controllo=this.controllo(targa);
    		if(controllo==false) {
    			this.targhe.add(targa);
        		this.posti-=1;
    			return true;
    	}else
    		return false;	
    }
    }else  	
    	return false;
  }
    
    public boolean controllo(String targa) {
    	for(int i=0;i<this.targhe.size();i++) 
    		 if(this.targhe.get(i)==targa)
    			 return true;
    	return false;
    }
    
    public boolean rimuoviAuto(String targa) {
    	if(this.targhe.isEmpty()==true)
    		return false;
    	else {
     	 for(int i=0;i<this.targhe.size();i++) 
     		 if(this.targhe.get(i).equals(targa)) {
     			 this.targhe.remove(i);	
     			 this.posti+=1;
     			 return true;
     		 }
     	 }
		return false;
    }
    
    public int getPostiLiberi() {
    	return (this.pmax-this.posti);
    }
    
	public static void main(String[] args) {
		Autorimessa autor;
		int posti,scelta;
		String nome,targa;
		boolean controllo;
		Scanner input=new Scanner(System.in);
		autor=new Autorimessa();
        System.out.println("Qual � il nome?");
        nome=input.next();
        autor.setNome(nome);
        do {
        	System.out.println("Inserire 1 per aggiungere un'auto,2 per ritirarne una,3 per stampare il numero di posti liberi, 4 per terminare");
        	scelta=input.nextInt();
        	switch(scelta) {
        	case 1:
        		System.out.println("Inserire la targa");
        		targa=input.next();
        		controllo=autor.aggiungiAuto(targa);
        		if(controllo==false)
        			System.out.println("Impossibile aggiungere");
        		break;
        	case 2:
        		System.out.println("Inserire la targa");
        		targa=input.next();
        		controllo=autor.rimuoviAuto(targa);
        		if(controllo==false)
        			System.out.println("Auto non presente");
        		break;
        	case 3:
        		System.out.println("Posti liberi "+autor.getPostiLiberi());
        		break;
        	}
        }while(scelta!=4);
	}

}
