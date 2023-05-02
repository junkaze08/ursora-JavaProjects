public class Teacher extends Employee{
    private String college;
    public Teacher(){
        super();
        college = "";
    }
    public Teacher(String college,String empPosition, int empNum, String name, String gender, int age, String street, String barangay, String CinMun, String province){
        super(empPosition, empNum, name, gender, age, street, barangay, CinMun, province);
        this.college = college;
    }

    public void setCollege(String college){
        this.college = college;
    }
    public String getCollege(){
        return college;
    }
}
