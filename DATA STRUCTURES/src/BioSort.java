/**
 * Write a description of class BioSort here.
 *
 * @author (Junester Ursora II)
 * @version (9/13/2021)
 */
import java.util.*;
public class BioSort{
    Scanner sc = new Scanner(System.in);
    void sortData(int idNum[], String last[], String first[],  int age[], String gender[], int i){
        System.out.println("\fSORT RESIDENTS");
        int sorts;
        do{
            System.out.println("\n1. Sort by Family Name");
            System.out.println("2. Sort by Age");
            System.out.println("0. Back to Menu");
            sorts = sc.nextInt();

            int tempoAge, tempoIDNum;
            String tempolast, tempofirst, tempogen;

            switch(sorts){
                case 1:
                    for(int x = 0; x < (i-1); x++){
                        for(int j = x+1; j < i; j++){
                            if(last[x].compareTo(last[j]) > 0){//this is a lexicographical ability to compare if last[x] is greater than last[y]
                                //then it returns a postive value and running the following code
                                //which is sorting the id number first and last name, age and gender
                                tempolast=last[x];
                                last[x]=last[j];
                                last[j]=tempolast;
                                //----------------
                                tempofirst=first[x];
                                first[x]=first[j];
                                first[j]=tempofirst;
                                //----------------
                                tempoIDNum=idNum[x];
                                idNum[x]=idNum[j];
                                idNum[j]=tempoIDNum;
                                //----------------
                                tempoAge=age[x];
                                age[x]=age[j];
                                age[j]=tempoAge;
                                //----------------
                                tempogen=gender[x];
                                gender[x]=gender[j];
                                gender[j]=tempogen;
                            }
                        }
                    }
                    System.out.println("\n\fSorted by Family Name");
                    System.out.println();
                    System.out.printf("%-10s%-20s%-20s%-10s%-10s","ID No.","Last Name","First Name","Age","Gender");
                    System.out.println();
                    for(int x = 0; x < i; x++){
                        System.out.printf("%-10d%-20s%-20s%-10s%-10s%n", idNum[x] , last[x] , first[x], age[x], gender[x]);
                    }
                    break;

                case 2:
                    for(int x = 0; x < (i-1); x++){
                        for(int j = x+1; j < i; j++){
                            if(age[x] < age[j]){//this is also a lexicographical that sorts the age from oldest to highest
                                tempolast=last[x];
                                last[x]=last[j];
                                last[j]=tempolast;
                                //----------------
                                tempofirst=first[x];
                                first[x]=first[j];
                                first[j]=tempofirst;
                                //----------------
                                tempoIDNum=idNum[x];
                                idNum[x]=idNum[j];
                                idNum[j]=tempoIDNum;
                                //----------------
                                tempoAge=age[x];
                                age[x]=age[j];
                                age[j]=tempoAge;
                                //----------------
                                tempogen=gender[x];
                                gender[x]=gender[j];
                                gender[j]=tempogen;
                            }
                        }
                    }
                    System.out.println("\n\fSorted by Age");
                    System.out.println();
                    System.out.printf("%-10s%-20s%-20s%-10s%-10s","ID No.","Last Name","First Name","Age","Gender");
                    System.out.println();
                    for(int x = 0; x < i; x++){
                        System.out.printf("%-10d%-20s%-20s%-10s%-10s%n", idNum[x] , last[x] , first[x], age[x], gender[x]);
                    }
                    break;
                case 0:
                    System.out.print("\f");
                    break;
                default:
                    System.out.println("\nInvalid Input.");
                    break;
            }
        } while(sorts!=0);
    }

    void dispData(int idNum[], String last[], String first[],  int age[], String gender[], int i){
        System.out.println("\n\fDATA OF RESIDENTS");
        System.out.println();
        System.out.printf("%-10s%-20s%-20s%-10s%-10s","ID No.","Last Name","First Name","Age","Gender");
        System.out.println();
        for(int x = 0; x < i; x++){
            System.out.printf("%-10d%-20s%-20s%-10s%-10s%n", idNum[x] , last[x] , first[x], age[x], gender[x]);
        }
        //this method can be use before sorting or after sorting the last name or the age.
    }
}