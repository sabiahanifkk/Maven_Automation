package day2_0412;

public class Linear_Array {

    public static void main(String[] args) {
        //declare the empty string array variables first
        String[] locations, countries, places;
        //declare the empty int array variables first
        int[] number, houseAdress;

        //define the variables
        locations = new String[]{"sixflag","Disney","Beach"};
        countries = new String[]{"Bangladesh","USA","Canada","India"};

        //define the int array variables
        number = new int[]{1,2,3,4};
        houseAdress = new int[]{222,333,444,555};

        //print the last value from locations variable
        System.out.println("My last location is " + locations[2] + " is in array index " + number[1]);

    }//end of main method
}//end of java class
