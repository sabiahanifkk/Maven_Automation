package day2_0412;

public class While_Loop {


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
        //while(int i=0; i <states.length; i++)


        int i = 0;
        while (i<states.length)
        { System.out.println("My state is "+ states[i]);
        i++;
        }//end of the for loop


    }//end of the method

}//end of the class
