package bozena;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Start {

	public static void main(String[] args) {
		Scanner skener = new Scanner(System.in);
		
		String sifra,ime,prezime,email;
		String datumZaposlenja= null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		LocalDate datumZaposlenjaZaposlenika;
		
		Zaposlenik[] zaposlenici = new Zaposlenik[2];

		for (int i = 0; i < 2; i++) {
		
			System.out.println("Unesite šifru zaposlenika: ");
			sifra = skener.next();
			System.out.println("Unesite ime zaposlenika: ");
			ime = skener.next();
			System.out.println("Unesite prezime zaposlenika: ");
			prezime = skener.next();
			System.out.println("Unesite email zaposlenika u formatu ime.prezime@mail.com: ");
			email = skener.next();
			System.out.println("Unesite datum zaposlenja zaposlenika u formatu(\"dd.MM.yyyy.\"): ");
			datumZaposlenja = skener.next();
			datumZaposlenjaZaposlenika=LocalDate.parse(datumZaposlenja, formatter);
			zaposlenici[i] = new Zaposlenik(sifra,ime,prezime,email,datumZaposlenjaZaposlenika);
			
		
		}
		String sifra2;
		String pocetakGodisnjiOdmor=null;
		String krajGodisnjiOdmor=null;
		LocalDate unosPocetakGodisnjiOdmor;
		LocalDate unosKrajGodisnjiOdmor;
		DateTimeFormatter formatter1= DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		DateTimeFormatter formatter2= DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		GodisnjiOdmor [] godisnjiOdmori= new GodisnjiOdmor [2];
		
		for (int i=0; i<2; i++) {
			
			System.out.println("Unesite šifru zaposlenika: ");
			sifra2 = skener.next();
			System.out.println("Unesite poèetak godišnjeg odmora zaposlenika u formatu(\"dd.MM.yyyy.\"): ");
			pocetakGodisnjiOdmor = skener.next();
			System.out.println("Unesite zadnji dan godišnjeg odmora zaposlenika u formatu(\"dd.MM.yyyy.\"): ");
			krajGodisnjiOdmor = skener.next();
			unosPocetakGodisnjiOdmor=LocalDate.parse(pocetakGodisnjiOdmor, formatter1);
			unosKrajGodisnjiOdmor=LocalDate.parse(krajGodisnjiOdmor, formatter2);
			godisnjiOdmori [i]= new GodisnjiOdmor(sifra2, unosPocetakGodisnjiOdmor, unosKrajGodisnjiOdmor);
			
		}
		
		skener.close ();
		
	}
		

}
