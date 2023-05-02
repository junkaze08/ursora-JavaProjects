public abstract class Car {
    private String name;
    private boolean engine;
    private int cylinders, wheels;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setEngine(boolean engine){
        this.engine = engine;
    }
    public boolean getEngine(){
        return engine;
    }
    public void setCylinders(int cylinders){
        this.cylinders = cylinders;
    }
    public int getCylinders(){
        return cylinders;
    }
    public void setWheels(int wheels){
        this.wheels = wheels;
    }
    public int getWheels(){
        return wheels;
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
