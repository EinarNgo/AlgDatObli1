public class Oblig1 {

    public static int maks(int[] a) {
        // sjekker at i ikke har et tomt aray
        if (a.length < 1) {
            throw new IllegalArgumentException("Illegal verdi");
        }

        // vi setter a.length-1 fordi vi vil unngaa array out of bounds,
        // naar vi skal bytte siste element.
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        // sjekker at i ikke har et tomt aray
        if (a.length < 1) {
            throw new IllegalArgumentException("Illegal verdi");
        }

        int tellerOmbytte = 0;
        // vi setter a.length-1 fordi vi vil unngaa array out of bounds,
        // naar vi skal bytte siste element.
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                ++tellerOmbytte;
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        for (int i : a) {
            System.out.print(" " + i);
        }
        System.out.println();
        return tellerOmbytte;
    }

    public static void delSortering(int[] a) {

        int left = 0;
        int right = a.length-1;

        while (left < right) {

            while ((a[left] & 1) == 1 && left < right) {
                left++;
            }
            while ((a[right] & 1) == 0 && left < right) {
                right--;
            }
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        bubble(a,0, antPartall(a));
        bubble(a, antPartall(a), a.length);

    }

    public static void rotasjon(char[] a) {
        if (a.length <= 0 || a == null) return;

        char temp = a[a.length-1];

        for (int i = a.length-2; i >= 0; i--) {
            a[i+1] = a[i];
        }
        a[0] = temp;
    }


    public static void rotasjon(char[] a, int k) {
        if (k < 0) {
            k = (k * -1) * a.length + k;
        }
        for (int i = 0; i < k; i++) {
            rotasjon(a);
        }
    }





    public static int antPartall(int[] a) {
        int antPartall = 0;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 1) == 0) {
                antPartall++;
            }
        }
        return antPartall;
    }





    public static void bubble(int[] a, int fra, int til) {
        int teller = a.length;
        for (int i = 0; i < teller; i++) {
            bubbleSort(a, teller, fra, til);
        }
        teller--;
    }

    public static void bubbleSort(int[] a, int teller, int fra, int til) {

        for (int i = fra; i < til-1; i++) {
            if (a[i] > a[i+1]) {
                int tmp = a[i];
                a[i] = a[i+1];
                a[i+1] = tmp;
            }
        }
    }
}
