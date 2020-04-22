/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.godisnjiodmor_app.view;

import hr.godisnjiodmor_app.util.HibernateUtil;
import hr.godisnjiodmor_app.util.Pomocno;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartFrame;

import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Bozena
 */
public class Izbornik extends javax.swing.JFrame {

    /**
     * Creates new form Izbornik
     */
    public Izbornik() {
        initComponents();
        setTitle(Pomocno.getNazivAplikacije());
        jmAplikacija.setText(Pomocno.getNazivAplikacije());

        Vrijeme v = new Vrijeme();
        v.start();

    }

    private class Vrijeme extends Thread {

        SimpleDateFormat df = new SimpleDateFormat("dd. MM. yyyy. HH:mm:ss");

        @Override
        public void run() {
            try {
                lblVrijeme.setText(df.format(new Date()));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
            run();
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

        jToolBar1 = new javax.swing.JToolBar();
        lblVrijeme = new javax.swing.JLabel();
        btnGraf = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAplikacija = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        lblVrijeme.setText("Vrijeme");
        jToolBar1.add(lblVrijeme);

        btnGraf.setText("Graf");
        btnGraf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafActionPerformed(evt);
            }
        });

        jmAplikacija.setText("Aplikacija");

        jMenuItem1.setText("Izlaz");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmAplikacija.add(jMenuItem1);

        jMenuBar1.add(jmAplikacija);

        jMenu2.setText("Izbornik");

        jMenuItem2.setText("Zaposlenik");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setText("Godišnji odmor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Evidencija godišnjeg odmora");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGraf)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(btnGraf)
                .addGap(18, 18, 18)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        HibernateUtil.getSessionFactory().close();
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new ViewZaposlenik().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new ViewGodisnjiOdmor().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new ViewEvidencijaGodisnjegOdmora().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btnGrafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(2, "Dani", "Božena");
        dataset.setValue(20, "Dani", "Petar");
        dataset.setValue(5, "Dani", "Marko");
        dataset.setValue(11, "Dani", "Elena");
        JFreeChart chart = ChartFactory.createBarChart("Neiskorišteni GO", "2020", "Dani", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartFrame frame = new ChartFrame("Neiskorišteni GO u 2020", chart);
        frame.setVisible(true);
        frame.setSize(450, 350);


    }//GEN-LAST:event_btnGrafActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraf;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu jmAplikacija;
    private javax.swing.JLabel lblVrijeme;
    // End of variables declaration//GEN-END:variables
}
