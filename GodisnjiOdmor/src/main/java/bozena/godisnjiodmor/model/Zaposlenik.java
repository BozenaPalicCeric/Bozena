/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bozena.godisnjiodmor.model;

import java.util.Date;

/**
 *
 * @author Božena
 */
public class Zaposlenik {
    
    private int sifra;
    private String ime;
    private String prezime;
    private String oib;
    private String email;
    private Date datumzaposlenja;
    private Integer nadredeni;

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
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

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatumzaposlenja() {
        return datumzaposlenja;
    }

    public void setDatumzaposlenja(Date datumzaposlenja) {
        this.datumzaposlenja = datumzaposlenja;
    }

    public Integer getNadredeni() {
        return nadredeni;
    }

    public void setNadredeni(Integer nadredeni) {
        this.nadredeni = nadredeni;
    }
    
    

}