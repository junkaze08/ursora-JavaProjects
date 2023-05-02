public class Address {
    private String street, barangay, CinMun, province;
    public Address(){
        street = "";
        barangay = "";
        CinMun = "";
        province = "";
    }

    public Address(String street, String barangay, String CinMun, String province){
        this.street = street;
        this.barangay = barangay;
        this.CinMun = CinMun;
        this.province = province;
    }
    public void setStreet(String street){
        this.street = street;
    }
    public String getStreet(){
        return street;
    }

    public void setBarangay(String barangay){
        this.barangay = barangay;
    }
    public String getBarangay(){
        return barangay;
    }

    public void setCinMun(String CinMun){
        this.CinMun = CinMun;
    }
    public String getCinMun(){
        return CinMun;
    }

    public void setProvince(String province){
        this.province = province;
    }

    public String getProvince(){
        return province;
    }
}
