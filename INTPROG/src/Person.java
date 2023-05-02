public class Person {
    private String name, gender;
    private int age;
    private Address address;

    public Person(){
        name = "";
        gender = "";
        age = 0;
        address = new Address();
    }

    public Person(String name, String gender, int age, String street, String barangay, String CinMun, String province){
        this.name = name;
        this.gender = gender;
        this.age = age;
        address = new Address(street, barangay, CinMun, province);
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setStreet(String street){
        address.setStreet(street);
    }
    public String getStreet(){
        return address.getStreet();
    }

    public void setBarangay(String barangay){
        address.setBarangay(barangay);
    }
    public String getBarangay(){
        return address.getBarangay();
    }

    public void setCinMun(String CinMun){
        address.setCinMun(getCinMun());
    }
    public String getCinMun(){
        return address.getCinMun();
    }

    public void setProvince(String province){
        address.setProvince(province);
    }

    public String getProvince(){
        return address.getProvince();
    }
}
