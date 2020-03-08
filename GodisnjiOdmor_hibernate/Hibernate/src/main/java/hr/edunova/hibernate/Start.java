/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.hibernate;

import hr.edunova.hibernate.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Profesor
 */
public class Start {
    
    public Start(){
        HibernateUtil.getSessionFactory().openSession();
        /*
        Osoba o = new Osoba();
        o.setIme("Pero");
        o.setPrezime("čšćđžČŠĆĐŽ");
        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(o);
        s.getTransaction().commit();
        s.close();
        HibernateUtil.shutdown();
        */
        
    }
    
    public static void main(String[] args) {
        new Start();
    }
    
}
