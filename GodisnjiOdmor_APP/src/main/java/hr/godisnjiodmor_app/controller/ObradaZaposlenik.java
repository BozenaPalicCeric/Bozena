/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.controller;

import hr.godisnjiodmor_app.model.GodisnjiOdmor;
import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.util.GodisnjiException;
import hr.godisnjiodmor_app.util.Pomocno;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Bozena
 */
public class ObradaZaposlenik extends Obrada<Zaposlenik>{

    public ObradaZaposlenik(Zaposlenik entitet) {
        super(entitet);
    }

    public ObradaZaposlenik() {
    super();
    }
    
    public Zaposlenik autoriziraj(String email, String lozinka){
        
        List<Zaposlenik> lista = session.createQuery("from Zaposlenik z "
                + " where z.email=:email")
                .setParameter("email", email).list();
        if(lista==null || lista.isEmpty()){
            return null;
        }
        Zaposlenik z = lista.get(0);
        if(z==null){
            return null;
        }
        
        return BCrypt.checkpw(lozinka, z.getLozinka()) ? z : null;
    }
    

    @Override
    protected void kontrolaCreate() throws GodisnjiException {
        kontrolaOib();
        kontrolaEmail();
        //kontrolaLozinka();
        kontrolaIstiOib();
        
        
    }

    @Override
    protected void kontrolaUpdate() throws GodisnjiException {
        
    }

    @Override
    protected void kontrolaDelete() throws GodisnjiException {
        if(!entitet.getGodisnjiOdmori().isEmpty()){
          String s="";
          for (GodisnjiOdmor g : entitet.getGodisnjiOdmori()) {
              s+=g.getPocetakGodisnjiOdmor() + ", ";
          }
          s=s.substring(0,s.length()-2);
          throw new GodisnjiException("Zaposlenik se ne može obrisati jer na njemu postoje vezani podaci: \n"+s);
      }
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

    private void kontrolaIstiOib() throws GodisnjiException {
     Long ukupno = (Long)session
            .createQuery(" select count(z) from Zaposlenik z "
                    + " where z.oib=:oib")
              .setParameter("oib", entitet.getOib())
              .uniqueResult();
      if(ukupno>0){
          throw  new GodisnjiException("U bazi postoji isti OIB, provjerite zaposlenika");
      }   
    }

    private void kontrolaLozinka() throws GodisnjiException{
        if(entitet.getLozinka()==null || entitet.getLozinka().trim().length()==0){
            throw new GodisnjiException("Obavezno lozinka"); 
        }
    }

   

    

}
