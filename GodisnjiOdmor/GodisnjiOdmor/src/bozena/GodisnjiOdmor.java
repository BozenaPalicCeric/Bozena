package bozena;

import java.time.LocalDate;


public class GodisnjiOdmor extends Zaposlenik {
	
	private String sifra;
	private LocalDate pocetakGodisnjiOdmor;
	private LocalDate krajGodisnjiOdmor;
	


	public GodisnjiOdmor(String sifra2, LocalDate unosPocetakGodisnjiOdmor, LocalDate unosKrajGodisnjiOdmor) {
		super();
	}




	public GodisnjiOdmor(String sifra, String ime, String prezime, String email, LocalDate datumZaposlenja,
			String sifra2, LocalDate pocetakGodisnjiOdmor, LocalDate krajGodisnjiOdmor) {
		super(sifra, ime, prezime, email, datumZaposlenja);
		sifra = sifra2;
		this.pocetakGodisnjiOdmor = pocetakGodisnjiOdmor;
		this.krajGodisnjiOdmor = krajGodisnjiOdmor;
	}






	public LocalDate getPocetakGodisnjiOdmor() {
		return pocetakGodisnjiOdmor;
	}
	public void setPocetakGodisnjiOdmor(LocalDate pocetakGodisnjiOdmor) {
		this.pocetakGodisnjiOdmor = pocetakGodisnjiOdmor;
	}
	public LocalDate getKrajGodisnjiOdmor() {
		return krajGodisnjiOdmor;
	}
	public void setKrajGodisnjiOdmor(LocalDate krajGodisnjiOdmor) {
		this.krajGodisnjiOdmor = krajGodisnjiOdmor;
	}




	public String getSifra() {
		return sifra;
	}




	public void setSifra(String sifra) {
		this.sifra = sifra;
	}


	

}
