/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app;

import hr.godisnjiodmor_app.controller.ObradaZaposlenik;
import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.util.GodisnjiException;
import hr.godisnjiodmor_app.util.HibernateUtil;

/**
 *
 * @author Bozena
 */
public class Start {
    public Start () {
    
        //HibernateUtil.getSessionFactory().openSession();
       
        Zaposlenik zaposlenik=new Zaposlenik();
        zaposlenik.setOib("25406");
        
        ObradaZaposlenik obradaZaposlenik= new ObradaZaposlenik(zaposlenik);
        
        try {
            obradaZaposlenik.create();
        } catch (GodisnjiException ex) {
            System.out.println("Spremanje nije prošlo, razlog: ");
            System.out.println(ex.getPoruka());
        }
        
        
}
    public static void main(String[] args) {
        new Start();
    }
}
