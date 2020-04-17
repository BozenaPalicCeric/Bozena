/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Bozena
 */
@Entity

public class Zaposlenik extends Entitet {

    private String ime;
    private String prezime;
    private String oib;
    private String email;
    private Date datumZaposlenja;
    @ManyToOne
    private Zaposlenik nadredeni;
    private Integer brojDanaGoPremaUgovoruORadu;
    private String lozinka;

    @OneToMany(mappedBy = "zaposlenik")
    private List<GodisnjiOdmor> godisnjiOdmori = new ArrayList<>();

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

    public Zaposlenik getNadredeni() {
        return nadredeni;
    }

    public void setNadredeni(Zaposlenik nadredeni) {
        this.nadredeni = nadredeni;
    }

    public Integer getBrojDanaGoPremaUgovoruORadu() {
        return brojDanaGoPremaUgovoruORadu;
    }

    public void setBrojDanaGoPremaUgovoruORadu(Integer brojDanaGoPremaUgovoruORadu) {
        this.brojDanaGoPremaUgovoruORadu = brojDanaGoPremaUgovoruORadu;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public List<GodisnjiOdmor> getGodisnjiOdmori() {
        return godisnjiOdmori;
    }

    public void setGodisnjiOdmori(List<GodisnjiOdmor> godisnjiOdmori) {
        this.godisnjiOdmori = godisnjiOdmori;
    }

    @Override
    public String toString() {
        return getSifra() + ". " + getIme() + " " + getPrezime();
    }

}
