import java.util.Arrays;

public class Oblig1Test {
    public static void main(String[] args) {


        int[] opp4 = {6,10,9,4,1,3,8,5,2,7};
        //int[] opp4 = {7, 6, 3, 10, 9, 2, 4, 1, 8, 5};
        Oblig1.delSortering(opp4);

        System.out.println();
        System.out.println(Arrays.toString(opp4));

        /*
        System.out.println("Odd: " + (16 & 1));
        System.out.println("Odd: " + (17 & 1));
        System.out.println("Odd: " + (110 & 1));
        */


        char[] opp5 = {'a', 'b', 'c', 'd', 'e'};
        Oblig1.rotasjon(opp5);
//System.out.println(Arrays.toString(opp5));

        char[] opp5a = {};
        Oblig1.rotasjon(opp5a);

        char[] opp5c = {'a', 'b', 'c', 'd', 'e'};
        char[] aa = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        Oblig1.rotasjon(opp5c, -3);
//System.out.println(Arrays.toString(opp5c));

        /*
        System.out.println(Arrays.toString(aa));
        Oblig1.rotasjon(aa, 3);
        System.out.println(Arrays.toString(aa));
        Oblig1.rotasjon(aa, -4);
        System.out.println(Arrays.toString(aa));
        */

        int[] a = {4,3,5,2,1};
        int[] b = {1,2,3,4,5};
        int[] c = {1,1,2,2,2};
        String[] d = {"ADG","BEH","CFI","DED"};


        //System.out.println(Oblig1.maks(a));

        System.out.println(Oblig1.antallUlikeSortert(c));
        System.out.println(Oblig1.flett("ENR","IA"));
        //  System.out.println(Oblig1.flettV2(d));


        String[] test = {"e","eeeee","ee"};
        int temp = test[0].length();

        for (int i = 0; i < test.length-1;++i) {
            if (test[i].length()<test[i+1].length()) {
                temp = test[i+1].length();
            }
        }


        System.out.println(test.length);
    }
    
}
