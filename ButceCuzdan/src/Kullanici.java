/**
 *
 * @author User
 */

//Nested class
public class Kullanici {
    private String Id, isim, soyisim;
    
    //Nested class
    class user {
        //Constructor
        user(String id, String Isim, String Soyisim){
            setId(id);
            setIsim(Isim);
            setSoyisim(Soyisim);
        }
    }

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the isim
     */
    public String getIsim() {
        return isim;
    }

    /**
     * @param isim the isim to set
     */
    public void setIsim(String isim) {
        this.isim = isim;
    }

    /**
     * @return the soyisim
     */
    public String getSoyisim() {
        return soyisim;
    }

    /**
     * @param soyisim the soyisim to set
     */
    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }
}