package Action_Items;


public class Counting {


    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0) {
                continue;
            } else {
                System.out.println(i);
            }//end of if statement


        }//end of loop
    }//end of main
}//end of class
