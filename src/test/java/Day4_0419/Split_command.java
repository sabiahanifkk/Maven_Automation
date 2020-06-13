package Day4_0419;

public class Split_command {
    public static void main(String[] args) {

        //create a string message first and store it as a single string variable
        String message = "Welcome to Selenium Automation Class";

                //I want to only print the keyword Selenium from my message variable
        //we need to define string array variable in order to split the message
        String[] arrayResult = message.split(" ");
        //print the result
        System.out.println("my final message is " + arrayResult[2]);


    }//end of main method

}//end of java class
