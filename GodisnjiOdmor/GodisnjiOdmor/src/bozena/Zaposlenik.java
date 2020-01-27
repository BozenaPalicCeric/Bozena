package bozena;

import java.time.LocalDate;


public class Zaposlenik {
	private String sifra;
	private String ime;
	private String prezime;
	private String email;
	private LocalDate datumZaposlenja;
	
	
	public Zaposlenik() {
		super();
	}
	
	
	public Zaposlenik(String sifra, String ime, String prezime, String email, LocalDate datumZaposlenja) {
		super();
		this.sifra = sifra;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.datumZaposlenja = datumZaposlenja;
	}


	public Zaposlenik(int ucitajInt, String ucitajString, String ucitajString2, String string) {
		// TODO Auto-generated constructor stub
	}


	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDatumZaposlenja() {
		return datumZaposlenja;
	}
	public void setDatumZaposlenja(LocalDate datumZaposlenja) {
		this.datumZaposlenja = datumZaposlenja;
	}
	
	

}
