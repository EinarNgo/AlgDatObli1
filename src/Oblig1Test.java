public class Oblig1Test {
    public static void main(String[] args) {

        int[] a = {4,3,5,2,1};
        int[] b = {1,2,3,4,5};
        int[] c = {1,1,2,2,2};
        String[] d = {"ADG","BEH","CFI","DED"};

        //System.out.println(Oblig1.maks(a));

        System.out.println(Oblig1.antallUlikeSortert(c));
        System.out.println(Oblig1.flett("ENR","IA"));
        System.out.println(Oblig1.flettV2(d));


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
