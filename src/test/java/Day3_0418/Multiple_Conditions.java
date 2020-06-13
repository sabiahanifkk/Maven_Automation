package Day3_0418;

public class Multiple_Conditions {
    public static void main(String[] args) {
        //declare three integer variables
        int a, b, c;
        a = 2;
        b = 4;
        c = 6;

        //write multiple if else conditions to handle your scenarios
        if (a + b > c) {
            System.out.println("a & b is greater than c");

        } else if (a + b < c) {
            System.out.println("a & b is less than c");
        } else {
            System.out.println("a & b is equal to c");
        }//end of if else if else condition

    }//end of main method
}//end of java class