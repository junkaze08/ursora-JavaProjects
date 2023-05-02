public class Operations {

    private static class Node {
        private String name;
        private String number1;
        private Node next;

        public Node(String name, String number){
            this.name = name;
            this.number1 = number;
        }
    }

    private Node first;

    public void add(String name, String number) {//Santillan
        Node node = new Node(name, number);
        if (first != null) {
            node.next = first;
        }
        first = node;
    }

    public void printList() {//Tuason
        Node current;
        current = first;
        System.out.println("Phonebook Directory:");
        while (current != null) {
            System.out.println(current.name +" - "+current.number1);
            current = current.next;
        }
    }

    public void updateName(String search_for, String newName){//Trinidad
        Node current;
        current = first;
        while (current != null) {
            if (current.name.equals(search_for)) {
                current.name = newName;
                break;
            }
            current = current.next;
        }
    }

    public void searchTargetName(String name){//Silag
        Node temp;
        for(temp = first; temp != null; temp=temp.next){
            if(name.equals(temp.name)){
                System.out.println("Contact number(s): "+temp.number1);
            }
        }
    }
}