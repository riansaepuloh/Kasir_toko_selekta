/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir_toko_selekta;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Wawan
 */
public class frm_utama extends javax.swing.JFrame {

    /**
     * Creates new form frm_supplier1
     */
    public frm_utama() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btn_karyawan = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_transaksi = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btn_karyawan.setBackground(new java.awt.Color(255, 153, 255));
        btn_karyawan.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 11)); // NOI18N
        btn_karyawan.setForeground(new java.awt.Color(255, 255, 255));
        btn_karyawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/karyawan.png"))); // NOI18N
        btn_karyawan.setText("KARYAWAN");
        btn_karyawan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_karyawan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_karyawanMouseClicked(evt);
            }
        });
        jPanel1.add(btn_karyawan);

        btn_supplier.setBackground(new java.awt.Color(153, 153, 255));
        btn_supplier.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 11)); // NOI18N
        btn_supplier.setForeground(new java.awt.Color(255, 255, 255));
        btn_supplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/packages2.png"))); // NOI18N
        btn_supplier.setText("SUPPLIER");
        btn_supplier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_supplier.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_supplierMouseClicked(evt);
            }
        });
        jPanel1.add(btn_supplier);

        btn_barang.setBackground(new java.awt.Color(102, 255, 102));
        btn_barang.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 11)); // NOI18N
        btn_barang.setForeground(new java.awt.Color(255, 255, 255));
        btn_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barang.png"))); // NOI18N
        btn_barang.setText("BARANG");
        btn_barang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_barang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_barangMouseClicked(evt);
            }
        });
        jPanel1.add(btn_barang);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOKO SELEKTA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btn_transaksi.setBackground(new java.awt.Color(204, 102, 255));
        btn_transaksi.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 11)); // NOI18N
        btn_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transaksi.png"))); // NOI18N
        btn_transaksi.setText("TRANSAKSI");
        btn_transaksi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_transaksiMouseClicked(evt);
            }
        });
        jPanel3.add(btn_transaksi);

        jButton4.setBackground(new java.awt.Color(102, 255, 255));
        jButton4.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/laporan.png"))); // NOI18N
        jButton4.setText("LAPORAN");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jButton4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(648, 386));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_karyawanMouseClicked
        new frm_karyawan().setVisible(true);
    }//GEN-LAST:event_btn_karyawanMouseClicked

    private void btn_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_supplierMouseClicked
        new frm_supplier().setVisible(true);
    }//GEN-LAST:event_btn_supplierMouseClicked

    private void btn_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_barangMouseClicked
        new frm_barang().setVisible(true);
    }//GEN-LAST:event_btn_barangMouseClicked

    private void btn_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_transaksiMouseClicked
        new frm_belanja().setVisible(true);
    }//GEN-LAST:event_btn_transaksiMouseClicked

    //============================== LOGIN
//    private Dimension dmn = Toolkit.getDefaultToolkit().getScreenSize();
//    public frm_utama(String userlogin) {
//
//        initComponents();
//        String _User = userlogin;
//        
//      
//        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
//        switch (_User) {
//            case "Administrator":
//                loginAdmin();
//                break;
//            case "User 1":
//                loginUser1();
//                break;
//            case "User 2":
//                loginUser1();
//                break;
//            case "User 3":
//                loginUser1();
//                break;
//            case "User 4":
//                loginUser1();
//                break;
//            case "User 5":
//                loginUser1();
//                break;
//            case "User 6":
//                loginUser1();
//                break;
//            case "User 7":
//                loginUser1();
//                break;
//            case "User 8":
//                loginUser1();
//                break;
//            case "User 9":
//                loginUser1();
//                break;
//            
//        }
//    }
//
//    frm_utama() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    
//    public void loginAdmin(){
//        jMenu2.setVisible(true);
//        jMenuItem1.setEnabled(true);
//        jMenuItem2.setEnabled(true);
//          
//    }
//    
//    public void loginUser1(){
//        jMenuItem1.setEnabled(false);
//        jMenuItem2.setEnabled(false);
//        
//    }
//    
//    public void loginUser2(){
//        jMenuItem1.setEnabled(false);
//        jMenuItem2.setEnabled(false);
//        
//    }
//    public void loginUser3(){
//        jMenuItem1.setEnabled(false);
//        jMenuItem2.setEnabled(false);
//        
//    }
//    public void loginUser4(){
//        jMenuItem1.setEnabled(false);
//        jMenuItem2.setEnabled(false);
//        
//    }
//    public void loginUser5(){
//        jMenuItem1.setEnabled(false);
//        jMenuItem2.setEnabled(false);
//        
//    }
//    public void loginUser6(){
//        jMenuItem1.setEnabled(false);
//        jMenuItem2.setEnabled(false);
//        
//    }
//    public void loginUser7(){
//        jMenuItem1.setEnabled(false);
//        jMenuItem2.setEnabled(false);
//        
//    }
//    public void loginUser8(){
//        jMenuItem1.setEnabled(false);
//        jMenuItem2.setEnabled(false);
//        
//    }
//    public void loginUser9(){
//        jMenuItem1.setEnabled(false);
//        jMenuItem2.setEnabled(false);
//        
//    }
//    
    
    
    //=================================
    
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
            java.util.logging.Logger.getLogger(frm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_karyawan;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
