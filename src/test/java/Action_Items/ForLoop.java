package Action_Items;

public class ForLoop {
    public static void main(String[] args) {
        String[] streetname = new String[6];
        streetname[0] = "Avenue C";
        streetname[1] = "Dahill Rd";
        streetname[2] = "Montbleu Dr";
        streetname[3] = "34th st";
        streetname[4] = "14th st";
        streetname[5] = "East 2nd Street";


        int[] Zipcode = new int[]{11218,11226,11230,10012,10463,10008};


        for (int i = 0; i <= 5; i++) {
            System.out.println(" I live in " + streetname[i] + " in " + Zipcode[i]);


        }
    }
}