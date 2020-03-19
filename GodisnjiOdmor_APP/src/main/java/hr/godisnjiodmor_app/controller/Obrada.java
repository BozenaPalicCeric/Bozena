/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.controller;

import hr.godisnjiodmor_app.util.GodisnjiException;
import hr.godisnjiodmor_app.util.HibernateUtil;
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
    
    public Obrada(T entitet){
        this.entitet=entitet;
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public T create() throws GodisnjiException{
        kontrolaCreate();
        return save();
    }
    
    public T update() throws GodisnjiException{
        kontrolaUpdate();
        return save();
    }
    
    public boolean delete() throws GodisnjiException{
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
        return true;
    }
    
    private T save(){
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
        return entitet;
    }
      
}
