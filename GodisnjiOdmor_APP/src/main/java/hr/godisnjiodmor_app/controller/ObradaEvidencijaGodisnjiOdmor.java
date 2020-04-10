/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.controller;

import hr.godisnjiodmor_app.model.EvidencijaGodisnjiOdmor;
import hr.godisnjiodmor_app.util.GodisnjiException;
import java.util.List;

/**
 *
 * @author Bozena
 */
public class ObradaEvidencijaGodisnjiOdmor extends Obrada<EvidencijaGodisnjiOdmor>{

    public ObradaEvidencijaGodisnjiOdmor(EvidencijaGodisnjiOdmor entitet) {
        super(entitet);
    }

    public ObradaEvidencijaGodisnjiOdmor() {
    super();
    }

    
    @Override
    protected void kontrolaCreate() throws GodisnjiException {
        
    }

    @Override
    protected void kontrolaUpdate() throws GodisnjiException {
        
    }

    @Override
    protected void kontrolaDelete() throws GodisnjiException {
        
    }

    @Override
    public List<EvidencijaGodisnjiOdmor> getPodaci() {
        return session.createQuery("from EvidencijaGodisnjiOdmor").list();
    }

    @Override
    protected void nakonSpremanja() throws GodisnjiException {
        
    }
    
    
}
