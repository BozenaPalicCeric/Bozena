/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.controller;

import hr.godisnjiodmor_app.model.Operater;
import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.util.GodisnjiException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Bozena
 */
public class ObradaOperater extends ObradaZaposlenik {

    public ObradaOperater(Zaposlenik entitet) {
        super(entitet);
    }

    public ObradaOperater() {
    }
    
      public Operater autoriziraj(String email, String lozinka){
        
        List<Operater> lista = session.createQuery("from Operater o "
                + " where o.email=:email")
                .setParameter("email", email).list();
        if(lista==null || lista.isEmpty()){
            return null;
        }
        Operater o = lista.get(0);
        if(o==null){
            return null;
        }
        
        return BCrypt.checkpw(lozinka, o.getLozinka()) ? o : null;
    }
    
    
    @Override
    public List<Zaposlenik> getPodaci() {
         return session.createQuery("from Operater").list();
    }
    
    protected void kontrolaCreate() throws GodisnjiException {
       kontrolaEmail();
       kontrolaLozinka();
    }

    @Override
    protected void kontrolaUpdate() throws GodisnjiException {
        
    }

    @Override
    protected void kontrolaDelete() throws GodisnjiException {
        
    }

    @Override
    protected void nakonSpremanja() throws GodisnjiException {
        
    }

    private void kontrolaLozinka() throws GodisnjiException{
        if(entitet.getLozinka()()==null || entitet.getLozinka().trim().length()==0){
            throw new GodisnjiException("Obavezno lozinka");
        }
    }

    private void kontrolaEmail() throws GodisnjiException{
        
    }
    
}
    
 
