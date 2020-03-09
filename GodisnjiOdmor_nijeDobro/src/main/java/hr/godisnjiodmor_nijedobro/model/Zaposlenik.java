/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_nijedobro.model;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Bozena
 */
@Entity
public class Zaposlenik extends Entitet{
    
    private String ime;
    private String prezime;
    private String oib;
    private String email;
    private Date datumZaposlenja;
    private Integer nadredeni;

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

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public Integer getNadredeni() {
        return nadredeni;
    }

    public void setNadredeni(Integer nadredeni) {
        this.nadredeni = nadredeni;
    }
    
    
}
