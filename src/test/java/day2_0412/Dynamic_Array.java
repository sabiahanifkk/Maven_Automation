package day2_0412;

public class Dynamic_Array {
    public static void main(String[] args) {

        //declare string variables by number of variables
        String[] Location,countries;

        int[] number,house_address;    //int variable declaration
        //for fraction numbers you need a different data type i.e. floor, double, float
        //defining array according to length

        countries = new String[5];

        countries[0] = "USA";
        countries[1] = "Russia";
        countries[2] = "New Zealand";
        countries[3] = "Bangladesh";
        countries[4] = "pakistan";

        house_address = new int[5];

        house_address[0] = 11218;
        house_address[1] = 11226;
        house_address[2] = 14068;
        house_address[3] = 11219;
        house_address[4] = 10012;


        System.out.println(" My country is "+ countries[3]+" and my zip code is "+ house_address[0]);


    }//end method

}//end class
