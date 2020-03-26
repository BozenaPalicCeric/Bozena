/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.util;

import hr.godisnjiodmor_app.controller.ObradaEvidencijaGodisnjiOdmor;
import hr.godisnjiodmor_app.controller.ObradaGodisnjiOdmor;
import hr.godisnjiodmor_app.controller.ObradaOperater;
import hr.godisnjiodmor_app.controller.ObradaZaposlenik;
import hr.godisnjiodmor_app.model.EvidencijaGodisnjiOdmor;
import hr.godisnjiodmor_app.model.GodisnjiOdmor;
import hr.godisnjiodmor_app.model.Operater;
import hr.godisnjiodmor_app.model.Zaposlenik;
import java.util.Date;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Bozena
 */


public class Pomocno {
    
    public static Operater LOGIRAN;
    
    
     public static String getNazivAplikacije(){
        return "Edunova APP";
    }
    
    public static boolean isOibValjan(String oib) {
        
        if(oib==null){
            return false;
        }
            
            

        if (oib.length() != 11)
            return false;

        try {
            Long.parseLong(oib);
        } catch (NumberFormatException e) {
            return false;
        }

        int a = 10;
        for (int i = 0; i < 10; i++) {
            a = a + Integer.parseInt(oib.substring(i, i+1));
            a = a % 10;
            if (a == 0)
                a = 10;
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        if (kontrolni == 10)
            kontrolni = 0;

        return kontrolni == Integer.parseInt(oib.substring(10));
    }

    public static void pocetniInsert() {
        
        Operater operater= new Operater();
        operater.setEmail("bozena.palic@gmail.com");
        operater.setIme("Božena");
        operater.setPrezime("Palić Cerić");
        operater.setLozinka(BCrypt.hashpw("b", BCrypt.gensalt()));
        
        ObradaOperater obradaOperater = new ObradaOperater(operater);
        try {
            obradaOperater.create();
        } catch (GodisnjiException ex) {
            System.out.println(ex.getPoruka());
        }
        
        Zaposlenik  zaposlenik= new Zaposlenik();
        zaposlenik.setIme("Pero");
        zaposlenik.setPrezime("Petrović");
        zaposlenik.setOib("95647933683");
        zaposlenik.setEmail("p.petrovic@gmail.com");
        zaposlenik.setDatumZaposlenja(new Date());
        zaposlenik.setNadredeni(1);
        
        ObradaZaposlenik obradaZaposlenik= new ObradaZaposlenik(zaposlenik);
        try {
            obradaZaposlenik.create();
        } catch (GodisnjiException ex) {
            
            System.out.println(ex.getPoruka());
        }
        
        GodisnjiOdmor godisnjiOdmor= new GodisnjiOdmor();
        godisnjiOdmor.setZaposlenik(zaposlenik);
        godisnjiOdmor.setPocetakGodisnjiOdmor(new Date());
        godisnjiOdmor.setKrajGodisnjiOdmor(new Date());
        
        
        ObradaGodisnjiOdmor obradaGodisnjiOdmor= new ObradaGodisnjiOdmor(godisnjiOdmor);
        try {
            obradaGodisnjiOdmor.create();
        } catch (GodisnjiException ex) {
            System.out.println(ex.getPoruka());
        }
        
        EvidencijaGodisnjiOdmor ego=new EvidencijaGodisnjiOdmor();
        ego.setGodina(2020);
        ego.setZaposlenik(zaposlenik);
        ego.setBrojDanaGodisnjiOdmor(20);
        
        ObradaEvidencijaGodisnjiOdmor oego= new ObradaEvidencijaGodisnjiOdmor(ego);
        
        try {
            oego.create();
        } catch (GodisnjiException ex) {
            System.out.println(ex.getPoruka());
        }
    }

}
