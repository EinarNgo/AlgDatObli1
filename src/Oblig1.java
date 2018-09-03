public class Oblig1 {

    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new IllegalArgumentException("Illegal verdi");
        }
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }

        }
        return a[a.length-1];
    }


}
