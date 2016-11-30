/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transaksi.view;

import com.transaksi.Dao.TransaksiDao;
import com.transaksi.Dialog.BarangDialog;
import com.transaksi.Entity.Barang;
import com.transaksi.Entity.Transaksi;
import com.transaksi.Entity.TransaksiDetil;
import com.transaksi.TabelModel.TabelModelTransaksiDetil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author krypton
 */
public class TransaksiView extends javax.swing.JFrame {

    private TabelModelTransaksiDetil tabelModelTransaksiDetil=new TabelModelTransaksiDetil();
    private TransaksiDao transaksiDao=new TransaksiDao();
    private Transaksi transaksi=new Transaksi();
    private Date date=new Date();
    List<Transaksi> listTransaksi=new ArrayList<>();
    private Barang b=new Barang();
    
    
    public TransaksiView() {
        initComponents();
        setLocationRelativeTo(null);
        tabel_transaksiDetil.setModel(tabelModelTransaksiDetil);
        txt_tanggal.setDate(date);
    }

    private void resetForm(){
        txt_karyawan.setText("");
        txt_kodeTransaksi.setText("");
        txt_total.setText("");
        tabelModelTransaksiDetil.clear();
    }
    
    private boolean validasiInput(){
        boolean valid=false;
        if(txt_karyawan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "nama karyawan tidak boleh kosong!");
        }else if(txt_kodeTransaksi.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode transaksi tidak boleh kosong!");
        }else if(txt_tanggal.getDate()==null){
            JOptionPane.showMessageDialog(null, "tanggal tidak boleh kosong!");
        }else if(txt_total.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "total masih 0, harap hitung total terlebih dahulu !");
        }else if(tabelModelTransaksiDetil.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "daftar barang belanjaan belum diinpu! harap ambil data barang terlebih dahulu");
        }else{
            valid=true;
        }
        return valid;
    }
    
    private int validHitung(){
        int validjumlah=0;
        for(int i=0; i<tabelModelTransaksiDetil.getRowCount(); i++){
            validjumlah=(int) tabel_transaksiDetil.getValueAt(i, 1);
        }
        return validjumlah;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_kodeTransaksi = new javax.swing.JTextField();
        txt_tanggal = new com.toedter.calendar.JDateChooser();
        txt_karyawan = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksiDetil = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btn_ambilBarang = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Form Transaksi");
        jPanel1.add(jLabel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("kd_transaksi :");

        jLabel3.setText("tanggal :");

        jLabel4.setText("karyawan :");

        txt_kodeTransaksi.setDisabledTextColor(new java.awt.Color(153, 0, 0));
        txt_kodeTransaksi.setEnabled(false);

        txt_tanggal.setEnabled(false);

        jButton3.setText("get_code");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_kodeTransaksi)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_karyawan, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_kodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pembelian Detil"));

        tabel_transaksiDetil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel_transaksiDetil);

        jLabel5.setText("Total :");

        txt_total.setDisabledTextColor(new java.awt.Color(204, 0, 51));
        txt_total.setEnabled(false);

        jButton4.setText("total");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(24, 24, 24))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_ambilBarang.setText("Ambil Barang");
        btn_ambilBarang.setEnabled(false);
        btn_ambilBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ambilBarangActionPerformed(evt);
            }
        });
        jPanel4.add(btn_ambilBarang);

        btn_simpan.setText("Simpan");
        btn_simpan.setEnabled(false);
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel4.add(btn_simpan);

        jButton5.setText("Batal");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // proses autonumber
        String autonumber=transaksiDao.kodeTransaksi();
        txt_kodeTransaksi.setText(autonumber);
        btn_ambilBarang.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_ambilBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ambilBarangActionPerformed
        // proses ambil barang
        boolean valid=false;
        BarangDialog dialog=new BarangDialog();
        b=dialog.ambilBarang();
        if(b!=null){
            List<Barang> barangCek=dialog.tabelModelBarang.getBarangCek();
            for(Barang bar : barangCek){
                TransaksiDetil detil=new TransaksiDetil();
                detil.setBarang(bar);
                detil.setJumlah(0);
                detil.setHarga(bar.getHarga());
                
                //validasi ambil barang
                for(int i=0; i<tabel_transaksiDetil.getRowCount(); i++){
                    TransaksiDetil detil1=tabelModelTransaksiDetil.getTransaksiDetil(i);
                    if(detil1.getBarang().getNama().equals(detil.getBarang().getNama())){
                        valid=true;
                    }
                }
                if(valid==false){
                    tabelModelTransaksiDetil.insertTransaksiDetil(detil);
                    btn_simpan.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "maaf nama barang sudah ada dalam tabel transaksi !");
                }
            }
        }
    }//GEN-LAST:event_btn_ambilBarangActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // proses hitung total keseluruhan
        int jumlahBaris=tabelModelTransaksiDetil.getRowCount();
        double totalBiaya=0;
        double jumlahBelanja, hargaSatuan;
        TableModel tableModel;
        tableModel=tabel_transaksiDetil.getModel();
        if(validHitung()==0){
            JOptionPane.showMessageDialog(null, "maaf total keseluruhan tidak bisa dihitung, karena masih ada jumlah belanjaan yang kosong atau 0");
        }else{
            for(int i=0; i<jumlahBaris; i++){
                jumlahBelanja=Double.parseDouble(tabel_transaksiDetil.getValueAt(i, 1).toString());
                hargaSatuan=Double.parseDouble(tabel_transaksiDetil.getValueAt(i, 2).toString());
                totalBiaya = totalBiaya+(jumlahBelanja*hargaSatuan);
            }
            txt_total.setText(String.valueOf(totalBiaya));
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // proses simpan data transaksi
        if(validasiInput()==true){
            transaksi=new Transaksi();
            transaksi.setKaryawan(txt_karyawan.getText());
            transaksi.setKodeTransaksi(txt_kodeTransaksi.getText());
            transaksi.setTanggal(txt_tanggal.getDate());
            transaksi.setTotal(Double.valueOf(txt_total.getText()));
            
            List<TransaksiDetil> transaksiDetils=new ArrayList<>();
            for(int i=0; i<tabelModelTransaksiDetil.getRowCount(); i++){
                TransaksiDetil detils=new TransaksiDetil();
                detils.setTransaksi(transaksi);
                
                Barang b=(Barang) tabel_transaksiDetil.getValueAt(i, 0);
                int jumlah=(int) tabel_transaksiDetil.getValueAt(i, 1);
                double harga=(double) tabel_transaksiDetil.getValueAt(i, 2);
                
                detils.setBarang(b);
                detils.setJumlah(jumlah);
                detils.setHarga(harga);
                transaksiDetils.add(detils);
            }
            transaksi.setGetTransaksiDetil(transaksiDetils);
            if(transaksiDao.insertTransaksi(transaksi) == true){
                JOptionPane.showMessageDialog(null, "data transaksi berhasil disimpan!");
                resetForm();
            }else{
                JOptionPane.showMessageDialog(null, "data gagal disimpan !");
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ambilBarang;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_transaksiDetil;
    private javax.swing.JTextField txt_karyawan;
    private javax.swing.JTextField txt_kodeTransaksi;
    private com.toedter.calendar.JDateChooser txt_tanggal;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
