import java.util.Arrays;

public class Oblig1Test {
    public static void main(String[] args) {

        int[] a = {4,3,2,1};
        System.out.println("Maks verdi: " + Oblig1.maks(a));
        for (int i : a) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.println("Antall ombyttinger: " + Oblig1.ombyttinger(a));

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

    }
    
}
