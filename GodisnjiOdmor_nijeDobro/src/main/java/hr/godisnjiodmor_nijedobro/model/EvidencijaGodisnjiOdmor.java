/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_nijedobro.model;

import java.time.Year;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bozena
 */
@Entity
public class EvidencijaGodisnjiOdmor extends Entitet{
    
    private Year godina;
    private Integer brojDanaGodisnjiOdmor;
    
    @ManyToOne
    private Zaposlenik zaposlenik;

    public Year getGodina() {
        return godina;
    }

    public void setGodina(Year godina) {
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
