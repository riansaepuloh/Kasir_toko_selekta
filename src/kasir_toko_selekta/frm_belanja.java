/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir_toko_selekta;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
                    "Tanggal Belanja",
                    "Total Belanja",
                    "Nama Karyawan"
                    
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
    
    String data[]=new String[4];
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
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
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
        int baris = tableModel1.getRowCount();
        if(baris !=0){
            for(int a = 0;a<baris;a++){
            tableModel1.removeRow(0);
            }
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
        jPanel1 = new javax.swing.JPanel();
        tgl_transaksi = new com.toedter.calendar.JDateChooser();
        txt_kd_barang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nm_barang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_qty = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        txt_total_belanja = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_harga_satuan = new javax.swing.JLabel();
        txt_tot_belanja = new javax.swing.JTextField();
        txt_kd_transaksi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_pembayaran = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_kembalian = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_sub_total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "TRANSAKSI"));

        tgl_transaksi.setDateFormatString("dd-MM-yyyy");

        txt_kd_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_kd_barangKeyPressed(evt);
            }
        });

        jLabel2.setText("KODE BARANG");

        jLabel3.setText("NAMA BARANG");

        txt_nm_barang.setEnabled(false);

        jLabel4.setText("JUMLAH");

        txt_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_qtyKeyPressed(evt);
            }
        });

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        txt_total_belanja.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_total_belanja.setForeground(new java.awt.Color(255, 0, 51));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("TOTAL BELANJA");

        jLabel6.setText("HARGA SATUAN");

        txt_tot_belanja.setBackground(new java.awt.Color(0, 0, 0));
        txt_tot_belanja.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        txt_tot_belanja.setForeground(new java.awt.Color(0, 204, 0));
        txt_tot_belanja.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txt_kd_transaksi.setEditable(false);

        jLabel7.setText("KODE TRANSAKSI");

        jButton2.setText("TRANSAKSI BARU");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_pembayaran.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_pembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pembayaranKeyPressed(evt);
            }
        });

        jLabel8.setText("PEMBAYARAN");

        txt_kembalian.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel9.setText("KEMBALIAN");

        jLabel10.setText("TOTAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nm_barang)
                            .addComponent(txt_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_kd_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_total_belanja, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(326, 326, 326))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgl_transaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_kembalian)
                                    .addComponent(txt_pembayaran)
                                    .addComponent(txt_tot_belanja, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(65, 65, 65))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel10))
                                        .addGap(26, 26, 26)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_harga_satuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_sub_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txt_qty, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kd_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nm_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(txt_harga_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgl_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txt_total_belanja)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tot_belanja, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sub_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btn_tambah))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(878, 605));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_fakturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_fakturMouseClicked
        if(evt.getClickCount()==1){
            hapus_isi_Tabel();
            tampilkan_detail();
            hapus_isi_total();
            
        }
    }//GEN-LAST:event_t_fakturMouseClicked

    private void hapus_isi_total(){
        txt_tot_belanja.setText("0");
        txt_pembayaran.setText("");
        txt_kembalian.setText("");
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      Date hari_ini = new Date();
      tgl_transaksi.setDate(hari_ini);
      txt_tot_belanja.setText("0");
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        transaksi_baru();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tambah_keranjang(){
        String databaru[]=new String[4];
        String kd_detail = tableModel.getValueAt(row, 0).toString();
        int qty = Integer.valueOf(txt_qty.getText());
        int hrg_satuan = Integer.valueOf(txt_harga_satuan.getText());
        int sub_total = Integer.valueOf(txt_sub_total.getText());
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        Date a = tgl_transaksi.getDate();
        String tgl_transaksi_sekarang = String.format(tanggal.format(a));
        int kd_struk = Integer.valueOf(txt_kd_transaksi.getText());
        String kd_barang = txt_kd_barang.getText();
        String nama_barang = txt_nm_barang.getText();
        
        
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "INSERT INTO `detail_belanja`" +
                         "(`kd_struk`, `kd_barang`, `tgl_transaksi`, `harga_satuan`, `jml_belanja`, `total_harga`)" +
                         "VALUES " +
                        "('"+kd_struk+"', '"+kd_barang+"', '"+tgl_transaksi_sekarang+"', '"+hrg_satuan+"', '"+qty+"', '"+sub_total+"');";
            stt.executeUpdate(SQL);
                databaru[0] = nama_barang;
                databaru[1] = String.valueOf(hrg_satuan);
                databaru[2] = String.valueOf(qty);
                databaru[3] = String.valueOf(sub_total);
                tableModel1.addRow(databaru);
            stt.close();
            kon.close();
            
            int total_bayar = Integer.valueOf(txt_tot_belanja.getText());
            total_bayar = total_bayar + sub_total;
            txt_tot_belanja.setText(String.valueOf(total_bayar));
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showConfirmDialog(null,ex.getMessage(),"Error",
            JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    private void txt_kd_barangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kd_barangKeyPressed
        int tekan = evt.getKeyCode();
        if(tekan==10){
            cari_barang();
            txt_qty.requestFocus();
        }
    }//GEN-LAST:event_txt_kd_barangKeyPressed

    private void pengembalian(){
        int total = Integer.valueOf(txt_tot_belanja.getText());
        int uang_bayar = Integer.valueOf(txt_pembayaran.getText());
        int kembalian = 0;
        kembalian = uang_bayar - total ;
        txt_kembalian.setText(String.valueOf(kembalian));
    }
    
    private void hitung_sub(){
        int qty = Integer.valueOf(txt_qty.getText());
        int hrg_satuan = Integer.valueOf(txt_harga_satuan.getText());
        int sub_total = 0;
        int total_bayar = 0;
        
        sub_total = qty * hrg_satuan;
        txt_sub_total.setText(String.valueOf(sub_total));
        total_bayar = sub_total + total_bayar; 
        
    }
    private void txt_qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_qtyKeyPressed
        int tekan = evt.getKeyCode();
        if(tekan==10){
            hitung_sub();
        }
        
    }//GEN-LAST:event_txt_qtyKeyPressed

    private void hapus_isi_txt(){
        txt_harga_satuan.setText("");
        txt_kd_barang.setText("");
        txt_nm_barang.setText("");
        txt_qty.setText("");
        txt_sub_total.setText("");
    }
    
    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        tambah_keranjang();
        hapus_isi_txt();
//        masukkan_total_belanja();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void txt_pembayaranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pembayaranKeyPressed
       int tekan = evt.getKeyCode();
        if(tekan==10){
            pengembalian();
        }
    }//GEN-LAST:event_txt_pembayaranKeyPressed

    private void cari_barang(){
        String cari_kd = txt_kd_barang.getText();
        String kd_barang = null, nama_barang = null;
        int jml_barang;
        int harga_barang = 0;
      try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM `barang` WHERE `kd_barang`='"+cari_kd+"';";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                kd_barang = res.getString(1);
                nama_barang = res.getString(2);
                jml_barang = res.getInt(3);
                harga_barang = res.getInt(4);
            }
            if(kd_barang==null){
                JOptionPane.showMessageDialog(null,"Maaf Kode Barang Salah","Kosong",JOptionPane.INFORMATION_MESSAGE);
            } else {
                txt_nm_barang.setText(nama_barang);
                txt_harga_satuan.setText(String.valueOf(harga_barang));
            }
            res.close();
            stt.close();
            kon.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Maaf Kode Barang Salah","Kosong",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }  
        
    }
    
    private void masukkan_total_belanja(){
        int kd_struk = 0;
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        Date a = tgl_transaksi.getDate();
        String tgl_transaksi_sekarang = String.format(tanggal.format(a));
        String kd_struk_baru = txt_kd_transaksi.getText();
        String tot_bayar = txt_tot_belanja.getText();
        try {
            
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT MAX(`kd_struk`) AS kode FROM `struk_belanja`;";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                kd_struk = res.getInt("kode");
            }
            String SQL1 = "INSERT INTO`struk_belanja` (`total_belanja`) "
                          + "VALUES "
                          + "('"+tot_bayar+"'); ";
            stt.executeUpdate(SQL1);
                data[0] = String.valueOf(kd_struk_baru);
                data[1] = tgl_transaksi_sekarang;
                data[2] = tot_bayar;
                data[3] = "Anisa";
                tableModel.removeRow(kd_struk);
                tableModel.insertRow(kd_struk-1, data);
            res.close();
            stt.close();
            kon.close();
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Kosong",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,"Maaf Kode transaksi Salah","Kosong",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    private void perhitungan(){
//        int jumlah
    }
    
    private void transaksi_baru(){
        int kd_struk = 0, kd_struk_baru=0;
        String data[]=new String[5];
        
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        Date a = tgl_transaksi.getDate();
        String tgl_transaksi_sekarang = String.format(tanggal.format(a));
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT MAX(`kd_struk`) AS kode FROM `struk_belanja`;";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                kd_struk = res.getInt("kode");
            }
            kd_struk_baru = kd_struk + 1;
            txt_kd_transaksi.setText(String.valueOf(kd_struk_baru));
            String SQL1 = "INSERT INTO`struk_belanja` (`kd_struk`, `tgl_transaksi`) "
                          + "VALUES "
                          + "('"+kd_struk_baru+"', '"+tgl_transaksi_sekarang+"'); ";
            stt.executeUpdate(SQL1);
                data[0] = String.valueOf(kd_struk_baru);
                data[1] = tgl_transaksi_sekarang;
                data[2] = "";
                data[3] = "anisa";
                tableModel.insertRow(kd_struk, data);
            res.close();
            stt.close();
            kon.close();
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Kosong",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,"Maaf Kode transaksi Salah","Kosong",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
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
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable t_detail;
    private javax.swing.JTable t_faktur;
    private com.toedter.calendar.JDateChooser tgl_transaksi;
    private javax.swing.JLabel txt_harga_satuan;
    private javax.swing.JTextField txt_kd_barang;
    private javax.swing.JTextField txt_kd_transaksi;
    private javax.swing.JTextField txt_kembalian;
    private javax.swing.JTextField txt_nm_barang;
    private javax.swing.JTextField txt_pembayaran;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JTextField txt_sub_total;
    private javax.swing.JTextField txt_tot_belanja;
    private javax.swing.JLabel txt_total_belanja;
    // End of variables declaration//GEN-END:variables
}
