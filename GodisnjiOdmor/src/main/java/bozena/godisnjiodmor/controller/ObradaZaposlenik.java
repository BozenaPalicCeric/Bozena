/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bozena.godisnjiodmor.controller;

import bozena.godisnjiodmor.model.Zaposlenik;
import bozena.godisnjiodmor.utility.Baza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Božena
 */
public class ObradaZaposlenik {
    public List<Zaposlenik> getZaposlenici () {
        List <Zaposlenik> vrati = new ArrayList<> ();
        Connection veza = Baza.getInstanca().getVeza();
        try {
            PreparedStatement izraz= veza.prepareStatement("select * from zaposlenik");
            ResultSet rs= izraz.executeQuery();
            Zaposlenik z;
            while (rs.next()) {
                z= new Zaposlenik();
                z.setSifra(rs.getInt("sifra"));
                z.setIme(rs.getString("ime"));
                z.setPrezime(rs.getString("prezime"));
                z.setOib(rs.getString("oib"));
                z.setEmail(rs.getString("email"));
                z.setDatumzaposlenja(rs.getDate("datumzaposlenja"));
                z.setNadredeni(rs.getInt("nadredeni"));
                vrati.add(z);
            }
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vrati;
    


}
}
