//Junester Ursora II - PML3
//INTPROG32
public class Main {
    public static void main(String[] args) {

        Mitsubishi mitsubishi = new Mitsubishi(5,"Outlander VRX 4WD");
        System.out.print(mitsubishi.getModel() + " is " +mitsubishi.getAge() + " years old. ");
        System.out.println(mitsubishi.getModel() +" "+ mitsubishi.startEngine());
        System.out.println(mitsubishi.getModel() +" "+ mitsubishi.accelerate());
        System.out.println(mitsubishi.getModel() +" "+ mitsubishi.brake()+"\n");

        Honda honda = new Honda(7,"Ford Falcon");
        System.out.print(honda.getModel() + " is " +honda.getAge() + " years old. ");
        System.out.println(honda.getModel() +" "+ honda.startEngine());
        System.out.println(honda.getModel() +" "+ honda.accelerate());
        System.out.println(honda.getModel() +" "+ honda.brake()+"\n");

        Ford ford = new Ford(9,"Honda BR-V");
        System.out.print(ford.getModel() + " is " +ford.getAge() + " years old. ");
        System.out.println(ford.getModel() +" "+ ford.startEngine());
        System.out.println(ford.getModel() +" "+ ford.accelerate());
        System.out.println(ford.getModel() +" "+ ford.brake()+"\n");
    }
}