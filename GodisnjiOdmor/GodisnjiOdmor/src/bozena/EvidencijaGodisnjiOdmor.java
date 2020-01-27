package bozena;

import java.time.LocalDate;
import java.time.Year;

public class EvidencijaGodisnjiOdmor extends GodisnjiOdmor {
	
	
	private Year godina;
	private int brojDanaGodisnjiOdmor;

	

	


	public EvidencijaGodisnjiOdmor(String sifra2, LocalDate unosPocetakGodisnjiOdmor, LocalDate unosKrajGodisnjiOdmor) {
		super(sifra2, unosPocetakGodisnjiOdmor, unosKrajGodisnjiOdmor);
	}


	public EvidencijaGodisnjiOdmor(String sifra, String ime, String prezime, String email, LocalDate datumZaposlenja,
			String sifra2, LocalDate pocetakGodisnjiOdmor, LocalDate krajGodisnjiOdmor, Year godina,
			int brojDanaGodisnjiOdmor) {
		super(sifra, ime, prezime, email, datumZaposlenja, sifra2, pocetakGodisnjiOdmor, krajGodisnjiOdmor);
		this.godina = godina;
		this.brojDanaGodisnjiOdmor = brojDanaGodisnjiOdmor;
	}


	public Year getGodina() {
		return godina;
	}
	public void setGodina(Year godina) {
		this.godina = godina;
	}
	public int getBrojDanaGodisnjiOdmor() {
		return brojDanaGodisnjiOdmor;
	}
	public void setBrojDanaGodisnjiOdmor(int brojDanaGodisnjiOdmor) {
		this.brojDanaGodisnjiOdmor = brojDanaGodisnjiOdmor;
	}

}
