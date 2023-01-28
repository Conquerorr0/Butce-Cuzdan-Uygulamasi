
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class AnaPencere extends javax.swing.JFrame {
    private static String kullaniciId, kullaniciAdi, kullaniciSoyadi;
    
    
    public AnaPencere() {
        initComponents();
        setLocationRelativeTo(null);
        kullanici();
    }

    Kullanici kullanici = new Kullanici();
    Kullanici.user user;
    
    //Kullanıcı bilgilerini veritabanından çektiğimiz metot
    public void kullanici(){
        //Veritabanı bağlantısı için kullandığımız hazır sınıflar
        Connection connection = null;
        //Veri tabanına bağlandığımız sınıf
        VeriTabani veriTabani = new VeriTabani();
        Statement statement = null;
        ResultSet resultSet;
        
        
        try {
            connection = veriTabani.getConnection();
            statement = connection.createStatement();
            //Sql komutu
            //kullanici veritabanındaki tabloya erişiyoruz
            resultSet = statement.executeQuery("SELECT * FROM kullanici");
            resultSet.next();
            
            //Değişkenlere veritabanının kolonlarından çektiğimiz bilgileri atıyoruz
            kullaniciId = resultSet.getString("KullaniciId");
            kullaniciAdi = resultSet.getString("KullaniciAdi");
            kullaniciSoyadi = resultSet.getString("KullaniciSoyadi");
            //Nested sınıftan nesne oluşturduk
            kullanici.new user(kullaniciId, kullaniciAdi, kullaniciSoyadi);
            //İsimin yazdığı labelı kullanıcı sınıfınfaki private isim ve soyisim değişkenleri ile güncelledik
            lblIsim.setText(kullanici.getIsim() + " " + kullanici.getSoyisim());
            
        } catch (SQLException e) {
            veriTabani.hataMesaji(e);
        }
        finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHesapSahibi = new javax.swing.JLabel();
        lblIsim = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnHesaplar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnKartlar = new javax.swing.JButton();
        btnFaturalar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bütçe/Cüzdan Yönetim Uygulaması");

        lblHesapSahibi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHesapSahibi.setText("Hesap Sahibi:");

        lblIsim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnHesaplar.setText("HESAPLAR");
        btnHesaplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHesaplarActionPerformed(evt);
            }
        });

        btnKartlar.setText("KARTLAR");
        btnKartlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKartlarActionPerformed(evt);
            }
        });

        btnFaturalar.setText("FATURALAR");
        btnFaturalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaturalarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHesapSahibi, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIsim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHesaplar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKartlar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFaturalar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHesapSahibi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIsim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHesaplar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnKartlar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFaturalar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnHesaplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHesaplarActionPerformed
        //Hesaplar penceresinden nesne oluşturduk
        HesaplarPencere hesaplarPencere = new HesaplarPencere();
        //Butona tıklandığında pencereyi görünür kılıyoruz
        hesaplarPencere.setVisible(true);
        //DISPOSE_ON_CLOSE ile pencere kapatılsada program durmayacak
        hesaplarPencere.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnHesaplarActionPerformed

    private void btnKartlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKartlarActionPerformed
        //Hesaplar penceresinden nesne oluşturduk
        KartlarPencere kartlarPencere = new KartlarPencere();
        //Butona tıklandığında pencereyi görünür kılıyoruz
        kartlarPencere.setVisible(true);
        //DISPOSE_ON_CLOSE ile pencere kapatılsada program durmayacak
        kartlarPencere.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnKartlarActionPerformed

    private void btnFaturalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaturalarActionPerformed
        //Hesaplar penceresinden nesne oluşturduk
        FaturalarPencere faturalarPencere = new FaturalarPencere();
        //Butona tıklandığında pencereyi görünür kılıyoruz
        faturalarPencere.setVisible(true);
        //DISPOSE_ON_CLOSE ile pencere kapatılsada program durmayacak
        faturalarPencere.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnFaturalarActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(AnaPencere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaPencere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaPencere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaPencere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaPencere().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFaturalar;
    private javax.swing.JButton btnHesaplar;
    private javax.swing.JButton btnKartlar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblHesapSahibi;
    private javax.swing.JLabel lblIsim;
    // End of variables declaration//GEN-END:variables
}
