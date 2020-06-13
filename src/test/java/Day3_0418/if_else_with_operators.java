package Day3_0418;

public class if_else_with_operators {
    public static void main(String[] args) {



    //scenario is if student grade is 90 to 100 then its A
    //if student grade is 80 to below 90 then its B
    //if student grade is 70 to below 80 then its C
    //if anything below C is failure

    //define a variable which will represent a grade number
    int grade = 95;
    //&& represents "and" operator in java
    //if && is used all conditions have to be true
    //|| represents "or" operator - either condition has to be true

        if(grade >= 90 && grade <= 100){
            System.out.println("students grade is A");
        }
        else if(grade >= 80 && grade < 90) {
            System.out.println("students grade is B");
        }
        else if(grade >=70 && grade < 80) {
            System.out.println("students grade is C");
        }
        else {
            System.out.println("students grade is F");
        }//end of conditional statements

    }//end of main method
}//end of java class


