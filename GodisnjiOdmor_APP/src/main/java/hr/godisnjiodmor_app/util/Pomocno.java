/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hr.godisnjiodmor_app.controller.ObradaGodisnjiOdmor;
import hr.godisnjiodmor_app.controller.ObradaZaposlenik;
import hr.godisnjiodmor_app.model.GodisnjiOdmor;
import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.view.ViewZaposlenik;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Bozena
 */
public class Pomocno {

    public static Zaposlenik LOGIRAN;

    private final static DecimalFormat df = df();

    public static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static String getNazivAplikacije() {
        return "Godišnji odmor APP";
    }

    public static String getDatum(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(d);
    }

    public static Date getDatumIzStringa(String s) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            return formatter.parse(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getFormatCijelogBroja(long i) {

        DecimalFormat dfCijeliBroj = new DecimalFormat("#");
        return dfCijeliBroj.format(i);
    }

    public static int getCijeliBrojIzStringa(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }

    private static DecimalFormat df() {
        NumberFormat nf = NumberFormat.
                getNumberInstance(new Locale("hr", "HR"));
        DecimalFormat dfl = (DecimalFormat) nf;
        dfl.applyPattern("#,###.00");
        return dfl;
    }

    public static boolean isOibValjan(String oib) {

        if (oib == null) {
            return false;
        }

        if (oib.length() != 11) {
            return false;
        }

        try {
            Long.parseLong(oib);
        } catch (NumberFormatException e) {
            return false;
        }

        int a = 10;
        for (int i = 0; i < 10; i++) {
            a = a + Integer.parseInt(oib.substring(i, i + 1));
            a = a % 10;
            if (a == 0) {
                a = 10;
            }
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        if (kontrolni == 10) {
            kontrolni = 0;
        }

        return kontrolni == Integer.parseInt(oib.substring(10));
    }

    public static String getGenOIB() {

        try {
            URL u = new URL("http://oib.itcentrala.com/oib-generator/");
            InputStream in = u.openStream();
            String s = new String(in.readAllBytes(),
                    StandardCharsets.UTF_8);
            // System.out.println(s);
            int pocIndex = s.indexOf("<div class=\"oib\"><span>HR</span>") + 32;
            return s.substring(pocIndex, pocIndex + 11);
        } catch (Exception e) {
            return "";
        }

    }

    public static void pocetniInsert() {

        Zaposlenik zaposlenik = new Zaposlenik();
        zaposlenik.setEmail("bozena.palic@gmail.com");
        zaposlenik.setIme("Božena");
        zaposlenik.setPrezime("Palić Cerić");
        zaposlenik.setOib("18298417901");
        zaposlenik.setLozinka(BCrypt.hashpw("b", BCrypt.gensalt()));
        zaposlenik.setBrojDanaGoPremaUgovoruORadu(20);
        Calendar cb = Calendar.getInstance();
        cb.set(Calendar.YEAR, 2019);
        cb.set(Calendar.MONTH, 0);
        cb.set(Calendar.DAY_OF_MONTH, 1);
        zaposlenik.setDatumZaposlenja(cb.getTime());
        zaposlenik.setNadredeni(zaposlenik);

        ObradaZaposlenik obradaZaposlenik = new ObradaZaposlenik(zaposlenik);
        try {
            zaposlenik = obradaZaposlenik.create();
        } catch (GodisnjiException ex) {
            System.out.println(ex.getPoruka());
        }

        GodisnjiOdmor godisnjiOdmorb = new GodisnjiOdmor();
        godisnjiOdmorb.setZaposlenik(zaposlenik);
        Calendar cab = Calendar.getInstance();
        cab.set(Calendar.YEAR, 2020);
        cab.set(Calendar.MONTH, 1);
        cab.set(Calendar.DAY_OF_MONTH, 3);
        godisnjiOdmorb.setPocetakGodisnjiOdmor(cab.getTime());
        Calendar calb = Calendar.getInstance();
        calb.set(Calendar.YEAR, 2020);
        calb.set(Calendar.MONTH, 1);
        calb.set(Calendar.DAY_OF_MONTH, 14);
        godisnjiOdmorb.setKrajGodisnjiOdmor(calb.getTime());
        godisnjiOdmorb.setKoristenBrojDanaGo(10);
        godisnjiOdmorb.setGodina(2020);
        godisnjiOdmorb.setOdobrenjeNadredeni(true);

        ObradaGodisnjiOdmor obradaGodisnjiOdmorb = new ObradaGodisnjiOdmor(godisnjiOdmorb);
        try {
            obradaGodisnjiOdmorb.create();
        } catch (GodisnjiException ex) {
            System.out.println(ex.getPoruka());
        }

        Zaposlenik z = new Zaposlenik();
        z.setIme("Petar");
        z.setPrezime("Petrović");
        z.setOib("95647933683");
        z.setEmail("p.petrovic@gmail.com");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2019);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        z.setDatumZaposlenja(c.getTime());
        z.setBrojDanaGoPremaUgovoruORadu(20);
        z.setNadredeni(zaposlenik);

        ObradaZaposlenik oz = new ObradaZaposlenik(z);
        try {
            z = oz.create();
        } catch (GodisnjiException ex) {

            System.out.println(ex.getPoruka());
        }

        GodisnjiOdmor godisnjiOdmor = new GodisnjiOdmor();
        godisnjiOdmor.setZaposlenik(z);
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, 2020);
        ca.set(Calendar.MONTH, 1);
        ca.set(Calendar.DAY_OF_MONTH, 3);
        godisnjiOdmor.setPocetakGodisnjiOdmor(ca.getTime());
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 14);
        godisnjiOdmor.setKrajGodisnjiOdmor(cal.getTime());
        godisnjiOdmor.setKoristenBrojDanaGo(10);
        godisnjiOdmor.setGodina(2019);
        godisnjiOdmor.setOdobrenjeNadredeni(true);

        ObradaGodisnjiOdmor obradaGodisnjiOdmor = new ObradaGodisnjiOdmor(godisnjiOdmor);
        try {
            obradaGodisnjiOdmor.create();
        } catch (GodisnjiException ex) {
            System.out.println(ex.getPoruka());
        }

        //z.getGodisnjiOdmori().add(godisnjiOdmor);
        Zaposlenik zaposlenik1 = new Zaposlenik();
        zaposlenik1.setIme("Marko");
        zaposlenik1.setPrezime("Mikić");
        zaposlenik1.setOib("34778528808");
        zaposlenik1.setEmail("miki1@gmail.com");
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, 2019);
        c1.set(Calendar.MONTH, 0);
        c1.set(Calendar.DAY_OF_MONTH, 1);
        zaposlenik1.setDatumZaposlenja(c1.getTime());
        zaposlenik1.setBrojDanaGoPremaUgovoruORadu(20);
        zaposlenik1.setNadredeni(zaposlenik);

        obradaZaposlenik = new ObradaZaposlenik(zaposlenik1);
        try {
            zaposlenik1 = obradaZaposlenik.create();
        } catch (GodisnjiException ex) {
            System.out.println(ex.getPoruka());
        }

        GodisnjiOdmor godisnjiOdmor1 = new GodisnjiOdmor();
        godisnjiOdmor1.setZaposlenik(zaposlenik1);
        Calendar ca1 = Calendar.getInstance();
        ca1.set(Calendar.YEAR, 2020);
        ca1.set(Calendar.MONTH, 2);
        ca1.set(Calendar.DAY_OF_MONTH, 2);
        godisnjiOdmor1.setPocetakGodisnjiOdmor(ca1.getTime());
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.YEAR, 2020);
        cal1.set(Calendar.MONTH, 2);
        cal1.set(Calendar.DAY_OF_MONTH, 13);
        godisnjiOdmor1.setKrajGodisnjiOdmor(cal1.getTime());
        godisnjiOdmor1.setKoristenBrojDanaGo(10);
        godisnjiOdmor1.setGodina(2020);
        godisnjiOdmor1.setOdobrenjeNadredeni(true);

        ObradaGodisnjiOdmor obradaGodisnjiOdmor1 = new ObradaGodisnjiOdmor(godisnjiOdmor1);
        try {
            obradaGodisnjiOdmor1.create();
        } catch (GodisnjiException ex) {
            System.out.println(ex.getPoruka());
        }

        //zaposlenik1.getGodisnjiOdmori().add(godisnjiOdmor1);
    }

}
