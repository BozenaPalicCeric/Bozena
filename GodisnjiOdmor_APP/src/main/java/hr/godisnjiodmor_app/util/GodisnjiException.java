/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.util;

/**
 *
 * @author Bozena
 */
public class GodisnjiException extends Exception{
    private String poruka;

  public GodisnjiException (String poruka) {
      this.poruka=poruka;
  }

    public String getPoruka() {
        return poruka;
    }
  
    
}
