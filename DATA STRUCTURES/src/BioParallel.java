
/**
 * Write a description of class BioParallel here.
 *
 * @author (Junester Ursora II)
 * @version (9/9/2021)
 */
import java.util.*;
public class BioParallel{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);//Scanner class to accept input from the user
        BioInpSea obj = new BioInpSea();//Constructor to create BioInpSea class to a new object
        BioSort object = new BioSort();//Constructor to create BioSort class to a new object
        int choice;
        int i = 0;
        int[] idNum = new int[100];
        int[] age = new int[100];
        String first[] = new String[100];
        String last[] = new String[100];
        String gender[] = new String[100];

        do{//The Menu tab will always execute as long as the variable choice is equals to 0 or less than 5
            System.out.println("\nMenu");
            System.out.println("1. Input data");
            System.out.println("2. Search data");
            System.out.println("3. Sort data");
            System.out.println("4. Display data");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            switch(choice){//inside this determines the constructor passing the inputs to "obj" and "object" object
                case 1:
                    obj.inputData(idNum,last,first,age,gender,i);
                    i++;
                    break;
                case 2:
                    obj.searchData(idNum,last,first,age,gender,i);
                    break;
                case 3:
                    object.sortData(idNum,last,first,age,gender,i);
                    break;
                case 4:
                    object.dispData(idNum,last,first,age,gender,i);
                    break;
            }
            if(choice==0){
                System.out.print("Thank you for using our program.");
                break;
            }
        }while(choice<5);
    }
}
