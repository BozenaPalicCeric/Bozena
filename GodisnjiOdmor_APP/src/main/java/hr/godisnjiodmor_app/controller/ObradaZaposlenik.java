/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.controller;

import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.util.GodisnjiException;
import hr.godisnjiodmor_app.util.Pomocno;
import java.util.List;

/**
 *
 * @author Bozena
 */
public class ObradaZaposlenik extends Obrada<Zaposlenik>{

    public ObradaZaposlenik(Zaposlenik entitet) {
        super(entitet);
    }

    public ObradaZaposlenik() {
    }

    @Override
    protected void kontrolaCreate() throws GodisnjiException {
        kontrolaOib();
        kontrolaEmail();
    }

    @Override
    protected void kontrolaUpdate() throws GodisnjiException {
        
    }

    @Override
    protected void kontrolaDelete() throws GodisnjiException {
        
    }

    @Override
    public List<Zaposlenik> getPodaci() {
        return session.createQuery("from Zaposlenik").list();
    }

    @Override
    protected void nakonSpremanja() throws GodisnjiException {
       
    }

    private void kontrolaOib() throws GodisnjiException{
        if(!Pomocno.isOibValjan(entitet.getOib())){
            throw new GodisnjiException("OIB nije valjan");
    }

    }

    private void kontrolaEmail() {
        
    }

}
