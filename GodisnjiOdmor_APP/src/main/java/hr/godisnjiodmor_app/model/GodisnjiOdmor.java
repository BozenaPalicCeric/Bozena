/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;



/**
 *
 * @author Bozena
 */
@Entity
public class GodisnjiOdmor extends Entitet{
    
    
    
    private Date pocetakGodisnjiOdmor;
    
    
    private Date krajGodisnjiOdmor;
    private Boolean odobrenjeNadredeni;
    
@ManyToOne
private Zaposlenik zaposlenik;

    public Date getPocetakGodisnjiOdmor() {
        return pocetakGodisnjiOdmor;
    }

    public void setPocetakGodisnjiOdmor(Date pocetakGodisnjiOdmor) {
        this.pocetakGodisnjiOdmor = pocetakGodisnjiOdmor;
    }

    public Date getKrajGodisnjiOdmor() {
        return krajGodisnjiOdmor;
    }

    public void setKrajGodisnjiOdmor(Date krajGodisnjiOdmor) {
        this.krajGodisnjiOdmor = krajGodisnjiOdmor;
    }

    public Boolean getOdobrenjeNadredeni() {
        return odobrenjeNadredeni;
    }

    public void setOdobrenjeNadredeni(Boolean odobrenjeNadredeni) {
        this.odobrenjeNadredeni = odobrenjeNadredeni;
    }

    public Zaposlenik getZaposlenik() {
        return zaposlenik;
    }

    public void setZaposlenik(Zaposlenik zaposlenik) {
        this.zaposlenik = zaposlenik;
    }

    
    
   
}
