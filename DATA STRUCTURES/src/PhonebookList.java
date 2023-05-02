import java.util.Scanner;

public class PhonebookList{

    String command, name = "", n1 = "", n2 = "", n3 = "";
    int counter = 0;
    Node head;
    Node tail;

    PhonebookList(){
        head = null;
        tail = null;
    }

    public void addContact(String string){
        Scanner sc = new Scanner(string);
        counter = 0;

        while(sc.hasNext()){
            if(sc.hasNext()){
                command = sc.next();
            }
            if(sc.hasNext()){
                name = sc.next();
                counter++;
            }
            if(sc.hasNext()){
                n1 = sc.next();
                counter++;
            }
            if(sc.hasNext()){
                n2 = sc.next();
                counter++;
            }
            if(sc.hasNext()){
                n3 = sc.next();
                counter++;
            }
        }

        if(counter == 2){

            for(Node temp = head; temp != null; temp = temp.next){
                if(name.equalsIgnoreCase(temp.name)){
                    if(temp.number1.equals("0")){
                        temp.number1 = n1;
                        System.out.println("Remarks: New number has been added.");
                        return;
                    } else if(temp.number2.equals("0") && temp.number3.equals("0")){
                        temp.number2 = n1;
                        System.out.println("Remarks: New number has been added.");
                        return;
                    } else if(temp.number3.equals("0")){
                        temp.number3 = n1;
                        System.out.println("Remarks: New number has been added.");
                        return;
                    } else {
                        System.out.println("Remarks: Invalid command. Reached 3 number limit per contact person");
                        return;
                    }
                }
            }

            if(head == null){
                n2 = "0";
                n3 = "0";
                head = new Node(name, n1, n2, n3, head);
                System.out.println("Remarks: New contact has been added.");
            }

        } else if(counter == 3){
            n3 = "0";
            head = new Node(name, n1, n2, n3, head);
            System.out.println("Remarks: New contact has been added.");
        } else if(counter == 4){
            head = new Node(name, n1, n2, n3, head);
            System.out.println("Remarks: New contact has been added.");
        } else {
            System.out.println("Remarks: Invalid command.");
        }
    }

    public void deleteContact(String string){
        Scanner sc = new Scanner(string);
        boolean delete = false;
        counter = 0;

        if(isEmpty()){
            System.out.println("Remarks: Invalid command. Empty Directory.");
            return;
        }

        while(sc.hasNext()){
            if(sc.hasNext()){
                command = sc.next();
            }
            if(sc.hasNext()){
                name = sc.next();
                counter++;
            }
            if(sc.hasNext()){
                n1 = sc.next();
                counter++;
            }
            if(sc.hasNext()){
                counter++;
            }

            break;
        }

        if(counter == 1){
            for(Node temp = head; temp != null; temp = temp.next){
                if(name.equals(temp.name)){
                    head = head.next;
                    delete = true;
                }
            }

            if(delete){
                System.out.println("Remarks: " + name + " has been removed.");
            } else {
                System.out.println("Remarks: Invalid command. " + name + " is not found in the Directory.");
            }
        } else if(counter == 2){
            for(Node temp = head; temp != null; temp = temp.next){
                if(name.equalsIgnoreCase(temp.name) && n1.equals(temp.number1)){
                    temp.number1 = temp.number2;
                    temp.number2 = temp.number3;
                    temp.number3 = null;
                    delete = true;
                } else if(name.equalsIgnoreCase(temp.name) && n1.equals(temp.number2)){
                    temp.number2 = temp.number3;
                    temp.number3 = null;
                    delete = true;
                } else if(name.equalsIgnoreCase(temp.name) && n1.equals(temp.number3)){
                    temp.number3 = null;
                    delete = true;
                }
            }

            if(delete){
                System.out.println("Remarks: " + name + "'s contact number has been removed.");
            } else {
                System.out.println("Remarks: Invalid command. " + name + "'s contact number is not found in the Directory.");
            }
        } else{
            System.out.println("Remarks: Invalid command.");
        }
    }

    public void viewContact(String string){
        Scanner sc = new Scanner(string);
        counter = 0;

        if(isEmpty()){
            System.out.println("Remarks: Invalid command. Empty Directory.");
            return;
        }

        while(sc.hasNext()){
            if(sc.hasNext()){
                command = sc.next();
                counter++;
            }
            if(sc.hasNext()){
                name = sc.next();
                counter++;
            }
            if(sc.hasNext()){
                counter++;
            }

            break;
        }

        if(counter == 1){
            System.out.println("Phonebook directory:");
            for(Node temp = head; temp != null; temp = temp.next){
                System.out.println(temp.name + " - " + temp.number1 + ", " + temp.number2 + ", " + temp.number3);
            }
        } else if(counter == 2){
            for(Node temp = head; temp != null; temp = temp.next){
                if(name.equals(temp.name)){
                    System.out.println("Contact Number(s): " + temp.number1 + ", " + temp.number2 + ", " + temp.number3);
                }
            }
        } else{
            System.out.println("Remarks: Invalid command.");
        }
    }

    public void modifyContact(String string){
        Scanner sc = new Scanner(string);
        String tempString = "", tempString2 = "";
        counter = 0;
        boolean update = false;

        if(isEmpty()){
            System.out.println("Remarks: Invalid command. Empty Directory.");
            return;
        }

        while(sc.hasNext()){
            if(sc.hasNext()){
                command = sc.next();
            }
            if(sc.hasNext()){
                name = sc.next();
                counter++;
            }
            if(sc.hasNext()){
                tempString = sc.next();
                counter++;
            }
            break;
        }

        if(counter == 2){

            for(Node temp = head; temp != null; temp = temp.next){
                if(name.equalsIgnoreCase(temp.name)){
                    temp.name = tempString;
                    update = true;
                }
            }

            if(update){
                System.out.println("Remarks: " + name + " has been modified.");
            } else {
                System.out.println("Remarks: Invalid command. " + name + " is not found in the Directory.");
            }
        } else {
            System.out.println("Remarks: Invalid command.");
        }
    }

    public boolean isEmpty(){
        return (head == null);
    }
}