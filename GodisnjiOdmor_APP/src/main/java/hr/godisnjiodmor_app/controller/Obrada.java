/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.controller;

import hr.godisnjiodmor_app.util.GodisnjiException;
import hr.godisnjiodmor_app.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bozena
 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected Session session;
    protected abstract void kontrolaCreate() throws GodisnjiException;
    protected abstract void kontrolaUpdate() throws GodisnjiException;
    protected abstract void kontrolaDelete() throws GodisnjiException;
    public abstract List<T> getPodaci();
    protected abstract void nakonSpremanja() throws GodisnjiException;
    
    
    public Obrada() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
     public Obrada(T entitet){
        this();
        this.entitet=entitet;
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }

    

    

    
    
    
    public T create() throws GodisnjiException{
        System.out.println(entitet);
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    public void createAll(List<T> lista) throws GodisnjiException{
    
        session.beginTransaction();
        for(T sl : lista){
            this.entitet=sl;
            kontrolaCreate();
            session.save(sl);
            nakonSpremanja();
        }
        session.getTransaction().commit();
        
        
    }
    
    public T update() throws GodisnjiException{
        kontrolaUpdate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    public boolean delete() throws GodisnjiException{
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
        return true;
    }
    
    private void save(){
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
    }
}