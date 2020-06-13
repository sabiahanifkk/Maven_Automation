package Action_Items;


import java.util.ArrayList;

public class vowels {
    public static void main(String[] args) {
        ArrayList<String> letters = new ArrayList<>();
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");
        letters.add("e");


        for (int i = 0; i<letters.size();i++)   {
                if (letters.get(i).equals("a")||(letters.get(i).equals("e"))) {
                    System.out.println(letters.get(i)+ " is a vowel");
            }else {
                    System.out.println(letters.get(i));
                }//end of if
        }//end of loop

    }//end of main






}//end of class
