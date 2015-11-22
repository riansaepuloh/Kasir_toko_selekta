/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir_toko_selekta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Wawan
 */
public class frm_belanja extends javax.swing.JFrame {

    //Dekralasi variabel
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    /**
     * Creates new form frm_supplie
     */
    public frm_belanja() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        t_detail.setModel(tableModel1);
        t_faktur.setModel(tableModel);
        settableload();
    }

    private javax.swing.table.DefaultTableModel tableModel1=getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel(){
//        //membuat judul header
        return new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String [] {
                    "Nama Barang",
                    "Harga Satuan",
                    "Jumlah",
                    "Total Harga"
                }
                )
        //disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]{
                false,false,false,false
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit[columnIndex];
            }
            
        };
    }
    
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel1();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel1(){
//        //membuat judul header
        return new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String [] {
                    "Kode Struk",
                    "Nama Karyawan",
                    "Tanggal Belanja"
                }
                )
        //disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]{
                false,false,false
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit[columnIndex];
            }
            
        };
    }
    
    String data[]=new String[3];
    private void settableload(){
        
        String stat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "Select *From struk_belanja";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                data[0] = res.getString(1);
                data[1] = res.getString(3);
                data[2] = res.getString(2);
                tableModel.addRow(data);
            }
            
            res.close();
            stt.close();
            kon.close();
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showConfirmDialog(null,ex.getMessage(),"Error",
            JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    private void hapus_isi_Tabel(){
        int i;
        int jlm_barang = tableModel1.getRowCount();
            for( i=0;i<jlm_barang;i++){
            tableModel1.removeRow(i);
            }
    }
    
    int row = 0;
    String data1[]=new String[4];
    private void tampilkan_detail(){
        row = t_faktur.getSelectedRow();
        String kd_detail = tableModel.getValueAt(row, 0).toString();
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT `barang`.`nama_barang`," +
                            "`detail_belanja`.`harga_satuan`," +
                            "`detail_belanja`.`jml_belanja`," +
                            "`detail_belanja`.`total_harga`" +
                            "FROM" +
                            "`barang`,`detail_belanja`" +
                            "WHERE" +
                            "`detail_belanja`.`kd_struk`='"+kd_detail+"' " +
                            "AND " +
                            "barang.`kd_barang` = `detail_belanja`.`kd_barang`;";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                data1[0] = res.getString(1);
                data1[1] = res.getString(2);
                data1[2] = res.getString(3);
                data1[3] = res.getString(4);
                tableModel1.addRow(data1);
            }
            res.close();
            stt.close();
            kon.close();
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showConfirmDialog(null,ex.getMessage(),"Error",
            JOptionPane.ERROR_MESSAGE);
            System.exit(0);
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
        t_detail = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_faktur = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        t_detail.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(t_detail);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TABEL STRUK BELANJA");

        t_faktur.setModel(new javax.swing.table.DefaultTableModel(
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
        t_faktur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_fakturMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(t_faktur);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(834, 517));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_fakturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_fakturMouseClicked
        if(evt.getClickCount()==1){
            hapus_isi_Tabel();
            tampilkan_detail();
        }
    }//GEN-LAST:event_t_fakturMouseClicked

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
            java.util.logging.Logger.getLogger(frm_belanja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_belanja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_belanja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_belanja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_belanja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable t_detail;
    private javax.swing.JTable t_faktur;
    // End of variables declaration//GEN-END:variables
}
