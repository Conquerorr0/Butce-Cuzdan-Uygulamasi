import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class VeriTabani {
    
    //MySql bağlantısı
    private String kullaniciAdi = "root";
    private String sifre = "";
    private String url = "jdbc:mysql://localhost:3306/butcecuzdan";
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, kullaniciAdi, sifre);
    }
    
    public void hataMesaji(SQLException ex){
        System.out.println(ex.getMessage());
    }

    void showErrorMessage(SQLException exception) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
