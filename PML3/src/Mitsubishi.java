public class Mitsubishi extends Car{
    private int age;
    private String model;

    public Mitsubishi(int age,String model){
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
        return ("is accelerating engine");
    }
    public String brake(){
        return ("is braking engine");
    }

}
