package day2_0412;

public class For_Loop {

    public static void main(String[] args) {
        //declare the string and the size of array
        //define the data in the string array

        String[] states = new String[6];
        states[0] = "New York";
        states[1] = "Arizona";
        states[2] = "Chicago";
        states[3] = "Kansas";
        states[4] = "Kentucky";
        states[5] = "Michigan";


        //start of the for loop
                        //for(int i=0; i <states.length; i++)


        for (int i = 0; i <=5; i++){
            System.out.println("My state is "+ states[i]);

    }//end of the for loop


    }//end of the method

}//end of the class
