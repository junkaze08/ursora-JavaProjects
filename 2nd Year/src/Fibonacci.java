import java.sql.SQLOutput;

public class Fibonacci {
    public static void main(String[] args){
        int prevNumber = 0;
        int currNumber = 1;
        int result = 0;
        int num = 21;
        while(currNumber<=num){
            if(currNumber % 2 != 0 ){
                result+=currNumber;
            }
                currNumber += prevNumber;
                prevNumber = currNumber - prevNumber;
        }
        var result1 = result;
        System.out.println(result1);
    }
}
