/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import hr.godisnjiodmor_app.controller.ObradaGodisnjiOdmor;
import hr.godisnjiodmor_app.controller.ObradaZaposlenik;
import hr.godisnjiodmor_app.model.GodisnjiOdmor;
import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.util.GodisnjiException;
import hr.godisnjiodmor_app.util.Pomocno;
import java.util.Date;
import java.util.Locale;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Bozena
 */
public class ViewGodisnjiOdmor extends javax.swing.JFrame {

    private final ObradaGodisnjiOdmor obrada;

    /**
     * Creates new form ViewGodisnjiOdmor
     */
    public ViewGodisnjiOdmor() {
        initComponents();
        obrada = new ObradaGodisnjiOdmor();
        ucitajZaposlenike();
        obrada.setEntitet(new GodisnjiOdmor());
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy.");
        DatePickerSettings dpk = new DatePickerSettings(new Locale("hr", "HR"));
        dpk.setFormatForDatesCommonEra("dd.MM.yyyy.");
        dpDatumPocetkaGo.setSettings(dps);
        dpDatumKrajaGo.setSettings(dpk);

    }

    private void ucitajZaposlenike() {
        DefaultComboBoxModel<Zaposlenik> m = new DefaultComboBoxModel<>();
        new ObradaZaposlenik().getPodaci().forEach(z -> m.addElement(z));
        cmbZaposlenik.setModel(m);
    }

    private void ucitaj() {
        DefaultListModel<GodisnjiOdmor> m = new DefaultListModel<>();
        obrada.getPodaci().forEach(godisnjiOdmor -> m.addElement(godisnjiOdmor));
        lstPodaci.setModel(m);
    }

    private void ucitajVrijednosti() {
        obrada.getEntitet().setGodina(Pomocno.getCijeliBrojIzStringa(txtGodina.getText()));

        if (dpDatumPocetkaGo.getDate() != null) {
            Date dp = Pomocno.convertToDateViaInstant(dpDatumPocetkaGo.getDate());
            obrada.getEntitet().setPocetakGodisnjiOdmor(dp);
        }

        //obrada.getEntitet().setPocetakGodisnjiOdmor(Pomocno.getDatumIzStringa(txtPocetakGodisnjiOdmor.getText()));
        //obrada.getEntitet().setKrajGodisnjiOdmor(Pomocno.getDatumIzStringa(txtKrajGodisnjiOdmor.getText()));
        if (dpDatumKrajaGo.getDate() != null) {
            Date dk = Pomocno.convertToDateViaInstant(dpDatumKrajaGo.getDate());
            obrada.getEntitet().setKrajGodisnjiOdmor(dk);
        }

        obrada.getEntitet().setKoristenBrojDanaGo(Pomocno.getCijeliBrojIzStringa(txtKoristenBrojDanaGo.getText()));
        obrada.getEntitet().setOdobrenjeNadredeni(chbOdobrenjeNadredeni.isSelected());
        obrada.getEntitet().setZaposlenik(cmbZaposlenik.getModel()
                .getElementAt(cmbZaposlenik.getSelectedIndex()));

    }

    private void postaviVrijednosti() {
        txtGodina.setText(Pomocno.getFormatCijelogBroja(obrada.getEntitet().getGodina()));
        if (obrada.getEntitet().getPocetakGodisnjiOdmor() == null) {
            dpDatumPocetkaGo.setDate(null);
        } else {
            dpDatumPocetkaGo.setDate(Pomocno.convertToLocalDateViaInstant(obrada.getEntitet().getPocetakGodisnjiOdmor()));
        }

        //txtPocetakGodisnjiOdmor.setText(Pomocno.getDatum(obrada.getEntitet().getPocetakGodisnjiOdmor()));
        //txtKrajGodisnjiOdmor.setText(Pomocno.getDatum(obrada.getEntitet().getKrajGodisnjiOdmor()));
        if (obrada.getEntitet().getKrajGodisnjiOdmor() == null) {
            dpDatumKrajaGo.setDate(null);
        } else {
            dpDatumKrajaGo.setDate(Pomocno.convertToLocalDateViaInstant(obrada.getEntitet().getKrajGodisnjiOdmor()));
        }

        txtKoristenBrojDanaGo.setText(Pomocno.getFormatCijelogBroja(obrada.getEntitet().getKoristenBrojDanaGo()));
        chbOdobrenjeNadredeni.setSelected(obrada.getEntitet().getOdobrenjeNadredeni());
        postaviZaposlenike();
    }

    private void postaviZaposlenike() {
        ComboBoxModel<Zaposlenik> m = cmbZaposlenik.getModel();
        for (int i = 0; i < m.getSize(); i++) {
            if (m.getElementAt(i).getSifra().equals(
                    obrada.getEntitet().getZaposlenik().getSifra())) {
                cmbZaposlenik.setSelectedIndex(i);
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnObrisi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPromijeni = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKoristenBrojDanaGo = new javax.swing.JTextField();
        chbOdobrenjeNadredeni = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        cmbZaposlenik = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtGodina = new javax.swing.JTextField();
        dpDatumKrajaGo = new com.github.lgooddatepicker.components.DatePicker();
        dpDatumPocetkaGo = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel1.setText("Zaposlenik");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel2.setText("Početak godišnjeg odmora");

        btnPromijeni.setText("Promijeni");
        btnPromijeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromijeniActionPerformed(evt);
            }
        });

        jLabel3.setText("Kraj godišnjeg odmora");

        jLabel4.setText("Korišten broj dana GO");

        chbOdobrenjeNadredeni.setText("Odobrio nadređeni");

        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        jLabel5.setText("Godina");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbOdobrenjeNadredeni)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPromijeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisi))
                    .addComponent(txtKoristenBrojDanaGo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtGodina, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbZaposlenik, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                    .addComponent(dpDatumKrajaGo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpDatumPocetkaGo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbZaposlenik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(dpDatumPocetkaGo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpDatumKrajaGo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKoristenBrojDanaGo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(chbOdobrenjeNadredeni)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromijeni)
                            .addComponent(btnObrisi)))
                    .addComponent(jScrollPane1))
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }
        try {
            obrada.delete();
            ucitaj();
        } catch (GodisnjiException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            obrada.setEntitet(new GodisnjiOdmor());
            ucitajVrijednosti();
            obrada.create();
            ucitaj();
        } catch (GodisnjiException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromijeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromijeniActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }

        ucitajVrijednosti();
        try {
            obrada.update();
            ucitaj();
        } catch (GodisnjiException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
    }//GEN-LAST:event_btnPromijeniActionPerformed

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        obrada.setEntitet(lstPodaci.getSelectedValue());
        if (obrada.getEntitet() == null) {
            return;
        }
        postaviVrijednosti();
    }//GEN-LAST:event_lstPodaciValueChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromijeni;
    private javax.swing.JCheckBox chbOdobrenjeNadredeni;
    private javax.swing.JComboBox<Zaposlenik> cmbZaposlenik;
    private com.github.lgooddatepicker.components.DatePicker dpDatumKrajaGo;
    private com.github.lgooddatepicker.components.DatePicker dpDatumPocetkaGo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<GodisnjiOdmor> lstPodaci;
    private javax.swing.JTextField txtGodina;
    private javax.swing.JTextField txtKoristenBrojDanaGo;
    // End of variables declaration//GEN-END:variables

}
