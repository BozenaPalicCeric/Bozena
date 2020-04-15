/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.view;

import hr.godisnjiodmor_app.controller.ObradaEvidencijaGodisnjiOdmor;
import hr.godisnjiodmor_app.controller.ObradaGodisnjiOdmor;
import hr.godisnjiodmor_app.controller.ObradaZaposlenik;
import hr.godisnjiodmor_app.model.Entitet;
import hr.godisnjiodmor_app.model.EvidencijaGodisnjiOdmor;
import hr.godisnjiodmor_app.model.GodisnjiOdmor;
import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.util.GodisnjiException;
import hr.godisnjiodmor_app.util.Pomocno;
import java.awt.event.KeyEvent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Božena
 */
public class ViewEvidencijaGodisnjiOdmor extends javax.swing.JFrame {
private final ObradaEvidencijaGodisnjiOdmor obrada;
    /**
     * Creates new form ViewEvidencijaGodisnjiOdmor
     */
    public ViewEvidencijaGodisnjiOdmor() {
        initComponents();
        obrada= new ObradaEvidencijaGodisnjiOdmor();
        ucitaj();
        ucitajZaposlenike();
        
    }
    private void ucitajZaposlenike() {
        DefaultComboBoxModel<Zaposlenik> m = new DefaultComboBoxModel<>();
        new ObradaZaposlenik().getPodaci().forEach(z->m.addElement(z));
        cmbZaposlenik.setModel(m);
    }
   
    
     private void ucitaj() {
        DefaultListModel<EvidencijaGodisnjiOdmor> m = new DefaultListModel<>();
        obrada.getPodaci().forEach(evidencijaGodisnjiOdmor -> m.addElement(evidencijaGodisnjiOdmor));
        lstPodaci.setModel(m);
    }

    private void ucitajVrijednosti() {
       
        obrada.getEntitet().setZaposlenik(cmbZaposlenik.getModel()
                .getElementAt(cmbZaposlenik.getSelectedIndex()));
    }

    private void postaviVrijednosti() {
        
        postaviZaposlenike();
    }
    private void postaviZaposlenike() {
        ComboBoxModel<Zaposlenik> m = cmbZaposlenik.getModel();
        for(int i=0;i<m.getSize();i++){
            if(m.getElementAt(i).getSifra().equals(
                    obrada.getEntitet().getZaposlenik().getSifra())){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnObrisi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPromijeni = new javax.swing.JButton();
        btnPreostaliBrojDanaGo = new javax.swing.JButton();
        lblIzracunRazmjerni = new javax.swing.JLabel();
        btnRazmjerniDioGo = new javax.swing.JButton();
        lblIzracunGo = new javax.swing.JLabel();
        cmbZaposlenik = new javax.swing.JComboBox<>();
        txtGodina = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

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

        jLabel2.setText("Godina");

        btnPromijeni.setText("Promijeni");
        btnPromijeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromijeniActionPerformed(evt);
            }
        });

        btnPreostaliBrojDanaGo.setText("Preostali broj dana GO");
        btnPreostaliBrojDanaGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreostaliBrojDanaGoActionPerformed(evt);
            }
        });

        lblIzracunRazmjerni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIzracunRazmjerni.setText("Izračun");

        btnRazmjerniDioGo.setText("Razmjernio dio GO");
        btnRazmjerniDioGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRazmjerniDioGoActionPerformed(evt);
            }
        });

        lblIzracunGo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIzracunGo.setText("Izračun");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnRazmjerniDioGo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPreostaliBrojDanaGo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDodaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPromijeni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnObrisi))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbZaposlenik, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblIzracunGo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblIzracunRazmjerni, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtGodina, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
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
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnPreostaliBrojDanaGo)
                        .addGap(27, 27, 27)
                        .addComponent(lblIzracunGo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRazmjerniDioGo)
                        .addGap(18, 18, 18)
                        .addComponent(lblIzracunRazmjerni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromijeni)
                            .addComponent(btnObrisi)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            obrada.setEntitet(new EvidencijaGodisnjiOdmor());
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

    private void btnPreostaliBrojDanaGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreostaliBrojDanaGoActionPerformed
        
        
       /*int izracun=obrada.getEntitet().getZaposlenik().getBrojDanaGoPremaUgovoruORadu()
               -obrada.getEntitet().getKoristenBrojDanaGo();
        lblIzracunGo.setText(izracun);
        */
    }//GEN-LAST:event_btnPreostaliBrojDanaGoActionPerformed

    private void btnRazmjerniDioGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRazmjerniDioGoActionPerformed
        //(trenutni broj dana u godini * broj dana GO prema ugovoru) / 365 dana
    }//GEN-LAST:event_btnRazmjerniDioGoActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPreostaliBrojDanaGo;
    private javax.swing.JButton btnPromijeni;
    private javax.swing.JButton btnRazmjerniDioGo;
    private javax.swing.JComboBox<Zaposlenik> cmbZaposlenik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIzracunGo;
    private javax.swing.JLabel lblIzracunRazmjerni;
    private javax.swing.JList<EvidencijaGodisnjiOdmor> lstPodaci;
    private javax.swing.JTextField txtGodina;
    // End of variables declaration//GEN-END:variables
}
