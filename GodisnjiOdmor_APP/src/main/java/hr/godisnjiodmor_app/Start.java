/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app;

import hr.godisnjiodmor_app.controller.ObradaGodisnjiOdmor;
import hr.godisnjiodmor_app.controller.ObradaZaposlenik;
import hr.godisnjiodmor_app.model.GodisnjiOdmor;
import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.util.GodisnjiException;
import hr.godisnjiodmor_app.util.HibernateUtil;
import hr.godisnjiodmor_app.util.Pomocno;
import hr.godisnjiodmor_app.view.SplashScreen;

/**
 *
 * @author Bozena
 */
public class Start {

    public Start() {

        new SplashScreen().setVisible(true);
        //System.out.println(Pomocno.getGenOIB());

       //Pomocno.pocetniInsert();
    }

    public static void main(String[] args) {
        new Start();
    }
}
