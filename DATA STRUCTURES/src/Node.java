public class Node{

    String name, number1, number2, number3;
    Node next;

    Node(){
        name = "";
        number1 = "";
        number2 = "";
        number3 = "";
        next = null;
    }

    Node(String name, String number1, String number2, String number3, Node next){
        this.name = name;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.next = next;
    }
}