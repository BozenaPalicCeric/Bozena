/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.controller;

import hr.godisnjiodmor_app.model.GodisnjiOdmor;
import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.util.GodisnjiException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bozena
 */
public class ObradaGodisnjiOdmor extends Obrada<GodisnjiOdmor> {

    public ObradaGodisnjiOdmor(GodisnjiOdmor entitet) {
        super(entitet);
    }

    public ObradaGodisnjiOdmor() {
        super();
    }

    @Override
    protected void kontrolaCreate() throws GodisnjiException {
        kontrolaOdobrenjeNadredeni();
        kontrolaKoristeniGo();

    }

    @Override
    protected void kontrolaUpdate() throws GodisnjiException {
        kontrolaOdobrenjeNadredeni();
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

    private void kontrolaOdobrenjeNadredeni() throws GodisnjiException {
        if (entitet.getOdobrenjeNadredeni() == false) {
            throw new GodisnjiException("GO nije odobren");
        }
    }

    private void kontrolaKoristeniGo() throws GodisnjiException {

        Long zbroj = (Long) session.createQuery(" select coalesce( sum( g.koristenBrojDanaGo),0) from GodisnjiOdmor g "
                + " where g.zaposlenik.sifra= :zaposlenik"
                + " and g.godina= :godina")
                .setParameter("zaposlenik", entitet.getZaposlenik().getSifra())
                .setParameter("godina", entitet.getGodina())
                .getSingleResult();

        if (entitet.getZaposlenik().getBrojDanaGoPremaUgovoruORadu() < (zbroj + entitet.getKoristenBrojDanaGo())) {
            throw new GodisnjiException("Provjerite ukupan broj korištenih dana GO");
        }
    }
    
}
