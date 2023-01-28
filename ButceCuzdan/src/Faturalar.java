
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class Faturalar {

    public Faturalar() {
        yazdir();
    }
    
    private String aylar = "", su = "", elektrik = "", dogalGaz = "";
    
    //Ayları ve fatura bilgilerini atadığımız diziler
    String[] ay;
    String[] su_faturasi;
    String[] elektrik_faturasi;
    String[] gaz_faturasi;
    
    public void yazdir(){
        Connection connection = null;
        VeriTabani veriTabani = new VeriTabani();
        Statement statement = null;
        ResultSet resultSet;
        
        try {
            connection = veriTabani.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM faturalar");
            
            //Veri tabanındaki bilgileri ilgili Stringlere sonlarına boşluk ekleyerek atıyoruz
            while(resultSet.next()){
                aylar += resultSet.getString("aylar") + " ";
                su += resultSet.getString("su_faturasi") + " ";
                elektrik += resultSet.getString("elektrik_faturasi") + " ";
                dogalGaz += resultSet.getString("dogal_gaz_faturasi") + " ";
            }
            //Split metodu ile Stringleri ilgili dizilere atıyoruz
            ay = aylar.split(" ");
            su_faturasi = su.split(" ");
            elektrik_faturasi = elektrik.split(" ");
            gaz_faturasi = dogalGaz.split(" ");
            
        } catch (Exception e) {
        }
    }

    /**
     * @return the aylar
     */
    public String getAylar() {
        return aylar;
    }

    /**
     * @param aylar the aylar to set
     */
    public void setAylar(String aylar) {
        this.aylar = aylar;
    }

    /**
     * @return the su
     */
    public String getSu() {
        return su;
    }

    /**
     * @param su the su to set
     */
    public void setSu(String su) {
        this.su = su;
    }

    /**
     * @return the elektrik
     */
    public String getElektrik() {
        return elektrik;
    }

    /**
     * @param elektrik the elektrik to set
     */
    public void setElektrik(String elektrik) {
        this.elektrik = elektrik;
    }

    /**
     * @return the dogalGaz
     */
    public String getDogalGaz() {
        return dogalGaz;
    }

    /**
     * @param dogalGaz the dogalGaz to set
     */
    public void setDogalGaz(String dogalGaz) {
        this.dogalGaz = dogalGaz;
    }
}
