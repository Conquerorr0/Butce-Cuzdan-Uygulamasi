
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class Hesaplar {
    
    private String hesapNo, bakiye, borc;
    
    //Constructorda veritabanından çekme işlemlerini yaptığımız metodu çağırdık
    public Hesaplar() {
        hesap();
    }
    
    //Hesap numaralarını tuttuğumuz String dizisi
    String[] hesapNumaralari;
    //Bakiyeleri tuttuğumuz String dizisi
    String[] hesapBakiye;
    //Borçları tuttuğumuz String dizisi
    String[] hesapBorc;
    
    //Veritabanı bağlantısı için kullandığımız hazır sınıflar
    Connection connection = null;
    //Veri tabanına bağlandığımız sınıf
    VeriTabani veriTabani = new VeriTabani();
    Statement statement = null;
    ResultSet resultSet;
    
    //Çektiğimiz bilgileri aşağıdaki Stringlere ekleyeceğiz
    String hesap_no = "";
    String hesap_bakiye = "";
    String hesap_borc = "";
    
    //Constructorda veritabanından çekme işlemlerini yaptığımız metodu
    public void hesap(){
        try {
            
            connection = veriTabani.getConnection();
            statement = connection.createStatement();
            //Sql komutu
            //banka veritabanındaki tabloya erişiyoruz
            resultSet = statement.executeQuery("SELECT * FROM banka");
            
            //Tablodaki bilgileri çekmek için while döngüsü açtık
            //Döngü tablodaki bilgilerin hepsini okuyana kadar dönüyor
            while(resultSet.next()){
                //Değişkenlere veritabanının kolonlarından çektiğimiz bilgileri atıyoruz
                //Bilgileri atarken sonlarına boşluk koyuyoruz
                //split metodundan boşluklardan bölüyoruz
                setHesapNo(resultSet.getString("hesap_no"));
                hesap_no += hesapNo + " ";
                setBakiye(resultSet.getString("bakiye"));
                hesap_bakiye += bakiye + " ";
                setBorc(resultSet.getString("borçlar"));
                hesap_borc += borc + " ";
            }
            //.split() metodu ile boşluklardan Stringi bölerek diziye atıyoruz
            hesapNumaralari = hesap_no.split(" ");
            hesapBakiye = hesap_bakiye.split(" ");
            hesapBorc = hesap_borc.split(" ");
            
        } catch (Exception e) {
        }
    }
    
    
    /**
     * @return the hesapNo
     */
    public String getHesapNo() {
        return hesapNo;
    }

    /**
     * @param hesapNo the hesapNo to set
     */
    public void setHesapNo(String hesapNo) {
        this.hesapNo = hesapNo;
    }

    /**
     * @return the bakiye
     */
    public String getBakiye() {
        return bakiye;
    }

    /**
     * @param bakiye the bakiye to set
     */
    public void setBakiye(String bakiye) {
        this.bakiye = bakiye;
    }

    /**
     * @return the borc
     */
    public String getBorc() {
        return borc;
    }

    /**
     * @param borc the borc to set
     */
    public void setBorc(String borc) {
        this.borc = borc;
    }
    
}
