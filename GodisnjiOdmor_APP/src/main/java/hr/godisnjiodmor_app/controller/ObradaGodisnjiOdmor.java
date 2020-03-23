/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.controller;

import hr.godisnjiodmor_app.model.GodisnjiOdmor;
import hr.godisnjiodmor_app.util.GodisnjiException;
import java.util.List;

/**
 *
 * @author Bozena
 */
public class ObradaGodisnjiOdmor extends Obrada<GodisnjiOdmor> {

    public ObradaGodisnjiOdmor(GodisnjiOdmor entitet) {
        super(entitet);
    }

    public ObradaGodisnjiOdmor() {
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
    public List<GodisnjiOdmor> getPodaci() {
        return session.createQuery("from GodisnjiOdmor").list();
    }

    @Override
    protected void nakonSpremanja() throws GodisnjiException {
        
    }
    
    
    
}