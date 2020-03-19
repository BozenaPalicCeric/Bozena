/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bozena
 */
@Entity
public class EvidencijaGodisnjiOdmor extends Entitet{
    
    private Integer godina;
    private Integer brojDanaGodisnjiOdmor;
    
    @ManyToOne
    private Zaposlenik zaposlenik;

    public Integer getGodina() {
        return godina;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    public Integer getBrojDanaGodisnjiOdmor() {
        return brojDanaGodisnjiOdmor;
    }

    public void setBrojDanaGodisnjiOdmor(Integer brojDanaGodisnjiOdmor) {
        this.brojDanaGodisnjiOdmor = brojDanaGodisnjiOdmor;
    }

    public Zaposlenik getZaposlenik() {
        return zaposlenik;
    }

    public void setZaposlenik(Zaposlenik zaposlenik) {
        this.zaposlenik = zaposlenik;
    }

    
}
