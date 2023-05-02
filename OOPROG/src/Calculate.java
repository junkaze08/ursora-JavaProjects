public class Calculate {
    private int n1, n2, n3, n4;

    public Calculate() {
    }

    public Calculate(int n1, int n2, int n3, int n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    public void setNum1(int n1){
        this.n1 = n1;
    }

    public void setNum2(int n2){
        this.n2 = n2;
    }

    public void setNum3(int n3){
        this.n3 = n3;
    }

    public void setNum4(int n4){
        this.n4 = n4;
    }

    public int getNum1(){
        return n1;
    }

    public int getNum2(){
        return n2;
    }

    public int getNum3(){
        return n3;
    }

    public int getNum4(){
        return n4;
    }

    public int displaysmallest(){
        int smaller;
        /*int smallest[] = {getNum1(), getNum2(), getNum3(), getNum4()};

        int smaller = smallest[0];
        for(int i = 0; i < smallest.length; i++) {
            if(smallest[i] < smaller)
                smaller = smallest[i];
        }*/
        if(n1<n2 && n1<n3 && n1<n4)
            smaller = n1;
        else if(n2<n3 && n2<n4)
            smaller = n2;
        else if(n3<n4)
            smaller = n3;
        else
            smaller = n4;

        return smaller;
    }

    public int displaylargest(){
        int largest[] = {getNum1(), getNum2(), getNum3(), getNum4()};
        int larger = largest[0];
        for(int i = 0; i < largest.length; i++) {
            if(largest[i] > larger)
                larger = largest[i];
        }
        return larger;
    }

    public void displaysquare(){
        System.out.println("\nSquared of each number: ");
        System.out.println(n1 + " = " + n1 * n1);
        System.out.println(n2 + " = " + n2 * n2);
        System.out.println(n3 + " = " + n3 * n3);
        System.out.println(n4 + " = " + n4 * n4);
    }

    public void displayfactorial(){
        System.out.println("\nFactorial of each number: ");
        System.out.println(n1 + " = " + Mainnn.factorial(getNum1()));
        System.out.println(n2 + " = " + Mainnn.factorial(getNum2()));
        System.out.println(n3 + " = " + Mainnn.factorial(getNum3()));
        System.out.println(n4 + " = " + Mainnn.factorial(getNum4()));
    }

    public void displaysummation(){
        System.out.println("\nSummation of each number: ");
        System.out.println(n1 + " = " + Mainnn.summation(getNum1()));
        System.out.println(n2 + " = " + Mainnn.summation(getNum2()));
        System.out.println(n3 + " = " + Mainnn.summation(getNum3()));
        System.out.println(n4 + " = " + Mainnn.summation(getNum4()));
    }

    public void displayperfectandprime(){
        System.out.println();
        System.out.println(n1 +  " is " + Mainnn.perfect(getNum1()) +  " and " + Mainnn.prime(getNum1()));
        System.out.println(n2 +  " is " + Mainnn.perfect(getNum2()) +  " and " + Mainnn.prime(getNum2()));
        System.out.println(n3 +  " is " + Mainnn.perfect(getNum3()) +  " and " + Mainnn.prime(getNum3()));
        System.out.println(n4 +  " is " + Mainnn.perfect(getNum4()) +  " and " + Mainnn.prime(getNum4()));
    }
}