/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.view;

import hr.godisnjiodmor_app.controller.ObradaGodisnjiOdmor;
import hr.godisnjiodmor_app.controller.ObradaZaposlenik;
import hr.godisnjiodmor_app.model.GodisnjiOdmor;
import hr.godisnjiodmor_app.model.Zaposlenik;
import hr.godisnjiodmor_app.util.GodisnjiException;
import hr.godisnjiodmor_app.util.HibernateUtil;
import hr.godisnjiodmor_app.util.Pomocno;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Božena
 */
public class EvidencijaGodisnjegOdmora extends javax.swing.JFrame {

    private final ObradaGodisnjiOdmor obrada;

    /**
     * Creates new form Evidencija2
     */
    public EvidencijaGodisnjegOdmora() {
        initComponents();
        obrada = new ObradaGodisnjiOdmor();
        obrada.setEntitet(new GodisnjiOdmor());
        ucitajZaposlenike();
    }

    private void ucitajZaposlenike() {
        DefaultComboBoxModel<Zaposlenik> m = new DefaultComboBoxModel<>();
        new ObradaZaposlenik().getPodaci().forEach(z -> m.addElement(z));
        cmbZaposlenik.setModel(m);
    }

    private void ucitajVrijednosti() {
        obrada.getEntitet().setGodina(Pomocno.getCijeliBrojIzStringa(txtGodina.getText()));
        obrada.getEntitet().setZaposlenik(cmbZaposlenik.getModel()
                .getElementAt(cmbZaposlenik.getSelectedIndex()));

    }

    private void postaviVrijednosti() {
        txtGodina.setText(Pomocno.getFormatCijelogBroja(obrada.getEntitet().getGodina()));

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

        cmbZaposlenik = new javax.swing.JComboBox<>();
        txtGodina = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnIzracunaj = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Zaposlenik");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Godina");

        btnIzracunaj.setText("Izračunaj");
        btnIzracunaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzracunajActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Preostali broj dana GO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGodina, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzracunaj, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbZaposlenik, javax.swing.GroupLayout.Alignment.LEADING, 0, 147, Short.MAX_VALUE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbZaposlenik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnIzracunaj)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzracunajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzracunajActionPerformed
        Session session = HibernateUtil.getSessionFactory().openSession();
        obrada.getEntitet().setZaposlenik((Zaposlenik) cmbZaposlenik.getSelectedItem());
        obrada.getEntitet().setGodina(Integer.parseInt(txtGodina.getText()));
        session.beginTransaction();

        Long zbroj = (Long) session.createQuery(" select coalesce( sum( g.koristenBrojDanaGo),0) from GodisnjiOdmor g "
                + " where g.zaposlenik.sifra= :zaposlenik"
                + " and g.godina= :godina")
                .setParameter("zaposlenik", obrada.getEntitet().getZaposlenik().getSifra())
                .setParameter("godina", obrada.getEntitet().getGodina())
                .getSingleResult();

        Long razlika = obrada.getEntitet().getZaposlenik().getBrojDanaGoPremaUgovoruORadu() - zbroj;

        session.getTransaction().commit();
        session.close();

        if (razlika >= 0) {
            JOptionPane.showMessageDialog(null, razlika);
        }


    }//GEN-LAST:event_btnIzracunajActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzracunaj;
    private javax.swing.JComboBox<Zaposlenik> cmbZaposlenik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtGodina;
    // End of variables declaration//GEN-END:variables
}
