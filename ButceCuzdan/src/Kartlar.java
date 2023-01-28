
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class Kartlar {
    private String kartIban = "", kartNo = "", kartLimit = "";
    
    public Kartlar() {
        kart();
    }
    
    //Bilgileri atayacağımız diziler
    String[] kartlar_iban;
    String[] kartlar_no;
    String[] kartlar_limit;
    
    public void kart(){
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
            //kartlar veritabanındaki tabloya erişiyoruz
            resultSet = statement.executeQuery("SELECT * FROM kartlar");
            
            //Tablodaki bilgileri çekmek için while döngüsü açtık
            //Döngü tablodaki bilgilerin hepsini okuyana kadar dönüyor
            while(resultSet.next()){
                kartIban += resultSet.getString("kart_iban") + " ";
                kartNo += resultSet.getString("kart_no") + " ";
                kartLimit += resultSet.getString("kart_limiti") + " ";
            }
            //.split() metodu ile boşluklardan Stringi bölerek diziye atıyoruz
            kartlar_iban = kartIban.split(" ");
            kartlar_no = kartNo.split(" ");
            kartlar_limit = kartLimit.split(" ");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    /**
     * @return the kartIban
     */
    public String getKartIban() {
        return kartIban;
    }

    /**
     * @param kartIban the kartIban to set
     */
    public void setKartIban(String kartIban) {
        this.kartIban = kartIban;
    }

    /**
     * @return the kartNo
     */
    public String getKartNo() {
        return kartNo;
    }

    /**
     * @param kartNo the kartNo to set
     */
    public void setKartNo(String kartNo) {
        this.kartNo = kartNo;
    }

    /**
     * @return the kartLimit
     */
    public String getKartLimit() {
        return kartLimit;
    }

    /**
     * @param kartLimit the kartLimit to set
     */
    public void setKartLimit(String kartLimit) {
        this.kartLimit = kartLimit;
    }
}
