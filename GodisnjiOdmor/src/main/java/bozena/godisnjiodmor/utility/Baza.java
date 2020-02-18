/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bozena.godisnjiodmor.utility;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Božena
 */
public class Baza {
      private Connection veza;
    private static Baza baza;

    public Connection getVeza() {
        return veza;
    }
    private Baza(){
        try {
            veza = DriverManager.getConnection("jdbc:mariadb://localhost/godisnjiodmor?"
                    + "user=edunova&password=edunova&useUnicode=true&characterEncoding=UTF-8");
        
    
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Baza getInstanca(){
        if(baza==null){
            baza=new Baza();
        }
        return baza;
    }
}
