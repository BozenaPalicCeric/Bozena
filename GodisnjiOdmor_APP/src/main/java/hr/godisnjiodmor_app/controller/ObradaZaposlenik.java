/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.controller;

import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.util.GodisnjiException;
import hr.godisnjiodmor_app.util.Pomocno;

/**
 *
 * @author Bozena
 */
public class ObradaZaposlenik <T extends Zaposlenik> extends Obrada<T>{

    public ObradaZaposlenik(T entitet) {
        super(entitet);
    }

    @Override
    protected void kontrolaCreate() throws GodisnjiException {
        kontrolaOib();
    }

    @Override
    protected void kontrolaUpdate() throws GodisnjiException {
       
    }

    @Override
    protected void kontrolaDelete() throws GodisnjiException {
        
    }

    private void kontrolaOib() throws GodisnjiException{
        if(!Pomocno.isOibValjan(entitet.getOib())) {
            throw new GodisnjiException("OIB nije valjan");
        }
    }
    
}
