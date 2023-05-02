public class Ford extends Car{
    private int age;

    private String model;

    public Ford(int age,String model){
        this.age = age;
        this.model = model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel(){
        return model;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public String startEngine(){
        return ("engine is starting");
    }
    public String accelerate(){
        return ("car is accelerating");
    }
    public String brake(){
        return ("car is braking");
    }
}
