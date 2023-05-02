
/**
 * Write a description of class BioInpSea here.
 *
 * @author (Junester Ursora II)
 * @version (9/9/2021)
 */
import java.util.*;
public class BioInpSea{
    Scanner sc = new Scanner(System.in);
    int choices = 0;
    void inputData(int idNum[], String last[], String first[],  int age[], String gender[], int i){//On this constructor with parameter accepts the id number, last and first name, age and gender
        int counter = 0;
        System.out.println();
        System.out.print("\fEnter ID No.: ");
        idNum[i] = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Last Name: ");
        last[i] = sc.nextLine();
        System.out.print("Enter First Name: ");
        first[i] = sc.nextLine();
        System.out.print("Enter Age: ");
        age[i] = sc.nextInt();
        do{
            System.out.print("Enter Gender: ");
            gender[i] = sc.next();
            if(gender[i].equals("Male")||gender[i].equals("male")||gender[i].equals("MALE")||gender[i].equals("m")||gender[i].equals("M")){
                //this conditional statement determines multiple possible inputs from the user of male.
                counter = 1;
            } else if(gender[i].equals("Female")||gender[i].equals("female")||gender[i].equals("FEMALE")||gender[i].equals("f")||gender[i].equals("F")){
                //this conditional statement determines multiple possible inputs from the user of female if the inputted data of the user is female.
                counter = 1;//This is also the same technique that I use if I would have an output throughout the program.
            } else {
                System.out.println("Invalid Gender!");
            }
        }while (counter == 0);
    }

    void searchData(int idNum[], String last[], String first[],  int age[], String gender [], int i){//On this constructor with parameter searches data of residents by ID and Gender
        System.out.println();
        System.out.println("\fSEARCH DATA");
        do{//inside this do while, user can choose on how they want to search the resident or back to menu
            System.out.println("\n1. Search Resident by ID");
            System.out.println("2. Search Resident by Name");
            System.out.println("3. Search Resident by Gender");
            System.out.println("0. Back to Menu");
            choices = sc.nextInt();
            switch(choices){
                case 1:
                    int temp = 0;
                    System.out.print("\fEnter ID No.: ");
                    int idnumber = sc.nextInt();
                    for(int j = 0; j < idNum.length; j++){//this for loop is for the number of characters in idNum
                        if(idNum[j] == idnumber){//this conditional statement determines if the array idNum[j] is present and equals on the input idnumber
                            i = j;
                            System.out.println();
                            System.out.println("Personal Information");
                            System.out.print("ID No.: " + idNum[i]);
                            System.out.println();
                            System.out.printf("Lastname: %S", last[i]);
                            System.out.println();
                            System.out.printf("Firstname: %S",first[i]);
                            System.out.println();
                            System.out.print("Age: " + age[i]);
                            System.out.println();
                            System.out.printf("Gender: %S", gender[i]);
                            System.out.println();
                            temp = 1;
                            break;
                        }
                    }
                    if(temp == 0){
                        System.out.println("ID Number not found!");
                    }
                    break;

                case 2:
                    System.out.println("\fEnter Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    int counter = 0;

                    for(int x = 0; x < i; x++){
                        if(first[x].equals(name)){//if the inputted name is the same as in the conditional statement, then it will display the same name that are searched.
                            System.out.println("\nPaired Name");
                            System.out.printf("%-10s%-20s%-20s%-10s%-10s","ID No.","Last Name","First Name","Age","Gender");
                            System.out.println();
                            System.out.printf("%-10d%-20s%-20s%-10s%-10s%n", idNum[x] , last[x] , first[x], age[x], gender[x]);
                            counter = 1;
                        }
                    }
                    if(counter == 0){
                        System.out.println("Name not found!");
                    }
                    break;

                case 3:
                    System.out.println("\fEnter Gender: ");
                    sc.nextLine();
                    String data = sc.nextLine();
                    if(data.equals("Male")||data.equals("male")||data.equals("MALE")||data.equals("m")||data.equals("M")){//this conditional statement determines multiple possible inputs from the user of male.
                        System.out.println("MALE RESIDENTS");
                        System.out.printf("%-10s%-20s%-20s%-10s%-10s","ID No.","Last Name","First Name","Age","Gender");
                        System.out.println();
                        for(int x = 0; x < i; x++){
                            if(gender[x].equals(data)){//if the inputted gender is the same as in the conditional statement, then it will display all the male residents
                                System.out.printf("%-10d%-20s%-20s%-10s%-10s%n", idNum[x] , last[x] , first[x], age[x], gender[x]);
                            }
                        }
                    } else if(data.equals("Female")||data.equals("female")||data.equals("FEMALE")||data.equals("f")||data.equals("F")){//this conditional statement determines multiple possible inputs from the user of female if the inputted data of the user is female.
                        System.out.println("FEMALE RESIDENTS");
                        System.out.printf("%-10s%-20s%-20s%-10s%-10s","ID No.","Last Name","First Name","Age","Gender");
                        System.out.println();
                        for(int x = 0; x < i; x++){
                            if(gender[x].equals(data)){//if the inputted gender is the same as in the conditional statement, then it will display all the female residents
                                System.out.printf("%-10d%-20s%-20s%-10s%-10s%n", idNum[x] , last[x] , first[x], age[x], gender[x]);
                            }//It uses printstream, a convenience method to write a String which is formatted to this output Stream, %s for string and %d is for integer and %n is for next line
                        }    //This is also the same technique that I use if I would have an output throughout the program.
                    } else {
                        System.out.println("Invalid Gender!");
                    }
                    break;

                case 0:
                    System.out.print("\f");
                    break;
                default:
                    System.out.println("\nInvalid! Please enter a valid choice");
            }
        } while (choices!=0);
    }
}

