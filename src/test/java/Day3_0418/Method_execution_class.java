package Day3_0418;

public class Method_execution_class {
//Main Method is your driving force in Java, you can't run anything if you don't call this method
    public static void main(String[] args) {

        //call the void method
        custom_methods.voidAdd(300,200);


        //call the return add method
        int r = custom_methods.ReturnAdd(200,300);
        //add the value with the result below
        System.out.println("new result is " + (r+25));

    }//end of main

}
