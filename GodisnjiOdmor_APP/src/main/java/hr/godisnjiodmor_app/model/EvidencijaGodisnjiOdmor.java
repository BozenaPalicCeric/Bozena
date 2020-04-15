/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Bozena
 */
@Entity
public class EvidencijaGodisnjiOdmor extends Entitet{
    
    
    private Integer preostaliBrojDanaGodisnjiOdmor;
    
    @ManyToOne
    private Zaposlenik zaposlenik;
    
    @OneToMany(mappedBy = "evidencijaGodisnjiOdmor")
    private List<GodisnjiOdmor> godisnjiOdmori=new ArrayList<>();

    public Integer getPreostaliBrojDanaGodisnjiOdmor() {
        return preostaliBrojDanaGodisnjiOdmor;
    }

    public void setPreostaliBrojDanaGodisnjiOdmor(Integer preostaliBrojDanaGodisnjiOdmor) {
        this.preostaliBrojDanaGodisnjiOdmor = preostaliBrojDanaGodisnjiOdmor;
    }

    public Zaposlenik getZaposlenik() {
        return zaposlenik;
    }

    public void setZaposlenik(Zaposlenik zaposlenik) {
        this.zaposlenik = zaposlenik;
    }

    public List<GodisnjiOdmor> getGodisnjiOdmori() {
        return godisnjiOdmori;
    }

    public void setGodisnjiOdmori(List<GodisnjiOdmor> godisnjiOdmori) {
        this.godisnjiOdmori = godisnjiOdmori;
    }
    
   
    

    @Override
    public String toString() {
        return getZaposlenik().getSifra()+ "." + getZaposlenik().getIme() + " " + getZaposlenik().getPrezime();
    }

    
    
}
